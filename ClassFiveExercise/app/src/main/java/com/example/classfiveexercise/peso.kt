package com.example.classfiveexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class peso : AppCompatActivity() {

    lateinit var txtNumberTyped : EditText
    lateinit var txtValueMg : TextView
    lateinit var txtValueG : TextView
    lateinit var txtValueKg : TextView
    lateinit var txtValueLB : TextView
    lateinit var txtValueOz : TextView
    lateinit var spin : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peso)

        spin = findViewById(R.id.spPeso)
        txtValueMg = findViewById(R.id.txtValueMg)
        txtValueG = findViewById(R.id.txtValueKg)
        txtValueKg = findViewById(R.id.txtValueKg)
        txtValueLB = findViewById(R.id.txtValueLB)
        txtValueOz = findViewById(R.id.txtValueOz)

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
                var unit : String = parent?.getItemAtPosition(position).toString()
                var number : Float

                if(txtNumberTyped.text.toString().equals("") || txtNumberTyped.text.toString().equals(null)){
                    number = 0f
                }else{
                    number = txtNumberTyped.text.toString().toFloat()
                }

                if(unit.equals("miligramas", true)){
                    ConvertToMg(number)
                }else if(unit.equals("gramas", true)){
                    ConvertToG(number)
                }else if(unit.equals("kilogramas", true)){
                    ConvertToKg(number)
                }else if(unit.equals("libra", true)){
                    ConvertToLb(number)
                }else if(unit.equals("onca", true)){
                    ConvertToOz(number)
                }
            }
        }
    }

    fun ConvertToMg(number : Float){
        //MG
        txtValueMg.text = number.toString()

        //G
        var numberConverted : Float = number / 1000
        txtValueG.text = numberConverted.toString()


        //Kg

        numberConverted = number / 1000000
        txtValueKg.text = numberConverted.toString()

        //Lb

        numberConverted = number / 453592
        txtValueLB.text = numberConverted.toString()

        //oz

        numberConverted = number / 28350
        txtValueOz.text = numberConverted.toString()
    }

    fun ConvertToG(number : Float){
        //G
        txtValueG.text = number.toString()

        //Mg
        var numberConverted : Float = number * 1000
        txtValueMg.text = numberConverted.toString()

        //Kg
        numberConverted = number / 1000
        txtValueKg.text = numberConverted.toString()


        //Lb
        numberConverted = number / 454
        txtValueLB.text = numberConverted.toString()

        //oz
        numberConverted = number / 28.35f
        txtValueOz.text = numberConverted.toString()
    }

    fun ConvertToKg(number: Float){
        //Kg
        txtValueKg.text = number.toString()

        //G
        var numberConverted : Float = number * 1000
        txtValueG.text = numberConverted.toString()

        //Mg
        numberConverted = number / 1000000
        txtValueMg.text = numberConverted.toString()

        //Lb
        numberConverted = number * 2.205f
        txtValueLB.text = numberConverted.toString()

        //Oz
        numberConverted = number * 35.274f
        txtValueOz.text = numberConverted.toString()
    }

    fun ConvertToLb(number : Float){
        //Lb
        txtValueLB.text = number.toString()

        //G
        var numberConverted : Float = number * 28.35f
        txtValueG.text = numberConverted.toString()

        //Mg
        numberConverted = number * 28350
        txtValueMg.text = numberConverted.toString()

        //Kg
        numberConverted = number / 35.274f
        txtValueKg.text = numberConverted.toString()

        //Lb
        numberConverted = number / 16
        txtValueLB.text = numberConverted.toString()

        //Oz
        numberConverted = number * 16
        txtValueOz.text = numberConverted.toString()
    }

    fun ConvertToOz(number : Float){
        //Oz
        txtValueOz.text = number.toString()

        //G
        var numberConverted : Float = number * 28.35f
        txtValueG.text = numberConverted.toString()

        //Mg
        numberConverted = number * 28350
        txtValueMg.text = numberConverted.toString()

        //kg
        numberConverted = number / 35.274f
        txtValueKg.text = numberConverted.toString()

        //lb
        numberConverted = number / 16
        txtValueLB.text = numberConverted.toString()
    }
}