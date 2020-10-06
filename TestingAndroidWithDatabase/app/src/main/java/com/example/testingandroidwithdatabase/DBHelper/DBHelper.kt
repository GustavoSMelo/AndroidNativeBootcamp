package com.example.testingandroidwithdatabase.DBHelper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.testingandroidwithdatabase.models.UserModel

val DATABASE_NAME="AndroidDatabase"

class DBHelper (var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    val TABLE_NAME="Users"
    val COL_NAME="name"
    val COL_EMAIL="email"
    val COL_CELLPHONE="cellphone"

    override fun onCreate(db: SQLiteDatabase?) {
        val CreateTable = "CREATE TABLE ${TABLE_NAME} " +
                "(${COL_NAME} VARCHAR(80) NOT NULL, " +
                " ${COL_EMAIL} VARCHAR(80) NOT NULL, " +
                " ${COL_CELLPHONE} INTEGER PRIMARY KEY )"

        db?.execSQL(CreateTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertData(user : UserModel) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_EMAIL, user.getEmail())
        contentValues.put(COL_NAME, user.getName())
        contentValues.put(COL_CELLPHONE, user.getCellphone())

        var result = db.insert(TABLE_NAME, null, contentValues)

        if (result == -1.toLong()) {
            Toast.makeText(context, "Error to insert data in database", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "User inserted with success", Toast.LENGTH_LONG).show()
        }
    }

    fun readData () : ArrayList<UserModel> {
        val db = this.writableDatabase
        var response = db.rawQuery("SELECT * FROM ${TABLE_NAME}", null)

        if(response.count <= 0){
            Toast.makeText(context, "Any user inserted in database", Toast.LENGTH_SHORT).show()
            val usrList = ArrayList<UserModel>()
            return usrList
        } else {
            val userList = ArrayList<UserModel>()
            while (response.moveToNext()){
                val usr = UserModel()
                usr.setName(response.getString(0))
                usr.setEmail(response.getString(1))
                usr.setCellphone(response.getInt(2))
                userList.add(usr)
            }

            return userList
        }
    }

    fun UpdateData (User : UserModel) {
        try{
            val db = this.writableDatabase
            val contentValue = ContentValues()
            contentValue.put(COL_EMAIL, User.getEmail())
            contentValue.put(COL_NAME, User.getName())
            contentValue.put(COL_CELLPHONE, User.getCellphone())
            db.update(TABLE_NAME,contentValue,"ID = ?", Array(1) { User.getCellphone().toString() })

            Toast.makeText(context, "User updated with success", Toast.LENGTH_SHORT).show()
        } catch (err : Error) {
            Toast.makeText(context, "Error in update user", Toast.LENGTH_SHORT).show()
        }
    }

    fun DeleteData (Cellphone : Int) {
        try {
            val db = this.writableDatabase
            db.delete(TABLE_NAME, "ID = ?", Array(1) { Cellphone.toString() })
            Toast.makeText(context, "User deleted with success", Toast.LENGTH_SHORT).show()
        } catch (err : Error) {
            Toast.makeText(context, "Error to delete user", Toast.LENGTH_SHORT).show()
        }
    }

    fun ReadDataOrder () : ArrayList<UserModel> {
    val db = this.writableDatabase
    var response = db.rawQuery("SELECT * FROM  ${TABLE_NAME} ORDER BY ${COL_NAME}", null)

    if (response.count <= 0){
        Toast.makeText(context, "Any user registred in database", Toast.LENGTH_LONG).show()
        val usrList = ArrayList<UserModel>()
        return usrList
    } else {
            val userList = ArrayList<UserModel>()
            while (response.moveToNext()){
                val usr = UserModel()
                usr.setName(response.getString(0))
                usr.setEmail(response.getString(1))
                usr.setCellphone(response.getInt(2))
                userList.add(usr)
            }

            return userList
        }
    }
}
