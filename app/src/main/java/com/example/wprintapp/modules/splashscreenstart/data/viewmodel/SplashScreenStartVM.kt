package com.example.wprintapp.modules.splashscreenstart.data.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.splashscreenstart.`data`.model.SplashScreenStartModel
import org.koin.core.KoinComponent

class SplashScreenStartVM : ViewModel(), KoinComponent {
  val splashScreenStartModel: MutableLiveData<SplashScreenStartModel> =
      MutableLiveData(SplashScreenStartModel())

  var navArguments: Bundle? = null
}
