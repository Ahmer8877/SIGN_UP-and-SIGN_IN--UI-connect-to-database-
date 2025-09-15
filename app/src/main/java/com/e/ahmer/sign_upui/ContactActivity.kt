package com.e.ahmer.sign_upui

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ContactActivity : AppCompatActivity() {
    // database reffernce
    private lateinit var database: DatabaseReference
    //dialog reffernce
     lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)


        //input edit text find id's
        val phoneinput=findViewById<TextInputEditText>(R.id.phoneinput)
        val nameinput=findViewById<TextInputEditText>(R.id.nameinput)
        val emailinput=findViewById<TextInputEditText>(R.id.emailinput)


      // add btn find id
        val addbtn=findViewById<Button>(R.id.Addbutton)
    //customised Alert boxes setup
        dialog= Dialog(this)
        dialog.setContentView(R.layout.donelertdialog)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.edgesshape))

        //add btn click on code
        addbtn.setOnClickListener {

            //create the list all inputs
            val phone=phoneinput.text.toString()
            val name=nameinput.text.toString()
            val email=emailinput.text.toString()

            //use contract data class
            val contractdata= contractdataclass(phone,name,email)
            // declared the firebase path
            database= FirebaseDatabase.getInstance().getReference("Contracts")
            database.child(phone).setValue(contractdata).
            //if app runs to execute this code
            addOnSuccessListener {
                emailinput.text?.clear()
                //show the customised alert box
                dialog.show()
            //success toast
                Toast.makeText(this,"Your Contract Added", Toast.LENGTH_SHORT).show()
                //if app not runs to execute this code

            }.addOnFailureListener {
                Toast.makeText(this,"You Cannot Added", Toast.LENGTH_SHORT).show()

            }

        }
        val okbtn=dialog.findViewById<Button>(R.id.okbutton)

        okbtn.setOnClickListener {
            dialog.dismiss()
        }

    }
}