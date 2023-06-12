package com.example.wprintapp.modules.settingssignedout.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class SettingsSignedOutModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSettings: String? = MyApp.getInstance().resources.getString(R.string.lbl_settings)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGeneralSetting: String? =
      MyApp.getInstance().resources.getString(R.string.msg_general_setting)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEdit: String? = MyApp.getInstance().resources.getString(R.string.lbl_edit)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPushNotificati: String? =
      MyApp.getInstance().resources.getString(R.string.msg_push_notificati)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAllowfetchto: String? =
      MyApp.getInstance().resources.getString(R.string.msg_allow_fetch_to)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTheme: String? = MyApp.getInstance().resources.getString(R.string.lbl_theme)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSelectthethem: String? =
      MyApp.getInstance().resources.getString(R.string.msg_select_the_them)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSupport: String? = MyApp.getInstance().resources.getString(R.string.lbl_support)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTermsofServic: String? =
      MyApp.getInstance().resources.getString(R.string.msg_terms_of_servic)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAbout: String? = MyApp.getInstance().resources.getString(R.string.lbl_about2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHelpFAQ: String? = MyApp.getInstance().resources.getString(R.string.lbl_help_faq)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSignout: String? = MyApp.getInstance().resources.getString(R.string.lbl_sign_out)

)
