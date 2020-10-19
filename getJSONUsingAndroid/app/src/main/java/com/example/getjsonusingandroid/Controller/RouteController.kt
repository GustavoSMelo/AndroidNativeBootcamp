package com.example.getjsonusingandroid.Controller

import android.os.AsyncTask
import android.util.Log
import java.net.URL

class RouteController{
    fun get () : String {
        val response = URL("http://mfpledon.com.br/receita.json").readText()
        return response
    }
}
