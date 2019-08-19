package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BrowseBooksController;
import com.twu.biblioteca.models.BookCopies;
import com.twu.biblioteca.models.BookCopy;
import com.twu.biblioteca.views.BrowseBooksView;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class BrowseBooksControllerTest {
    @After
    public void restoreStreams() {
        BookCopies.clear();
    }
    @Test
    public void getTableStringTest() {
//         Arrange
        BrowseBooksController browseBooksController = new BrowseBooksController(BrowseBooksView.getInstance());

        BookCopy bookAnnaKarenina = new BookCopy("Anna Karenina", "Leo Tolstoy", 1877);
        BookCopy bookWalden = new BookCopy("Walden", "Henry David Thoreau", 1854);
        BookCopy bookAgileSoftwareDevelopment = new BookCopy("Agile Software Development", "Robert Cecil Martin", 2003);

        BookCopies.add(bookAnnaKarenina);
        BookCopies.add(bookWalden);
        BookCopies.add(bookAgileSoftwareDevelopment);

//         Act
        String actualOutput = browseBooksController.getBody();

//        Assert
        String expectedOutput =
                "[INDEX] | Title | Author | Year Published\n" +
                        "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                        "[2] | Walden | Henry David Thoreau | 1854\n" +
                        "[3] | Agile Software Development | Robert Cecil Martin | 2003\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }



    @Test
    public void processUserInputTest() {
//         Arrange
        BrowseBooksController browseBooksController = new BrowseBooksController(BrowseBooksView.getInstance());

        BookCopy bookAnnaKarenina = new BookCopy("Anna Karenina", "Leo Tolstoy", 1877);
        BookCopy bookWalden = new BookCopy("Walden", "Henry David Thoreau", 1854);
        BookCopy bookAgileSoftwareDevelopment = new BookCopy("Agile Software Development", "Robert Cecil Martin", 2003);

        BookCopies.add(bookAnnaKarenina);
        BookCopies.add(bookWalden);
        BookCopies.add(bookAgileSoftwareDevelopment);

//         Act
        String actualOutput = browseBooksController.processUserInput("x");

//        Assert
        String expectedOutput = "";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
}
