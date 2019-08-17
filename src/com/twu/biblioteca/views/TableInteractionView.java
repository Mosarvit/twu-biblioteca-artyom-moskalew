package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.TableInteractionController;
import com.twu.biblioteca.models.BookEntry;
import com.twu.biblioteca.IOHandler;
import com.twu.biblioteca.views.helpers.TablePrinter;
import com.twu.biblioteca.views.parts.NavigationBar;

import java.util.ArrayList;

import static com.twu.biblioteca.controllers.TableInteractionController.*;

public abstract class TableInteractionView extends View {
    protected String viewName;
    protected String viewTitle;
    protected String emptyListMessage;
    protected String wrongNumberSelectedMessage;
    protected String onSuccessMessagePart;
    protected String requestingInputMessage;
    protected String thankYouMessage;
    protected TableInteractionController controller;


    public String getViewName(){
        return viewName;
    }

    public abstract View enter(IOHandler ioHandler);

    protected View interactWithTable(IOHandler ioHandler, BookSelection bookSelection) {

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

                ioHandler.println(controller.processNumericalInput(checkOutableBooks, userSelectedOptionString));


            } else {
                ioHandler.println("This is not a valid menu option. Please try again.");
            }
        }
    }



    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }



    interface BookSelection {
        ArrayList<BookEntry> selectBooks();
    }
}
