package com.twu.biblioteca.controllers;

public class BrowseController extends TableInteractionController {
    public BrowseController(){
        this.bookAction = book -> book.checkOut();
        this.onSuccessMessagePart = "is checked out";
    }
}
