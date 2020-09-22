package com.example.classfiveexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class timeactivity : AppCompatActivity() {

    lateinit var spin : Spinner
    lateinit var txtMs : TextView
    lateinit var txtSeg : TextView
    lateinit var txtMin : TextView
    lateinit var txtHora : TextView
    lateinit var txtDia : TextView
    lateinit var txtValueTyped : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timeactivity)

        spin = findViewById(R.id.spTime)
        txtMs = findViewById(R.id.txtValueMs)
        txtSeg = findViewById(R.id.txtValueSeg)
        txtMin = findViewById(R.id.txtValueMin)
        txtHora = findViewById(R.id.txtValueHr)
        txtDia = findViewById(R.id.txtValueDia)

        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var unit : String = parent?.getItemAtPosition(position).toString()
                txtValueTyped = findViewById(R.id.txtValueTyped)
                var number : Float

                if(txtValueTyped.text.toString().equals("") || txtValueTyped.text.toString() == null){
                    number = 0f
                }else{
                    number = txtValueTyped.text.toString().toFloat()
                }

                if(unit.equals("milisegundo", true)){
                    ConvertToMS(number, unit)
                }else if(unit.equals("segundo", true)){
                    ConvertToSeg(number, unit)
                }else if(unit.equals("minuto", true)){
                    ConvertToMin(number, unit)
                }else if(unit.equals("hora", true)){
                    ConvertToHr(number, unit)
                }else if(unit.equals("dia", true)){
                    ConvertToDay(number, unit)
                }
            }
        }
    }

    fun ConvertToMS(number : Float, unit : String){
            txtMs.text = number.toString()
            val calc1 = number / 1000
            txtSeg.text = calc1.toString()
            val calc2 = number / 60000
            txtMin.text = calc2.toString()
            val calc3 = number / 36000000
            txtHora.text = calc3.toString()
            val calc4 = number / 8640000000
            txtDia.text = calc4.toString()
    }

    fun ConvertToSeg(number : Float, unit : String) {
            val calc1 = number * 1000
            txtMs.text = calc1.toString()
            txtSeg.text = number.toString()
            val calc2 = number / 60
            txtMin.text = calc2.toString()
            val calc3 = number / 3600
            txtHora.text = calc3.toString()
            val calc4 = number / 86400
            txtDia.text = calc4.toString()

    }

    fun ConvertToMin(number : Float, unit : String) {
            val calc1 = number * 60000
            txtMs.text = calc1.toString()
            val calc2 = number * 60
            txtSeg.text = calc2.toString()
            txtMin.text = number.toString()
            val calc3 = number / 60
            txtHora.text = calc3.toString()
            val calc4 = number / 1440
            txtDia.text = calc4.toString()

    }

    fun ConvertToHr(number:Float, unit : String) {
            val calc1 = number * 36000000
            txtMs.text = calc1.toString()
            val calc2 = number * 3600
            txtSeg.text = calc2.toString()
            val calc3 = number * 60
            txtMin.text = calc3.toString()
            txtHora.text = number.toString()
            val calc4 = number / 24
            txtDia.text = calc4.toString()

    }

    fun ConvertToDay(number : Float, unit : String){
            val calc1 = number * 8640000000
            txtMs.text = calc1.toString()
            val calc2 = number * 86400
            txtSeg.text = calc2.toString()
            val calc3 = number * 1440
            txtMin.text = calc3.toString()
            val calc4 = number * 24
            txtHora.text = calc4.toString()
            txtDia.text = number.toString()
        
    }
}