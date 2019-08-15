package com.twu.biblioteca;


import org.junit.*;

import java.awt.*;
import java.awt.event.KeyEvent;
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
        Bookshelf.clear();
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
                "Navigation Bar:\n" +
                "[m] Main Menu\n" +
                "[b] Browse all books\n" +
                "[x] Quit Biblioteca\n" +
                "\n" +
                "Please type the number of your option then hit Enter:\n" +
                "You selected option [x].\n" +
                "Good Buy!\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void startListNoBooksTest() throws AWTException {
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
                "Navigation Bar:\n" +
                "[m] Main Menu\n" +
                "[b] Browse all books\n" +
                "[x] Quit Biblioteca\n" +
                "\n" +
                "Please type the number of your option then hit Enter:\n" +
                "You selected option [b].\n" +
                "Here are the books in our library:\n" +
                "There are currently no books in the library. Please try later.\n" +
                "Navigation Bar:\n" +
                "[m] Main Menu\n" +
                "[b] Browse all books\n" +
                "[x] Quit Biblioteca\n" +
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
                "Navigation Bar:\n" +
                "[m] Main Menu\n" +
                "[b] Browse all books\n" +
                "[x] Quit Biblioteca\n" +
                "\n" +
                "Please type the number of your option then hit Enter:\n" +
                "You typed \"abc\". This is not a valid menu option. Please try again.\n" +
                "You selected option [x].\n" +
                "Good Buy!\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void listBooks1Test() {
//         Arrange
        System.setIn(new ByteArrayInputStream("b\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

        BibliotecaBook bookAnnaKarenina = new BibliotecaBook("Anna Karenina", "Leo Tolstoy", 1877);
        BibliotecaBook bookWalden = new BibliotecaBook("Walden", "Henry David Thoreau", 1854);
        BibliotecaBook bookAgileSoftwareDevelopment = new BibliotecaBook("Agile Software Development", "Robert Cecil Martin", 2003);

        Bookshelf.add(bookAnnaKarenina);
        Bookshelf.add(bookWalden);
        Bookshelf.add(bookAgileSoftwareDevelopment);

//         Act
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "Navigation Bar:\n" +
                "[m] Main Menu\n" +
                "[b] Browse all books\n" +
                "[x] Quit Biblioteca\n" +
                "\n" +
                "Please type the number of your option then hit Enter:\n" +
                "You selected option [b].\n" +
                "Here are the books in our library:\n" +
                "[INDEX] | Title | Author | Year Published\n" +
                "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                "[2] | Walden | Henry David Thoreau | 1854\n" +
                "[3] | Agile Software Development | Robert Cecil Martin | 2003\n"+
                "\n" +
                "Navigation Bar:\n" +
                "[m] Main Menu\n" +
                "[b] Browse all books\n" +
                "[x] Quit Biblioteca\n" +
                "\n" +
                "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                "You selected option [x].\n" +
                "Good Buy!\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }


}
