package com.twu.biblioteca.views;

import com.twu.biblioteca.models.BookEntry;
import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.views.helpers.TablePrinter;
import com.twu.biblioteca.views.parts.NavigationBar;

import java.util.ArrayList;

public abstract class TableInteractionView extends View {
    protected String viewName;
    protected String viewTitle;
    protected String emptyListMessage;
    protected String wrongNumberSelectedMessage;
    protected String onSuccessMessagePart;
    protected String requestingInputMessage;
    protected String thankYouMessage;

    public String getViewName(){
        return viewName;
    }

    public abstract View enter(IOHandler ioHandler);

    protected View interactWithTable(IOHandler ioHandler, BookAction greetService1, BookSelection bookSelection) {

        while (true) {
            ioHandler.println(this.viewTitle);

            ArrayList<BookEntry> checkOutableBooks = bookSelection.selectBooks();
            if (checkOutableBooks.isEmpty()) {
                ioHandler.println(this.emptyListMessage);
            } else {
                TablePrinter.printListOfBooks(ioHandler, checkOutableBooks);
            }

            NavigationBar navigationBar = NavigationBar.getInstance();
            navigationBar.printNavigationBar(ioHandler);

            ioHandler.println(this.requestingInputMessage);

            String userSelectedOptionString = ioHandler.getNextInputLine();

            ioHandler.println("You selected option [" + userSelectedOptionString + "].");

            if (navigationBar.hasOption(userSelectedOptionString)) {
                View tableActionView = navigationBar.getView(userSelectedOptionString);
                return tableActionView;
            } else if (isNumeric(userSelectedOptionString)) {
                int userSelectedNumber = Integer.parseInt(userSelectedOptionString);
                if (userSelectedNumber <= checkOutableBooks.size()) {
                    BookEntry bookSelectedForCheckOut = checkOutableBooks.get(userSelectedNumber - 1);
                    greetService1.applyToBook(bookSelectedForCheckOut);
                    ioHandler.println("\"" + bookSelectedForCheckOut.getTitle() + "\" " + this.onSuccessMessagePart + ".");
                    ioHandler.println(this.thankYouMessage);
                } else {
                    ioHandler.println(this.wrongNumberSelectedMessage);
                }
                ioHandler.println("");
            } else {
                ioHandler.println("This is not a valid menu option. Please try again.");
            }
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    interface BookAction {
        void applyToBook(BookEntry book);
    }

    interface BookSelection {
        ArrayList<BookEntry> selectBooks();
    }
}
