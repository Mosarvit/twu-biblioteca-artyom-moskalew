package com.twu.biblioteca.controllers;

public class ReturnController extends TableInteractionController {
    public ReturnController(){
        this.bookAction = book -> book.returnBook();
        this.onSuccessMessagePart = "has been returned";
    }
}
