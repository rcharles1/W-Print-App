package com.example.wprintapp.modules.paymentstatusfailed.ui

import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityPaymentStatusFailedBinding
import com.example.wprintapp.modules.paymentmethod.ui.PaymentMethodActivity
import com.example.wprintapp.modules.paymentstatusfailed.`data`.viewmodel.PaymentStatusFailedVM
import kotlin.String
import kotlin.Unit

class PaymentStatusFailedActivity :
    BaseActivity<ActivityPaymentStatusFailedBinding>(R.layout.activity_payment_status_failed) {
  private val viewModel: PaymentStatusFailedVM by viewModels<PaymentStatusFailedVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.paymentStatusFailedVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearPaymentStatus.setOnClickListener {
      val destIntent = PaymentMethodActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PAYMENT_STATUS_FAILED_ACTIVITY"

  }
}
