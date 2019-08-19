package com.twu.biblioteca.models;

public class Movie extends Model{
    private String director;
    public Movie(String title, String director, int yearReleased) {
        this.title = title;
        this.director = director;
        this.releaseYear = yearReleased;
    }

    public String getDirector() {
        return this.director;
    }

}
