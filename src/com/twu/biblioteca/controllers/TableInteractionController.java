package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.BookEntry;
import com.twu.biblioteca.views.View;
import com.twu.biblioteca.views.helpers.TablePrinter;
import com.twu.biblioteca.views.parts.NavigationBar;

import java.util.ArrayList;

public abstract class TableInteractionController implements Controller {
    protected BookAction bookAction;
    protected String onSuccessMessagePart;
    protected String thankYouMessage;
    protected String wrongNumberSelectedMessage;
    protected String requestInputMessage;
    protected BookSelection bookSelection;
    protected String emptyListMessage;
    protected String viewTitle;
    protected View correspondingView;
    protected View nextView;


    public String applyActionToBook(BookEntry bookSelectedForCheckOut) {
        this.bookAction.applyToBook(bookSelectedForCheckOut);
        return "\"" + bookSelectedForCheckOut.getTitle() + "\" " + this.onSuccessMessagePart + ".";
    }

    public String processNumericalInput(String userSelectedOptionString) {
        ArrayList<BookEntry> selectedEntries = this.bookSelection.selectBooks();
        String response = "";
        int userSelectedNumber = Integer.parseInt(userSelectedOptionString);
        if (userSelectedNumber <= selectedEntries.size()) {
            BookEntry bookSelectedForCheckOut = selectedEntries.get(userSelectedNumber - 1);
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
        return this.viewTitle;
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
            response += "This is not a valid menu option. Please try again.";
            this.nextView = this.correspondingView;
        }
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

        ArrayList<BookEntry> checkOutableBooks = bookSelection.selectBooks();

        if (checkOutableBooks.isEmpty()) {
            tableString += this.emptyListMessage + "\n";
        } else {
            tableString += TablePrinter.getTableAsString(checkOutableBooks);
        }
        return tableString;

    }


    interface BookAction {
        void applyToBook(BookEntry book);
    }

    interface BookSelection {
        ArrayList<BookEntry> selectBooks();
    }
}
