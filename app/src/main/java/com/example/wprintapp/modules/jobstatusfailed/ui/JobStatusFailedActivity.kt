package com.example.wprintapp.modules.jobstatusfailed.ui

import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityJobStatusFailedBinding
import com.example.wprintapp.modules.homecontainer.ui.HomeContainerActivity
import com.example.wprintapp.modules.jobstatusfailed.`data`.viewmodel.JobStatusFailedVM
import kotlin.String
import kotlin.Unit

class JobStatusFailedActivity :
    BaseActivity<ActivityJobStatusFailedBinding>(R.layout.activity_job_status_failed) {
  private val viewModel: JobStatusFailedVM by viewModels<JobStatusFailedVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.jobStatusFailedVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtPrice.setOnClickListener {
      val destIntent = HomeContainerActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "JOB_STATUS_FAILED_ACTIVITY"

  }
}
