package com.example.wprintapp.modules.uploadingfile.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.uploadingfile.`data`.model.UploadingFileModel
import org.koin.core.KoinComponent

class UploadingFileVM : ViewModel(), KoinComponent {
  val uploadingFileModel: MutableLiveData<UploadingFileModel> =
      MutableLiveData(UploadingFileModel())

  var navArguments: Bundle? = null
}
