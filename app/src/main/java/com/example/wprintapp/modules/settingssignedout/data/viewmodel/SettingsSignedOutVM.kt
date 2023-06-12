package com.example.wprintapp.modules.settingssignedout.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.settingssignedout.`data`.model.SettingsSignedOutModel
import org.koin.core.KoinComponent

class SettingsSignedOutVM : ViewModel(), KoinComponent {
  val settingsSignedOutModel: MutableLiveData<SettingsSignedOutModel> =
      MutableLiveData(SettingsSignedOutModel())

  var navArguments: Bundle? = null
}
