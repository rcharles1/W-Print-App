package com.example.wprintapp.modules.resetforgottenpasswordone.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class ResetForgottenPasswordOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtResetpassword: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_reset_password2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEnterthephone: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_the_phone)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRectangleThirtyOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_did_not_receive)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etLanguageValue: String? = null
)
