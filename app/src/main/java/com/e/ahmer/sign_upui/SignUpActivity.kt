package com.e.ahmer.sign_upui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {

    lateinit var database: DatabaseReference

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //sign up button code

        val signupbtn=findViewById<TextView>(R.id.signupbtn)


    // text input layouts code

        val userid=findViewById<TextInputEditText>(R.id.line1)
        val email=findViewById<TextInputEditText>(R.id.line2)
        val password=findViewById<TextInputEditText>(R.id.line3)


        //signupbtn performance code

        signupbtn.setOnClickListener {
            val uniqueId= userid.text.toString()
            val email=email.text.toString()
            val password=password.text.toString()

            //data class object


             val user= user(uniqueId, email, password)

            //database path code

            database= FirebaseDatabase.getInstance().getReference("Users")

            //gets the id user and taost toast the msg success or failure
            database.child(uniqueId).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "user registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Failure", Toast.LENGTH_SHORT).show()
            }



        }

             //explicit intent (sign in button code)

        val signInButton=findViewById<TextView>(R.id.signinText)

        signInButton.setOnClickListener {
            val btnintent= Intent(this, signinactivity::class.java)
            startActivity(btnintent)
        }
        }
    }