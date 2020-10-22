package com.example.contactlistexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    lateinit var btnPhone : ImageButton
    lateinit var btnEmail : ImageButton
    lateinit var btnAbout : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPhone = findViewById(R.id.btnPhone)
        btnEmail = findViewById(R.id.btnEmail)
        btnAbout = findViewById(R.id.btnAbout)

        btnPhone.setOnClickListener {
            val myIntent : Intent = Intent(this, PhoneActivity::class.java)
            startActivity(myIntent)
        }

        btnEmail.setOnClickListener{
            val myIntent = Intent(this, EmailActivity::class.java)
            startActivity(myIntent)
        }

        btnAbout.setOnClickListener{
            val myIntent = Intent(this, AboutActivity::class.java)
            startActivity(myIntent)
        }
    }
}