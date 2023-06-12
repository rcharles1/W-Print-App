package com.example.wprintapp.modules.neabrysettings.ui

import androidx.fragment.app.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseDialogFragment
import com.example.wprintapp.databinding.DialogNearbySettingsBinding
import com.example.wprintapp.modules.neabrysettings.`data`.viewmodel.NearbySettingsVM
import kotlin.String
import kotlin.Unit

class NeabrySettingsDialog :
    BaseDialogFragment<DialogNearbySettingsBinding>(R.layout.dialog_nearby_settings) {
  private val viewModel: NearbySettingsVM by viewModels<NearbySettingsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    binding.neabrySettingsVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "NEABRY_SETTINGS_DIALOG"

  }
}
