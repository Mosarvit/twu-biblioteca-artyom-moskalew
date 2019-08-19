package com.twu.biblioteca.controllers;

import com.twu.biblioteca.views.UI_GLOBALS;
import com.twu.biblioteca.views.View;

public class UserLogOutController extends Controller{
    private View correspondingView;
    private View nextView;
    public UserLogOutController(View view) {

        this.correspondingView = view;
        this.nextView = view;
    }
}
