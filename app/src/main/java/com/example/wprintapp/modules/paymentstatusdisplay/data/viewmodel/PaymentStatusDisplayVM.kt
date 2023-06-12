package com.example.wprintapp.modules.paymentstatusdisplay.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.paymentstatusdisplay.`data`.model.PaymentStatusDisplayModel
import org.koin.core.KoinComponent

class PaymentStatusDisplayVM : ViewModel(), KoinComponent {
  val paymentStatusDisplayModel: MutableLiveData<PaymentStatusDisplayModel> =
      MutableLiveData(PaymentStatusDisplayModel())

  var navArguments: Bundle? = null
}
