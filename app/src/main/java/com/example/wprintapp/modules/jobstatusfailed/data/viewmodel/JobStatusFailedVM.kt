package com.example.wprintapp.modules.jobstatusfailed.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.jobstatusfailed.`data`.model.JobStatusFailedModel
import org.koin.core.KoinComponent

class JobStatusFailedVM : ViewModel(), KoinComponent {
  val jobStatusFailedModel: MutableLiveData<JobStatusFailedModel> =
      MutableLiveData(JobStatusFailedModel())

  var navArguments: Bundle? = null
}
