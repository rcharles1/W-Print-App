package com.example.wprintapp.modules.terms.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.terms.`data`.model.TermsModel
import org.koin.core.KoinComponent

class TermsVM : ViewModel(), KoinComponent {
  val termsModel: MutableLiveData<TermsModel> = MutableLiveData(TermsModel())

  var navArguments: Bundle? = null
}
