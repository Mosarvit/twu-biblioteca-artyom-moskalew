package com.twu.biblioteca.controllers;

import com.twu.biblioteca.views.MainMenuView;
import com.twu.biblioteca.views.View;

public class MainMenuController extends TableInteractionController {
    public MainMenuController(View view) {
        this.viewTitle = "This is the Main Menu.";
        this.requestInputMessage = "Please type an option from the Navigation Bar and then hit Enter:";
        this.nextView = view;
        this.correspondingView = view;
    }

    public String getBody() {
        return "";
    }
}
