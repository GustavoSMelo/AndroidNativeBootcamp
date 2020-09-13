package com.example.navigationactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var Greetings : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Greetings = findViewById(R.id.txtGreetings)

        Greetings.text = "Obrigado pelo seu registro "+ intent.getStringExtra("Name").toString() +"\n\nLogo iremos mandar um email para" + intent.getStringExtra("Email").toString()
    }
}