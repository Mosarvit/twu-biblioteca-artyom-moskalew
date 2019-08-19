package com.twu.biblioteca.models;

public abstract class Model {
    protected boolean checkedOut = false;
    protected String author;
    protected int releaseYear;
    protected String title;

    public boolean isCheckedOut() {
        return this.checkedOut;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYearReleased() {
        return  this.releaseYear;
    }

    public void returnBook(){
        this.checkedOut = false;
    }

    public void checkOut() { this.checkedOut = true;
    }

}
