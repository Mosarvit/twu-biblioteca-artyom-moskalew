package com.twu.biblioteca.views;

import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.controllers.AccountInfoController;

public class AccountInfoView extends InteractiveView {
    private static final AccountInfoView ACCOUNT_INFO_VIEW___SINGLETON = new AccountInfoView();

    private AccountInfoView() {
        this.viewName = UI_GLOBALS.NAVIGATION_BAR_LABELS_ACCOUNT_INFO;
        this.controller = new AccountInfoController(this);
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

    public static AccountInfoView getInstance() {
        return ACCOUNT_INFO_VIEW___SINGLETON;
    }
}
