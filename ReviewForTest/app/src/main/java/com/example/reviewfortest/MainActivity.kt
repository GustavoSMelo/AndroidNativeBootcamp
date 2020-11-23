package com.example.reviewfortest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.reviewfortest.controller.userController
import com.example.reviewfortest.models.userModel

class MainActivity : AppCompatActivity() {

    lateinit var txtCellphone : EditText
    lateinit var txtName : EditText
    lateinit var txtEmail : EditText
    lateinit var txtPassword : EditText
    lateinit var btnStore : Button
    lateinit var btnIndex : Button
    lateinit var btnDelete : Button
    lateinit var btnUpdate : Button
    lateinit var btnAPI : Button

    private val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStore = findViewById(R.id.btnStore)

        btnStore.setOnClickListener {
            txtCellphone = findViewById(R.id.txtCellphone)
            txtName = findViewById(R.id.txtName)
            txtEmail = findViewById(R.id.txtEmail)
            txtPassword = findViewById(R.id.txtPassoword)

            val userManipulator = userController(context)

            val user = userModel()

            user.setPassword(txtPassword.text.toString())
            user.setName(txtName.text.toString())
            user.setEmail(txtEmail.text.toString())
            user.setCellphone(txtCellphone.text.toString())

            userManipulator.Store(user)
        }

        btnIndex = findViewById(R.id.btnIndex)

        btnIndex.setOnClickListener {
            val myIntent : Intent = Intent(context, index_users::class.java)
            startActivity(myIntent)
        }

        btnDelete = findViewById(R.id.btnDelete)

        btnDelete.setOnClickListener {
            val user = userModel()

            txtEmail = findViewById(R.id.txtEmail)
            txtName = findViewById(R.id.txtName)
            txtPassword = findViewById(R.id.txtPassoword)
            txtCellphone = findViewById(R.id.txtCellphone)

            user.setCellphone(txtCellphone.text.toString())

            val userManipulator = userController(context)
            userManipulator.Destroy(user)
        }

        btnUpdate = findViewById(R.id.btnUpdate)

        btnUpdate.setOnClickListener {
            val user = userModel()

            txtEmail = findViewById(R.id.txtEmail)
            txtName = findViewById(R.id.txtName)
            txtPassword = findViewById(R.id.txtPassoword)
            txtCellphone = findViewById(R.id.txtCellphone)

            user.setName(txtName.text.toString())
            user.setEmail(txtEmail.text.toString())
            user.setPassword(txtPassword.text.toString())
            user.setCellphone(txtCellphone.text.toString())

            val userManipulator = userController(context)
            userManipulator.Update(user)
        }

        btnAPI = findViewById(R.id.btnAPI)

        btnAPI.setOnClickListener {
            val myIntent = Intent(this, apiView::class.java)
            startActivity(myIntent)
        }
    }
}
