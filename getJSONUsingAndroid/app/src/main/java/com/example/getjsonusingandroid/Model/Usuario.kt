package com.example.getjsonusingandroid.Model

class Usuario {
    private var cpf : String = ""
    private var rg : String = ""
    private var nome : String = ""
    private var datanasc : String = ""
    private var sexo : String = ""
    private var salario : Double = 0.0

    fun Usuario () {}

    fun getCPF () : String {
        return this.cpf
    }

    fun setCPF (cpf: String) {
        this.cpf = cpf
    }

    fun getRG () : String {
        return this.rg
    }

    fun setRG (rg: String) {
        this.rg = rg
    }

    fun getName () : String {
        return this.nome
    }

    fun setName (nome: String) {
        this.nome = nome
    }

    fun getData () : String {
        return this.datanasc
    }

    fun setData (datanasc: String) {
        this.datanasc = datanasc
    }

    fun getSex () : String {
        return this.sexo
    }

    fun setSex (sexo: String) {
        this.sexo = sexo
    }

    fun getSal () : Double {
        return this.salario
    }

    fun setSal (salario : Double) {
        this.salario = salario
    }

    fun Scan () : String {
        return "Nome: ${this.getName()}, CPF: ${this.getCPF()}, RG: ${this.getRG()}, Data de nascimento: ${this.getData()}, Sexo: ${this.getSex()}, Salario: ${this.getSal()}"
    }
}