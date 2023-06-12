package com.example.wprintapp.modules.uploadingfile.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class UploadingFileModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtUploadingplea: String? =
      MyApp.getInstance().resources.getString(R.string.msg_uploading_plea)

)
