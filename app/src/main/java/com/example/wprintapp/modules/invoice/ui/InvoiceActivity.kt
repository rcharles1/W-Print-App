package com.example.wprintapp.modules.invoice.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityInvoiceBinding
import com.example.wprintapp.modules.invoice.`data`.viewmodel.InvoiceVM
import com.example.wprintapp.modules.paymentmethod.ui.PaymentMethodActivity
import com.example.wprintapp.modules.printpreview.ui.PrintPreviewActivity
import kotlin.String
import kotlin.Unit

class InvoiceActivity : BaseActivity<ActivityInvoiceBinding>(R.layout.activity_invoice) {
  private val viewModel: InvoiceVM by viewModels<InvoiceVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.invoiceVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearRowprintpreview.setOnClickListener {
      val destIntent = PrintPreviewActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnConfirmInvoiceOne.setOnClickListener {
      val destIntent = PaymentMethodActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "INVOICE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, InvoiceActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
