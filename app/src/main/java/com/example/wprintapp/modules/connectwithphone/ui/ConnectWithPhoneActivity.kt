package com.example.wprintapp.modules.connectwithphone.ui


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityConnectWithPhoneBinding
import com.example.wprintapp.modules.connectwithphone.data.viewmodel.ConnectWithPhoneVM
import com.example.wprintapp.modules.homecontainer.ui.HomeContainerActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit


class ConnectWithPhoneActivity :
    BaseActivity<ActivityConnectWithPhoneBinding>(R.layout.activity_connect_with_phone) {
  private val viewModel: ConnectWithPhoneVM by viewModels()
  private lateinit var auth: FirebaseAuth
  private lateinit var callbacks:PhoneAuthProvider.OnVerificationStateChangedCallbacks
  lateinit var storedVerificationId:String
  lateinit var resendToken:PhoneAuthProvider.ForceResendingToken

  @SuppressLint("SetTextI18n")
  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.connectWithPhoneVM = viewModel

    auth = Firebase.auth

    val myButton = findViewById<AppCompatButton>(R.id.btnSendOTP)
    myButton.text = "SEND OTP"

  }


  override fun setUpClicks() {

    binding.imageArrowleft.setOnClickListener {
      finish()
    }

    binding.btnSendOTP.setOnClickListener{
      val phone = binding.etPhone.text.toString()

      //validating input
      if (phone.isNotEmpty()){
        // phone number to match local phone number
        val formattedNumber = PhoneNumberUtils.formatNumber(phone, "TZ")
        sendVerificationCode(formattedNumber)
      }else{

        //Display error message
        Toast.makeText(this,"An Empty Field is not Allowed", Toast.LENGTH_SHORT).show()
      }

    }

    binding.btnSignIn.setOnClickListener {
      val otp = binding.etOTP.text.toString()
      //validating input
      if (otp.isNotEmpty()){
        verifyVerificationCode(otp)

      }else{
        //Display error message
        Toast.makeText(this,"Please Enter OTP", Toast.LENGTH_SHORT).show()
      }

      callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        override fun onVerificationCompleted(credential: PhoneAuthCredential) {

          //Detect sms
          val code = credential.smsCode
          if (code!=null){
            binding.etOTP.setText(code)
          }

        }

        override fun onVerificationFailed(e: FirebaseException) {
          Toast.makeText(applicationContext,"Authentication Failed!", Toast.LENGTH_SHORT).show()
//          // This callback is invoked in an invalid request for verification is made,
//          // for instance if the the phone number format is not valid.
//          Log.w(TAG, "onVerificationFailed", e)
//
//          if (e is FirebaseAuthInvalidCredentialsException) {
//            // Invalid request
//          } else if (e is FirebaseTooManyRequestsException) {
//            // The SMS quota for the project has been exceeded
//          } else if (e is FirebaseAuthMissingActivityForRecaptchaException) {
//            // reCAPTCHA verification attempted with null Activity
//          }
//
//          // Show a message and update the UI
        }


        override fun onCodeSent(
          verificationId: String,
          token: PhoneAuthProvider.ForceResendingToken,
        ) {
          // The SMS verification code has been sent to the provided phone number, we
          // now need to ask the user to enter the code and then construct a credential
          // by combining the code with a verification ID.

          // Save verification ID and resending token so we can use them later
          storedVerificationId = verificationId
          resendToken = token

        }
      }
    }
    }


  private fun sendVerificationCode(formattedNumber:String){
    val options = PhoneAuthOptions.newBuilder(auth)
      .setPhoneNumber(formattedNumber) // Phone number to verify
      .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
      .setActivity(this) // Activity (for callback binding)
      .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
      .build()
    PhoneAuthProvider.verifyPhoneNumber(options)

  }

  private fun verifyVerificationCode(code:String){
    val credential = PhoneAuthProvider.getCredential(storedVerificationId, code)
    signUp(credential)

  }

  private fun signUp(credential: PhoneAuthCredential){
    auth.signInWithCredential(credential)
      .addOnCompleteListener(this) { task ->
        if (task.isSuccessful) {
          // Sign in success, update UI with the signed-in user's information
          task.result?.user
          val destIntent = HomeContainerActivity.getIntent(this, null)
          startActivity(destIntent)
          finish()

        } else {

          if (task.exception is FirebaseAuthInvalidCredentialsException) {
            // The verification code entered was invalid
            Toast.makeText(applicationContext,"Code entered is incorrect", Toast.LENGTH_SHORT).show()
            binding.etOTP.setText("")
          }
          // Update UI
        }
      }
  }


  companion object {
    const val TAG: String = "CONNECT_WITH_PHONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ConnectWithPhoneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
