package com.example.reviewfortest.controller

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.reviewfortest.models.userModel
import java.lang.Error

val DATABASE_NAME = "ReviewForTest.db"

class userController(var context : Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    private val TABLE_NAME = "user"
    private val COL_NAME = "name"
    private val COL_EMAIL = "email"
    private val COL_PASSWORD = "password"
    private val COL_CELLPHONE= "cellphone"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ${TABLE_NAME} (" +
                "${COL_CELLPHONE} VARCHAR(20) PRIMARY KEY," +
                "${COL_NAME} VARCHAR(200) NOT NULL," +
                "${COL_EMAIL} VARCHAR(200) NOT NULL," +
                "${COL_PASSWORD} VARCHAR(200) NOT NULL) ")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) { }

    fun Store (user : userModel) {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put("cellphone", user.getCellphone())
        contentValues.put("name", user.getName())
        contentValues.put("email", user.getEmail())
        contentValues.put("password", user.getPassword())

        val result = db.insert(TABLE_NAME, null, contentValues)

        if (result == -1.toLong()) {
           Toast.makeText(context, "Error to insert a new user in database", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "User inserted with success", Toast.LENGTH_LONG).show()
        }
    }

    fun Index () : ArrayList<userModel> {
        val db = this.readableDatabase
        val usrArry = ArrayList<userModel>()

        val response = db.rawQuery("SELECT * FROM ${TABLE_NAME}", null)

        if(response.count <= 0) {
            val usrArrayList = ArrayList<userModel>()
            Toast.makeText(context, "Any user finded in database", Toast.LENGTH_LONG).show()
            return usrArrayList
        } else {
            while (response.moveToNext()) {
                val newUser = userModel()

                newUser.setCellphone(response.getString(0))
                newUser.setName(response.getString(1))
                newUser.setEmail(response.getString(2))
                newUser.setPassword(response.getString(3))

                usrArry.add(newUser)
            }
            return usrArry
        }
    }

    fun Destroy (user : userModel) {
        val db = this.writableDatabase

        try {
            db.delete(TABLE_NAME, "cellphone = ?", Array(1) { user.getCellphone().toString()} )
            Toast.makeText(context, "user deleted with success", Toast.LENGTH_SHORT).show()
        } catch (err : Error) {
            Toast.makeText(context, "user not found, or cannot delete this user", Toast.LENGTH_SHORT).show()
        }
    }

    fun Update (user : userModel) {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put("name", user.getName())
        contentValues.put("email", user.getEmail())
        contentValues.put("password", user.getPassword())

        try {
            db.update(TABLE_NAME, contentValues, "cellphone = ?", Array(1) { user.getCellphone().toString() })
            Toast.makeText(context, "User updated with success", Toast.LENGTH_SHORT).show()
        } catch (err : Error) {
            Toast.makeText(context, "Error to updated user", Toast.LENGTH_SHORT).show()
        }
    }
}
