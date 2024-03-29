package com.twu.biblioteca;


import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.views.UI_GLOBALS;
import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;

public class ProgramTest {

    private  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
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
    public void startQuit1Test() {
//         Arrange
        System.setIn(new ByteArrayInputStream("x\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        Program program = new Program(iOHandler);

//         Act
        program.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = UI_GLOBALS.BIBLIOTECA_WELCOME_MESSAGE + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_HEADER + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_LOGGED_OUT_USER_MESSAGE + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_TEST_GLOBALS.LOGGED_OUT_USER_NAVIGATION_BAR +
                UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_REQUEST_INPUT_MESSAGE + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [x]." + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.BIBLIOTECA_GOOD_BYE_MESSAGE + UI_GLOBALS.LINE_BREAK
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void startWrongOptionChosen2Test()  {
//         Arrange
        System.setIn(new ByteArrayInputStream("abc\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        Program program = new Program(iOHandler);
        Session.setLoggedInUser(new User("123-4567", "password1"));

//         Act
        program.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = UI_GLOBALS.BIBLIOTECA_WELCOME_MESSAGE + "\n" +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_HEADER + "\n" +
                UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_LIBRARY_NAME + "123-4567" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_PASSWORD + "password1" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                "\n" +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_REQUEST_INPUT_MESSAGE + "\n" +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [abc].\n" +
                UI_GLOBALS.ACCOUNT_INFO_INVALID_USER_INPUT_MESSAGE + "\n" +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_HEADER + "\n" +
                "\n" +
                UI_GLOBALS.ACCOUNT_INFO_LIBRARY_NAME + "123-4567" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_PASSWORD + "password1" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                "\n" +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_REQUEST_INPUT_MESSAGE + "" +
                "\n" +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [x].\n" +
                "\n" +
                UI_GLOBALS.BIBLIOTECA_GOOD_BYE_MESSAGE + "\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void startListNoBooksTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("b\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        Program program = new Program(iOHandler);
        Session.setLoggedInUser(new User("123-4567", "password1"));

//         Act
        program.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = UI_GLOBALS.BIBLIOTECA_WELCOME_MESSAGE + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_HEADER + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_LIBRARY_NAME + "123-4567" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_PASSWORD + "password1" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_REQUEST_INPUT_MESSAGE + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [b]." + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                "Here are the books in our library:" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                "There are currently no books in the library. Please try later." + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                UI_GLOBALS.LINE_BREAK +
                "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [x]." + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.BIBLIOTECA_GOOD_BYE_MESSAGE + UI_GLOBALS.LINE_BREAK
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }


    @Test
    public void browseBooksTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("b\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        Program program = new Program(iOHandler);
        Session.setLoggedInUser(new User("123-4567", "password1"));

        Book bookAnnaKarenina = new Book("Anna Karenina", "Leo Tolstoy", 1877);
        Book bookWalden = new Book("Walden", "Henry David Thoreau", 1854);
        Book bookAgileSoftwareDevelopment = new Book("Agile Software Development", "Robert Cecil Martin", 2003);

        Database.add(bookAnnaKarenina);
        Database.add(bookWalden);
        Database.add(bookAgileSoftwareDevelopment);

//         Act
        program.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = UI_GLOBALS.BIBLIOTECA_WELCOME_MESSAGE + "\n" +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_HEADER + "\n" +
                "\n" +
                UI_GLOBALS.ACCOUNT_INFO_LIBRARY_NAME + "123-4567" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_PASSWORD + "password1" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                "\n" +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_REQUEST_INPUT_MESSAGE + "\n" +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [b].\n" +
                "\n" +
                "Here are the books in our library:\n" +
                UI_GLOBALS.LINE_BREAK +
                "[INDEX] | Title | Author | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                "[2] | Walden | Henry David Thoreau | 1854\n" +
                "[3] | Agile Software Development | Robert Cecil Martin | 2003\n"+
                "\n" +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [x].\n" +
                "\n" +
                UI_GLOBALS.BIBLIOTECA_GOOD_BYE_MESSAGE + "\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
    @Test
    public void browseMoviesTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("m\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        Program program = new Program(iOHandler);
        Session.setLoggedInUser(new User("123-4567", "password1"));


        Movie movieForrestGump = new Movie("Forrest Gump", "Robert Zemeckis", 1994);
        Movie movieMatrix = new Movie("Matrix", "Lana Wachowski, Lilly Wachowski", 1999);
        Movie movieTheGodfather = new Movie("The Godfather", "Francis Ford Coppola", 1972);

        Database.add(movieForrestGump);
        Database.add(movieMatrix);
        Database.add(movieTheGodfather);

//         Act
        program.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = UI_GLOBALS.BIBLIOTECA_WELCOME_MESSAGE + "\n" +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_HEADER + "\n" +
                "\n" +
                UI_GLOBALS.ACCOUNT_INFO_LIBRARY_NAME + "123-4567" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_PASSWORD + "password1" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                "\n" +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_REQUEST_INPUT_MESSAGE + "\n" +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [m].\n" +
                "\n" +
                "Here are the movies in our library:\n" +
                UI_GLOBALS.LINE_BREAK +
                "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                "[1] | Forrest Gump | Robert Zemeckis | 1994\n" +
                "[2] | Matrix | Lana Wachowski, Lilly Wachowski | 1999\n" +
                "[3] | The Godfather | Francis Ford Coppola | 1972\n"+
                "\n" +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the movie you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [x].\n" +
                "\n" +
                UI_GLOBALS.BIBLIOTECA_GOOD_BYE_MESSAGE + "\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
    @Test
    public void checkOutThenReturnMovieTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("m\n2\nrm\n1\nm\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        Program program = new Program(iOHandler);
        Session.setLoggedInUser(new User("123-4567", "password1"));

        Movie movieForrestGump = new Movie("Forrest Gump", "Robert Zemeckis", 1994);
        Movie movieMatrix = new Movie("Matrix", "Lana Wachowski, Lilly Wachowski", 1999);
        Movie movieTheGodfather = new Movie("The Godfather", "Francis Ford Coppola", 1972);

        Database.add(movieForrestGump);
        Database.add(movieMatrix);
        Database.add(movieTheGodfather);

//         Act
        program.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = UI_GLOBALS.BIBLIOTECA_WELCOME_MESSAGE + "\n" +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_HEADER + "\n" +
                "\n" +
                UI_GLOBALS.ACCOUNT_INFO_LIBRARY_NAME + "123-4567" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_PASSWORD + "password1" + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                "\n" +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_REQUEST_INPUT_MESSAGE + "\n" +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [m].\n" +
                "\n" +
                "Here are the movies in our library:\n" +
                UI_GLOBALS.LINE_BREAK +
                "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                "[1] | Forrest Gump | Robert Zemeckis | 1994\n" +
                "[2] | Matrix | Lana Wachowski, Lilly Wachowski | 1999\n" +
                "[3] | The Godfather | Francis Ford Coppola | 1972\n"+
                "\n" +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the movie you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [2].\n" +
                "\"Matrix\" is checked out.\n" +
                "Thank you! Enjoy the movie.\n" +
                "\n" +
                "Here are the movies in our library:\n" +
                UI_GLOBALS.LINE_BREAK +
                "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                "[1] | Forrest Gump | Robert Zemeckis | 1994\n" +
                "[2] | The Godfather | Francis Ford Coppola | 1972\n"+
                "\n" +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the movie you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [rm].\n" +
                "\n" +
                "Here are movies, that you can return:\n" +
                UI_GLOBALS.LINE_BREAK +
                "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                "[1] | Matrix | Lana Wachowski, Lilly Wachowski | 1999\n" +
                "\n" +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the movie you want to return or type an option from the Navigation Bar, then hit Enter:\n" +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [1].\n" +
                "\"Matrix\" has been returned.\n" +
                "Thank you for returning the movie!\n" +
                "\n" +
                "Here are movies, that you can return:\n" +
                UI_GLOBALS.LINE_BREAK +
                "There are currently no movies to return. You need to check out moviess first.\n" +
                "\n" +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the movie you want to return or type an option from the Navigation Bar, then hit Enter:\n" +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [m].\n" +
                "\n" +
                "Here are the movies in our library:\n" +
                UI_GLOBALS.LINE_BREAK +
                "[INDEX] | Title | Director | " + UI_GLOBALS.MEDIA_TABLE_HEAD_BOOK_RELEASE_YEAR + "\n" +
                "[1] | Forrest Gump | Robert Zemeckis | 1994\n" +
                "[2] | Matrix | Lana Wachowski, Lilly Wachowski | 1999\n" +
                "[3] | The Godfather | Francis Ford Coppola | 1972\n"+
                "\n" +
                UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                "\n" +
                "Please type the number of the movie you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [x].\n" +
                "\n" +
                UI_GLOBALS.BIBLIOTECA_GOOD_BYE_MESSAGE + "\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void logInTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("li\n123-4567\npassword1\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        Program program = new Program(iOHandler);
        User user1 = new User("123-4567", "password1");

        Database.add(user1);

        Movie movieForrestGump = new Movie("Forrest Gump", "Robert Zemeckis", 1994);
        Movie movieMatrix = new Movie("Matrix", "Lana Wachowski, Lilly Wachowski", 1999);
        Movie movieTheGodfather = new Movie("The Godfather", "Francis Ford Coppola", 1972);

        Database.add(movieForrestGump);
        Database.add(movieMatrix);
        Database.add(movieTheGodfather);

//         Act
        program.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = UI_GLOBALS.BIBLIOTECA_WELCOME_MESSAGE + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.ACCOUNT_INFO_VIEW_HEADER + UI_GLOBALS.LINE_BREAK +
                "\n" +
                "You are currently logged out. Please log in to check out or return media\n" +
                "\n" +
                "Navigation Bar:\n" +
                "[a] Account Information\n" +
                "[b] List all books\n" +
                "[m] List all movies\n" +
                "[li] Log in\n" +
                "[x] Quit Biblioteca\n" +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:\n" +
                "You selected optoin  [li].\n" +
                "\n" +
                "Login to your account\n" +
                "\n" +
                "Please enter your user name\n" +
                "Please enter your password\n" +
                "You successfully logged in as 123-4567\n" +
                "Account Information.\n" +
                "\n" +
                "Library Name: 123-4567\n" +
                "Password: password1\n" +
                "\n" +
                "Navigation Bar:\n" +
                "[a] Account Information\n" +
                "[b] List all books\n" +
                "[rb] Return Books\n" +
                "[m] List all movies\n" +
                "[rm] Return Movies\n" +
                "[lo] Log out\n" +
                "[x] Quit Biblioteca\n" +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:\n" +
                "You selected optoin  [x].\n" +
                "\n" +
                "Good Bye!" + UI_GLOBALS.LINE_BREAK ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
}
