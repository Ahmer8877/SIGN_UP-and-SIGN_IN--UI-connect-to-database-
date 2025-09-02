package com.e.ahmer.sign_upui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class welcomeActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

       //get the string data(email,password) for sign in activity
        val email=intent.getStringExtra(signinactivity.Key1)
        val password=intent.getStringExtra(signinactivity.Key3)

        //mail and password find id

        val mailtext=findViewById<TextView>(R.id.tvmail)
        val passwordtext=findViewById<TextView>(R.id.tvpassword)

        //view the mail... and password... data in welcome activity

        mailtext.text="Mail: $email"
        passwordtext.text="PASSWORD: $password"

    }
}