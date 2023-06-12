package com.example.wprintapp.modules.printoptions.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.printoptions.`data`.model.PrintOptionsModel
import org.koin.core.KoinComponent

class PrintOptionsVM : ViewModel(), KoinComponent {
  val printOptionsModel: MutableLiveData<PrintOptionsModel> = MutableLiveData(PrintOptionsModel())

  var navArguments: Bundle? = null
}
