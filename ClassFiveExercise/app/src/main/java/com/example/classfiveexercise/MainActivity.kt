package com.example.classfiveexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_timeactivity.*
import kotlinx.android.synthetic.main.activity_volume.*
import kotlinx.android.synthetic.main.activity_peso.*
import kotlinx.android.synthetic.main.activity_area.*
import kotlinx.android.synthetic.main.activity_comprimento.*
import kotlinx.android.synthetic.main.activity_temperatura.*

class MainActivity : AppCompatActivity() {

    lateinit var btnTime : Button
    lateinit var btnVolume : Button
    lateinit var btnPeso : Button
    lateinit var btnArea : Button
    lateinit var btnComprimento : Button
    lateinit var btnTemperatura : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTime = findViewById(R.id.btnTime)

        btnTime.setOnClickListener {
            var myIntent: Intent = Intent(this, timeactivity::class.java)

            startActivity(myIntent)
        }

        btnVolume = findViewById(R.id.btnVolumes)

        btnVolume.setOnClickListener {
            var myIntent : Intent = Intent(this, volume::class.java)
            startActivity(myIntent)
        }

        btnPeso = findViewById(R.id.btnPeso)

        btnPeso.setOnClickListener {
            var myIntent : Intent =Intent(this, peso::class.java)
            startActivity(myIntent)
        }

        btnArea = findViewById(R.id.btnArea)

        btnArea.setOnClickListener {
            var myIntent : Intent = Intent(this, Area::class.java)
            startActivity(myIntent)
        }

        btnComprimento = findViewById(R.id.btnComprimento)
        btnComprimento.setOnClickListener {
            var myIntent : Intent = Intent(this, comprimento::class.java)
            startActivity(myIntent)
        }

        btnTemperatura = findViewById(R.id.btnTemperatura)
        btnTemperatura.setOnClickListener {
            var myIntent : Intent = Intent(this, temperatura::class.java)
            startActivity(myIntent)
        }
    }
}
