package com.example.wprintapp.modules.splashscreenend.data.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.splashscreenend.data.model.SplashScreenEndModel
import org.koin.core.KoinComponent

class SplashScreenEndVM : ViewModel(), KoinComponent {
    val splashScreenEndModel: MutableLiveData<SplashScreenEndModel> =
        MutableLiveData(SplashScreenEndModel())

    var navArguments: Bundle? = null
}