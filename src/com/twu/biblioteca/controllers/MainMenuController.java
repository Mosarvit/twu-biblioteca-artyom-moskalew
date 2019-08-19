package com.twu.biblioteca.controllers;

import com.twu.biblioteca.Session;
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
        String body = "";
        if(Session.getUserIsLoggedIn()){
            return UI_GLOBALS.MAIN_MENU_LOGGED_IN_USER_MESSAGE_PART + Session.getLoggedInUser().getUserName() + UI_GLOBALS.LINE_BREAK;
        }else{
            return UI_GLOBALS.MAIN_MENU_LOGGED_OUT_USER_MESSAGE+UI_GLOBALS.LINE_BREAK;
        }
    }
}
