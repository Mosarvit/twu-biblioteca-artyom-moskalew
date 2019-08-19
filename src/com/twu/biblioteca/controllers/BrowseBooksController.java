package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.views.View;

public class BrowseBooksController extends InteractiveViewController {
    public BrowseBooksController(View view){
        this.bookAction = book -> book.checkOut();
        this.bookSelection = () -> Database.selectAllBooksWhereCheckedOutIsFalse();
        this.viewTitle = "Here are the books in our library:";
        this.onSuccessMessagePart = "is checked out";
        this.wrongNumberSelectedMessage = "Sorry, that book is not available. Please try again.";
        this.thankYouMessage = "Thank you! Enjoy the book.";
        this.requestInputMessage = "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:";
        this.emptyListMessage = "There are currently no books in the library. Please try later.";
        this.correspondingView = view;
        this.nextView = view;
    }


}
