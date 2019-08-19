package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BrowseBooksController;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.views.BrowseBooksView;
import com.twu.biblioteca.views.UI_GLOBALS;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class BrowseBooksControllerTest {
    @After
    public void restoreStreams() {
        Database.clear();
    }
    @Test
    public void getTableStringTest() {
//         Arrange
        BrowseBooksController browseBooksController = new BrowseBooksController(BrowseBooksView.getInstance());

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

//         Act
        String actualOutput = browseBooksController.getBody();

//        Assert
        String expectedOutput =
                "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR +  "\n" +
                        "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                        "[2] | Walden | Henry David Thoreau | 1854\n" +
                        "[3] | Agile Software Development | Robert Cecil Martin | 2003\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void getTableAsAdminTest() {
//         Arrange
        User admin = new User("111-1111", "adminPassword");
        Session.setLoggedInUser(admin);

        BrowseBooksController browseBooksController = new BrowseBooksController(BrowseBooksView.getInstance());

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

//         Act
        String actualOutput = browseBooksController.getBody();

//        Assert
        String expectedOutput =
                "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR +  "\n" +
                        "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                        "[2] | Walden | Henry David Thoreau | 1854\n" +
                        "[3] | Agile Software Development | Robert Cecil Martin | 2003\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void processUserInputTest() {
//         Arrange
        BrowseBooksController browseBooksController = new BrowseBooksController(BrowseBooksView.getInstance());

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

//         Act
        String actualOutput = browseBooksController.processUserInput("x");

//        Assert
        String expectedOutput = "";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void processBodyInteractionInput() {
//         Arrange
        BrowseBooksController browseBooksController = new BrowseBooksController(BrowseBooksView.getInstance());

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

//         Act
        String actualOutput = browseBooksController.processBodyInteractionInput("1");
        String actualRequestInputMessage = browseBooksController.getRequesUserInputMessage();

//        Assert
        String expectedOutput = UI_GLOBALS.BROWSE_VIEW_SORRY_LOG_IN_FIRST;
        String expectedRequestInputMessage = UI_GLOBALS.REQUEST_NAVIGATION_BAR_SELECTION_MESSAGE;
        Assert.assertThat(actualOutput, is(expectedOutput));
        Assert.assertThat(actualRequestInputMessage, is(expectedRequestInputMessage));
    }
}
