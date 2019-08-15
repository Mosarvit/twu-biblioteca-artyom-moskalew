package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;

public class QuitBibliotecaView extends View {
    private static final QuitBibliotecaView quitBibliotecaView_singleton = new QuitBibliotecaView();

    private QuitBibliotecaView() {
        this.viewName = "Quit Biblioteca";
    }

    public static QuitBibliotecaView getInstance() {
        return quitBibliotecaView_singleton;
    }

    public View enter(IOHandler ioHandler) {
        ioHandler.printOutput("Good Buy!");
        return null;
    }
}
