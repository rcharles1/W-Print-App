package com.example.wprintapp.modules.paymentstatussuccess.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityPaymentStatusSuccessBinding
import com.example.wprintapp.modules.paymentstatussuccess.`data`.viewmodel.PaymentStatusSuccessVM
import com.example.wprintapp.modules.uploadingfile.ui.UploadingFileActivity
import kotlin.String
import kotlin.Unit

class PaymentStatusSuccessActivity :
    BaseActivity<ActivityPaymentStatusSuccessBinding>(R.layout.activity_payment_status_success) {
  private val viewModel: PaymentStatusSuccessVM by viewModels<PaymentStatusSuccessVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.paymentStatusSuccessVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearColumnprintjobstatu.setOnClickListener {
      val destIntent = UploadingFileActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PAYMENT_STATUS_SUCCESS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PaymentStatusSuccessActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
