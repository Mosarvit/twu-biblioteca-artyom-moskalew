package com.twu.biblioteca.controllers;

import com.twu.biblioteca.Session;
import com.twu.biblioteca.models.Media;
import com.twu.biblioteca.views.UI_GLOBALS;
import com.twu.biblioteca.views.View;
import com.twu.biblioteca.views.parts.NavigationBar;

import java.util.ArrayList;

public class MainMenuController extends InteractiveViewController {
    public MainMenuController(View view) {
        this.viewHeader = UI_GLOBALS.MAIN_MENU_VIEW_HEADER;
        this.requestLoggedInUserInputMessage = UI_GLOBALS.MAIN_MENU_VIEW_REQUEST_INPUT_MESSAGE;
        this.nextView = view;
        this.correspondingView = view;
    }

    public String getBody() {
        String body = "";
        if (Session.userIsLoggedIn()) {
            return  UI_GLOBALS.MAIN_MENU_LIBRARY_NAME + Session.getLoggedInUser().getLibraryName() +
                    UI_GLOBALS.LINE_BREAK +
                    UI_GLOBALS.MAIN_MENU_PASSWORD + Session.getLoggedInUser().getPassword() +
                    UI_GLOBALS.LINE_BREAK
                    ;
        } else {
            return UI_GLOBALS.MAIN_MENU_LOGGED_OUT_USER_MESSAGE + UI_GLOBALS.LINE_BREAK;
        }
    }

    protected String printTableForAdmin(ArrayList<Media> checkOutableMedias) {
        return null;
    }

    public String processUserInput(String userSelectedOptionString) {
        String response = "";

        if (userSelectedNavigationBarOption(userSelectedOptionString)) {
            this.nextView = NavigationBar.getInstance().processValidUserInput(userSelectedOptionString);
        } else {
            response += UI_GLOBALS.MAIN_MENU_INVALID_USER_INPUT_MESSAGE;
        }
        return response;
    }

}
