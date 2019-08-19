package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.controllers.MainMenuController;

public class MainMenuView extends InteractiveView {
    private static final MainMenuView mainMenuView_singleton = new MainMenuView();

    private MainMenuView() {
        this.viewName = UI_GLOBALS.NAVIGATION_BAR_LABELS_MAIN_MENU;
        this.controller = new MainMenuController(this);
    }

    public View enter(IOHandler ioHandler){

        ioHandler.println(this.controller.getTitle());
        ioHandler.print(UI_GLOBALS.LINE_BREAK);
        ioHandler.println(this.controller.getBody());
        ioHandler.println(this.controller.getNavigationBarString());
        ioHandler.println(this.controller.getRequesUserInputMessage());

        String userSelectedOptionString = ioHandler.getNextInputLine();
        ioHandler.println(UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [" + userSelectedOptionString + "].");

        ioHandler.println(this.controller.processUserInput(userSelectedOptionString));

        return this.controller.getNextView();
    }

    public static MainMenuView getInstance() {
        return mainMenuView_singleton;
    }
}
