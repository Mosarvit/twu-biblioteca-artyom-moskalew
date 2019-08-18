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

    protected String wrongNumberSelectedMessage;

    protected String thankYouMessage;
    protected TableInteractionController controller;


    public String getViewName(){
        return viewName;
    }

    public abstract View enter(IOHandler ioHandler);

    protected View interactWithTable(IOHandler ioHandler) {

        while (true) {
            ioHandler.println(this.controller.getTitle());
            ioHandler.println(this.controller.getTableString());
            ioHandler.println(this.controller.getNavigationBarString());
            ioHandler.println(this.controller.getRequestInputMessage());

            String userSelectedOptionString = ioHandler.getNextInputLine();
            ioHandler.println("You selected option [" + userSelectedOptionString + "].");

            if (NavigationBar.getInstance().hasOption(userSelectedOptionString)) {
                return NavigationBar.getInstance().getView(userSelectedOptionString);
            }

            if (isNumeric(userSelectedOptionString)) {
                ioHandler.println(controller.processNumericalInput(userSelectedOptionString));
            } else {
                ioHandler.println("This is not a valid menu option. Please try again.");
            }
        }
    }



    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }



}
