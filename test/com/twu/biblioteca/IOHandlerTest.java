package com.twu.biblioteca;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;

public class IOHandlerTest {

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
    public void getLastOutputTest() {
//        Arrange
        IOHandler ioHandler = new IOHandler();

//        Act
        ioHandler.printOutput("abc");
        
//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput = "abc\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
}