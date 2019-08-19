package com.twu.biblioteca.models;

public abstract class Media {
    protected boolean checkedOut = false;
    protected int releaseYear;
    protected String title;

    public boolean isCheckedOut() {
        return this.checkedOut;
    }

    public String getTitle() {
        return this.title;
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
