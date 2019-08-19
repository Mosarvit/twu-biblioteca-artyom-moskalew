package com.twu.biblioteca;

import com.twu.biblioteca.views.AccountInfoView;
import com.twu.biblioteca.views.UI_GLOBALS;
import com.twu.biblioteca.views.View;

public class CommandLineApp {
    private final IOHandler ioHandler;

    public CommandLineApp(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    public void start() {
        this.ioHandler.println(UI_GLOBALS.BIBLIOTECA_WELCOME_MESSAGE + "");

        View currentView = AccountInfoView.getInstance();

        while (currentView != null) {
            currentView = currentView.enter(this.ioHandler);
        }
    }
}
