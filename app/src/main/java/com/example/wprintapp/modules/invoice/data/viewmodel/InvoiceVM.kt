package com.example.wprintapp.modules.invoice.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.invoice.`data`.model.InvoiceModel
import org.koin.core.KoinComponent

class InvoiceVM : ViewModel(), KoinComponent {
  val invoiceModel: MutableLiveData<InvoiceModel> = MutableLiveData(InvoiceModel())

  var navArguments: Bundle? = null
}
