package com.twu.biblioteca.controllers;

import com.twu.biblioteca.Session;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.views.AccountInfoView;
import com.twu.biblioteca.views.UI_GLOBALS;
import com.twu.biblioteca.views.View;

public class UserLogInController extends Controller {
    private String requestUsernameMessage = UI_GLOBALS.USER_LOG_IN_VIEW_REQUEST_USERNAME;
    private String requestPasswordMessage = UI_GLOBALS.USER_LOG_IN_VIEW_REQUEST_PASSWORD;
    private String successfulLogInMessage = UI_GLOBALS.USER_LOG_IN_VIEW_SUCCESSFUL_LOG_IN_MESSAGE_PART;
    private String failedLogInMessage = UI_GLOBALS.USER_LOG_IN_VIEW_FAILED_LOG_IN_MESSAGE;

    public UserLogInController(View view) {

        this.viewHeader = UI_GLOBALS.USER_LOG_IN_VIEW_HEADER;
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

    public String processUserNamePasswordCombination(String userName, String password) {
        User user = Database.selectUserWhereUsernameEquals(userName);
        this.nextView = AccountInfoView.getInstance();
        if(user == null){
            return this.failedLogInMessage;
        }
        if(user.getPassword().equals(password)){
            Session.setLoggedInUser(user);
            return this.successfulLogInMessage + userName;
        }else{
            return this.failedLogInMessage;
        }
    }
}
