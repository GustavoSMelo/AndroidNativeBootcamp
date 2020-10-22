package com.example.contactlistexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.contactlistexercise.controlls.Controll
import com.example.contactlistexercise.models.userModel
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject

class EmailActivity : AppCompatActivity() {

    lateinit var emailList : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        emailList = findViewById(R.id.listUserEmail)
        val context = this
        val usrList = ArrayList<userModel>()

        doAsync {

            val response = Controll().Index()
            val jsonRoot = JSONObject(response)
            val arryJSON = jsonRoot.optJSONArray("listacontatos")

            for (i in 0 until arryJSON.length()) {
                val newUser = userModel()
                val jsonManipulate : JSONObject = arryJSON.getJSONObject(i)

                newUser.setName(jsonManipulate.getString("nomecontato"))
                newUser.setPhone_Number(jsonManipulate.getString("celular"))
                newUser.setEmail_Address(jsonManipulate.getString("email"))

                usrList.add(newUser)
            }

            println(response)

            uiThread {
                val arryAdapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, usrList.map { user -> "${user.getName()} / ${user.getEmail_Address()}" })
                emailList.adapter = arryAdapter

                emailList.setOnItemClickListener { parent, view, position, id ->
                    val sendToEMailTo = usrList.get(position).getEmail_Address()
                    val myIntent = Intent(Intent.ACTION_SEND)
                    myIntent.type = "text/html"
                    myIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf<String>(sendToEMailTo.toString()))
                    myIntent.putExtra(Intent.EXTRA_CC, "")
                    myIntent.putExtra(Intent.EXTRA_BCC, "")
                    myIntent.putExtra(Intent.EXTRA_SUBJECT, "")
                    myIntent.putExtra(Intent.EXTRA_TEXT, "")

                    startActivity(myIntent)
                }
            }
        }
    }
}