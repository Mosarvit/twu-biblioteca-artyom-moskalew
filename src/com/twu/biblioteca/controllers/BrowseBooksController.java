package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.Media;
import com.twu.biblioteca.views.View;
import com.twu.biblioteca.views.helpers.TablePrinter;
import com.twu.biblioteca.views.parts.NavigationBar;

import java.util.ArrayList;

public class BrowseBooksController extends InteractiveViewController {
    public BrowseBooksController(View view){
        this.mediaAction = media -> media.checkOut();
        this.mediaSelection = () -> Database.selectAllBooksWhereCheckedOutIsFalse();
        this.viewHeader = "Here are the books in our library:";
        this.onSuccessMessagePart = "is checked out";
        this.wrongNumberSelectedMessage = "Sorry, that book is not available. Please try again.";
        this.thankYouMessage = "Thank you! Enjoy the book.";
        this.requestLoggedInUserInputMessage = "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:";
        this.emptyListMessage = "There are currently no books in the library. Please try later.";
        this.correspondingView = view;
        this.nextView = view;
    }

    protected String printTableForAdmin(ArrayList<Media> checkOutableMedias) {
        return TablePrinter.getTableForAdminBrowse(checkOutableMedias);
    }

    public String processUserInput(String userSelectedOptionString){
        String response = "";

        if (userSelectedNavigationBarOption(userSelectedOptionString)) {
            this.nextView = NavigationBar.getInstance().processValidUserInput(userSelectedOptionString);
        } else {
            response += processBodyInteractionInput(userSelectedOptionString);
        }
        return response;
    }
}
