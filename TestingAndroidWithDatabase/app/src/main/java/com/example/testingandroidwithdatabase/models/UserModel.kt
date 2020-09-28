package com.example.testingandroidwithdatabase.models

public final class UserModel {
    private var Name : String? = null
    private var Email : String? = null
    private var ID : Int? = null

    constructor(){}

    constructor(Name : String, Email : String, ID : Int){
        this.Name = Name
        this.Email = Email
        this.ID = ID
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

    fun getID() : Int{
        return this.ID.toString().toInt()
    }

    fun setID(ID : Int){
        this.ID = ID
    }
}