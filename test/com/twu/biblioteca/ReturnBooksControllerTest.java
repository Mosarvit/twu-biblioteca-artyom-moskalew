package com.twu.biblioteca;

import com.twu.biblioteca.controllers.ReturnBooksController;
import com.twu.biblioteca.controllers.ReturnMoviesController;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.views.ReturnBooksView;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ReturnBooksControllerTest {
    @After
    public void restoreStreams() {
        Database.clear();
    }
    @Test
    public void applyActionToBookTest1() {
        // Arrange
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);
        ReturnBooksController returnBooksController = new ReturnBooksController(ReturnBooksView.getInstance());

        // Act
        String response = returnBooksController.applyActionToBook(bookAgileSoftwareDevelopment);

        // Assert
        Assert.assertThat(response, is("\"Agile Software Development\" has been returned."));

    }

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

    @Test
    public void checkOutBooksToTwoUsersAndAdminTest() {
        // Arrange
        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

        User admin = new User("111-1111", "adminPassword");
        User user1 = new User("123-4567", "password1");
        User user2 = new User("123-4568", "password1");

        Session.setLoggedInUser(user1);
        bookWalden.checkOut();

        Session.setLoggedInUser(user2);
        bookAnnaKarenina.checkOut();

        ReturnBooksController returnBooksController = new ReturnBooksController(ReturnBooksView.getInstance());

        // Act
        Session.setLoggedInUser(user1);
        String response1 = returnBooksController.getBody();

        // Assert
        String expectedResponse1 = "[INDEX] | Title | Author | Release Year\n" +
                "[1] | Walden | Henry David Thoreau | 1854\n"
                ;
        Assert.assertThat(response1, is(expectedResponse1));

        // Act
        Session.setLoggedInUser(user2);
        String response2 = returnBooksController.getBody();

        // Assert
        String expectedResponse2 = "[INDEX] | Title | Author | Release Year\n" +
                "[1] | Anna Karenina | Leo Tolstoy | 1877\n"
                ;
        Assert.assertThat(response2, is(expectedResponse2));

        // Act
        Session.setLoggedInUser(admin);
        String response3 = returnBooksController.getBody();

        // Assert
        String expectedResponse3 = "[INDEX] | Title | Author | Release Year\n" +
                "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                "[2] | Walden | Henry David Thoreau | 1854\n"
                ;
        Assert.assertThat(response3, is(expectedResponse3));

    }



}
