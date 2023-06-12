package com.example.wprintapp.modules.helpfaq.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityHelpFaqBinding
import com.example.wprintapp.modules.helpfaq.`data`.viewmodel.HelpFaqVM
import kotlin.String
import kotlin.Unit

class HelpFaqActivity : BaseActivity<ActivityHelpFaqBinding>(R.layout.activity_help_faq) {
  private val viewModel: HelpFaqVM by viewModels<HelpFaqVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.helpFaqVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "HELP_FAQ_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HelpFaqActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
