package com.example.reviewfortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.reviewfortest.controller.APIController
import com.example.reviewfortest.models.apiUserModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONArray
import org.json.JSONObject

class apiView : AppCompatActivity() {

    lateinit var lstItem : ListView
    private val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_view)

        doAsync {
            val response = APIController().getDataByAPI()
            val objRaiz = JSONObject(response)
            val jsonArray : JSONArray = objRaiz.optJSONArray("receita")
            val UserList = ArrayList<apiUserModel>()

            for (i in 0 until jsonArray.length()) {
                val jsonManipulator = jsonArray.getJSONObject(i)
                val apiUser = apiUserModel()

                apiUser.setCPF(jsonManipulator.getString("cpf"))
                apiUser.setNome(jsonManipulator.getString("nome"))
                apiUser.setRG(jsonManipulator.getString("rg"))
                apiUser.setDatanasc(jsonManipulator.getString("datanasc"))
                apiUser.setSexo(jsonManipulator.getString("sexo"))

                UserList.add(apiUser)
            }

            uiThread {
                lstItem = findViewById(R.id.lstItem)
                val arrayAdapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, UserList.map { user -> user.toString() })
                lstItem.adapter = arrayAdapter
            }
        }
    }
}