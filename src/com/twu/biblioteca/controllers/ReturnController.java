package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.BookEntries;
import com.twu.biblioteca.views.View;

public class ReturnController extends InteractiveViewController {
    public ReturnController(View view){
        this.bookAction = book -> book.returnBook();
        this.bookSelection = () -> BookEntries.selectAllBooksWhereCheckedOutIsTrue();
        this.viewTitle = "Here are books, that you can return:";
        this.onSuccessMessagePart = "has been returned";
        this.wrongNumberSelectedMessage = "That is not a valid book to return. Please try again.";
        this.thankYouMessage = "Thank you for returning the book!";
        this.requestInputMessage = "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:";
        this.emptyListMessage = "There are currently no books to return. You need to check out books first.";
        this.correspondingView = view;
        this.nextView = view
        ;
    }
}
