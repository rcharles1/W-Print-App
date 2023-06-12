package com.example.wprintapp.modules.paymentmethod.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class PaymentMethodModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtYourInvoice: String? = MyApp.getInstance().resources.getString(R.string.lbl_your_invoice)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTotalDue: String? = MyApp.getInstance().resources.getString(R.string.lbl_total_due)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTshCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_tsh_1700)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt000011233: String? = MyApp.getInstance().resources.getString(R.string.lbl_000011233)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTotalPages: String? = MyApp.getInstance().resources.getString(R.string.lbl_total_pages)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPagesCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_8_pages)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSubtotals: String? = MyApp.getInstance().resources.getString(R.string.lbl_subtotals)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrintColor: String? = MyApp.getInstance().resources.getString(R.string.lbl_print_color)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtColored: String? = MyApp.getInstance().resources.getString(R.string.lbl_colored)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrintSize: String? = MyApp.getInstance().resources.getString(R.string.lbl_print_size)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtA4: String? = MyApp.getInstance().resources.getString(R.string.lbl_a4)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrintPreview: String? = MyApp.getInstance().resources.getString(R.string.lbl_print_preview)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_confirm_invoic)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etGroupThirteenValue: String? = null
)
