package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    lateinit var txtN1 : EditText
    lateinit var txtN2 : EditText
    lateinit var txtResult: TextView
    lateinit var btnMais : Button
    lateinit var btnMenos : Button
    lateinit var btnDiv : Button
    lateinit var btnMult : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        getScreenElements()

        btnMais.setOnClickListener { Sum() }
        btnMenos.setOnClickListener { Less() }
        btnDiv.setOnClickListener { Div() }
        btnMult.setOnClickListener { Mult() }
    }

    fun getScreenElements(){
        txtN1 = findViewById(R.id.txtN1)
        txtN2 = findViewById(R.id.txtN2)
        txtResult = findViewById(R.id.txtResult)
        btnMais = findViewById(R.id.btnSoma)
        btnMenos = findViewById(R.id.btnMenos)
        btnMult = findViewById(R.id.btnMult)
        btnDiv = findViewById(R.id.btnDiv)
    }

    fun Sum(){
        if (txtN1.text.toString().equals("") || txtN1.text.toString().equals(null) ||
            txtN2.text.toString().equals("") || txtN2.text.toString().equals(null)){
            Toast.makeText(applicationContext, "to continue, please insert all the fields", Toast.LENGTH_SHORT)
        }else{
            var result = txtN2.text.toString().toDouble() + txtN1.text.toString().toDouble()
            txtResult.text = "Result: " + result.toString()
        }
    }

    fun Less(){
        if (txtN1.text.toString().equals("") || txtN1.text.toString().equals(null) ||
            txtN2.text.toString().equals("") || txtN2.text.toString().equals(null)){
            Toast.makeText(applicationContext, "to continue, please insert all the fields", Toast.LENGTH_SHORT)
        }else{
            var result = txtN1.text.toString().toDouble() - txtN2.text.toString().toDouble()
            txtResult.text = "Result: " + result.toString()
        }
    }

    fun Div(){
        if (txtN1.text.toString().equals("") || txtN1.text.toString().equals(null) ||
            txtN2.text.toString().equals("") || txtN2.text.toString().equals(null)){
            Toast.makeText(applicationContext, "to continue, please insert all the fields", Toast.LENGTH_SHORT)
        }else{
            var result = txtN1.text.toString().toDouble() / txtN2.text.toString().toDouble()
            txtResult.text = "Result: " + result.toString()
        }
    }

    fun Mult(){
        if (txtN1.text.toString().equals("") || txtN1.text.toString().equals(null) ||
            txtN2.text.toString().equals("") || txtN2.text.toString().equals(null)){
            Toast.makeText(applicationContext, "to continue, please insert all the fields", Toast.LENGTH_SHORT)
        }else{
            var result = txtN2.text.toString().toDouble() * txtN1.text.toString().toDouble()
            txtResult.text = "Result: " + result.toString()
        }
    }
}