package com.twu.biblioteca;

public class BibliotecaBook {
    private final int yearPublished;
    private final String author;
    private final String title;
    private boolean checkedOut = false;

    public BibliotecaBook(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYearPublished() {
        return this.yearPublished;
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
