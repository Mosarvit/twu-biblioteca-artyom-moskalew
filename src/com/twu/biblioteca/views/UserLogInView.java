package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.controllers.UserLogInController;

public class UserLogInView extends View {
    private static UserLogInView userLogInView_singleton = new UserLogInView();
    private final UserLogInController controller;

    private UserLogInView() {
        this.viewName = UI_GLOBALS.NAVIGATION_BAR_USER_LOG_IN_LABEL;
        this.controller = new UserLogInController(this);
    }

    public static UserLogInView getInstance() {
        return userLogInView_singleton;
    }

    public View enter(IOHandler ioHandler) {
        ioHandler.println(this.controller.getViewHeader() + UI_GLOBALS.LINE_BREAK);
        ioHandler.println(this.controller.getRequestUserNameMessage());
        String userName = ioHandler.getNextInputLine();
        ioHandler.println(this.controller.getRequestPasswordMessage());
        String password = ioHandler.getNextInputLine();
        ioHandler.println(this.controller.processUserNamePasswordCombination(userName, password));
        return this.controller.getNextView();
    }
}
