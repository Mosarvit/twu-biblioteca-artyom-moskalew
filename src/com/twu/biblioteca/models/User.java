package com.twu.biblioteca.models;

public class User extends Model{
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
