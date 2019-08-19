package com.twu.biblioteca.controllers;

import com.twu.biblioteca.Session;
import com.twu.biblioteca.views.UI_GLOBALS;
import com.twu.biblioteca.views.View;

public class UserLogOutController extends Controller{
    private final String onSuccessMessage;
    private View correspondingView;
    private View nextView;
    public UserLogOutController(View view) {
        this.viewHeader = UI_GLOBALS.USER_LOG_OUT_HEADER;
        this.onSuccessMessage = UI_GLOBALS.USER_LOG_OUT_VIEW_SUCCESSFULLY_LOGGED_OUT_MESSAGE;
        this.correspondingView = view;
        this.nextView = view;
    }

    public String getViewHeader() {
        return this.viewHeader;
    }

    public String logOutCurrentUser() {
        Session.logOutCurrentUser();
        return this.onSuccessMessage;
    }


}
