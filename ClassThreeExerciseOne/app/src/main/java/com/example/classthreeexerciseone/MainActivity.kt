package com.example.classthreeexerciseone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    lateinit var txtN01 : EditText
    lateinit var txtN02 : EditText
    lateinit var btnPlus : Button
    lateinit var btnLess : Button
    lateinit var btnMult : Button
    lateinit var btnDiv : Button
    lateinit var txtResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResult = findViewById(R.id.txtResult)
        btnPlus = findViewById(R.id.btnPlus)
        btnLess = findViewById(R.id.btnLess)
        btnDiv = findViewById(R.id.btnDiv)
        btnMult = findViewById(R.id.btnMult)

        btnPlus.setOnClickListener {
            getNumbers()

            if(VerifyText()){
                var result : Float = txtN01.text.toString().toFloat() + txtN02.text.toString().toFloat()
                txtResult.setText(result.toString())
            }else{
                Toast.makeText(applicationContext, "To continue, please, complete all the fields", Toast.LENGTH_SHORT)
            }
        }

        btnLess.setOnClickListener {
            getNumbers()

            if(VerifyText()){
                var result : Float = txtN01.text.toString().toFloat() - txtN02.text.toString().toFloat()
                txtResult.setText(result.toString())
            }else{
                Toast.makeText(applicationContext, "To continue, please, complete all the fields", Toast.LENGTH_SHORT)
            }
        }

        btnDiv.setOnClickListener {
            getNumbers()

            if(VerifyText()){
                var result : Float = txtN01.text.toString().toFloat() / txtN02.text.toString().toFloat()
                txtResult.setText(result.toString())
            }else{
                Toast.makeText(applicationContext, "To continue, please, complete all the fields", Toast.LENGTH_SHORT)
            }
        }

        btnMult.setOnClickListener {
            getNumbers()

            if(VerifyText()){
                var result : Float = txtN01.text.toString().toFloat() * txtN02.text.toString().toFloat()
                txtResult.setText(result.toString())
            }else{
                Toast.makeText(applicationContext, "To continue, please, complete all the fields", Toast.LENGTH_SHORT)
            }
        }
    }

    fun getNumbers(){
        txtN01 = findViewById(R.id.txtNumber01)
        txtN02 = findViewById(R.id.txtNumber02)
    }

    fun VerifyText():Boolean{
        if(txtN01.text == null || txtN01.text.equals("") || txtN02.text == null || txtN02.equals("")){
            return false
        }else{
            return true
        }
    }
}