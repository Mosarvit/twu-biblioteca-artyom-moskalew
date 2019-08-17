package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.BookEntry;

import java.util.ArrayList;

public abstract class TableInteractionController {
    protected BookAction bookAction;
    protected String onSuccessMessagePart;
    protected String thankYouMessage;
    protected String wrongNumberSelectedMessage;

    public String applyActionToBook(BookEntry bookSelectedForCheckOut) {
        this.bookAction.applyToBook(bookSelectedForCheckOut);
        return  "\"" + bookSelectedForCheckOut.getTitle() + "\" " + this.onSuccessMessagePart + ".";
    }

    public String processNumericalInput(ArrayList<BookEntry> checkOutableBooks, String userSelectedOptionString){
        String response = "";
        int userSelectedNumber = Integer.parseInt(userSelectedOptionString);
        if (userSelectedNumber <= checkOutableBooks.size()) {
            BookEntry bookSelectedForCheckOut = checkOutableBooks.get(userSelectedNumber - 1);
            response +=  applyActionToBook(bookSelectedForCheckOut) + "\n";
            response += this.thankYouMessage;
        } else {
            response += this.wrongNumberSelectedMessage;
        }
        response += "\n";
        return response;
    }

    interface BookAction {
        void applyToBook(BookEntry book);
    }
}
