package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.BookEntries;
import com.twu.biblioteca.models.BookEntry;
import com.twu.biblioteca.views.TableInteractionView;
import com.twu.biblioteca.views.helpers.TablePrinter;
import com.twu.biblioteca.views.parts.NavigationBar;

import java.util.ArrayList;

public abstract class TableInteractionController {
    protected BookAction bookAction;
    protected String onSuccessMessagePart;
    protected String thankYouMessage;
    protected String wrongNumberSelectedMessage;
    protected String requestInputMessage;
    protected BookSelection bookSelection;
    protected String emptyListMessage;
    protected String viewTitle;


    public String applyActionToBook(BookEntry bookSelectedForCheckOut) {
        this.bookAction.applyToBook(bookSelectedForCheckOut);
        return  "\"" + bookSelectedForCheckOut.getTitle() + "\" " + this.onSuccessMessagePart + ".";
    }

    public String processNumericalInput(String userSelectedOptionString){
        ArrayList<BookEntry> selectedEntries =  this.bookSelection.selectBooks();
        String response = "";
        int userSelectedNumber = Integer.parseInt(userSelectedOptionString);
        if (userSelectedNumber <= selectedEntries.size()) {
            BookEntry bookSelectedForCheckOut = selectedEntries.get(userSelectedNumber - 1);
            response +=  applyActionToBook(bookSelectedForCheckOut) + "\n";
            response += this.thankYouMessage;
        } else {
            response += this.wrongNumberSelectedMessage;
        }
        response += "\n";
        return response;
    }

    public String getRequestInputMessage(){
        return this.requestInputMessage;
    }

    public String getTableString(){

        String tableString = "";

        ArrayList<BookEntry> checkOutableBooks = bookSelection.selectBooks();

        if (checkOutableBooks.isEmpty()) {
            tableString += this.emptyListMessage + "\n";
        } else {
            tableString += TablePrinter.getTableAsString(checkOutableBooks);
        }
        return tableString;
    }

    public String getNavigationBarString() {
        return  NavigationBar.getInstance().toString();
    }

    public String getTitle() {
        return this.viewTitle;
    }

    interface BookAction {
        void applyToBook(BookEntry book);
    }

    interface BookSelection {
        ArrayList<BookEntry> selectBooks();
    }
}
