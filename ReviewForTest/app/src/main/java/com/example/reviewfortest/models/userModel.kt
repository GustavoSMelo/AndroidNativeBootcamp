package com.example.reviewfortest.models

class userModel {
    private var cellphone : String = ""
    private var email : String = ""
    private var name : String = ""
    private var password : String = ""

    fun userModel () {}

    fun getCellphone () : String {
        return this.cellphone
    }

    fun getEmail () : String {
        return this.email
    }

    fun getName () : String {
        return this.name
    }

    fun getPassword () : String {
        return this.password
    }

    fun setCellphone (cellphone : String) {
        this.cellphone = cellphone
    }

    fun setEmail (email : String) {
        this.email = email
    }

    fun setName (name : String) {
        this.name = name
    }

    fun setPassword (password : String) {
        this.password = password
    }

    override fun toString () : String {
        return "cellphone: ${this.cellphone},\n email: ${this.email},\n name: ${this.name},\n password: ${this.password} \n"
    }
}
