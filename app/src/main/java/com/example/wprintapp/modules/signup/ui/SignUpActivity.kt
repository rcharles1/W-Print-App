package com.example.wprintapp.modules.signup.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivitySignUpBinding
import com.example.wprintapp.modules.signin.ui.SignInActivity
import com.example.wprintapp.modules.signup.data.viewmodel.SignUpVM
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : BaseActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
  private val viewModel: SignUpVM by viewModels()
  private lateinit var auth: FirebaseAuth


  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUpVM = viewModel

    //Initialize Firebase Auth
    auth = Firebase.auth
  }

  @SuppressLint("ServiceCast")
  override fun setUpClicks() {
    binding.btnSignUp.setOnClickListener {

      val username = binding. UserName.text.toString()
      val emailAddress = binding.email.text.toString()
      val phoneNumber = binding.phone.text.toString()
      val password = binding.password.text.toString()
      val confirmPassword = binding.confirmPassword.text.toString()

      //validate inputs
      if (emailAddress.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty() && phoneNumber.isNotEmpty() && confirmPassword.isNotEmpty()){
        //Check for matching passwords
        if (password == confirmPassword){
          auth.createUserWithEmailAndPassword(emailAddress, password)
            .addOnCompleteListener(this) { task ->
              if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Toast.makeText(this,"Account created successfully",Toast.LENGTH_SHORT).show()
                val intent = SignInActivity.getIntent(this, null)
                startActivity(intent)

                // ...

              } else {
                // If sign in fails, display a message to the user.
                val exception = task.exception
                if (exception is FirebaseAuthException) {
                  when (exception.errorCode) {
                    "ERROR_EMAIL_ALREADY_IN_USE" -> {
                      // The email address is already in use by another account.
                      // ...
                    }
                    "ERROR_WEAK_PASSWORD" -> {
                      // The password is not strong enough.
                      // ...
                    }
                    else -> {
                      // Handle other errors
                      Toast.makeText(this,"Unexpected error",Toast.LENGTH_SHORT).show()
                    }
                  }
                }
              }
            }

//          // Write a message to the database
//          val database = Firebase.database
//          val myRef = database.getReference("Users")
//          val user = SignUpModel(username,emailAddress,phoneNumber,password,confirmPassword)
//          myRef.setValue(user).addOnSuccessListener {
//            Toast.makeText(this,"Successfully Saved", Toast.LENGTH_LONG).show()
//            val destIntent = SignInActivity.getIntent(this, null)
//            startActivity(destIntent)
//          }.addOnFailureListener {
//            Toast.makeText(this,"Failed Signing Up!" ,Toast.LENGTH_LONG).show()
//          }
//
//          // Read from the database
//          myRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//              // This method is called once with the initial value and again
//              // whenever data at this location is updated.
//              val value = dataSnapshot.getValue<String>()
//              Log.d(TAG, "Value is: $value")
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//              // Failed to read value
//              Log.w(TAG, "Failed to read value.", error.toException())
//            }
//          })

        }else{
          Toast.makeText(this,"Password is not matching", Toast.LENGTH_SHORT).show()
        }
      }else{
      //Display error message
      Toast.makeText(this,"Empty Fields Are not Allowed", Toast.LENGTH_SHORT).show()
    }

    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.txtConfirmation.setOnClickListener {
      val destIntent = SignInActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGN_UP_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUpActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
