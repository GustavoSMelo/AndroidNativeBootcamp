package com.example.trainingandroidwithjava.models;

public final class user {
    private String name = "";
    private String email = "";
    private int cellphone = 0;

    public user() {}

    public user(String name, String email, int cellphone) {
        this.name = name;
        this.email = email;
        this.cellphone = cellphone;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public int getCellphone(){
        return this.cellphone;
    }

    public void setCellphone(int cellphone){
        this.cellphone = cellphone;
    }
}
