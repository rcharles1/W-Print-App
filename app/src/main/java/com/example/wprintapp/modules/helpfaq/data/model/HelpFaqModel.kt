package com.example.wprintapp.modules.helpfaq.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class HelpFaqModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHelpFAQ: String? = MyApp.getInstance().resources.getString(R.string.lbl_help_faq)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrintingovera: String? =
      MyApp.getInstance().resources.getString(R.string.msg_printing_over_a)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? =
      MyApp.getInstance().resources.getString(R.string.msg_before_you_star)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrintingovert: String? =
      MyApp.getInstance().resources.getString(R.string.msg_printing_over_t)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescriptionOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_this_option_may)

)
