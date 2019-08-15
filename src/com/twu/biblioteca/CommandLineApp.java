package com.twu.biblioteca;

import com.twu.biblioteca.views.MainMenuView;
import com.twu.biblioteca.views.View;

public class CommandLineApp {
    private final IOHandler ioHandler;

    public CommandLineApp(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    public void start() {
        this.ioHandler.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        View currentTableActionView = MainMenuView.getInstance();

        while (currentTableActionView != null) {
            currentTableActionView = currentTableActionView.enter(this.ioHandler);
        }
    }
}
