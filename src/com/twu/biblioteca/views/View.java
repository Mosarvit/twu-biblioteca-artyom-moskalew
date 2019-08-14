package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;

import java.util.HashMap;

public abstract class View {
    private HashMap<String, View> menuOptionsHM = new HashMap<String, View>();

    public abstract View enter(IOHandler ioHandler);
}
