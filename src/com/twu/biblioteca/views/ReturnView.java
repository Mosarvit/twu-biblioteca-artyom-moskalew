package com.twu.biblioteca.views;

import com.twu.biblioteca.models.BookEntries;
import com.twu.biblioteca.IOHandler;

public class ReturnView extends TableInteractionView {
    private static ReturnView returnView_singleton = new ReturnView();

    private ReturnView() {

        this.viewName = "Return books";
        this.viewTitle = "Here are books, that you can return:";
        this.emptyListMessage = "There are currently no books to return. You need to check out books first.";
        this.wrongNumberSelectedMessage = "That is not a valid book to return. Please try again.";
        this.onSuccessMessagePart = "has been returned";
        this.requestingInputMessage = "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:";
        this.thankYouMessage = "Thank you for returning the book!";
    }

    public static ReturnView getInstance() {
        return returnView_singleton;
    }

    public View enter(IOHandler ioHandler) {
        return interactWithBookEntries(ioHandler, bookEntry -> bookEntry.returnBook(), () -> BookEntries.selectAllBooksWhereCheckedOutIsTrue());
    }
}
