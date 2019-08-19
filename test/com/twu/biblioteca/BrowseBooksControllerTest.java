package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BrowseBooksController;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.views.BrowseBooksView;
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
}
