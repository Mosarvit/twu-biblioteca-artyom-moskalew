package com.twu.biblioteca;

import com.twu.biblioteca.models.BookEntry;
import com.twu.biblioteca.models.BookEntries;
import com.twu.biblioteca.views.BrowseView;
import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;


public class BrowseViewTest {


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
    public void listBooksAndQuit1Test() {
//         Arrange
        System.setIn(new ByteArrayInputStream("x\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        BrowseView browseView = BrowseView.getInstance();

        BookEntry bookAnnaKarenina = new BookEntry("Anna Karenina", "Leo Tolstoy", 1877);
        BookEntry bookWalden = new BookEntry("Walden", "Henry David Thoreau", 1854);
        BookEntry bookAgileSoftwareDevelopment = new BookEntry("Agile Software Development", "Robert Cecil Martin", 2003);

        BookEntries.add(bookAnnaKarenina);
        BookEntries.add(bookWalden);
        BookEntries.add(bookAgileSoftwareDevelopment);

//         Act
        browseView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Here are the books in our library:\n" +
                        "[INDEX] | Title | Author | Year Published\n" +
                        "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                        "[2] | Walden | Henry David Thoreau | 1854\n" +
                        "[3] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        "Navigation Bar:  [m] Main Menu  [l] List of books  [r] Return books  [x] Quit Biblioteca  \n" +
                        "\n" +
                        "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                        "You selected option [x].\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void listBooksAndCheckOutTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("1\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        BrowseView browseView = BrowseView.getInstance();

        BookEntry bookAnnaKarenina = new BookEntry("Anna Karenina", "Leo Tolstoy", 1877);
        BookEntry bookWalden = new BookEntry("Walden", "Henry David Thoreau", 1854);
        BookEntry bookAgileSoftwareDevelopment = new BookEntry("Agile Software Development", "Robert Cecil Martin", 2003);

        BookEntries.add(bookAnnaKarenina);
        BookEntries.add(bookWalden);
        BookEntries.add(bookAgileSoftwareDevelopment);

//         Act
        browseView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Here are the books in our library:\n" +
                        "[INDEX] | Title | Author | Year Published\n" +
                        "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                        "[2] | Walden | Henry David Thoreau | 1854\n" +
                        "[3] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        "Navigation Bar:  [m] Main Menu  [l] List of books  [r] Return books  [x] Quit Biblioteca  \n" +
                        "\n" +
                        "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                        "You selected option [1].\n" +
                        "\"Anna Karenina\" is checked out.\n" +
                        "Thank you! Enjoy the book.\n" +
                        "\n" +
                        "Here are the books in our library:\n" +
                        "[INDEX] | Title | Author | Year Published\n" +
                        "[1] | Walden | Henry David Thoreau | 1854\n" +
                        "[2] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        "Navigation Bar:  [m] Main Menu  [l] List of books  [r] Return books  [x] Quit Biblioteca  \n" +
                        "\n" +
                        "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                        "You selected option [x].\n"
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void listBooksAndCheckOutChoiceTooHighTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("4\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        BrowseView browseView = BrowseView.getInstance();

        BookEntry bookAnnaKarenina = new BookEntry("Anna Karenina", "Leo Tolstoy", 1877);
        BookEntry bookWalden = new BookEntry("Walden", "Henry David Thoreau", 1854);
        BookEntry bookAgileSoftwareDevelopment = new BookEntry("Agile Software Development", "Robert Cecil Martin", 2003);

        BookEntries.add(bookAnnaKarenina);
        BookEntries.add(bookWalden);
        BookEntries.add(bookAgileSoftwareDevelopment);

//         Act
        browseView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Here are the books in our library:\n" +
                        "[INDEX] | Title | Author | Year Published\n" +
                        "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                        "[2] | Walden | Henry David Thoreau | 1854\n" +
                        "[3] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        "Navigation Bar:  [m] Main Menu  [l] List of books  [r] Return books  [x] Quit Biblioteca  \n" +
                        "\n" +
                        "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                        "You selected option [4].\n" +
                        "Sorry, that book is not available. Please try again.\n" +
                        "\n" +
                        "Here are the books in our library:\n" +
                        "[INDEX] | Title | Author | Year Published\n" +
                        "[1] | Anna Karenina | Leo Tolstoy | 1877\n" +
                        "[2] | Walden | Henry David Thoreau | 1854\n" +
                        "[3] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        "Navigation Bar:  [m] Main Menu  [l] List of books  [r] Return books  [x] Quit Biblioteca  \n" +
                        "\n" +
                        "Please type the number of the book you want to check out or type an option from the Navigation Bar, then hit Enter:\n" +
                        "You selected option [x].\n"
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
}
