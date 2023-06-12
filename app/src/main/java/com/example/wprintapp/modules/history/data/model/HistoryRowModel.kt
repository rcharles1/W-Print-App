package com.example.wprintapp.modules.history.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class HistoryRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTestPagepdf: String? = MyApp.getInstance().resources.getString(R.string.lbl_test_page_pdf)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCanonPIXMA: String? = MyApp.getInstance().resources.getString(R.string.lbl_canon_pixma)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNearbyPrinting: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_nearby_printing)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt1052023: String? = MyApp.getInstance().resources.getString(R.string.lbl_10_5_2023)

)
