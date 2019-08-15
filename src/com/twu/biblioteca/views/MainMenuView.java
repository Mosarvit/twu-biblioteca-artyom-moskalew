package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.views.parts.NavigationBar;

public class MainMenuView extends View {
    private static final MainMenuView mainMenuView_singleton = new MainMenuView();

    private MainMenuView() {
        this.viewName = "Main Menu";
    }

    public static MainMenuView getInstance() {
        return mainMenuView_singleton;
    }

    public View enter(IOHandler ioHandler) {
        ioHandler.println("This is the Main Menu.");
        NavigationBar navigationBar = NavigationBar.getInstance();
        navigationBar.printNavigationBar(ioHandler);
        ioHandler.println("Please type an option from the Navigation Bar and then hit Enter:");

        while (true) {
            String userSelectedOptionString = ioHandler.getNextInputLine();

            if (navigationBar.hasOption(userSelectedOptionString)) {
                ioHandler.println("You selected option [" + userSelectedOptionString + "].");
                View tableActionView = navigationBar.getView(userSelectedOptionString);
                return tableActionView;
            } else {
                ioHandler.println("You typed \"" + userSelectedOptionString + "\". This is not a valid menu option. Please try again.");
            }
        }
    }


}
