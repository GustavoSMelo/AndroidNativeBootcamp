package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    lateinit var btnIMC : Button
    lateinit var btnCalculadora : Button
    lateinit var txtHeight : EditText
    lateinit var txtWeight : EditText
    lateinit var txtResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIMC = findViewById(R.id.btnIMC)
        btnCalculadora = findViewById(R.id.btnCalculadora)

        txtHeight = findViewById(R.id.txtHeight)
        txtWeight = findViewById(R.id.txtWeight)

        txtResult = findViewById(R.id.txtResult)

        btnIMC.setOnClickListener {

            if(txtHeight.text.toString().equals("") || txtHeight.text.toString().equals(null) ||
                txtWeight.text.toString().equals("") || txtWeight.text.toString().equals(null)){
                Toast.makeText(applicationContext, "to Continue, please insert all the fields", Toast.LENGTH_SHORT)
            }else{
                var calc = txtWeight.text.toString().toDouble() / (txtHeight.text.toString().toDouble() * txtHeight.text.toString().toDouble())

                txtResult.text = "Resultado do IMC: " + calc.toString()
            }
        }

        btnCalculadora.setOnClickListener {
            var myIntent : Intent = Intent(this, MainActivity2::class.java)
            startActivity(myIntent)
        }
    }
}