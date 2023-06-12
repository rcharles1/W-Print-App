package com.example.wprintapp.modules.remoteprinter.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class RemotePrinterRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtCanonPIXMA: String? = MyApp.getInstance().resources.getString(R.string.lbl_canon_pixma)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCanonPIXMAOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_canon_pixma2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtArdhiUniversit: String? =
      MyApp.getInstance().resources.getString(R.string.msg_ardhi_universit)

)
