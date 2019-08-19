package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.ReturnMoviesController;

public class ReturnMoviesView extends InteractiveView {
    private static ReturnMoviesView returnMoviesView_singleton = new ReturnMoviesView();
    private ReturnMoviesView() {
        this.viewName = UI_GLOBALS.NAVIGATION_BAR_LABELS_RETURN_MOVIES;
        this.controller = new ReturnMoviesController(this);
    }

    public static ReturnMoviesView getInstance() {
        return returnMoviesView_singleton;
    }

}
