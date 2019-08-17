package com.twu.biblioteca;

import com.twu.biblioteca.controllers.ReturnController;
import com.twu.biblioteca.models.BookEntry;
import com.twu.biblioteca.views.ReturnView;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class TableInteractionViewTest {
    @Test
    public void applyActionToBookTest1(){
        // Arrange
        BookEntry bookAgileSoftwareDevelopment = new BookEntry("Agile Software Development", "Robert Cecil Martin", 2003);
        ReturnController returnController = new ReturnController();

        // Act
        String response = returnController.applyActionToBook(bookAgileSoftwareDevelopment);

        // Assert
        Assert.assertThat(response, is("\"Agile Software Development\" has been returned."));

    }
}
