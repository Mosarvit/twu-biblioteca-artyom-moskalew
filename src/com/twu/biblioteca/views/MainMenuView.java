package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.controllers.MainMenuController;
import com.twu.biblioteca.controllers.TableInteractionController;
import com.twu.biblioteca.views.parts.NavigationBar;

public class MainMenuView extends TableInteractionView {
    private static final MainMenuView mainMenuView_singleton = new MainMenuView();

    private MainMenuView() {
        this.viewName = "Main Menu";
        this.controller = new MainMenuController(this);
    }

    public static MainMenuView getInstance() {
        return mainMenuView_singleton;
    }
}
