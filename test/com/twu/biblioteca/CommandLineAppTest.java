package com.twu.biblioteca;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void startListNoBooksTest() throws AWTException {
//         Arrange
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

//         Act
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "Here are your options:\n" +
                "[1] View the list of all books.\n" +
                "Please type the number of your option then hit Enter:\n" +
                "You selected option [1] to view the list of all Books.\n" +
                "There are currently no books in the library. Please try later.\n"
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void startWrongOptionChosen1Test() throws AWTException {
//         Arrange
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

//         Act
        System.setIn(new ByteArrayInputStream("99\n1\n".getBytes()));
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "Here are your options:\n" +
                "[1] View the list of all books.\n" +
                "Please type the number of your option then hit Enter:\n" +
                "You typed \"99\". This is not a valid menu option. Please try again.\n" +
                "Here are your options:\n" +
                "[1] View the list of all books.\n" +
                "Please type the number of your option then hit Enter:\n" +
                "You selected option [1] to view the list of all Books.\n" +
                "There are currently no books in the library. Please try later.\n"
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void startWrongOptionChosen2Test() throws AWTException {
//         Arrange
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

//         Act
        System.setIn(new ByteArrayInputStream("ab\n1\n".getBytes()));
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "Here are your options:\n" +
                "[1] View the list of all books.\n" +
                "Please type the number of your option then hit Enter:\n" +
                "You typed \"ab\". This is not a valid menu option. Please try again.\n" +
                "Here are your options:\n" +
                "[1] View the list of all books.\n" +
                "Please type the number of your option then hit Enter:\n" +
                "You selected option [1] to view the list of all Books.\n" +
                "There are currently no books in the library. Please try later.\n"
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void listOneBook1Test(){
//         Arrange
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

        BibliotecaBook bookAnnaKarenina = new BibliotecaBook("Anna Karenina", "Leo Tolstoy", 1877);

        Bookshelf.add(bookAnnaKarenina);

//         Act
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "Here are your options:\n" +
                "[1] View the list of all books.\n" +
                "Please type the number of your option then hit Enter:\n" +
                "You selected option [1] to view the list of all Books.\n" +
                "Here are the books in our library:\n" +
                "[INDEX] | Title | Author | Year Published\n" +
                "[1] | Anna Karenina | Leo Tolstoy | 1877\n"
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void listOneBook2Test(){
//         Arrange
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

        BibliotecaBook bookAnnaKarenina = new BibliotecaBook("Walden", "Henry David Thoreau", 1854);

        Bookshelf.add(bookAnnaKarenina);

//         Act
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "Here are your options:\n" +
                "[1] View the list of all books.\n" +
                "Please type the number of your option then hit Enter:\n" +
                "You selected option [1] to view the list of all Books.\n" +
                "Here are the books in our library:\n" +
                "[INDEX] | Title | Author | Year Published\n" +
                "[1] | Walden | Henry David Thoreau | 1854\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
    @Test
    public void viewListOfBooksTest(){
//         Arrange
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

        BibliotecaBook bookAnnaKarenina = new BibliotecaBook("Anna Karenina", "Leo Tolstoy", 1877);
        BibliotecaBook bookWalden = new BibliotecaBook("Walden", "Henry David Thoreau", 1854);
        BibliotecaBook bookAgileSoftwareDevelopment = new BibliotecaBook("Agile Software Development", "Robert Cecil Martin", 2003);

        Bookshelf.add(bookAnnaKarenina);
        Bookshelf.add(bookWalden);
        Bookshelf.add(bookAgileSoftwareDevelopment);

//         Act
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "This is the Main Menu.\n" +
                "Here are your options:\n" +
                "[1] View the list of all books.\n" +
                "Please type the number of your option then hit Enter:\n" +
                "You selected option [1] to view the list of all Books.\n" +
                "Here are the books in our library:\n" +
                "[INDEX] | Title | Author | Year Published\n" +
                "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                "[2] | Walden | Henry David Thoreau | 1854\n" +
                "[3] | Agile Software Development | Robert Cecil Martin | 2003\n";
        Assert.assertThat(actualOutput, is(expectedOutput));

    }
}
