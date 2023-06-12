package com.example.wprintapp.modules.selectprinter.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.selectprinter.`data`.model.SelectPrinterModel
import org.koin.core.KoinComponent

class SelectPrinterVM : ViewModel(), KoinComponent {
  val selectPrinterModel: MutableLiveData<SelectPrinterModel> =
      MutableLiveData(SelectPrinterModel())

  var navArguments: Bundle? = null
}
