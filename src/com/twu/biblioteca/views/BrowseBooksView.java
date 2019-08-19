package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.BrowseBooksController;


public class BrowseBooksView extends InteractiveView {
    private static BrowseBooksView browseBooksView_singleton = new BrowseBooksView();

    private BrowseBooksView() {
        this.viewName = "List of books";
        this.controller = new BrowseBooksController(this);
    }

    public static BrowseBooksView getInstance() {
        return browseBooksView_singleton;
    }
}
