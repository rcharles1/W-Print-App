package com.example.wprintapp.modules.about.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.about.`data`.model.AboutModel
import org.koin.core.KoinComponent

class AboutVM : ViewModel(), KoinComponent {
  val aboutModel: MutableLiveData<AboutModel> = MutableLiveData(AboutModel())

  var navArguments: Bundle? = null
}
