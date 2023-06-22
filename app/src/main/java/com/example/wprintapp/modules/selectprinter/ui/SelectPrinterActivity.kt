package com.example.wprintapp.modules.selectprinter.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivitySelectPrinterBinding
import com.example.wprintapp.modules.home.ui.HomeFragment
import com.example.wprintapp.modules.nearbyprinter.ui.NearbyPrinterActivity
import com.example.wprintapp.modules.remoteprinter.ui.RemotePrinterActivity
import com.example.wprintapp.modules.selectprinter.`data`.viewmodel.SelectPrinterVM
import kotlin.String
import kotlin.Unit

class SelectPrinterActivity :
    BaseActivity<ActivitySelectPrinterBinding>(R.layout.activity_select_printer) {
  private val viewModel: SelectPrinterVM by viewModels()


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.selectPrinterVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnRemotePrinter.setOnClickListener {
      val destIntent = RemotePrinterActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnNearbyPrinterOne.setOnClickListener {
      val destIntent = NearbyPrinterActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SELECT_PRINTER_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SelectPrinterActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
