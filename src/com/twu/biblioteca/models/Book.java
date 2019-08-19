package com.twu.biblioteca.models;

public class Book extends Model {
    public Book(String title, String author, int yearReleased) {
        this.title = title;
        this.author = author;
        this.releaseYear = yearReleased;
    }
}
