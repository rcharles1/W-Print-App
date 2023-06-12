package com.example.wprintapp.modules.helpfaq.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.helpfaq.`data`.model.HelpFaqModel
import org.koin.core.KoinComponent

class HelpFaqVM : ViewModel(), KoinComponent {
  val helpFaqModel: MutableLiveData<HelpFaqModel> = MutableLiveData(HelpFaqModel())

  var navArguments: Bundle? = null
}
