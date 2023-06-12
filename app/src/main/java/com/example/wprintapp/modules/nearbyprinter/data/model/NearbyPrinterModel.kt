package com.example.wprintapp.modules.nearbyprinter.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class NearbyPrinterModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtNearbyPrinter: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_nearby_printer)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTurnonWiFit: String? =
      MyApp.getInstance().resources.getString(R.string.msg_turn_on_wi_fi_t)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPairedPrinter: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_paired_printer)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAvailablePrint: String? =
      MyApp.getInstance().resources.getString(R.string.msg_available_print)

)
