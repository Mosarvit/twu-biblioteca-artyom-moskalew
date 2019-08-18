package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BrowseController;
import com.twu.biblioteca.models.BookEntries;
import com.twu.biblioteca.models.BookEntry;
import com.twu.biblioteca.views.BrowseView;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;

public class BrowseControllerTest {
    @After
    public void restoreStreams() {
        BookEntries.clear();
    }
    @Test
    public void getTableStringTest() {
//         Arrange
        BrowseController browseController = new BrowseController();

        BookEntry bookAnnaKarenina = new BookEntry("Anna Karenina", "Leo Tolstoy", 1877);
        BookEntry bookWalden = new BookEntry("Walden", "Henry David Thoreau", 1854);
        BookEntry bookAgileSoftwareDevelopment = new BookEntry("Agile Software Development", "Robert Cecil Martin", 2003);

        BookEntries.add(bookAnnaKarenina);
        BookEntries.add(bookWalden);
        BookEntries.add(bookAgileSoftwareDevelopment);

//         Act
        String actualOutput = browseController.getTableString();

//        Assert
        String expectedOutput =
                "[INDEX] | Title | Author | Year Published\n" +
                        "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                        "[2] | Walden | Henry David Thoreau | 1854\n" +
                        "[3] | Agile Software Development | Robert Cecil Martin | 2003\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
}
