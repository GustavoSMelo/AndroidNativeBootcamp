package com.example.classfiveexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class volume : AppCompatActivity() {

    lateinit var spin : Spinner
    lateinit var txtLitros : TextView
    lateinit var txtCentimetros : TextView
    lateinit var txtDecimetros : TextView
    lateinit var txtMetros : TextView
    lateinit var txtMilimetros : TextView
    lateinit var txtTypedValue : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        spin = findViewById(R.id.spTime)
        txtLitros = findViewById(R.id.txtValueLitro)
        txtCentimetros = findViewById(R.id.txtValueCm)
        txtDecimetros = findViewById(R.id.txtValueDm)
        txtMetros = findViewById(R.id.txtValueMS)
        txtMilimetros = findViewById(R.id.txtValueMM)

        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                txtTypedValue = findViewById(R.id.txtValueTyped)
                var unit : String = parent?.getItemAtPosition(position).toString()
                var number : Float

                if(txtTypedValue.text.toString().equals("") || txtTypedValue.text.toString().equals(null)){
                    number = 0f
                }else{
                    number = txtTypedValue.text.toString().toFloat()
                }


                if(unit.equals("litros", true)){
                    ConvertToLitros(number, unit)
                }else if(unit.equals("centimetros", true)){
                    ConvertToCentimetros(number, unit)
                }else if(unit.equals("decimetros", true)){
                    ConvertToDecimetros(number, unit)
                }else if(unit.equals("metros", true)){
                    ConvertToMetros(number, unit)
                }else if(unit.equals("milimetros", true)){
                    ConvertToMilimetros(number, unit)
                }
            }
        }
    }

    fun ConvertToLitros(number : Float, unit : String){
        txtLitros.text = number.toString()
        val calc1 = number * 100
        txtCentimetros.text = calc1.toString()
        txtDecimetros.text = number.toString()
        val calc3 = number / 1000
        txtMetros.text = calc3.toString()
        val calc4 = number / 1000000
        txtMilimetros.text = calc4.toString()
    }

    fun ConvertToCentimetros(number : Float, unit : String) {
        val calc1 = number * 1000
        txtLitros.text = calc1.toString()
        txtCentimetros.text = number.toString()
        val calc2 = number / 60
        txtDecimetros.text = calc2.toString()
        val calc3 = number / 3600
        txtMetros.text = calc3.toString()
        val calc4 = number / 86400
        txtMilimetros.text = calc4.toString()

    }

    fun ConvertToDecimetros(number : Float, unit : String) {
        val calc1 = number * 60000
        txtLitros.text = calc1.toString()
        val calc2 = number * 60
        txtCentimetros.text = calc2.toString()
        txtDecimetros.text = number.toString()
        val calc3 = number / 60
        txtMetros.text = calc3.toString()
        val calc4 = number / 1440
        txtMilimetros.text = calc4.toString()
    }

    fun ConvertToMetros(number:Float, unit : String) {
        val calc1 = number * 36000000
        txtLitros.text = calc1.toString()
        val calc2 = number * 3600
        txtCentimetros.text = calc2.toString()
        val calc3 = number * 60
        txtDecimetros.text = calc3.toString()
        txtMetros.text = number.toString()
        val calc4 = number / 24
        txtMilimetros.text = calc4.toString()

    }

    fun ConvertToMilimetros(number : Float, unit : String){
        val calc1 = number * 8640000000
        txtLitros.text = calc1.toString()
        val calc2 = number * 86400
        txtCentimetros.text = calc2.toString()
        val calc3 = number * 1440
        txtDecimetros.text = calc3.toString()
        val calc4 = number * 24
        txtMetros.text = calc4.toString()
        txtMilimetros.text = number.toString()

    }
}