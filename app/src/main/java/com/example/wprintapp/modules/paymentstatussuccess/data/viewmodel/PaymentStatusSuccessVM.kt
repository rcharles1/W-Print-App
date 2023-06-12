package com.example.wprintapp.modules.paymentstatussuccess.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.paymentstatussuccess.`data`.model.PaymentStatusSuccessModel
import org.koin.core.KoinComponent

class PaymentStatusSuccessVM : ViewModel(), KoinComponent {
  val paymentStatusSuccessModel: MutableLiveData<PaymentStatusSuccessModel> =
      MutableLiveData(PaymentStatusSuccessModel())

  var navArguments: Bundle? = null
}
