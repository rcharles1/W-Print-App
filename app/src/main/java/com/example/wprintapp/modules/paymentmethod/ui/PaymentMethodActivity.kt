package com.example.wprintapp.modules.paymentmethod.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityPaymentMethodBinding
import com.example.wprintapp.modules.paymentdetails.ui.PaymentDetailsActivity
import com.example.wprintapp.modules.paymentmethod.`data`.viewmodel.PaymentMethodVM
import com.example.wprintapp.modules.uploadingfile.ui.UploadingFileActivity
import kotlin.String
import kotlin.Unit

class PaymentMethodActivity :
    BaseActivity<ActivityPaymentMethodBinding>(R.layout.activity_payment_method) {
  private val viewModel: PaymentMethodVM by viewModels<PaymentMethodVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.paymentMethodVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnVodacom.setOnClickListener {
      val destIntent = PaymentDetailsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnTigo.setOnClickListener {
      val destIntent = PaymentDetailsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnAirtel.setOnClickListener {
      val destIntent = PaymentDetailsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnHalotel.setOnClickListener {
      val destIntent = PaymentDetailsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnCash.setOnClickListener {
      val destIntent = UploadingFileActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PAYMENT_METHOD_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PaymentMethodActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
