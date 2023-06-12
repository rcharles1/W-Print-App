package com.example.wprintapp.modules.splashscreenstart.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivitySplashScreenStartBinding
import com.example.wprintapp.modules.splashscreenend.ui.SplashScreenEndActivity
import com.example.wprintapp.modules.splashscreenstart.data.viewmodel.SplashScreenStartVM
import kotlin.String
import kotlin.Unit

@SuppressLint("CustomSplashScreen")
class SplashScreenStartActivity :
    BaseActivity<ActivitySplashScreenStartBinding>(R.layout.activity_splash_screen_start) {
    private val viewModel: SplashScreenStartVM by viewModels()

    override fun onInitialized(): Unit {
        viewModel.navArguments = intent.extras?.getBundle("bundle")
        binding.splashScreenStartVM = viewModel
        window.statusBarColor = ContextCompat.getColor(this,R.color.deep_purple_500)
        Handler(Looper.getMainLooper()).postDelayed( {
            val destIntent = SplashScreenEndActivity.getIntent(this, null)
            destIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(destIntent)
            finish()
        }, 1000)
    }

    override fun setUpClicks(): Unit {
        binding.viewSplashscreens.setOnClickListener {
            val destIntent = SplashScreenEndActivity.getIntent(this, null)
            startActivity(destIntent)
        }
    }

    companion object {
        const val TAG: String = "SPLASH_SCREEN_START_ACTIVITY"

    }
}