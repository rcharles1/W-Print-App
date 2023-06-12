package com.example.wprintapp.modules.splashscreenend.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivitySplashScreenEndBinding
import com.example.wprintapp.modules.signin.ui.SignInActivity
import com.example.wprintapp.modules.splashscreenend.data.viewmodel.SplashScreenEndVM
import kotlin.String
import kotlin.Unit

@SuppressLint("CustomSplashScreen")
class SplashScreenEndActivity :
  BaseActivity<ActivitySplashScreenEndBinding>(R.layout.activity_splash_screen_end) {
  private val viewModel: SplashScreenEndVM by viewModels()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.splashScreenEndVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = SignInActivity.getIntent(this, null)
//      destIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
      startActivity(destIntent)
      finish()
    }, 1500)
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SPLASH_SCREEN_END_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SplashScreenEndActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
