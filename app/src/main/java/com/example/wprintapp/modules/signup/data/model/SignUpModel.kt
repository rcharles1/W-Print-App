package com.example.wprintapp.modules.signup.`data`.model

import android.provider.ContactsContract.CommonDataKinds.Email
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class SignUpModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLetsGetStart: String? =
      MyApp.getInstance().resources.getString(R.string.msg_let_s_get_start)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCreateanaccou: String? =
      MyApp.getInstance().resources.getString(R.string.msg_create_an_accou)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmation: String? =
      MyApp.getInstance().resources.getString(R.string.msg_already_have_an)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var Username: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var Email: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var phone: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var password: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var confirmPassword: String? = null
)
