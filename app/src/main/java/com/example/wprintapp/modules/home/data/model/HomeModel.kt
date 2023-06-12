package com.example.wprintapp.modules.home.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class HomeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHome: String? = MyApp.getInstance().resources.getString(R.string.lbl_home)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSelectafilet: String? =
      MyApp.getInstance().resources.getString(R.string.msg_select_a_file_t)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDocument: String? = MyApp.getInstance().resources.getString(R.string.lbl_document)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPictures: String? = MyApp.getInstance().resources.getString(R.string.lbl_pictures)

)
