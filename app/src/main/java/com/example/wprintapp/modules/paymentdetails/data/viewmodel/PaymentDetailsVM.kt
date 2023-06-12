package com.example.wprintapp.modules.paymentdetails.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.paymentdetails.`data`.model.PaymentDetailsModel
import org.koin.core.KoinComponent

class PaymentDetailsVM : ViewModel(), KoinComponent {
  val paymentDetailsModel: MutableLiveData<PaymentDetailsModel> =
      MutableLiveData(PaymentDetailsModel())

  var navArguments: Bundle? = null
}
