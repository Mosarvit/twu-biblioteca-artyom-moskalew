package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;

public class QuitView extends View {
    private static final QuitView QUIT_VIEW___SINGLETON = new QuitView();

    private QuitView() {
        this.viewName = UI_GLOBALS.NAVIGATION_BAR_LABELS_QUIT_BIBLIOTECA;
    }

    public static QuitView getInstance() {
        return QUIT_VIEW___SINGLETON;
    }

    public InteractiveView enter(IOHandler ioHandler) {
        ioHandler.println(UI_GLOBALS.BIBLIOTECA_GOOD_BYE_MESSAGE + "");
        return null;
    }
}
