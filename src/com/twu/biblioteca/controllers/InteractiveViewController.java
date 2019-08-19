package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Media;
import com.twu.biblioteca.views.UI_GLOBALS;
import com.twu.biblioteca.views.View;
import com.twu.biblioteca.views.helpers.TablePrinter;
import com.twu.biblioteca.views.parts.NavigationBar;

import java.util.ArrayList;

public abstract class InteractiveViewController extends Controller {
    protected MediaAction mediaAction;
    protected String onSuccessMessagePart;
    protected String thankYouMessage;
    protected String wrongNumberSelectedMessage;
    protected String requestInputMessage;
    protected MediaSelection mediaSelection;
    protected String emptyListMessage;
    protected View correspondingView;
    protected View nextView;


    public String applyActionToBook(Media bookSelectedForCheckOut) {
        this.mediaAction.applyToBook(bookSelectedForCheckOut);
        return "\"" + bookSelectedForCheckOut.getTitle() + "\" " + this.onSuccessMessagePart + ".";
    }

    public String processNumericalInput(String userSelectedOptionString) {
        ArrayList<Media> selectedEntries = this.mediaSelection.selectMedia();
        String response = "";
        int userSelectedNumber = Integer.parseInt(userSelectedOptionString);
        if (userSelectedNumber <= selectedEntries.size()) {
            Media bookSelectedForCheckOut = selectedEntries.get(userSelectedNumber - 1);
            response += applyActionToBook(bookSelectedForCheckOut) + "\n";
            response += this.thankYouMessage;
        } else {
            response += this.wrongNumberSelectedMessage;
        }
        return response;
    }

    public String getRequestInputMessage() {
        return this.requestInputMessage;
    }

    public String getNavigationBarString() {
        return NavigationBar.getInstance().toString();
    }

    public String getTitle() {
        return this.viewHeader;
    }

    public String processUserInput(String userSelectedOptionString) {
        String response = "";

        if (userSelectedNavigationBarOption(userSelectedOptionString)) {
            this.nextView = NavigationBar.getInstance().processValidUserInput(userSelectedOptionString);
        } else {
            response += processBodyInteractionInput(userSelectedOptionString);
        }
        return response;
    }

    protected boolean userSelectedNavigationBarOption(String userSelectedOptionString) {
        return NavigationBar.getInstance().hasOption(userSelectedOptionString);
    }

    private String processBodyInteractionInput(String userSelectedOptionString) {
        String response = "";
        if (isNumeric(userSelectedOptionString)) {
            response += processNumericalInput(userSelectedOptionString);
            this.nextView = this.correspondingView;
        } else {
            response += UI_GLOBALS.MAIN_MENU_INVALID_USER_INPUT_MESSAGE;
            this.nextView = this.correspondingView;
        }
        response += "\n";
        return response;
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    public View getNextView() {
        return this.nextView;
    }

    public String getBody() {
        String tableString = "";

        ArrayList<Media> checkOutableBooks = mediaSelection.selectMedia();

        if (checkOutableBooks.isEmpty()) {
            tableString += this.emptyListMessage ;
        } else {
            tableString += TablePrinter.getTableAsString(checkOutableBooks);
        }

        return tableString;

    }


    interface MediaAction {
        void applyToBook(Media media);
    }

    interface MediaSelection {
        ArrayList<Media> selectMedia();
    }
}
