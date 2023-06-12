package com.example.wprintapp.modules.remoteprinter.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.remoteprinter.`data`.model.RemotePrinterModel
import com.example.wprintapp.modules.remoteprinter.`data`.model.RemotePrinterRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class RemotePrinterVM : ViewModel(), KoinComponent {
  val remotePrinterModel: MutableLiveData<RemotePrinterModel> =
      MutableLiveData(RemotePrinterModel())

  var navArguments: Bundle? = null

  val remotePrinterList: MutableLiveData<MutableList<RemotePrinterRowModel>> =
      MutableLiveData(mutableListOf())
}
