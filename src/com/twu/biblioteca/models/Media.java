package com.twu.biblioteca.models;

import com.twu.biblioteca.Session;

public abstract class Media extends Model {
    protected boolean checkedOut = false;
    protected int releaseYear;
    protected String title;
    private User holder;

    public boolean isCheckedOut() {
        return this.checkedOut;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYearReleased() {
        return this.releaseYear;
    }

    public void returnBook() {
        this.checkedOut = false;
    }

    public void checkOut() {
        this.holder = Session.getLoggedInUser();
        this.checkedOut = true;
    }

    public User getHodlder() {
        return this.holder;
    }
}
