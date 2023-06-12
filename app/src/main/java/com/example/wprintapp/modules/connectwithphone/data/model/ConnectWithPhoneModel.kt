package com.example.wprintapp.modules.connectwithphone.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class ConnectWithPhoneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtConnectwithph: String? =
      MyApp.getInstance().resources.getString(R.string.msg_connect_with_ph)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etLanguageValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etInteractivePasValue: String? = null
)
