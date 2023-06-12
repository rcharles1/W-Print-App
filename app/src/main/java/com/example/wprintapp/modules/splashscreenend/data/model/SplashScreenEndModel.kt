package com.example.wprintapp.modules.splashscreenend.data.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class SplashScreenEndModel(
    /**
     * TODO Replace with dynamic value
     */
    var txtWPrint: String? = MyApp.getInstance().resources.getString(R.string.lbl_w_print)

)