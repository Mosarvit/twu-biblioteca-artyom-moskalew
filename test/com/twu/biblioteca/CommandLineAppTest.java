package com.twu.biblioteca;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;

public class CommandLineAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        Bookshelf.clear();
    }

    @Test
    public void startTest() {
//         Arrange
        IOHandler iOHandler = new IOHandler();
        CommandLineApp commandLineApp = new CommandLineApp(iOHandler);

//         Act
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "There are currently no books in the library. Please try later!\n";
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
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "Here are the books in our library:\n" +
                "[INDEX] | Title | Author | Year Published\n" +
                "[1] | Anna Karenina | Leo Tolstoy | 1877\n";
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
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
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
        commandLineApp.start();

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" +
                "Here are the books in our library:\n" +
                "[INDEX] | Title | Author | Year Published\n" +
                "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                "[2] | Walden | Henry David Thoreau | 1854\n" +
                "[3] | Agile Software Development | Robert Cecil Martin | 2003\n";
        Assert.assertThat(actualOutput, is(expectedOutput));

    }
}
