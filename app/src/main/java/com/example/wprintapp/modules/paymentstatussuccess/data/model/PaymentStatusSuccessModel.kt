package com.example.wprintapp.modules.paymentstatussuccess.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class PaymentStatusSuccessModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_payment_success)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrintJobStatu: String? =
      MyApp.getInstance().resources.getString(R.string.msg_print_job_statu)

)
