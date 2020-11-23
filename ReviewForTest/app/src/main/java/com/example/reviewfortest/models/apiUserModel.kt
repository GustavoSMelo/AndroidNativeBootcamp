package com.example.reviewfortest.models

class apiUserModel {
    private var cpf : String = ""
    private var rg : String = ""
    private var nome : String = ""
    private var datanasc : String = ""
    private var sexo : String = ""

    public fun apiUserModel () {}

    // getters

    public fun getCPF () : String {
        return this.cpf
    }

    public fun getRG () : String {
        return this.rg
    }

    public fun getNome () : String {
        return this.nome
    }

    public fun getDatanasc () : String {
        return this.datanasc
    }

    public fun getSexo () : String {
        return this.sexo
    }

    // setters

    public fun setCPF (cpf : String) {
        this.cpf = cpf
    }

    public fun setRG (rg : String) {
        this.rg = rg
    }

    public fun setNome (nome : String) {
        this.nome = nome
    }

    public fun setDatanasc (datanasc : String) {
        this.datanasc = datanasc
    }

    public fun setSexo (sexo : String) {
        this.sexo = sexo
    }

    //toString

    public override fun toString(): String {
        return "cpf: ${this.getCPF()} | rg: ${this.getRG()} |" +
                " nome: ${this.getNome()} | datanasc: ${this.getDatanasc()} | sexo: ${this.getSexo()}"
    }
}
