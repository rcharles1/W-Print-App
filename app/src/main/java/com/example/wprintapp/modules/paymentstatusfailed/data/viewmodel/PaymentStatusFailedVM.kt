package com.example.wprintapp.modules.paymentstatusfailed.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.paymentstatusfailed.`data`.model.PaymentStatusFailedModel
import org.koin.core.KoinComponent

class PaymentStatusFailedVM : ViewModel(), KoinComponent {
  val paymentStatusFailedModel: MutableLiveData<PaymentStatusFailedModel> =
      MutableLiveData(PaymentStatusFailedModel())

  var navArguments: Bundle? = null
}
