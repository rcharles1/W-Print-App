package com.example.wprintapp.modules.printpreview.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class PrintPreviewModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPrintPreview: String? = MyApp.getInstance().resources.getString(R.string.lbl_print_preview)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etLanguageValue: String? = null
)
