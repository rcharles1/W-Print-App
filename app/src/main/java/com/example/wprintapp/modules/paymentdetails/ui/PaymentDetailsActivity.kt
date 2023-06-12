package com.example.wprintapp.modules.paymentdetails.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityPaymentDetailsBinding
import com.example.wprintapp.modules.paymentdetails.`data`.viewmodel.PaymentDetailsVM
import com.example.wprintapp.modules.paymentstatusdisplay.ui.PaymentStatusDisplayActivity
import kotlin.String
import kotlin.Unit

class PaymentDetailsActivity :
    BaseActivity<ActivityPaymentDetailsBinding>(R.layout.activity_payment_details) {
  private val viewModel: PaymentDetailsVM by viewModels<PaymentDetailsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.paymentDetailsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnMakePayment.setOnClickListener {
      val destIntent = PaymentStatusDisplayActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PAYMENT_DETAILS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PaymentDetailsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
