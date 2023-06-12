package com.example.wprintapp.modules.nearbyprinter.ui

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityNearbyPrinterBinding
import com.example.wprintapp.modules.nearbyprinter.data.viewmodel.NearbyPrinterVM
import org.koin.android.ext.android.bind
import kotlin.collections.map


private val Any.SSID: Unit
  get() {}

class NearbyPrinterActivity :
    BaseActivity<ActivityNearbyPrinterBinding>(R.layout.activity_nearby_printer) {
  private val viewModel: NearbyPrinterVM by viewModels()
  private val wifiManager = this.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.nearbyPrinterVM = viewModel

  }

  override fun setUpClicks() {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }

    binding.btnScan.setOnClickListener {
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
        val success = wifiManager.startScan()
        if (!success) {
          // scan failure handling
          scanFailure()
        }

      }

    }
  }

  private fun scanSuccess() {
    val results = if (ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
      ) != PackageManager.PERMISSION_GRANTED
    ) {

      // TODO: Consider calling
      //    ActivityCompat#requestPermissions
      val requestCode = 1 // unique request code
      val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
      ActivityCompat.requestPermissions(this, permissions, requestCode)

      // here to request the missing permissions, and then overriding
      //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
      //                                          int[] grantResults)
      // to handle the case where the user grants the permission. See the documentation
      // for ActivityCompat#requestPermissions for more details.
      return
    } else {
      Toast.makeText(this, "Scanning", Toast.LENGTH_SHORT).show()

    }

    val resultList = binding.ListView
    val resultOption: Array<Any> = arrayOf(results)

    wifiManager.scanResults
    // use new scan results
      val networkNames = resultOption.map { it.SSID }
      val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, networkNames)
      resultList.adapter = adapter


  }


  private fun scanFailure() {
    // handle failure: new scan did NOT succeed
    // consider using old scan results: these are the OLD results!
    val results = if (ActivityCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
      ) != PackageManager.PERMISSION_GRANTED
    ) {
      // TODO: Consider calling
      //    ActivityCompat#requestPermissions
      // here to request the missing permissions, and then overriding
      //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
      //                                          int[] grantResults)
      // to handle the case where the user grants the permission. See the documentation
      // for ActivityCompat#requestPermissions for more details.
      return
    } else {
      Toast.makeText(this, "No Available devices", Toast.LENGTH_SHORT).show()
    }
    wifiManager.scanResults
    // potentially use older scan results
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


