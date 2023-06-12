package com.example.wprintapp.modules.printfee.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class ListtshcounterRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtA0: String? = MyApp.getInstance().resources.getString(R.string.lbl_a0)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTshCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_tsh_0_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTshCounterOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_tsh_0_00)

)
