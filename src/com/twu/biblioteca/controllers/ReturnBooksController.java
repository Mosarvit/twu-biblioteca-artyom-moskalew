package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.views.View;

public class ReturnBooksController extends InteractiveViewController {
    public ReturnBooksController(View view){
        this.mediaAction = book -> book.returnBook();
        this.mediaSelection = () -> Database.selectAllBooksWhereCheckedOutIsTrue();
        this.viewTitle = "Here are books, that you can return:";
        this.onSuccessMessagePart = "has been returned";
        this.wrongNumberSelectedMessage = "That is not a valid book to return. Please try again.";
        this.thankYouMessage = "Thank you for returning the book!";
        this.requestInputMessage = "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:";
        this.emptyListMessage = "There are currently no books to return. You need to check out books first.";
        this.correspondingView = view;
        this.nextView = view;
    }
}