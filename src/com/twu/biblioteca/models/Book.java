package com.twu.biblioteca.models;

public class Book extends Media {
    private String author;
    public Book(String title, String author, int yearReleased) {
        this.title = title;
        this.author = author;
        this.releaseYear = yearReleased;
    }

    public String getAuthor() {
        return this.author;
    }
}
