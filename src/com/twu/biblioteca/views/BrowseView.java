package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.BrowseController;


public class BrowseView extends InteractiveView {
    private static BrowseView browseView_singleton = new BrowseView();

    private BrowseView() {
        this.viewName = "List of books";
        this.controller = new BrowseController(this);
    }

    public static BrowseView getInstance() {
        return browseView_singleton;
    }
}
