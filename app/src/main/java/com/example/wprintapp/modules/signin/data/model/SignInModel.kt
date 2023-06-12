package com.example.wprintapp.modules.signin.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class SignInModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLogintoyour: String? = MyApp.getInstance().resources.getString(R.string.msg_log_in_to_your)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcometoWPr: String? =
      MyApp.getInstance().resources.getString(R.string.msg_welcome_to_w_pr)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtForgotPassword: String? =
      MyApp.getInstance().resources.getString(R.string.msg_forgot_password)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtOrconnectusin: String? =
      MyApp.getInstance().resources.getString(R.string.msg_or_connect_usin)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmation: String? =
      MyApp.getInstance().resources.getString(R.string.msg_don_t_have_an_a)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etLanguageValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etInteractivePasValue: String? = null
)
