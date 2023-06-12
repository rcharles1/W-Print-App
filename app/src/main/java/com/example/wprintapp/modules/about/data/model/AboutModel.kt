package com.example.wprintapp.modules.about.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class AboutModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_about)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrintdocuments: String? =
      MyApp.getInstance().resources.getString(R.string.msg_print_documents)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageOne: String? = MyApp.getInstance().resources.getString(R.string.msg_copyright)

)
