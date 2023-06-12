package com.example.wprintapp.modules.filepreview.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class FilePreviewModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFilePreview: String? = MyApp.getInstance().resources.getString(R.string.lbl_file_preview)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSelectPrinter: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_select_printer)

)
