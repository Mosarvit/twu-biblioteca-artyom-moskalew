package com.twu.biblioteca.views;

import com.twu.biblioteca.BibliotecaBook;
import com.twu.biblioteca.Bookshelf;
import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.TablePrinter;

import java.util.ArrayList;

public class CheckedOutView extends View {
    private static CheckedOutView browseView_singleton = new CheckedOutView();

    private CheckedOutView() {
        this.viewName = "Browse all books";
    }

    public static CheckedOutView getInstance() {
        return browseView_singleton;
    }

    public View enter(IOHandler ioHandler) {


        while (true) {
            ioHandler.printOutput("Here are books, that you can return:");

            ArrayList<BibliotecaBook> checkedOutBooks = Bookshelf.selectAllBooksWhereCheckedOutIsTrue();
            if (checkedOutBooks.isEmpty()) {
                ioHandler.printOutput("There are currently no books that can be returned. You need to check out a book first.");
            } else {
                TablePrinter.printListOfBooks(ioHandler, checkedOutBooks);
            }

            NavigationBar navigationBar = NavigationBar.getInstance();
            navigationBar.printNavigationBar(ioHandler);

            ioHandler.printOutput("Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:");

            String userSelectedOptionString = ioHandler.getNextInputLine();

            ioHandler.printOutput("You selected option [" + userSelectedOptionString + "].");

            if (navigationBar.hasOption(userSelectedOptionString)) {
                View view = navigationBar.getView(userSelectedOptionString);
                return view;
            } else if (isNumeric(userSelectedOptionString)) {
                int userSelectedNumber = Integer.parseInt(userSelectedOptionString);
                if (userSelectedNumber <= checkedOutBooks.size()) {
                    BibliotecaBook bookSelectedForCheckOut = checkedOutBooks.get(userSelectedNumber - 1);
                    bookSelectedForCheckOut.returnBook();
                    ioHandler.printOutput("\"" + bookSelectedForCheckOut.getTitle() + "\" has been returned.");
                    ioHandler.printOutput("Thank you for returning the book!");
                } else {
                    ioHandler.printOutput("That is not a valid book to return. Please try again.");
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
