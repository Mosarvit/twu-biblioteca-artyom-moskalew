package com.twu.biblioteca;

import com.twu.biblioteca.controllers.ReturnBooksController;
import com.twu.biblioteca.controllers.ReturnMoviesController;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.views.ReturnBooksView;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ReturnMoviesControllerTest {
    @After
    public void restoreStreams() {
        Database.clear();
    }
    @Test
    public void applyActionToBookTest1() {
        // Arrange
        String movieTitle = "Forrest Gump";
        Movie movieForrestGump = new Movie(movieTitle, "Robert Zemeckis", 1994);
        ReturnMoviesController returnBooksController = new ReturnMoviesController(ReturnBooksView.getInstance());

        // Act
        String response = returnBooksController.applyActionToBook(movieForrestGump);

        // Assert
        Assert.assertThat(response, is("\""+movieTitle+"\" has been returned."));

    }

    @Ignore
    @Test
    public void processNumericalInputTest() {
        // Arrange
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);
        Database.add(bookAgileSoftwareDevelopment);
        bookAgileSoftwareDevelopment.checkOut();
        ReturnBooksController returnBooksController = new ReturnBooksController(ReturnBooksView.getInstance());

        // Act
        String response = returnBooksController.processNumericalInput("1");

        // Assert
        String expectedResponse = "\"Agile Software Development\" has been returned.\n" +
                "Thank you for returning the book!"
                ;
        Assert.assertThat(response, is(expectedResponse));
    }
}
