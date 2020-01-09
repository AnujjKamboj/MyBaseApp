package com.example.mybaseapp.data;

public class SignUpEntity {
    String userName;
    String password;
    String device;

    public SignUpEntity(String userName, String password, String device) {
        this.userName = userName;
        this.password = password;
        this.device = device;
    }
}
