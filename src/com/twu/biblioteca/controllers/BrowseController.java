package com.twu.biblioteca.controllers;

public class BrowseController extends TableInteractionController {
    public BrowseController(){
        this.bookAction = book -> book.checkOut();
        this.onSuccessMessagePart = "is checked out";
        this.wrongNumberSelectedMessage = "Sorry, that book is not available. Please try again.";
        this.thankYouMessage = "Thank you! Enjoy the book.";
    }
}
