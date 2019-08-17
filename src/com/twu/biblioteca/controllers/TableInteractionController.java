package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.BookEntry;
import com.twu.biblioteca.views.TableInteractionView;

public abstract class TableInteractionController {
    protected BookAction bookAction;
    protected String onSuccessMessagePart;

    public String applyActionToBook(BookEntry bookSelectedForCheckOut) {
        this.bookAction.applyToBook(bookSelectedForCheckOut);
        return  "\"" + bookSelectedForCheckOut.getTitle() + "\" " + this.onSuccessMessagePart + ".";
    }

    interface BookAction {
        void applyToBook(BookEntry book);
    }
}
