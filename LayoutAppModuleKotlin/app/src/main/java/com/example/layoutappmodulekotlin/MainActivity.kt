package com.example.layoutappmodulekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var btnPlus : Button
    lateinit var btnLess : Button
    lateinit var qntd : TextView
    lateinit var price : TextView
    lateinit var name : EditText
    lateinit var btnOrder : Button
    lateinit var txtTy : TextView
    public var qntdSelected : Int = 0
    public var qntdPrice : Float = 0.0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlus = findViewById(R.id.btnPlus)
        btnLess = findViewById(R.id.btnLess)
        qntd = findViewById(R.id.qntd)
        price = findViewById(R.id.txtPrice)
        name = findViewById(R.id.txtName)
        btnOrder = findViewById(R.id.btnOrder)
        txtTy = findViewById(R.id.txtTy)

        btnPlus.setOnClickListener {
            qntdSelected += 1
            qntd.text = qntdSelected.toString()
            qntdPrice += 5
            price.text = qntdPrice.toString()
        }

        btnLess.setOnClickListener {
            if(qntdSelected <= 0){
                Toast.makeText(applicationContext, "you can not order negative foods ", Toast.LENGTH_SHORT).show()
            }else{
                qntdSelected -= 1
                qntd.text = qntdSelected.toString()
                qntdPrice -= 5
                price.text = qntdPrice.toString()
            }
        }

        btnOrder.setOnClickListener {
            if(qntdSelected <= 0){
                Toast.makeText(applicationContext, "to order food, you must to order 1 or more qntd ", Toast.LENGTH_SHORT).show()
            }
            else{
                if(name.text.equals("")){
                    Toast.makeText(applicationContext, "please, insert your name to continue", Toast.LENGTH_SHORT).show()
                }else{
                    txtTy.text = "Thanks to order in Arbs " + name.text + " :) "
                }
            }
        }
    }
}