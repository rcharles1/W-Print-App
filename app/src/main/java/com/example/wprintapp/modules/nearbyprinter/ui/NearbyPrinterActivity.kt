package com.example.wprintapp.modules.nearbyprinter.ui

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityNearbyPrinterBinding
import com.example.wprintapp.modules.nearbyprinter.data.viewmodel.NearbyPrinterVM
import kotlin.collections.map


class NearbyPrinterActivity :
    BaseActivity<ActivityNearbyPrinterBinding>(R.layout.activity_nearby_printer) {
  private val viewModel: NearbyPrinterVM by viewModels()




  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.nearbyPrinterVM = viewModel

  }

  @RequiresApi(Build.VERSION_CODES.TIRAMISU)
  override fun setUpClicks() {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }

    binding.btnScan.setOnClickListener {

      val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
      val isWifiEnabled = wifiManager.isWifiEnabled

      //Check if wi fi is enabled
      if (!isWifiEnabled){
        Toast.makeText(this,"Turn on Wi-Fi in Settings", Toast.LENGTH_SHORT).show()
      }else{

        val wifiScanReceiver = object : BroadcastReceiver() {
          override fun onReceive(context: Context, intent: Intent) {
            val success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
            if (success) {
              scanSuccess()
            } else {
              scanFailure()
            }
          }
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        this.registerReceiver(wifiScanReceiver, intentFilter)

        val executor = ContextCompat.getMainExecutor(this)
        val callback = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
          object : WifiManager.ScanResultsCallback() {
            override fun onScanResultsAvailable() {
              // Handle scan results here
            }
          }
        } else {
          TODO("VERSION.SDK_INT < R")
        }
        wifiManager.registerScanResultsCallback(executor, callback)
        val success = wifiManager.startScan()
        if (!success) {
          scanFailure()
        }
      }

    }
  }

    private fun scanSuccess() {
      if (ActivityCompat.checkSelfPermission(
          this,
          Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
      ) {
        val requestCode = 1 // unique request code
        val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
        ActivityCompat.requestPermissions(this, permissions, requestCode)
        return
      }

      val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
      val results = wifiManager.scanResults
      // use new scan results
      val networkNames = results.map { if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        it.wifiSsid.toString()
      } else {
        TODO("VERSION.SDK_INT < TIRAMISU")
      }
      }
      val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, networkNames)
      binding.ListView.adapter = adapter
    }


  @RequiresApi(Build.VERSION_CODES.TIRAMISU)
  private fun scanFailure() {
    // handle failure: new scan did NOT succeed
    // consider using old scan results: these are the OLD results!
   Toast.makeText(this,"No new devices detected",Toast.LENGTH_SHORT).show()

    if (ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
      ) != PackageManager.PERMISSION_GRANTED
    ) {
      return
    }

    val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    val scanResults = wifiManager.scanResults
    // potentially use older scan results
    val ssid = scanResults.map { if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
      it.wifiSsid.toString()
    } else {
      TODO("VERSION.SDK_INT < TIRAMISU")
    }
    }

    val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ssid)
    binding.ListView.adapter = adapter

  }

  companion object {
    const val TAG: String = "NEARBY_PRINTER_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, NearbyPrinterActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}


