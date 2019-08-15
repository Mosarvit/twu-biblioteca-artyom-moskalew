package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;

public class MainMenuView extends View{
    private static final MainMenuView mainMenuView_singleton = new MainMenuView();

    private MainMenuView() {
        this.viewName = "Main Menu";
    }

    public static MainMenuView getInstance() {
        return mainMenuView_singleton;
    }

    public View enter(IOHandler ioHandler) {
        ioHandler.printOutput("This is the Main Menu.");
        NavigationBar navigationBar = NavigationBar.getInstance();
        navigationBar.printNavigationBar(ioHandler);
        ioHandler.printOutput("Please type the number of your option then hit Enter:");

        while (true) {
            String userSelectedOptionString = ioHandler.getNextInputLine();

            if (navigationBar.hasOption(userSelectedOptionString)) {
                ioHandler.printOutput("You selected option [" + userSelectedOptionString + "].");
                View view = navigationBar.getView(userSelectedOptionString);
                return view;
            } else {
                ioHandler.printOutput("You typed \"" + userSelectedOptionString + "\". This is not a valid menu option. Please try again.");
            }
        }
    }


}
