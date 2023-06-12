package com.example.wprintapp.modules.neabrysettings.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.neabrysettings.`data`.model.NeabrySettingsModel
import org.koin.core.KoinComponent

class NearbySettingsVM : ViewModel(), KoinComponent {
  val neabrySettingsModel: MutableLiveData<NeabrySettingsModel> =
      MutableLiveData(NeabrySettingsModel())

  var navArguments: Bundle? = null
}
