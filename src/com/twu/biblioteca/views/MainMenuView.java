package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.MainMenuController;

public class MainMenuView extends InteractiveView {
    private static final MainMenuView mainMenuView_singleton = new MainMenuView();

    private MainMenuView() {
        this.viewName = "Main Menu";
        this.controller = new MainMenuController(this);
    }

    public static MainMenuView getInstance() {
        return mainMenuView_singleton;
    }
}
