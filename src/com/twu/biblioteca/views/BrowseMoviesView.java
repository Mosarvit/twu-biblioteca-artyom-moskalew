package com.twu.biblioteca.views;


import com.twu.biblioteca.controllers.BrowseBooksController;

public class BrowseMoviesView extends InteractiveView {
    private static BrowseMoviesView browseMoviesView_singleton = new BrowseMoviesView();

    private BrowseMoviesView() {
        this.viewName = "List of books";
        this.controller = new BrowseBooksController(this);
    }

    public static BrowseMoviesView getInstance() {
        return browseMoviesView_singleton;
    }
}
