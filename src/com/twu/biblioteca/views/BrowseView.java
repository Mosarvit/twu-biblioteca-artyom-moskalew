package com.twu.biblioteca.views;

import com.twu.biblioteca.BibliotecaBook;
import com.twu.biblioteca.Bookshelf;
import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.TablePrinter;

import java.util.ArrayList;

public class BrowseView extends View {
    private static BrowseView browseView_singleton = new BrowseView();

    private BrowseView() {
        this.viewName = "Browse all books";
    }

    public static BrowseView getInstance() {
        return browseView_singleton;
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

            ioHandler.printOutput("You selected option [" + userSelectedOptionString + "].");

            if (navigationBar.hasOption(userSelectedOptionString)) {
                View view = navigationBar.getView(userSelectedOptionString);
                return view;
            } else if (isNumeric(userSelectedOptionString)) {
                int userSelectedNumber = Integer.parseInt(userSelectedOptionString);
                if (userSelectedNumber <= checkOutableBooks.size()) {
                    BibliotecaBook bookSelectedForCheckOut = checkOutableBooks.get(userSelectedNumber - 1);
                    bookSelectedForCheckOut.checkOut();
                    ioHandler.printOutput("\"" + bookSelectedForCheckOut.getTitle() + "\" is checked out.");
                    ioHandler.printOutput("Thank you! Enjoy the book.");
                } else {
                    ioHandler.printOutput("Sorry, that book is not available. Please try again.");
                }
                ioHandler.printOutput("");
            } else {
                ioHandler.printOutput("This is not a valid menu option. Please try again.");
            }
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
