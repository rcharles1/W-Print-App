package com.example.wprintapp.modules.settingssignedout.ui

import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivitySettingsSignedOutBinding
import com.example.wprintapp.modules.about.ui.AboutActivity
import com.example.wprintapp.modules.editprofile.ui.EditProfileActivity
import com.example.wprintapp.modules.helpfaq.ui.HelpFaqActivity
import com.example.wprintapp.modules.profile.ui.ProfileActivity
import com.example.wprintapp.modules.settingssignedout.`data`.viewmodel.SettingsSignedOutVM
import com.example.wprintapp.modules.terms.ui.TermsActivity
import kotlin.String
import kotlin.Unit

class SettingsSignedOutActivity :
    BaseActivity<ActivitySettingsSignedOutBinding>(R.layout.activity_settings_signed_out) {
  private val viewModel: SettingsSignedOutVM by viewModels<SettingsSignedOutVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.settingsSignedOutVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearRowabout.setOnClickListener {
      val destIntent = AboutActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowhelpfaq.setOnClickListener {
      val destIntent = HelpFaqActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowtermsofservic.setOnClickListener {
      val destIntent = TermsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.viewFrameFortyOne.setOnClickListener {
      val destIntent = ProfileActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowedit.setOnClickListener {
      val destIntent = EditProfileActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SETTINGS_SIGNED_OUT_ACTIVITY"

  }
}
