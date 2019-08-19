package com.twu.biblioteca.models;

public class User extends Model{
    private  String username;
    private  String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Object getUserName() {
        return this.username;
    }

    public Object getPassword() { return this.password;
    }
}
