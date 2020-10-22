package com.example.contactlistexercise.controlls

import android.util.Log
import java.net.URL

class Controll {
    fun Index () : String {
        val response = URL("http://mfpledon.com.br/listadecontatos.json").readText()
        Log.d("teste", response)
        return response
    }
}