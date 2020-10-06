package com.example.testingandroidwithdatabase.models

public final class UserModel {
    private var Name : String? = null
    private var Email : String? = null
    private var cellphone : Int? = null

    constructor(){}

    constructor(Name : String, Email : String, ID : Int){
        this.Name = Name
        this.Email = Email
        this.cellphone = ID
    }

    fun getName() : String {
        return this.Name.toString()
    }

    fun setName(Name : String){
        this.Name = Name
    }

    fun getEmail() : String {
        return this.Email.toString()
    }

    fun setEmail(Email : String){
        this.Email = Email
    }

    fun getCellphone() : Int{
        return this.cellphone.toString().toInt()
    }

    fun setCellphone(cellphone : Int){
        this.cellphone = cellphone
    }

    fun Scan() : String {
        return "Nome: ${this.getName()}, Email: ${this.getEmail()}, Celular: ${this.getCellphone()}"
    }
}