package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.BrowseController;
import com.twu.biblioteca.models.BookEntries;
import com.twu.biblioteca.IOHandler;


public class BrowseView extends TableInteractionView {
    private static BrowseView browseView_singleton = new BrowseView();

    private BrowseView() {
        this.viewName = "List of books";
        this.viewTitle = "Here are the books in our library:";
        this.emptyListMessage = "There are currently no books in the library. Please try later.";
        this.wrongNumberSelectedMessage = "Sorry, that book is not available. Please try again.";

        this.requestingInputMessage = "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:";
        this.thankYouMessage = "Thank you! Enjoy the book.";
        this.controller = new BrowseController();
    }

    public static BrowseView getInstance() {
        return browseView_singleton;
    }

    public View enter(IOHandler ioHandler) {
        return interactWithTable(ioHandler, () -> BookEntries.selectAllBooksWhereCheckedOutIsFalse());
    }
}
