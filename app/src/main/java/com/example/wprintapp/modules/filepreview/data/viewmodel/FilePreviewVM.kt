package com.example.wprintapp.modules.filepreview.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.filepreview.`data`.model.FilePreviewModel
import org.koin.core.KoinComponent

class FilePreviewVM : ViewModel(), KoinComponent {
  val filePreviewModel: MutableLiveData<FilePreviewModel> = MutableLiveData(FilePreviewModel())

  var navArguments: Bundle? = null
}
