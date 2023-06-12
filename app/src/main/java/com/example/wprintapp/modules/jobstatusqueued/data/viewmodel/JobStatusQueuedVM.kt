package com.example.wprintapp.modules.jobstatusqueued.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.jobstatusqueued.`data`.model.JobStatusQueuedModel
import org.koin.core.KoinComponent

class JobStatusQueuedVM : ViewModel(), KoinComponent {
  val jobStatusQueuedModel: MutableLiveData<JobStatusQueuedModel> =
      MutableLiveData(JobStatusQueuedModel())

  var navArguments: Bundle? = null
}
