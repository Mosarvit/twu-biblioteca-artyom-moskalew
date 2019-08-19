package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.ReturnController;

public class ReturnBooksView extends InteractiveView {
    private static ReturnBooksView returnBooksView_singleton = new ReturnBooksView();
    private ReturnBooksView() {
        this.viewName = UI_GLOBALS.NAVIGATION_BAR_LABELS_RETURN_BOOKS;
        this.controller = new ReturnController(this);
    }

    public static ReturnBooksView getInstance() {
        return returnBooksView_singleton;
    }

}
