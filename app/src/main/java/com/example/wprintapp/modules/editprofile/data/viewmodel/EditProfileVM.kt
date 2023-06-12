package com.example.wprintapp.modules.editprofile.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.editprofile.`data`.model.EditProfileModel
import org.koin.core.KoinComponent

class EditProfileVM : ViewModel(), KoinComponent {
  val editProfileModel: MutableLiveData<EditProfileModel> = MutableLiveData(EditProfileModel())

  var navArguments: Bundle? = null
}
