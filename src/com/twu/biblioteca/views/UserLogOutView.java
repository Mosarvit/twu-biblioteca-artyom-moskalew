package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.controllers.UserLogInController;
import com.twu.biblioteca.controllers.UserLogOutController;

public class UserLogOutView extends View {
    private static UserLogOutView userLogOutView_singleton = new UserLogOutView();
    private final UserLogOutController controller;

    private UserLogOutView() {
        this.viewName = UI_GLOBALS.NAVIGATION_BAR_USER_LOG_OUT_LABEL;
        this.controller = new UserLogOutController(this);
    }

    public static UserLogOutView getInstance() {
        return userLogOutView_singleton;
    }

    public View enter(IOHandler ioHandler) {
        return null;
    }
}
