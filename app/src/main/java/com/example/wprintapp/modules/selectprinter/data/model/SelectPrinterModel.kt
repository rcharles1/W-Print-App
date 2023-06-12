package com.example.wprintapp.modules.selectprinter.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class SelectPrinterModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSelectPrinter: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_select_printer)

)
