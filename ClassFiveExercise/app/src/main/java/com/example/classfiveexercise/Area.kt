package com.example.classfiveexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class Area : AppCompatActivity() {

    lateinit var txtNumberTyped : EditText
    lateinit var spin : Spinner
    lateinit var txtCentimetrosQuadrados : TextView
    lateinit var txtDecimetrosQuadrados : TextView
    lateinit var txtMetrosQuadrados : TextView
    lateinit var txtPolegadasQuadrados : TextView
    lateinit var txtPesQuadrados : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area)

        txtCentimetrosQuadrados = findViewById(R.id.txtValueCm2)
        txtDecimetrosQuadrados = findViewById(R.id.txtValueDm2)
        txtMetrosQuadrados = findViewById(R.id.txtValueM2)
        txtPolegadasQuadrados = findViewById(R.id.txtValueIn2)
        txtPesQuadrados = findViewById(R.id.txtValueFt2)

        spin = findViewById(R.id.spArea)
        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

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
                } else{
                    number = txtNumberTyped.text.toString().toFloat()
                }

                if(unit.equals("centimetros-quadrados", true)){
                    ConvertToCentimetros(number)
                }
                else if(unit.equals("decimetros-quadrados", true)){
                    ConvertToDecimetros(number)
                }

                else if(unit.equals("metros-quadrados", true)){
                    ConvertToMetros(number)
                }

                else if(unit.equals("polegadas-quadrados", true)){
                    ConvertToPolegadas(number)
                }

                else if(unit.equals("pe-quadrados", true)){
                    ConvertToPesQuadrados(number)
                }
            }

        }
    }

    fun ConvertToCentimetros(number : Float){
        //cm
        txtCentimetrosQuadrados.text = number.toString()

        //dm
        var convertedValue : Float = number / 10
        txtDecimetrosQuadrados.text = convertedValue.toString()

        //M
        convertedValue = number / 1000
        txtMetrosQuadrados.text = convertedValue.toString()

        //polegadas
        convertedValue = number / 6.452f
        txtPolegadasQuadrados.text = convertedValue.toString()

        //Pes
        convertedValue = number / 929
        txtPesQuadrados.text = convertedValue.toString()
    }

    fun ConvertToDecimetros(number : Float){
        //dm
        txtDecimetrosQuadrados.text = number.toString()

        //cm
        var convertedValue : Float = number * 10
        txtCentimetrosQuadrados.text = convertedValue.toString()

        //m
        convertedValue = number / 100
        txtMetrosQuadrados.text = convertedValue.toString()

        //polegadas
        convertedValue = number * 15.5f
        txtPolegadasQuadrados.text = convertedValue.toString()

        //pe
        convertedValue = number / 9.29f
        txtPesQuadrados.text = convertedValue.toString()
    }

    fun ConvertToMetros(number : Float){
        txtMetrosQuadrados.text = number.toString()

        //cm
        var convertedValue : Float = number * 10000
        txtCentimetrosQuadrados.text = convertedValue.toString()

        //dm
        convertedValue = number * 100
        txtDecimetrosQuadrados.text = convertedValue.toString()

        //polegadas
        convertedValue = number * 1550
        txtPolegadasQuadrados.text = convertedValue.toString()

        //pe
        convertedValue = number * 10764f
        txtPesQuadrados.text = convertedValue.toString()
    }

    fun ConvertToPesQuadrados(number : Float){
        txtPesQuadrados.text = number.toString()

        //cm
        var convertedValue : Float = number * 107640000000f
        txtCentimetrosQuadrados.text = convertedValue.toString()

        //dm
        convertedValue = number * 929
        txtDecimetrosQuadrados.text = convertedValue.toString()

        //metros
        convertedValue = number * 10764
        txtMetrosQuadrados.text = convertedValue.toString()

        //polegadas
        convertedValue = number * 144
        txtPolegadasQuadrados.text = convertedValue.toString()
    }

    fun ConvertToPolegadas(number : Float){
        txtPolegadasQuadrados.text = number.toString()

        //pe
        var convertedValue : Float = number / 144
        txtPesQuadrados.text = convertedValue.toString()

        //cm
        convertedValue = number / 155000000000
        txtCentimetrosQuadrados.text = convertedValue.toString()

        //dm
        convertedValue = number / 15.5f
        txtDecimetrosQuadrados.text = convertedValue.toString()

        //m
        convertedValue = number / 1550
        txtMetrosQuadrados.text = convertedValue.toString()
    }
}