package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;

import java.util.HashMap;

public abstract class View {
    protected String viewName;
    protected HashMap<String, View> menuOptionsHM = new HashMap<String, View>();

    public String getViewName(){
        return viewName;
    }

    public abstract View enter(IOHandler ioHandler);
}
