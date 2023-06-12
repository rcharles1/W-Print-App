package com.example.wprintapp.modules.favorites.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class FavoritesRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtCanonPIXMA: String? = MyApp.getInstance().resources.getString(R.string.lbl_canon_pixma)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBOOMStationary: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_boom_stationary)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtArdhiUniversit: String? =
      MyApp.getInstance().resources.getString(R.string.msg_ardhi_universit)

)
