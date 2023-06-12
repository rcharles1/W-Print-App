package com.example.wprintapp.modules.jobstatusqueued.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityJobStatusQueuedBinding
import com.example.wprintapp.modules.homecontainer.ui.HomeContainerActivity
import com.example.wprintapp.modules.jobstatusqueued.`data`.viewmodel.JobStatusQueuedVM
import kotlin.String
import kotlin.Unit

class JobStatusQueuedActivity :
    BaseActivity<ActivityJobStatusQueuedBinding>(R.layout.activity_job_status_queued) {
  private val viewModel: JobStatusQueuedVM by viewModels<JobStatusQueuedVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.jobStatusQueuedVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtCANCEL.setOnClickListener {
      val destIntent = HomeContainerActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "JOB_STATUS_QUEUED_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, JobStatusQueuedActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
