package com.example.contactlistexercise.models

class userModel {
    private var name : String = ""
    private var phone_number : String = ""
    private var email_address : String = ""

    fun getName() : String {
        return this.name
    }

    fun setName(name : String){
        this.name = name
    }

    fun getPhone_Number () :String {
        return this.phone_number
    }

    fun setPhone_Number (phone_number : String) {
        this.phone_number = phone_number
    }

    fun getEmail_Address () : String {
        return this.email_address
    }

    fun setEmail_Address (email_address : String) {
        this.email_address = email_address
    }
}
