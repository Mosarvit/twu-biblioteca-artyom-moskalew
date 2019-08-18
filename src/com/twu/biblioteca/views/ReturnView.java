package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.ReturnController;
import com.twu.biblioteca.models.BookEntries;
import com.twu.biblioteca.IOHandler;

public class ReturnView extends TableInteractionView {
    private static ReturnView returnView_singleton = new ReturnView();


    private ReturnView() {

        this.viewName = "Return books";


        this.wrongNumberSelectedMessage = "That is not a valid book to return. Please try again.";
        this.thankYouMessage = "Thank you for returning the book!";
        this.controller = new ReturnController();

    }

    public static ReturnView getInstance() {
        return returnView_singleton;
    }

    public View enter(IOHandler ioHandler) {
        return interactWithTable(ioHandler);
    }
}
