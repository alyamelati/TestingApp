package com.test.testingapp

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {
    lateinit var editName: EditText
    lateinit var editAge: EditText
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var editVerifyPassword: EditText
    lateinit var btnRegister: Button
    lateinit var btnLogin: Button
    lateinit var progressDialog: ProgressDialog

    var auth = FirebaseAuth.getInstance()

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar!!.hide()

        editName = findViewById(R.id.user_name)
        editAge = findViewById(R.id.user_age)
        editEmail = findViewById(R.id.user_email)
        editPassword = findViewById(R.id.user_password)
        editVerifyPassword = findViewById(R.id.verify_password)
        btnRegister = findViewById(R.id.btn_register)
        btnLogin = findViewById(R.id.btn_login)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Log In")
        progressDialog.setMessage("Please wait...")


        btnLogin.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }

        btnRegister.setOnClickListener {
            if(editName.text.isNotEmpty() && editAge.text.isNotEmpty() && editEmail.text.isNotEmpty() && editPassword.text.isNotEmpty() && editVerifyPassword.text.isNotEmpty()){
                if(editPassword.text.toString() == editVerifyPassword.text.toString()){
                    registerAccount()
                } else {
                    Toast.makeText(this, "Password and Verify Password must be the same", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please input all the required fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerAccount(){
        val name = editName.text.toString()
        val age = editAge.text.toString()
        val email = editEmail.text.toString()
        val password = editPassword.text.toString()

        progressDialog.show()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val userUpdateProfile = userProfileChangeRequest {
                        displayName = name
                    }
                    val user = task.result.user
                    user!!.updateProfile(userUpdateProfile)
                        .addOnCompleteListener {
                            progressDialog.dismiss()
                            startActivity(Intent(this, MainActivity::class.java))
                        }
                        .addOnFailureListener { error2 ->
                            Toast.makeText(this, error2.localizedMessage, Toast.LENGTH_SHORT).show()
                        }
                } else {
                    progressDialog.dismiss()
                }
            }
            .addOnFailureListener { error ->
                Toast.makeText(this, error.localizedMessage, Toast.LENGTH_SHORT).show()
            }
    }
}