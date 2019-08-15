package com.twu.biblioteca.views;

import com.twu.biblioteca.BibliotecaBook;
import com.twu.biblioteca.Bookshelf;
import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.TablePrinter;

import java.util.ArrayList;

public class BrowseAllBooksView extends View {
    private static BrowseAllBooksView browseAllBooksView_singleton = new BrowseAllBooksView();

    private BrowseAllBooksView() {
        this.viewName = "Browse all books";
    }

    public static BrowseAllBooksView getInstance() {
        return browseAllBooksView_singleton;
    }

    public View enter(IOHandler ioHandler) {


        while (true) {
            ioHandler.printOutput("Here are the books in our library:");

            ArrayList<BibliotecaBook> checkOutableBooks = Bookshelf.selectAllBooksWhereCheckedOutIsFalse();
            if (checkOutableBooks.isEmpty()) {
                ioHandler.printOutput("There are currently no books in the library. Please try later.");
            } else {
                TablePrinter.printListOfBooks(ioHandler, checkOutableBooks);
            }

            NavigationBar navigationBar = NavigationBar.getInstance();
            navigationBar.printNavigationBar(ioHandler);

            ioHandler.printOutput("Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:");

            String userSelectedOptionString = ioHandler.getNextInputLine();

            if (navigationBar.hasOption(userSelectedOptionString)) {
                ioHandler.printOutput("You selected option [" + userSelectedOptionString + "].");
                View view = navigationBar.getView(userSelectedOptionString);
                return view;
            } else {
                int userSelectedNumber = Integer.parseInt(userSelectedOptionString);
                if (userSelectedNumber <= checkOutableBooks.size()) {
                    ioHandler.printOutput("You selected option [" + userSelectedOptionString + "].");
                    BibliotecaBook bookSelectedForCheckOut = checkOutableBooks.get(userSelectedNumber - 1);
                    bookSelectedForCheckOut.checkOut();
                    ioHandler.printOutput("\"" + bookSelectedForCheckOut.getTitle() + "\" is checked out.");
                    ioHandler.printOutput("");
                } else {
                    ioHandler.printOutput("You typed \"" + userSelectedOptionString + "\". This is not a valid menu option. Please try again.");
                }
            }
        }
    }
}
