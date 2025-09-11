package com.e.ahmer.sign_upui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signinactivity : AppCompatActivity() {

    //database refference variable,initialize in below
    lateinit var databaseReference: DatabaseReference

       //on create function

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signinactivity)

        //sign in btn variable

        val signInButton=findViewById<Button>(R.id.signinbtn)

        //Enter user id(variable)
        val userName=findViewById<TextInputEditText>(R.id.signinuserid)

        //sign in btn click process code

        signInButton.setOnClickListener {

            //unique id declared the string

            val uniqueId=userName.text.toString()

            // if unique id is empty to move the readdata function

            if (uniqueId.isNotEmpty()){
                readdata(uniqueId)
            }else {

                //if unique id is empty to show this toast msg
                Toast.makeText(this,"Please enter the user id", Toast.LENGTH_SHORT).show()
            }
            }

        }
        }

     //on create class is over


     //readdata fun. code

private fun signinactivity.readdata(uniqueId: String) {

     //provide the database reffernce and provide the firebase path
     databaseReference= FirebaseDatabase.getInstance().getReference("Users")

      // get the unique id child
    databaseReference.child(uniqueId).get().addOnSuccessListener {

        //if user exist or not

        //it mean in gain

        if (it.exists()){
            val email=it.child("email").value
            val password=it.child("password").value
            val username=it.child("user name").value

            //welcome intent and open the welcome activity

            val welcomeintent= Intent(this, ContactActivity::class.java)
            startActivity(welcomeintent)


        }else{
              //if this data does not exist,so print toast msg
            Toast.makeText(this,"User does not exists", Toast.LENGTH_SHORT).show()
        }

        // if data does not match the database data so,print  this toast msg
    }.addOnFailureListener {
        Toast.makeText(this,"Failed error in DB", Toast.LENGTH_SHORT).show()


    }


    }


