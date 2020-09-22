package com.example.classfiveexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class temperatura : AppCompatActivity() {
    lateinit var spin : Spinner
    lateinit var txtTypedNumber : EditText
    lateinit var txtCelcius : TextView
    lateinit var txtKelvin : TextView
    lateinit var txtFahrenheit : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperatura)

        spin = findViewById(R.id.spTemperatura)
        txtCelcius = findViewById(R.id.txtValueCelcius)
        txtKelvin = findViewById(R.id.txtValueKelvin)
        txtFahrenheit = findViewById(R.id.txtValueFahrenheit)

        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var unit : String = parent?.getItemAtPosition(position).toString()

                var number : Float
                txtTypedNumber = findViewById(R.id.txtValueTyped)

                if(txtTypedNumber.text.toString().equals("") || txtTypedNumber.text.toString().equals(null)){
                    number = 0f
                }
                else {
                    number = txtTypedNumber.text.toString().toFloat()
                }

                if(unit.equals("celcius", true)){
                    ConvertToCelcius(number)
                }else if(unit.equals("kelvin", true)){
                    ConvertToKelvin(number)
                }else if(unit.equals("fahrenheit", true)){
                    ConvertToCFahrenheit(number)
                }
            }
        }
    }

    fun ConvertToCelcius(number : Float){
        txtCelcius.text = number.toString()

        var ConvertedNumber : Float = number + 273.15f
        txtKelvin.text = ConvertedNumber.toString()

        ConvertedNumber = (number * 9/5) + 32
        txtFahrenheit.text = ConvertedNumber.toString()
    }

    fun ConvertToKelvin(number : Float){
        txtKelvin.text = number.toString()

        var ConvertedNumber : Float = number - 273.15f
        txtCelcius.text = ConvertedNumber.toString()

        ConvertedNumber = (number - 273.15f) * 9 / 5 + 32
        txtFahrenheit.text =  ConvertedNumber.toString()
    }

    fun ConvertToCFahrenheit(number : Float){
        txtFahrenheit.text = number.toString()

        var ConvertedNumber : Float = (number - 32) * 5 / 9
        txtCelcius.text = ConvertedNumber.toString()

        ConvertedNumber = (number - 32) * 5 / 9 + 273.15f
        txtKelvin.text = ConvertedNumber.toString()
    }
}