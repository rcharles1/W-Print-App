package com.example.wprintapp.modules.printpreview.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.printpreview.`data`.model.PrintPreviewModel
import org.koin.core.KoinComponent

class PrintPreviewVM : ViewModel(), KoinComponent {
  val printPreviewModel: MutableLiveData<PrintPreviewModel> = MutableLiveData(PrintPreviewModel())

  var navArguments: Bundle? = null
}
