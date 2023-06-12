package com.example.wprintapp.modules.neabrysettings.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class NeabrySettingsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtNearbyDetails: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_nearby_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etInteractiveInpValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etInteractiveInpOneValue: String? = null
)
