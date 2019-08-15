package com.twu.biblioteca;


import com.twu.biblioteca.models.BookEntry;
import com.twu.biblioteca.models.BookEntries;
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
        BookEntries.clear();
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
                "Navigation Bar:  [m] Main Menu  [l] List of books  [r] Return books  [x] Quit Biblioteca  \n" +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:\n" +
                "You selected option [x].\n" +
                "Good Buy!\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void startListNoBooksTest() throws AWTException {
//         Arrange
        System.setIn(new ByteArrayInputStream("l\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

//         Act
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "Navigation Bar:  [m] Main Menu  [l] List of books  [r] Return books  [x] Quit Biblioteca  \n" +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:\n" +
                "You selected option [l].\n" +
                "Here are the books in our library:\n" +
                "There are currently no books in the library. Please try later.\n" +
                "Navigation Bar:  [m] Main Menu  [l] List of books  [r] Return books  [x] Quit Biblioteca  \n" +
                "\n" +
                "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                "You selected option [x].\n" +
                "Good Buy!\n"
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
                "Navigation Bar:  [m] Main Menu  [l] List of books  [r] Return books  [x] Quit Biblioteca  \n" +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:\n" +
                "You typed \"abc\". This is not a valid menu option. Please try again.\n" +
                "You selected option [x].\n" +
                "Good Buy!\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void listBooks1Test() {
//         Arrange
        System.setIn(new ByteArrayInputStream("l\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

        BookEntry bookAnnaKarenina = new BookEntry("Anna Karenina", "Leo Tolstoy", 1877);
        BookEntry bookWalden = new BookEntry("Walden", "Henry David Thoreau", 1854);
        BookEntry bookAgileSoftwareDevelopment = new BookEntry("Agile Software Development", "Robert Cecil Martin", 2003);

        BookEntries.add(bookAnnaKarenina);
        BookEntries.add(bookWalden);
        BookEntries.add(bookAgileSoftwareDevelopment);

//         Act
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "Navigation Bar:  [m] Main Menu  [l] List of books  [r] Return books  [x] Quit Biblioteca  \n" +
                "\n" +
                "Please type an option from the Navigation Bar and then hit Enter:\n" +
                "You selected option [l].\n" +
                "Here are the books in our library:\n" +
                "[INDEX] | Title | Author | Year Published\n" +
                "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                "[2] | Walden | Henry David Thoreau | 1854\n" +
                "[3] | Agile Software Development | Robert Cecil Martin | 2003\n"+
                "\n" +
                "Navigation Bar:  [m] Main Menu  [l] List of books  [r] Return books  [x] Quit Biblioteca  \n" +
                "\n" +
                "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                "You selected option [x].\n" +
                "Good Buy!\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }


}
