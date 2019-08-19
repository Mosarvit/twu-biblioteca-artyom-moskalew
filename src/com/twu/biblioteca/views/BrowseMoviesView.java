package com.twu.biblioteca.views;


import com.twu.biblioteca.controllers.BrowseBooksController;
import com.twu.biblioteca.controllers.BrowseMoviesController;

public class BrowseMoviesView extends InteractiveView {
    private static BrowseMoviesView browseMoviesView_singleton = new BrowseMoviesView();

    private BrowseMoviesView() {
        this.viewName = UI_GLOBALS.NAVIGATION_BAR_LABELS_BROWSE_MOVIES;
        this.controller = new BrowseMoviesController(this);
    }

    public static BrowseMoviesView getInstance() {
        return browseMoviesView_singleton;
    }
}
