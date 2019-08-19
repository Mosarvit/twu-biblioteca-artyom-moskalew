package com.twu.biblioteca;


import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.views.UI_GLOBALS;
import org.junit.*;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;

public class CommandLineAppTest {

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
    public void startQuit1Test() {
//         Arrange
        System.setIn(new ByteArrayInputStream("x\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

//         Act
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING  +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:\n" +
                "You selected option [x].\n" +
                "\n" +
                "Good Bye!\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void startListNoBooksTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("b\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

//         Act
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING  +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:\n" +
                "You selected option [b].\n" +
                "\n" +
                "Here are the books in our library:\n" +
                "There are currently no books in the library. Please try later.\n" +
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING  +
                "\n" +
                "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                "You selected option [x].\n" +
                "\n" +
                "Good Bye!\n"
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void startWrongOptionChosen2Test() throws AWTException {
//         Arrange
        System.setIn(new ByteArrayInputStream("abc\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

//         Act
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING  +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:\n" +
                "You selected option [abc].\n" +
                "This is not a valid menu option. Please try again.\n" +
                "This is the Main Menu.\n" +
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING  +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:" +
                "\n" +
                "You selected option [x].\n" +
                "\n" +
                "Good Bye!\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void browseBooksTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("b\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

//         Act
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING  +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:\n" +
                "You selected option [b].\n" +
                "\n" +
                "Here are the books in our library:\n" +
                "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                "[2] | Walden | Henry David Thoreau | 1854\n" +
                "[3] | Agile Software Development | Robert Cecil Martin | 2003\n"+
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING  +
                "\n" +
                "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                "You selected option [x].\n" +
                "\n" +
                "Good Bye!\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void browseMoviesTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("m\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

        Movie movieForrestGump = new Movie("Forrest Gump", "Robert Zemeckis", 1994);
        Movie movieMatrix = new Movie("Matrix", "Lana Wachowski, Lilly Wachowski", 1999);
        Movie movieTheGodfather = new Movie("The Godfather", "Francis Ford Coppola", 1972);

        Database.add(movieForrestGump);
        Database.add(movieMatrix);
        Database.add(movieTheGodfather);

//         Act
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:\n" +
                "You selected option [m].\n" +
                "\n" +
                "Here are the movies in our library:\n" +
                "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                "[1] | Forrest Gump | Robert Zemeckis | 1994\n" +
                "[2] | Matrix | Lana Wachowski, Lilly Wachowski | 1999\n" +
                "[3] | The Godfather | Francis Ford Coppola | 1972\n"+
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the movie you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                "You selected option [x].\n" +
                "\n" +
                "Good Bye!\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void checkOutThenReturnMovieTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("m\n2\nrm\n1\nb\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

        Movie movieForrestGump = new Movie("Forrest Gump", "Robert Zemeckis", 1994);
        Movie movieMatrix = new Movie("Matrix", "Lana Wachowski, Lilly Wachowski", 1999);
        Movie movieTheGodfather = new Movie("The Godfather", "Francis Ford Coppola", 1972);

        Database.add(movieForrestGump);
        Database.add(movieMatrix);
        Database.add(movieTheGodfather);

//         Act
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:\n" +
                "You selected option [m].\n" +
                "\n" +
                "Here are the movies in our library:\n" +
                "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                "[1] | Forrest Gump | Robert Zemeckis | 1994\n" +
                "[2] | Matrix | Lana Wachowski, Lilly Wachowski | 1999\n" +
                "[3] | The Godfather | Francis Ford Coppola | 1972\n"+
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the movie you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                "You selected option [2].\n" +
                "\"Matrix\" is checked out.\n" +
                "Thank you! Enjoy the movie.\n" +
                "\n" +
                "Here are the movies in our library:\n" +
                "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                "[1] | Forrest Gump | Robert Zemeckis | 1994\n" +
                "[2] | The Godfather | Francis Ford Coppola | 1972\n"+
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the movie you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                "You selected option [rb].\n" +
                "\n" +
                "Here are movies, that you can return:\n" +
                "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                "[1] | Matrix | Lana Wachowski, Lilly Wachowski | 1999\n" +
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:\n" +
                "You selected option [1].\n" +
                "\"Matrix\" has been returned.\n" +
                "Thank you for returning the book!\n" +
                "\n" +
                "Here are movies, that you can return:\n" +
                "There are no movies that can be returned.\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:\n" +
                "\n" +
                "You selected option [m].\n" +
                "\n" +
                "Here are the movies in our library:\n" +
                "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                "[1] | Forrest Gump | Robert Zemeckis | 1994\n" +
                "[2] | Matrix | Lana Wachowski, Lilly Wachowski | 1999\n" +
                "[3] | The Godfather | Francis Ford Coppola | 1972\n"+
                "\n" +
                UI_TEST_GLOBALS.NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the movie you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                "You selected option [x].\n" +
                "Good Bye!\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
}
