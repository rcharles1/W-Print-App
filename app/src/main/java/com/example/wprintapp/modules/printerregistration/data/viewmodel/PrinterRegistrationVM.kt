package com.example.wprintapp.modules.printerregistration.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.printerregistration.`data`.model.PrinterRegistrationModel
import org.koin.core.KoinComponent

class PrinterRegistrationVM : ViewModel(), KoinComponent {
  val printerRegistrationModel: MutableLiveData<PrinterRegistrationModel> =
      MutableLiveData(PrinterRegistrationModel())

  var navArguments: Bundle? = null
}
