package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.BrowseController;
import com.twu.biblioteca.models.BookEntries;
import com.twu.biblioteca.IOHandler;


public class BrowseView extends TableInteractionView {
    private static BrowseView browseView_singleton = new BrowseView();

    private BrowseView() {
        this.viewName = "List of books";




        this.controller = new BrowseController();
    }

    public static BrowseView getInstance() {
        return browseView_singleton;
    }

    public View enter(IOHandler ioHandler) {
        return interactWithTable(ioHandler);
    }
}
