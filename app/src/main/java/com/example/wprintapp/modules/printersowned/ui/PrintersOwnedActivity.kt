package com.example.wprintapp.modules.printersowned.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityPrintersOwnedBinding
import com.example.wprintapp.modules.printersowned.`data`.viewmodel.PrintersOwnedVM
import kotlin.String
import kotlin.Unit

class PrintersOwnedActivity :
    BaseActivity<ActivityPrintersOwnedBinding>(R.layout.activity_printers_owned) {
  private val viewModel: PrintersOwnedVM by viewModels<PrintersOwnedVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.printersOwnedVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "PRINTERS_OWNED_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PrintersOwnedActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
