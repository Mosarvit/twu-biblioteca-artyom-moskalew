package com.twu.biblioteca;

import com.twu.biblioteca.controllers.BrowseBooksController;
import com.twu.biblioteca.controllers.BrowseMoviesController;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.views.BrowseBooksView;
import com.twu.biblioteca.views.BrowseMoviesView;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class BrowseMoviesControllerTest {
    @After
    public void restoreStreams() {
        Database.clear();
    }

    @Test
    public void getTableStringTest() {
//         Arrange
        BrowseMoviesController browseMoviesController = new BrowseMoviesController(BrowseMoviesView.getInstance());

        Movie movieForrestGump = new Movie("Forrest Gump", "Robert Zemeckis", 1994);
        Movie movieMatrix = new Movie("Matrix", "Lana Wachowski, Lilly Wachowski", 1999);
        Movie movieTheGodfather = new Movie("The Godfather", "Francis Ford Coppola", 1972);

        Database.add(movieForrestGump);
        Database.add(movieMatrix);
        Database.add(movieTheGodfather);

//         Act
        String actualOutput = browseMoviesController.getBody();

//        Assert
        String expectedOutput =
                "[INDEX] | Title | Director | Year Released\n" +
                        "[1] | Forrest Gump | Robert Zemeckis | 1994\n" +
                        "[2] | Matrix | Lana Wachowski, Lilly Wachowski | 1999\n" +
                        "[3] | The Godfather | Francis Ford Coppola | 1972\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
}
