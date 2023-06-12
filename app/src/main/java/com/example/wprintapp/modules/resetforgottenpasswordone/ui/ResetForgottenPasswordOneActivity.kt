package com.example.wprintapp.modules.resetforgottenpasswordone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityResetForgottenPasswordOneBinding
import com.example.wprintapp.modules.createnewpassword.ui.CreateNewPasswordActivity
import com.example.wprintapp.modules.resetforgottenpasswordone.data.viewmodel.ResetForgottenPasswordOneVM
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ResetForgottenPasswordOneActivity :
    BaseActivity<ActivityResetForgottenPasswordOneBinding>(R.layout.activity_reset_forgotten_password_one)
    {
  private val viewModel: ResetForgottenPasswordOneVM by viewModels()
      private lateinit var auth: FirebaseAuth

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.resetForgottenPasswordOneVM = viewModel

    auth = Firebase.auth
  }

  override fun setUpClicks() {
    binding.btnSendCode.setOnClickListener{
      val email = binding.etUserEmail
      compareEmail(email)
    }
    binding.btnVerifyCode.setOnClickListener {
      val destIntent = CreateNewPasswordActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }
      private fun compareEmail(email:EditText) {
        if (email.text.toString().isNotEmpty()) {
          if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
            Toast.makeText(this,"Enter a valid email address",Toast.LENGTH_SHORT).show()
          }else {
            auth.sendPasswordResetEmail(email.text.toString()).addOnCompleteListener{ task->
              if (task.isSuccessful){
                Toast.makeText(this,"Email sent! Check your email.",Toast.LENGTH_SHORT).show()
              }
            }
          }
        }else{
          Toast.makeText(this, "Enter an email address to continue", Toast.LENGTH_SHORT).show()
        }
      }

  companion object {
    const val TAG: String = "RESET_FORGOTTEN_PASSWORD_ONE_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ResetForgottenPasswordOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
