package com.example.wprintapp.modules.printpreview.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityPrintPreviewBinding
import com.example.wprintapp.modules.paymentmethod.ui.PaymentMethodActivity
import com.example.wprintapp.modules.printpreview.`data`.viewmodel.PrintPreviewVM
import kotlin.String
import kotlin.Unit

class PrintPreviewActivity :
    BaseActivity<ActivityPrintPreviewBinding>(R.layout.activity_print_preview) {
  private val viewModel: PrintPreviewVM by viewModels<PrintPreviewVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.printPreviewVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.etLanguage.setOnClickListener {
      val destIntent = PaymentMethodActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PRINT_PREVIEW_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PrintPreviewActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
