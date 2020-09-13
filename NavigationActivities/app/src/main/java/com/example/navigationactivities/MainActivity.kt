package com.example.navigationactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    lateinit var btnNavigation : Button
    lateinit var txtEmail : EditText
    lateinit var txtName : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNavigation = findViewById(R.id.btnTransition)

        btnNavigation.setOnClickListener {
            var myIntent : Intent = Intent(this, MainActivity2::class.java)

            txtEmail = findViewById(R.id.txtEmail)
            txtName = findViewById(R.id.txtName)

            myIntent.putExtra("Email", txtEmail.text.toString())
            myIntent.putExtra("Name", txtName.text.toString())
            startActivity(myIntent)
        }
    }
}