package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.controllers.ReturnController;

public class ReturnView extends TableInteractionView {
    private static ReturnView returnView_singleton = new ReturnView();
    private ReturnView() {
        this.viewName = "Return books";
        this.controller = new ReturnController(this);
    }

    public static ReturnView getInstance() {
        return returnView_singleton;
    }

}
