package com.example.wprintapp.modules.printerregistration.ui

import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityPrinterRegistrationBinding
import com.example.wprintapp.modules.printerregistration.`data`.viewmodel.PrinterRegistrationVM
import com.example.wprintapp.modules.printfee.ui.PrintFeeActivity
import com.example.wprintapp.modules.profile.ui.ProfileActivity
import kotlin.String
import kotlin.Unit

class PrinterRegistrationActivity :
    BaseActivity<ActivityPrinterRegistrationBinding>(R.layout.activity_printer_registration) {
  private val viewModel: PrinterRegistrationVM by viewModels<PrinterRegistrationVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.printerRegistrationVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnRegisterPrinterOne.setOnClickListener {
      val destIntent = ProfileActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowsetprintfee.setOnClickListener {
      val destIntent = PrintFeeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PRINTER_REGISTRATION_ACTIVITY"

  }
}
