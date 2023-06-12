package com.example.wprintapp.modules.jobstatussuccess.ui

import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityJobStatusSuccessBinding
import com.example.wprintapp.modules.homecontainer.ui.HomeContainerActivity
import com.example.wprintapp.modules.jobstatussuccess.`data`.viewmodel.JobStatusSuccessVM
import kotlin.String
import kotlin.Unit

class JobStatusSuccessActivity :
    BaseActivity<ActivityJobStatusSuccessBinding>(R.layout.activity_job_status_success) {
  private val viewModel: JobStatusSuccessVM by viewModels<JobStatusSuccessVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.jobStatusSuccessVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtDONE.setOnClickListener {
      val destIntent = HomeContainerActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "JOB_STATUS_SUCCESS_ACTIVITY"

  }
}
