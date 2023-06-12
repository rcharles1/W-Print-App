package com.example.wprintapp.modules.printersowned.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.printersowned.`data`.model.PrintersOwnedModel
import org.koin.core.KoinComponent

class PrintersOwnedVM : ViewModel(), KoinComponent {
  val printersOwnedModel: MutableLiveData<PrintersOwnedModel> =
      MutableLiveData(PrintersOwnedModel())

  var navArguments: Bundle? = null
}
