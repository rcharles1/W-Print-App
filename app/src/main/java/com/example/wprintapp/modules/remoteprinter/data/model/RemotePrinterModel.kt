package com.example.wprintapp.modules.remoteprinter.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class RemotePrinterModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRemotePrinter: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_remote_printer)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSearchResults: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_search_results2)

)
