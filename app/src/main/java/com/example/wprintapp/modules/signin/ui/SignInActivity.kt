package com.example.wprintapp.modules.signin.ui

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivitySignInBinding
import com.example.wprintapp.modules.connectwithphone.ui.ConnectWithPhoneActivity
import com.example.wprintapp.modules.homecontainer.ui.HomeContainerActivity
import com.example.wprintapp.modules.resetforgottenpasswordone.ui.ResetForgottenPasswordOneActivity
import com.example.wprintapp.modules.signin.data.viewmodel.SignInVM
import com.example.wprintapp.modules.signup.ui.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : BaseActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
  private val viewModel: SignInVM by viewModels()
  private lateinit var auth:FirebaseAuth


    override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signInVM = viewModel

    //Initialize Firebase Auth
    auth = Firebase.auth

    }

  override fun setUpClicks() {
    binding.btnSignIn.setOnClickListener {
//      val destIntent = HomeContainerActivity.getIntent(this, null)
      val emailAddress = binding.etEmail.text.toString()
      val password = binding.etInteractivePas.text.toString()

      //validating input
      if (emailAddress.isNotEmpty() && password.isNotEmpty()){
        auth.signInWithEmailAndPassword(emailAddress, password).addOnCompleteListener {
          if (it.isSuccessful){
            val destIntent = HomeContainerActivity.getIntent(this, null)
            startActivity(destIntent)
          }else{
            Toast.makeText(this,"Email provided does not match our records",Toast.LENGTH_SHORT).show()
          }
        }
      }else{
        //Display error message
        Toast.makeText(this,"Empty Fields Are not Allowed", Toast.LENGTH_SHORT).show()
      }

    }
    binding.txtForgotPassword.setOnClickListener {
      val destIntent = ResetForgottenPasswordOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtSignUpPage.setOnClickListener {
      val destIntent = SignUpActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnPhoneNumber.setOnClickListener {
      val destIntent = ConnectWithPhoneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGN_IN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignInActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
