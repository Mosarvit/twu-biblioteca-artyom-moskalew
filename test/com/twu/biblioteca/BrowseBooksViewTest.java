package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.views.BrowseBooksView;
import com.twu.biblioteca.views.UI_GLOBALS;
import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;


public class BrowseBooksViewTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
        Database.clear();
    }

    @Test
    public void listBooksAndQuit1Test() {
//         Arrange
        System.setIn(new ByteArrayInputStream("x\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        BrowseBooksView browseBooksView = BrowseBooksView.getInstance();

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

//         Act
        browseBooksView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Here are the books in our library:\n" +
                        "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                        "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                        "[2] | Walden | Henry David Thoreau | 1854\n" +
                        "[3] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        UI_TEST_GLOBALS.NAVIGATION_BAR_STRING +
                        "\n" +
                        "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                        UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [x].\n\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void listBooksAndCheckOutTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("1\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        BrowseBooksView browseBooksView = BrowseBooksView.getInstance();

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

//         Act
        browseBooksView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Here are the books in our library:\n" +
                        "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                        "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                        "[2] | Walden | Henry David Thoreau | 1854\n" +
                        "[3] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        UI_TEST_GLOBALS.NAVIGATION_BAR_STRING +
                        "\n" +
                        "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                        UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [1].\n" +
                        "\"Anna Karenina\" is checked out.\n" +
                        "Thank you! Enjoy the book.\n" +
                        "\n"
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void listBooksAndCheckOutChoiceTooHighTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("4\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        BrowseBooksView browseBooksView = BrowseBooksView.getInstance();

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

//         Act
        browseBooksView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Here are the books in our library:\n" +
                        "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                        "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                        "[2] | Walden | Henry David Thoreau | 1854\n" +
                        "[3] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        UI_TEST_GLOBALS.NAVIGATION_BAR_STRING +
                        "\n" +
                        "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                        UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [4].\n" +
                        "Sorry, that book is not available. Please try again.\n" +
                        "\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
}
