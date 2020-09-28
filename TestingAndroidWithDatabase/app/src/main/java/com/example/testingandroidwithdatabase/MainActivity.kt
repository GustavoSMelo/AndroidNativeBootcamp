package com.example.testingandroidwithdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.testingandroidwithdatabase.DBHelper.DBHelper
import com.example.testingandroidwithdatabase.models.UserModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var txtId : EditText
    lateinit var txtEmail : EditText
    lateinit var txtName : EditText
    lateinit var btnInsert : Button
    lateinit var btnRead : Button
    lateinit var txtResult : TextView
    lateinit var btnUpdate : Button
    lateinit var btnDelete : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInsert = findViewById(R.id.btnInsert)
        btnRead = findViewById(R.id.btnRead)
        btnUpdate = findViewById(R.id.btnUpdate)

        btnInsert.setOnClickListener {
            txtId = findViewById(R.id.txtId)
            txtEmail = findViewById(R.id.txtEmail)
            txtName = findViewById(R.id.txtName)

            var user = UserModel(txtName.text.toString() , txtEmail.text.toString(), txtId.text.toString().toInt())
            var db = DBHelper(this)
            db.insertData(user)
        }

        btnRead.setOnClickListener {
            val db = DBHelper(this)
            val usrList : ArrayList<UserModel> = db.readData()

            if(usrList.isNotEmpty()){
                txtResult = findViewById(R.id.txtResult)
                txtResult.text = ""

                for(i in 0 until usrList.size){
                    txtResult.text = txtResult.text.toString() + "${usrList.get(i).getName()} ${usrList.get(i).getID()} ${usrList.get(i).getEmail()} \n"
                }
            }
        }

        btnUpdate.setOnClickListener {
            val db = DBHelper(this)
            val Usr = UserModel()

            txtName = findViewById(R.id.txtName)
            txtEmail = findViewById(R.id.txtEmail)
            txtId = findViewById(R.id.txtId)

            Usr.setName(txtName.text.toString())
            Usr.setEmail(txtEmail.text.toString())
            Usr.setID(txtId.text.toString().toInt())

            db.UpdateData(Usr)
        }

        btnDelete = findViewById(R.id.btnDelete)

        btnDelete.setOnClickListener {
            val db = DBHelper(this)
            txtId = findViewById(R.id.txtId)

            db.DeleteData(txtId.text.toString().toInt())
        }
    }
}