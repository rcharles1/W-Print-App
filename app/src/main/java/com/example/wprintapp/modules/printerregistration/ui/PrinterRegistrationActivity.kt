package com.example.wprintapp.modules.printerregistration.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityPrinterRegistrationBinding
import com.example.wprintapp.modules.printerregistration.data.viewmodel.PrinterRegistrationVM
import com.example.wprintapp.modules.profile.ui.ProfileActivity

class PrinterRegistrationActivity :
    BaseActivity<ActivityPrinterRegistrationBinding>(R.layout.activity_printer_registration) {
  private val viewModel: PrinterRegistrationVM by viewModels()

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.printerRegistrationVM = viewModel
  }

  override fun setUpClicks() {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnRegisterPrinterOne.setOnClickListener {
      val destIntent = ProfileActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.rbNearbyPrinter.setOnLongClickListener {
      val destIntent = ProfileActivity.getIntent(this, null)
      startActivity(destIntent)
      true
    }



  }

  companion object {
    const val TAG: String = "PRINTER_REGISTRATION_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PrinterRegistrationActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }

  }
}
