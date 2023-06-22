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
import com.example.wprintapp.modules.homecontainer.ui.HomeContainerActivity
import com.example.wprintapp.modules.signin.ui.SignInActivity
import com.example.wprintapp.modules.splashscreenend.data.viewmodel.SplashScreenEndVM
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.String
import kotlin.Unit

@SuppressLint("CustomSplashScreen")
class SplashScreenEndActivity :
  BaseActivity<ActivitySplashScreenEndBinding>(R.layout.activity_splash_screen_end) {
  private val viewModel: SplashScreenEndVM by viewModels()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.splashScreenEndVM = viewModel

    val user = Firebase.auth.currentUser

    if (user != null) {
      // User is already signed in, allow them to continue using the app
      val i = HomeContainerActivity.getIntent(this, null)
      startActivity(i)
    } else {

      // No user is signed in, show the login screen
        val destIntent = SignInActivity.getIntent(this, null)
        startActivity(destIntent)
        finish() //Prevents splash screen from being included in app's back stack.
      }
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
