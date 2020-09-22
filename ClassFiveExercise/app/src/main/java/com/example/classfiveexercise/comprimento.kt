package com.example.classfiveexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class comprimento : AppCompatActivity() {

    lateinit var spin : Spinner
    lateinit var txtNumberTyped : EditText
    lateinit var txtMM : TextView
    lateinit var txtKm : TextView
    lateinit var txtCm : TextView
    lateinit var txtDm : TextView
    lateinit var txtMetros : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprimento)

        spin = findViewById(R.id.spComprimento)
        txtMM = findViewById(R.id.txtValuemmC)
        txtKm = findViewById(R.id.txtValueKmC)
        txtCm = findViewById(R.id.txtValueCmC)
        txtDm = findViewById(R.id.txtValueDmC)
        txtMetros = findViewById(R.id.txtValueMC)

        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                txtNumberTyped = findViewById(R.id.txtValueTyped)
                var number : Float
                var unit : String = parent?.getItemAtPosition(position).toString()

                if(txtNumberTyped.text.toString().equals("") || txtNumberTyped.text.toString().equals(null)){
                    number = 0f
                }else{
                    number = txtNumberTyped.text.toString().toFloat()
                }

                if(unit.equals("milimetros-comprimento", true)){
                    ConvertToMilimetros(number)
                }else if(unit.equals("centimetros-comprimento", true)){
                    ConvertToCentimetros(number)
                }else if(unit.equals("decimetros-comprimento", true)){
                    ConvertToDecimetros(number)
                }else if(unit.equals("metros-comprimento", true)){
                    ConvertToMetros(number)
                }else if(unit.equals("kilometros-comprimento", true)){
                    ConvertToKilometros(number)
                }
            }
        }
    }

    fun ConvertToMilimetros(number: Float){
        //mm
        txtMM.text = number.toString()

        //cm
        var numberConverted : Float = number /10
        txtCm.text = numberConverted.toString()

        //dm
        numberConverted = number / 100
        txtDm.text = numberConverted.toString()

        //m
        numberConverted = number / 1000
        txtMetros.text = numberConverted.toString()

        //km
        numberConverted = number / 1000000
        txtKm.text = numberConverted.toString()
    }

    fun ConvertToCentimetros(number: Float){
        //cm
        txtCm.text = number.toString()

        //mm
        var convertedNumber : Float = number * 10
        txtMM.text = convertedNumber.toString()

        //dm
        convertedNumber = number / 10
        txtDm.text = convertedNumber.toString()

        //m
        convertedNumber = number / 100
        txtMetros.text = convertedNumber.toString()

        //km
        convertedNumber = number / 100000
        txtKm.text = convertedNumber.toString()
    }

    fun ConvertToMetros(number: Float){
        //m
        txtMetros.text = number.toString()

        //mm
        var convertedNumber : Float = number * 1000
        txtMM.text = convertedNumber.toString()

        //cm
        convertedNumber = number * 100
        txtCm.text = convertedNumber.toString()

        //dm
        convertedNumber = number * 10
        txtDm.text = convertedNumber.toString()

        //km
        convertedNumber = number / 1000
        txtKm.text = convertedNumber.toString()
    }

    fun ConvertToDecimetros(number: Float){
        txtDm.text = number.toString()

        //mm
        var convertedNumber : Float = number * 100
        txtMM.text = convertedNumber.toString()

        //cm
        convertedNumber = number * 10
        txtCm.text = convertedNumber.toString()

        //m
        convertedNumber = number / 10
        txtMetros.text = convertedNumber.toString()

        //km
        convertedNumber = number / 10000
        txtKm.text = convertedNumber.toString()
    }

    fun ConvertToKilometros(number: Float){
        txtKm.text = number.toString()

        //mm
        var convertedNumber : Float = number * 1000000
        txtMM.text = convertedNumber.toString()

        //cm
        convertedNumber = number * 100000
        txtCm.text = convertedNumber.toString()

        //m
        convertedNumber = number * 1000
        txtMetros.text = convertedNumber.toString()

        //dm
        convertedNumber = number * 10000
        txtDm.text = convertedNumber.toString()
    }

}