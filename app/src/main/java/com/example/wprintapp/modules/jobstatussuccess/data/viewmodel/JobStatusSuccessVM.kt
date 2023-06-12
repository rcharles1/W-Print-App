package com.example.wprintapp.modules.jobstatussuccess.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.jobstatussuccess.`data`.model.JobStatusSuccessModel
import org.koin.core.KoinComponent

class JobStatusSuccessVM : ViewModel(), KoinComponent {
  val jobStatusSuccessModel: MutableLiveData<JobStatusSuccessModel> =
      MutableLiveData(JobStatusSuccessModel())

  var navArguments: Bundle? = null
}
