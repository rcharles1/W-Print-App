package com.example.wprintapp.modules.uploadingfile.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityUploadingFileBinding
import com.example.wprintapp.modules.jobstatusqueued.ui.JobStatusQueuedActivity
import com.example.wprintapp.modules.uploadingfile.`data`.viewmodel.UploadingFileVM
import kotlin.String
import kotlin.Unit

class UploadingFileActivity :
    BaseActivity<ActivityUploadingFileBinding>(R.layout.activity_uploading_file) {
  private val viewModel: UploadingFileVM by viewModels<UploadingFileVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.uploadingFileVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearUploadingfile.setOnClickListener {
      val destIntent = JobStatusQueuedActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "UPLOADING_FILE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, UploadingFileActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
