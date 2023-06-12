package com.example.wprintapp.modules.printerregistration.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class PrinterRegistrationModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRegisterPrinte: String? =
      MyApp.getInstance().resources.getString(R.string.msg_register_printe)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrinterDetails: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_printer_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCategory: String? = MyApp.getInstance().resources.getString(R.string.lbl_category)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPaymentDetails: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_payment_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSetPrintFee: String? = MyApp.getInstance().resources.getString(R.string.lbl_set_print_fee)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etInteractiveInpValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etLanguageValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etInteractiveInpOneValue: String? = null
)
