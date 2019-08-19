package com.twu.biblioteca.models;

public class MovieCopy extends MediaCopy {
    private String director;
    private boolean checkedOut = false;

    public MovieCopy(String title, String director, int yearReleased) {
        this.title = title;
        this.director = director;
        this.yearReleased = yearReleased;
        this.mediaType = "Movie";
    }

    public String getDirector() {
        return this.director;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYearReleased() {
        return this.yearReleased;
    }

    public boolean isCheckedOut() {
        return this.checkedOut;
    }

    public void checkOut() {
        this.checkedOut = true;
    }

    public void returnBook() {
        this.checkedOut = false;
    }
}
