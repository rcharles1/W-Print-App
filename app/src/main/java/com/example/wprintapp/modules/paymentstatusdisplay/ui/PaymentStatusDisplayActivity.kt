package com.example.wprintapp.modules.paymentstatusdisplay.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityPaymentStatusDisplayBinding
import com.example.wprintapp.modules.paymentstatusdisplay.`data`.viewmodel.PaymentStatusDisplayVM
import com.example.wprintapp.modules.paymentstatussuccess.ui.PaymentStatusSuccessActivity
import kotlin.String
import kotlin.Unit

class PaymentStatusDisplayActivity :
    BaseActivity<ActivityPaymentStatusDisplayBinding>(R.layout.activity_payment_status_display) {
  private val viewModel: PaymentStatusDisplayVM by viewModels<PaymentStatusDisplayVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.paymentStatusDisplayVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearPaymentStatus.setOnClickListener {
      val destIntent = PaymentStatusSuccessActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PAYMENT_STATUS_DISPLAY_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PaymentStatusDisplayActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
