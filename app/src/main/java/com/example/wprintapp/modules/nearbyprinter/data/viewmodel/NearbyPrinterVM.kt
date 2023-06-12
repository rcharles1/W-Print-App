package com.example.wprintapp.modules.nearbyprinter.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.nearbyprinter.`data`.model.NearbyPrinterModel
import org.koin.core.KoinComponent

class NearbyPrinterVM : ViewModel(), KoinComponent {
  val nearbyPrinterModel: MutableLiveData<NearbyPrinterModel> =
      MutableLiveData(NearbyPrinterModel())

  var navArguments: Bundle? = null
}
