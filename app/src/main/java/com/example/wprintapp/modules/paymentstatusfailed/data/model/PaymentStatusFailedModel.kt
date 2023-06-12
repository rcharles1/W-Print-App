package com.example.wprintapp.modules.paymentstatusfailed.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class PaymentStatusFailedModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtPaymentFailed: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_payment_failed)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPleaseconsider: String? =
      MyApp.getInstance().resources.getString(R.string.msg_please_consider)

)
