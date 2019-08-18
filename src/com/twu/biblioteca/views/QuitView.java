package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;

public class QuitView extends View {
    private static final QuitView QUIT_VIEW___SINGLETON = new QuitView();

    private QuitView() {
        this.viewName = "Quit Biblioteca";
    }

    public static QuitView getInstance() {
        return QUIT_VIEW___SINGLETON;
    }

    public InteractiveView enter(IOHandler ioHandler) {
        ioHandler.println("Good Bye!");
        return null;
    }
}
