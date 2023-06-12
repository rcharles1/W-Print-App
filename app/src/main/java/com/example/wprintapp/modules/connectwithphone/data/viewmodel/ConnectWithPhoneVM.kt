package com.example.wprintapp.modules.connectwithphone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.connectwithphone.`data`.model.ConnectWithPhoneModel
import org.koin.core.KoinComponent

class ConnectWithPhoneVM : ViewModel(), KoinComponent {
  val connectWithPhoneModel: MutableLiveData<ConnectWithPhoneModel> =
      MutableLiveData(ConnectWithPhoneModel())

  var navArguments: Bundle? = null
}
