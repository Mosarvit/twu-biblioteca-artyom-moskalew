package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.Media;
import com.twu.biblioteca.views.View;
import com.twu.biblioteca.views.helpers.TablePrinter;

import java.util.ArrayList;

public class BrowseMoviesController extends InteractiveViewController {
    public BrowseMoviesController(View view){
        this.mediaAction = media -> media.checkOut();
        this.mediaSelection = () -> Database.selectAllMoviesWhereCheckedOutIsFalse();
        this.viewHeader = "Here are the movies in our library:";
        this.onSuccessMessagePart = "is checked out";
        this.wrongNumberSelectedMessage = "Sorry, that movie is not available. Please try again.";
        this.thankYouMessage = "Thank you! Enjoy the movie.";
        this.requestInputMessage = "Please type the number of the movie you want to check out or type an option from the Navigation Bar, then hit Enter:";
        this.emptyListMessage = "There are currently no movies in the library. Please try later.";
        this.correspondingView = view;
        this.nextView = view;
    }

    protected String printTableForAdmin(ArrayList<Media> checkOutableMedias) {
        return TablePrinter.getTableForAdminBrowse(checkOutableMedias);
    }
}
