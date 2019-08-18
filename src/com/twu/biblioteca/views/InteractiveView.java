package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.InteractiveViewController;
import com.twu.biblioteca.IOHandler;

public abstract class InteractiveView extends View {
    protected InteractiveViewController controller;

    public View enter(IOHandler ioHandler){

        ioHandler.println(this.controller.getTitle());
        ioHandler.println(this.controller.getBody());
        ioHandler.println(this.controller.getNavigationBarString());
        ioHandler.println(this.controller.getRequestInputMessage());

        String userSelectedOptionString = ioHandler.getNextInputLine();
        ioHandler.println("You selected option [" + userSelectedOptionString + "].");

        ioHandler.println(this.controller.processUserInput(userSelectedOptionString));

        return this.controller.getNextView();
    }
}
