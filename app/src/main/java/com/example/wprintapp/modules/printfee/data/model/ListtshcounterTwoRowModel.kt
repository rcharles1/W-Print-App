package com.example.wprintapp.modules.printfee.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class ListtshcounterTwoRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtA2: String? = MyApp.getInstance().resources.getString(R.string.lbl_a2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTshCounterTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_tsh_0_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTshCounterOneTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_tsh_0_00)

)
