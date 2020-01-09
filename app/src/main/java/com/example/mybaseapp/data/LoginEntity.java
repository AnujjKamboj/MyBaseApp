package com.example.mybaseapp.data;

public class LoginEntity {
    String userName;
    String password;
    String device;

    public LoginEntity(String userName, String password, String device) {
        this.userName = userName;
        this.password = password;
        this.device = device;
    }
}
