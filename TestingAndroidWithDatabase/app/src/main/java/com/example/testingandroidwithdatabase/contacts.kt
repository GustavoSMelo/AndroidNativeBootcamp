package com.example.testingandroidwithdatabase

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.testingandroidwithdatabase.DBHelper.DBHelper
import com.example.testingandroidwithdatabase.models.UserModel
import java.util.jar.Manifest

class contacts : AppCompatActivity() {
    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        listView = findViewById<ListView>(R.id.listView)
        val db = DBHelper(this)
        val usrList : ArrayList<UserModel> = db.ReadDataOrder()

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, usrList.map { usr -> usr.getName() })

        listView.adapter = arrayAdapter
        listView.setOnItemLongClickListener {parent, view, position, id ->
            Toast.makeText(this, usrList.get(position).Scan(), Toast.LENGTH_LONG).show()
            true
        }

        listView.setOnItemClickListener {parent, view, position, id ->
            val uri = Uri.parse("tel: " + usrList.get(position).getCellphone())

            var myIntent : Intent = Intent(Intent.ACTION_CALL, uri)

            if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                 ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 1)
            }else {
                startActivity(myIntent)
            }


        }
    }
}