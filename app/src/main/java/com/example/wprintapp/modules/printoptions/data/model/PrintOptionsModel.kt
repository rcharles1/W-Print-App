package com.example.wprintapp.modules.printoptions.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class PrintOptionsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPrintOptions: String? = MyApp.getInstance().resources.getString(R.string.lbl_print_options)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrinterSelecte: String? =
      MyApp.getInstance().resources.getString(R.string.msg_printer_selecte)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCopies: String? = MyApp.getInstance().resources.getString(R.string.lbl_copies)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDuplexMode: String? = MyApp.getInstance().resources.getString(R.string.lbl_duplex_mode)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPaperOrientati: String? =
      MyApp.getInstance().resources.getString(R.string.msg_paper_orientati)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPaperSize: String? = MyApp.getInstance().resources.getString(R.string.lbl_paper_size)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPaperSizeOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_a4)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrintoutColor: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_printout_color)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etFrameTwentySixValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etOrientationDroValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etColorValue: String? = null
)
