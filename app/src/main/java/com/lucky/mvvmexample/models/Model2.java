package com.lucky.mvvmexample.models;

public class Model2 {
    private String email;
    private String password;
public Model2(String a ,String b){
    email=a;password=b;
}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
