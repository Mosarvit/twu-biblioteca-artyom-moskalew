package com.twu.biblioteca.models;

import com.twu.biblioteca.Session;

public abstract class Media extends Model {
    protected int releaseYear;
    protected String title;
    protected User holder;

    public boolean isCheckedOut() {
        return holder != null;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYearReleased() {
        return this.releaseYear;
    }

    public void returnBook() {
        this.holder = null;
    }

    public void checkOut() {
        this.holder = Session.getLoggedInUser();
    }

    public User getHodlder() {
        return this.holder;
    }
}
