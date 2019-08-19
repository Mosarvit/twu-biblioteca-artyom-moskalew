package com.twu.biblioteca.controllers;

import com.twu.biblioteca.views.UI_GLOBALS;
import com.twu.biblioteca.views.View;

public class MainMenuController extends InteractiveViewController {
    public MainMenuController(View view) {
        this.viewHeader = UI_GLOBALS.MAIN_MENU_VIEW_HEADER;
        this.requestInputMessage = UI_GLOBALS.MAIN_MENU_VIEW_REQUEST_INPUT_MESSAGE;
        this.nextView = view;
        this.correspondingView = view;
    }

    public String getBody() {
        return UI_GLOBALS.MAIN_MENU_LOGGED_OUT_USER_MESSAGE;
    }
}
