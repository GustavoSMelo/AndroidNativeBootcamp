package com.example.reviewfortest.controller

import java.net.URL

class APIController {
    fun getDataByAPI () : String {
        val response = URL("http://mfpledon.com.br/receita.json").readText()
        return response
    }
}