package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.views.MainMenuView;
import com.twu.biblioteca.views.QuitView;
import com.twu.biblioteca.views.UI_GLOBALS;
import com.twu.biblioteca.views.View;

public class UserLogInController extends Controller {
    private String requestInputMessage = UI_GLOBALS.USER_LOG_IN_VIEW_REQUEST_INPUT_MESSAGE;
    private View correspondingView;
    private View nextView;
    private String requestUsernameMessage = UI_GLOBALS.USER_LOG_IN_VIEW_REQUEST_USERNAME;
    private String requestPasswordMessage = UI_GLOBALS.USER_LOG_IN_VIEW_REQUEST_PASSWORD;
    private String successfulLogInMessage = UI_GLOBALS.USER_LOG_IN_VIEW_SUCCESSFUL_LOG_IN_MESSAGE_PART;
    private String failedLogInMessage = UI_GLOBALS.USER_LOG_IN_VIEW_FAILED_LOG_IN_MESSAGE;

    public UserLogInController(View view) {

        this.viewHeader = UI_GLOBALS.USER_LOG_IN_VIEW_HEADER;
        this.correspondingView = view;
        this.nextView = view;
    }

    public String getViewHeader() {
        return this.viewHeader;
    }

    public String getRequestUserNameMessage() {
        return this.requestUsernameMessage;
    }

    public String getRequestPasswordMessage() { return this.requestPasswordMessage;
    }

    public String processUserNamePassworCombiantion(String userName, String password) {
        User user = Database.selectUserWhereUsernameEquals(userName);
        this.nextView = MainMenuView.getInstance();
        if(user.getPassword().equals(password)){
            return this.successfulLogInMessage + userName;
        }else{
            return this.failedLogInMessage;
        }
    }

    public View getNextView() {
        return QuitView.getInstance();
    }
}
