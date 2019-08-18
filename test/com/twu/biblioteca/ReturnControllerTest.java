package com.twu.biblioteca;

import com.twu.biblioteca.controllers.ReturnController;
import com.twu.biblioteca.models.BookEntries;
import com.twu.biblioteca.models.BookEntry;
import com.twu.biblioteca.views.ReturnView;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;

public class ReturnControllerTest {
    @After
    public void restoreStreams() {
        BookEntries.clear();
    }
    @Test
    public void applyActionToBookTest1() {
        // Arrange
        BookEntry bookAgileSoftwareDevelopment = new BookEntry("Agile Software Development", "Robert Cecil Martin", 2003);
        ReturnController returnController = new ReturnController();

        // Act
        String response = returnController.applyActionToBook(bookAgileSoftwareDevelopment);

        // Assert
        Assert.assertThat(response, is("\"Agile Software Development\" has been returned."));

    }

    @Test
    public void processNumericalInputTest() {
        // Arrange
        BookEntry bookAgileSoftwareDevelopment = new BookEntry("Agile Software Development", "Robert Cecil Martin", 2003);
        BookEntries.add(bookAgileSoftwareDevelopment);
        bookAgileSoftwareDevelopment.checkOut();
        ReturnController returnController = new ReturnController();

        // Act
        String response = returnController.processNumericalInput("1");

        // Assert
        String expectedResponse = "\"Agile Software Development\" has been returned.\n" +
                "Thank you for returning the book!\n"
                ;
        Assert.assertThat(response, is(expectedResponse));
    }
}
