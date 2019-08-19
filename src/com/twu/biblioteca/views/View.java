package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.controllers.Controller;

public abstract class View {
    protected String viewName;
    public abstract View enter(IOHandler ioHandler);

    public String getViewName() {
        return this.viewName;
    }
}
