package com.e.ahmer.sign_upui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //splash screen code

        supportActionBar?.hide()
        Handler().postDelayed({
            val intent= Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        },2000)


        }
    }