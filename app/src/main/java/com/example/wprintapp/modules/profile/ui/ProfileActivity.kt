package com.example.wprintapp.modules.profile.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityProfileBinding
import com.example.wprintapp.modules.printerregistration.ui.PrinterRegistrationActivity
import com.example.wprintapp.modules.printersowned.ui.PrintersOwnedActivity
import com.example.wprintapp.modules.profile.`data`.viewmodel.ProfileVM
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.String
import kotlin.Unit

class ProfileActivity : BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {
  private val viewModel: ProfileVM by viewModels()
  private lateinit var auth: FirebaseAuth

  @SuppressLint("SetTextI18n")
  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.profileVM = viewModel
    //Initialize firebase
    auth = Firebase.auth


    val user = auth.currentUser
    user?.let {
      val name = it.displayName
      val email = it.email
      val phone = it.phoneNumber

      binding.userName.text= name
      binding.etEmail.text = email
      binding.etMobileNo.text= phone
    }


  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }

    binding.addImageView.setOnClickListener{
      val intent = PrinterRegistrationActivity.getIntent(this, null)
      startActivity(intent)
    }
    binding.etFrameSix.setOnClickListener {
      val destIntent = PrintersOwnedActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PROFILE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ProfileActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
