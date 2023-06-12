package com.example.wprintapp.modules.paymentmethod.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.paymentmethod.`data`.model.PaymentMethodModel
import org.koin.core.KoinComponent

class PaymentMethodVM : ViewModel(), KoinComponent {
  val paymentMethodModel: MutableLiveData<PaymentMethodModel> =
      MutableLiveData(PaymentMethodModel())

  var navArguments: Bundle? = null
}
