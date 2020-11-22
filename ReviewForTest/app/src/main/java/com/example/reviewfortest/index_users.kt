package com.example.reviewfortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.reviewfortest.controller.userController
import com.example.reviewfortest.models.userModel

class index_users : AppCompatActivity() {

    lateinit var txtListUser : TextView
    private var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index_users)

        txtListUser = findViewById(R.id.txtListUser)

        val userManipulator = userController(this)
        val usrArray : ArrayList<userModel> = userManipulator.Index()

        if (usrArray.isNotEmpty()) {
            var ListOfUser : String = ""

            for (i in 0 until usrArray.size) {
                ListOfUser += "${usrArray.get(i).toString()} \n"
            }
            txtListUser.text = ListOfUser
        }
    }
}