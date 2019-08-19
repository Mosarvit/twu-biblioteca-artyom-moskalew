package com.twu.biblioteca.models;

public class User extends Model{
    private  String libraryName;
    private  String password;

    public User(String libraryName, String password) {
        this.libraryName = libraryName;
        this.password = password;
    }

    public String getLibraryName() {
        return this.libraryName;
    }

    public Object getPassword() { return this.password;
    }
}
