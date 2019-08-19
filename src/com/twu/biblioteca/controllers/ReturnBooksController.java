package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.Media;
import com.twu.biblioteca.views.View;
import com.twu.biblioteca.views.helpers.TablePrinter;
import com.twu.biblioteca.views.parts.NavigationBar;

import java.util.ArrayList;

public class ReturnBooksController extends InteractiveViewController {
    public ReturnBooksController(View view){
        this.mediaAction = book -> book.returnBook();
        this.mediaSelection = () -> Database.selectAllCheckedOutBooksVisibleToCurrentUser();
        this.viewHeader = "Here are books, that you can return:";
        this.onSuccessMessagePart = "has been returned";
        this.wrongNumberSelectedMessage = "That is not a valid book to return. Please try again.";
        this.thankYouMessage = "Thank you for returning the book!";
        this.requestLoggedInUserInputMessage = "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:";
        this.emptyListMessage = "There are currently no books to return. You need to check out books first.";
        this.correspondingView = view;
        this.nextView = view;
    }

    protected String printTableForAdmin(ArrayList<Media> checkOutableMedias) {
        return TablePrinter.getTableForAdminReturn(checkOutableMedias);
    }

    public String processUserInput(String userSelectedOptionString) {
        String response = "";

        if (userSelectedNavigationBarOption(userSelectedOptionString)) {
            this.nextView = NavigationBar.getInstance().processValidUserInput(userSelectedOptionString);
        } else {
            response += processBodyInteractionInput(userSelectedOptionString);
        }
        return response;
    }
}
