package com.example.getjsonusingandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.TextView
import com.example.getjsonusingandroid.Controller.RouteController
import com.example.getjsonusingandroid.Model.Usuario
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var list : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById(R.id.listItem)

        doAsync {
            val response = RouteController().get()
            val objRaiz = JSONObject(response)
            val jsonArray : JSONArray = objRaiz.optJSONArray("receita")
            val UserList = ArrayList<Usuario>()
            Log.d("sla", jsonArray.toString())
            for (i in 0 until jsonArray.length()){
                val jsonManipulate : JSONObject = jsonArray.getJSONObject(i)
                val newUser = Usuario()

                newUser.setName(jsonManipulate.getString("nome"))
                newUser.setCPF(jsonManipulate.getString("cpf"))
                newUser.setRG(jsonManipulate.getString("rg"))
                newUser.setSal(jsonManipulate.getDouble("salario"))
                newUser.setData(jsonManipulate.getString("datanasc"))
                newUser.setSex(jsonManipulate.getString("sexo"))

                UserList.add(newUser)
            }

            uiThread {
                var textList = ""

                UserList.map { usuario -> textList += "${usuario.Scan()} \n\n\n" }

                println(textList)
                list.text = textList
            }

        }
    }
}
