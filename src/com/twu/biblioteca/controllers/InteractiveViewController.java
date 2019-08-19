package com.twu.biblioteca.controllers;

import com.twu.biblioteca.Session;
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
    protected String requestLoggedInUserInputMessage;
    protected MediaSelection mediaSelection;
    protected String emptyListMessage;
    protected View correspondingView;
    protected View nextView;
    protected String sorryLogInFirstMessage = UI_GLOBALS.BROWSE_VIEW_SORRY_LOG_IN_FIRST;
    private String requestLoggedOutUserInputMessage = UI_GLOBALS.REQUEST_NAVIGATION_BAR_SELECTION_MESSAGE;


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

    public String getRequesUserInputMessage() {
        if(Session.userIsLoggedIn()){
            return this.requestLoggedInUserInputMessage;
        }else{
            return this.requestLoggedOutUserInputMessage;
        }

    }

    public String getNavigationBarString() {
        return NavigationBar.getInstance().toString();
    }

    public String getTitle() {

        return this.viewHeader;
    }

    public abstract String processUserInput(String userSelectedOptionString);

    protected boolean userSelectedNavigationBarOption(String userSelectedOptionString) {
        return NavigationBar.getInstance().hasOption(userSelectedOptionString);
    }

    public String processBodyInteractionInput(String userSelectedOptionString) {
        String response = "";
        if(!Session.userIsLoggedIn()){
            return this.sorryLogInFirstMessage;
        }
        if (isNumeric(userSelectedOptionString)) {
            response += processNumericalInput(userSelectedOptionString);
            this.nextView = this.correspondingView;
        } else {
            response += UI_GLOBALS.ACCOUNT_INFO_INVALID_USER_INPUT_MESSAGE;
            this.nextView = this.correspondingView;
        }
        response += "\n";
        return response;
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    public View getNextView() {
        View tempView = this.nextView;
        this.nextView = this.correspondingView;
        return tempView;
    }

    public String getBody() {
        String tableString = "";

        ArrayList<Media> checkOutableMedias = mediaSelection.selectMedia();

        if (checkOutableMedias.isEmpty()) {
            tableString += this.emptyListMessage + UI_GLOBALS.LINE_BREAK ;
        } else {
            if (Session.currenUserIsAdmin()){
                tableString += printTableForAdmin(checkOutableMedias);
            }else{
                tableString += TablePrinter.getTableForUser(checkOutableMedias);
            }
        }
        return tableString;
    }

    protected abstract String printTableForAdmin(ArrayList<Media> checkOutableMedias) ;


    interface MediaAction {
        void applyToBook(Media media);
    }

    interface MediaSelection {
        ArrayList<Media> selectMedia();
    }
}
