package com.twu.biblioteca;

import com.twu.biblioteca.views.BrowseView;
import com.twu.biblioteca.views.CheckedOutView;
import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;


public class CheckedOutViewTest {


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
    public void listBooksAndQuit1Test() {
//         Arrange
        System.setIn(new ByteArrayInputStream("x\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        CheckedOutView checkedOutView = CheckedOutView.getInstance();

        BibliotecaBook bookAnnaKarenina = new BibliotecaBook("Anna Karenina", "Leo Tolstoy", 1877);
        BibliotecaBook bookWalden = new BibliotecaBook("Walden", "Henry David Thoreau", 1854);
        BibliotecaBook bookAgileSoftwareDevelopment = new BibliotecaBook("Agile Software Development", "Robert Cecil Martin", 2003);

        Bookshelf.add(bookAnnaKarenina);
        Bookshelf.add(bookWalden);
        Bookshelf.add(bookAgileSoftwareDevelopment);

        bookWalden.checkOut();
        bookAgileSoftwareDevelopment.checkOut();

//         Act
        checkedOutView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Here are books, that you can return:\n" +
                        "[INDEX] | Title | Author | Year Published\n" +
                        "[1] | Walden | Henry David Thoreau | 1854\n" +
                        "[2] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        "Navigation Bar:\n" +
                        "[m] Main Menu\n" +
                        "[b] Browse all books\n" +
                        "[x] Quit Biblioteca\n" +
                        "\n" +
                        "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:\n" +
                        "You selected option [x].\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Ignore
    @Test
    public void listBooksAndReturnTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("2\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        CheckedOutView checkedOutView = CheckedOutView.getInstance();

        BibliotecaBook bookAnnaKarenina = new BibliotecaBook("Anna Karenina", "Leo Tolstoy", 1877);
        BibliotecaBook bookWalden = new BibliotecaBook("Walden", "Henry David Thoreau", 1854);
        BibliotecaBook bookAgileSoftwareDevelopment = new BibliotecaBook("Agile Software Development", "Robert Cecil Martin", 2003);

        Bookshelf.add(bookAnnaKarenina);
        Bookshelf.add(bookWalden);
        Bookshelf.add(bookAgileSoftwareDevelopment);

        bookWalden.checkOut();
        bookAgileSoftwareDevelopment.checkOut();

//         Act
        checkedOutView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Here are books, that you can return:\n" +
                        "[INDEX] | Title | Author | Year Published\n" +
                        "[1] | Walden | Henry David Thoreau | 1854\n" +
                        "[2] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        "Navigation Bar:\n" +
                        "[m] Main Menu\n" +
                        "[b] Browse all books\n" +
                        "[x] Quit Biblioteca\n" +
                        "\n" +
                        "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:\n" +
                        "You selected option [2].\n" +
                        "\"Agile Software Development\" has been returned.\n" +
                        "Thank you for returning the book!\n" +
                        "\n" +
                        "Here are books, that you can return:\n" +
                        "[INDEX] | Title | Author | Year Published\n" +
                        "[1] | Walden | Henry David Thoreau | 1854\n" +
                        "\n" +
                        "Navigation Bar:\n" +
                        "[m] Main Menu\n" +
                        "[b] Browse all books\n" +
                        "[x] Quit Biblioteca\n" +
                        "\n" +
                        "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:\n" +
                        "You selected option [x].\n"
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void listBooksAndCheckOutChoiceTooHighTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("3\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        CheckedOutView checkedOutView = CheckedOutView.getInstance();

        BibliotecaBook bookAnnaKarenina = new BibliotecaBook("Anna Karenina", "Leo Tolstoy", 1877);
        BibliotecaBook bookWalden = new BibliotecaBook("Walden", "Henry David Thoreau", 1854);
        BibliotecaBook bookAgileSoftwareDevelopment = new BibliotecaBook("Agile Software Development", "Robert Cecil Martin", 2003);

        Bookshelf.add(bookAnnaKarenina);
        Bookshelf.add(bookWalden);
        Bookshelf.add(bookAgileSoftwareDevelopment);

        bookWalden.checkOut();
        bookAgileSoftwareDevelopment.checkOut();

//         Act
        checkedOutView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Here are books, that you can return:\n" +
                        "[INDEX] | Title | Author | Year Published\n" +
                        "[1] | Walden | Henry David Thoreau | 1854\n" +
                        "[2] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        "Navigation Bar:\n" +
                        "[m] Main Menu\n" +
                        "[b] Browse all books\n" +
                        "[x] Quit Biblioteca\n" +
                        "\n" +
                        "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:\n" +
                        "You selected option [3].\n" +
                        "That is not a valid book to return. Please try again.\n" +
                        "\n" +
                        "Here are books, that you can return:\n" +
                        "[INDEX] | Title | Author | Year Published\n" +
                        "[1] | Walden | Henry David Thoreau | 1854\n" +
                        "[2] | Agile Software Development | Robert Cecil Martin | 2003\n" +
                        "\n" +
                        "Navigation Bar:\n" +
                        "[m] Main Menu\n" +
                        "[b] Browse all books\n" +
                        "[x] Quit Biblioteca\n" +
                        "\n" +
                        "Please type the number of the book you want to return or type an option from the Navigation Bar, then hit Enter:\n" +
                        "You selected option [x].\n"
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
}
