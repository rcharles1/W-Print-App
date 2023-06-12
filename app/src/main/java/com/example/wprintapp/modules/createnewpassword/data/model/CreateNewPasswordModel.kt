package com.example.wprintapp.modules.createnewpassword.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class CreateNewPasswordModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtCreatenewpass: String? =
      MyApp.getInstance().resources.getString(R.string.msg_create_new_pass)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtYournewpasswo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_your_new_passwo)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeZone: String? = MyApp.getInstance().resources.getString(R.string.msg_must_be_at_leas)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeZoneOne: String? = MyApp.getInstance().resources.getString(R.string.msg_both_passwords)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etInteractivePasValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etInteractivePasOneValue: String? = null
)
