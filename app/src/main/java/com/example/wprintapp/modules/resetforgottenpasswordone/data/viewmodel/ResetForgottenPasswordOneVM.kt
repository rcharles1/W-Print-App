package com.example.wprintapp.modules.resetforgottenpasswordone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.resetforgottenpasswordone.`data`.model.ResetForgottenPasswordOneModel
import org.koin.core.KoinComponent

class ResetForgottenPasswordOneVM : ViewModel(), KoinComponent {
  val resetForgottenPasswordOneModel: MutableLiveData<ResetForgottenPasswordOneModel> =
      MutableLiveData(ResetForgottenPasswordOneModel())

  var navArguments: Bundle? = null
}
