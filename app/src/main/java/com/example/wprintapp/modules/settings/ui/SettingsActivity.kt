package com.example.wprintapp.modules.settings.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivitySettingsBinding
import com.example.wprintapp.modules.about.ui.AboutActivity
import com.example.wprintapp.modules.editprofile.ui.EditProfileActivity
import com.example.wprintapp.modules.helpfaq.ui.HelpFaqActivity
import com.example.wprintapp.modules.settings.`data`.viewmodel.SettingsVM
import com.example.wprintapp.modules.terms.ui.TermsActivity
import kotlin.String
import kotlin.Unit

class SettingsActivity : BaseActivity<ActivitySettingsBinding>(R.layout.activity_settings) {
  private val viewModel: SettingsVM by viewModels<SettingsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.settingsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearRowhelpfaq.setOnClickListener {
      val destIntent = HelpFaqActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowabout.setOnClickListener {
      val destIntent = AboutActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowtermsofservic.setOnClickListener {
      val destIntent = TermsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowedit.setOnClickListener {
      val destIntent = EditProfileActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SETTINGS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SettingsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
