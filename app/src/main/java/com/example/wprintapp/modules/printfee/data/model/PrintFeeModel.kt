package com.example.wprintapp.modules.printfee.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class PrintFeeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSetPrintFee: String? = MyApp.getInstance().resources.getString(R.string.lbl_set_print_fee)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_depending_on_pa)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBWhite: String? = MyApp.getInstance().resources.getString(R.string.lbl_b_white)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtColored: String? = MyApp.getInstance().resources.getString(R.string.lbl_colored)

)
