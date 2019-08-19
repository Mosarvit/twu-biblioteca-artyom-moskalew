package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.views.View;

public class ReturnMoviesController extends InteractiveViewController {
    public ReturnMoviesController(View view){
        this.mediaAction = book -> book.returnBook();
        this.mediaSelection = () -> Database.selectAllMoviesWhereCheckedOutIsTrue();
        this.viewTitle = "Here are movies, that you can return:";
        this.onSuccessMessagePart = "has been returned";
        this.wrongNumberSelectedMessage = "That is not a valid movie to return. Please try again.";
        this.thankYouMessage = "Thank you for returning the movie!";
        this.requestInputMessage = "Please type the number of the movie you want to return or type an option from the Navigation Bar, then hit Enter:";
        this.emptyListMessage = "There are currently no movies to return. You need to check out moviess first.";
        this.correspondingView = view;
        this.nextView = view;
    }
}
