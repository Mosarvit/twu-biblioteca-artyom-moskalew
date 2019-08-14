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
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
}
