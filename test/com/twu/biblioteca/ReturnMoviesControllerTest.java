package com.twu.biblioteca;

import com.twu.biblioteca.controllers.ReturnBooksController;
import com.twu.biblioteca.controllers.ReturnMoviesController;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.User;
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
        Assert.assertThat(response, is("\"" + movieTitle + "\" has been returned."));

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
                "Thank you for returning the book!";
        Assert.assertThat(response, is(expectedResponse));
    }

    @Test
    public void checkOutMoviesToTwoUsersTest() {
        // Arrange
        Movie movieForrestGump = new Movie("Forrest Gump", "Robert Zemeckis", 1994);
        Movie movieMatrix = new Movie("Matrix", "Lana Wachowski, Lilly Wachowski", 1999);
        Movie movieTheGodfather = new Movie("The Godfather", "Francis Ford Coppola", 1972);

        Database.add(movieForrestGump);
        Database.add(movieMatrix);
        Database.add(movieTheGodfather);

        User admin = new User("111-1111", "adminPassword");
        User user1 = new User("123-4567", "password1");
        User user2 = new User("123-4568", "password1");

        Session.setLoggedInUser(user1);
        movieMatrix.checkOut();

        Session.setLoggedInUser(user2);
        movieTheGodfather.checkOut();

        ReturnMoviesController returnMoviesController = new ReturnMoviesController(ReturnBooksView.getInstance());

        // Act
        Session.setLoggedInUser(user1);
        String response1 = returnMoviesController.getBody();

        // Assert
        String expectedResponse1 = "[INDEX] | Title | Director | Release Year\n" +
                "[1] | Matrix | Lana Wachowski, Lilly Wachowski | 1999\n";
        Assert.assertThat(response1, is(expectedResponse1));

        // Act
        Session.setLoggedInUser(user2);
        String response2 = returnMoviesController.getBody();

        // Assert
        String expectedResponse2 = "[INDEX] | Title | Director | Release Year\n" +
                "[1] | The Godfather | Francis Ford Coppola | 1972\n";
        Assert.assertThat(response2, is(expectedResponse2));

        // Act
        Session.setLoggedInUser(admin);
        String response3 = returnMoviesController.getBody();

        // Assert
        String expectedResponse3 = "[INDEX] | Title | Director | Release Year | Holder Library Number\n" +
                "[1] | Matrix | Lana Wachowski, Lilly Wachowski | 1999 | 123-4567\n" +
                "[2] | The Godfather | Francis Ford Coppola | 1972 | 123-4568\n";
        Assert.assertThat(response3, is(expectedResponse3));

    }
}
