package com.example.contactlistexercise

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.app.ActivityCompat
import com.example.contactlistexercise.controlls.Controll
import com.example.contactlistexercise.models.userModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONArray
import org.json.JSONObject

class PhoneActivity : AppCompatActivity() {

    lateinit var listV : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)

        val usrList = ArrayList<userModel>()
        listV = findViewById(R.id.listUserPhone)
        val context = this

        doAsync {
            val response = Controll().Index()
            val objRaiz = JSONObject(response)

            val jsonArray : JSONArray = objRaiz.optJSONArray("listacontatos")
            for (i in 0 until jsonArray.length()) {
                val jsonManipulate : JSONObject = jsonArray.getJSONObject(i)

                val newUser = userModel()

                newUser.setName(jsonManipulate.getString("nomecontato"))
                newUser.setEmail_Address(jsonManipulate.getString("email"))
                newUser.setPhone_Number(jsonManipulate.getString("celular"))

                usrList.add(newUser)
            }

            uiThread {
                val arryAdapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, usrList.map { user -> "${user.getName()} / ${user.getPhone_Number()}" })
                listV.adapter = arryAdapter

                listV.setOnItemClickListener { parent, view, position, id ->
                    var uri = Uri.parse("tel: " + usrList.get(position).getPhone_Number())

                    var myIntent = Intent(Intent.ACTION_CALL, uri)

                    if(ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(context, arrayOf(android.Manifest.permission.CALL_PHONE), 1)
                    } else {
                        startActivity(myIntent)
                    }
                }
            }
        }
    }
}