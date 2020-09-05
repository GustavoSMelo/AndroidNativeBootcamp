package com.example.classthreeexercisetwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var txtN01: EditText
    lateinit var txtN02: EditText
    lateinit var txtResult: TextView
    lateinit var rdGroup: RadioGroup
    lateinit var rdSom: RadioButton
    lateinit var rdLess: RadioButton
    lateinit var rdMult: RadioButton
    lateinit var rdDiv: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResult = findViewById(R.id.txtResult)
        rdGroup = findViewById(R.id.rdGroup)

        rdGroup.setOnCheckedChangeListener{radioGroup, i ->
            getNumbers()

            if(verifyNumbers()){
                var rb : RadioButton = findViewById<RadioButton>(i)
                if(rb.text.toString().equals("Soma")){
                    var result : Float = txtN01.text.toString().toFloat() + txtN02.text.toString().toFloat()
                    txtResult.setText(result.toString())
                }else if(rb.text.toString().equals("Subtracao")){
                    var result : Float = txtN01.text.toString().toFloat() - txtN02.text.toString().toFloat()
                    txtResult.setText(result.toString())
                }else if(rb.text.toString().equals("Divisao")){
                    var result : Float = txtN01.text.toString().toFloat() / txtN02.text.toString().toFloat()
                    txtResult.setText(result.toString())
                }else if(rb.text.toString().equals("Multiplicacao")){
                    var result : Float = txtN01.text.toString().toFloat() * txtN02.text.toString().toFloat()
                    txtResult.setText(result.toString())
                }
            }else{
                Toast.makeText(applicationContext, "To continue, complete all the fields", Toast.LENGTH_SHORT)
            }
        }
    }

    fun verifyNumbers():Boolean{
        if(txtN01.text.toString().equals("") || txtN01.text.toString().equals(null) ||
            txtN02.text.toString().equals("") || txtN02.text.toString().equals(null)){
            return false
        }else{
            return true
        }
    }

    fun getNumbers(){
        txtN01 = findViewById(R.id.txtNumber01)
        txtN02 = findViewById(R.id.txtNumber02)
    }
}
