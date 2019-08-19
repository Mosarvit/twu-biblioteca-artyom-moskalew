package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.views.ReturnBooksView;
import com.twu.biblioteca.views.UI_GLOBALS;
import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;


public class ReturnBooksViewTest {


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
        Session.clear();
    }

    @Test
    public void listBooksAndQuit1Test() {
//         Arrange
        System.setIn(new ByteArrayInputStream("x\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        ReturnBooksView returnBooksView = ReturnBooksView.getInstance();
        Session.setLoggedInUser(new User("123-4567", "password1"));

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

        bookWalden.checkOut();
        bookAgileSoftwareDevelopment.checkOut();

//         Act
        returnBooksView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Here are books, that you can return:\n" +
                        UI_GLOBALS.LINE_BREAK +
                        "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                        "[1] | Walden | Henry David Thoreau | 1854\n" +
                        "[2] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                        "\n" +
                        "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:\n" +
                        UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [x].\n\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void listBooksAndReturnTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("2\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        ReturnBooksView returnBooksView = ReturnBooksView.getInstance();
        Session.setLoggedInUser(new User("123-4567", "password1"));

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

        bookWalden.checkOut();
        bookAgileSoftwareDevelopment.checkOut();

//         Act
        returnBooksView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Here are books, that you can return:\n" +
                        UI_GLOBALS.LINE_BREAK +
                        "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                        "[1] | Walden | Henry David Thoreau | 1854\n" +
                        "[2] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                        "\n" +
                        "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:\n" +
                        UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [2].\n" +
                        "\"Agile Software Development\" has been returned.\n" +
                        "Thank you for returning the book!\n"+
                        "\n"
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void listBooksAndCheckOutChoiceTooHighTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("3\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        ReturnBooksView returnBooksView = ReturnBooksView.getInstance();
        Session.setLoggedInUser(new User("123-4567", "password1"));

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

        bookWalden.checkOut();
        bookAgileSoftwareDevelopment.checkOut();

//         Act
        returnBooksView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Here are books, that you can return:\n" +
                        UI_GLOBALS.LINE_BREAK +
                        "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                        "[1] | Walden | Henry David Thoreau | 1854\n" +
                        "[2] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                        "\n" +
                        "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:\n" +
                        UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [3].\n" +
                        "That is not a valid book to return. Please try again.\n" +
                        "\n"
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
}
