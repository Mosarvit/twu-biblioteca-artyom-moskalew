package com.twu.biblioteca.controllers;

public class ReturnController extends TableInteractionController {
    public ReturnController(){
        this.bookAction = book -> book.returnBook();
        this.onSuccessMessagePart = "has been returned";
        this.wrongNumberSelectedMessage = "That is not a valid book to return. Please try again.";
        this.thankYouMessage = "Thank you for returning the book!";
    }
}
