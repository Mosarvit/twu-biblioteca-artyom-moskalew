package com.twu.biblioteca.models;

public class BookCopy extends MediaCopy {
    private boolean checkedOut = false;
    private String author;

    public BookCopy(String title, String author, int yearReleased) {
        this.title = title;
        this.author = author;
        this.yearReleased = yearReleased;
        this.mediaType = "Book";
    }

    public String getAuthor() {
        return this.author;
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
