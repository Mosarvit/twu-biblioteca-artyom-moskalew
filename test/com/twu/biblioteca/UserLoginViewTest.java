package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.views.BrowseBooksView;
import com.twu.biblioteca.views.UI_GLOBALS;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;


public class UserLoginViewTest {


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
        Database.clear();
    }

    @Test
    public void listBooksAndQuit1Test() {
//         Arrange
        System.setIn(new ByteArrayInputStream("user1\npassword1\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        UserLogInView userLogInView = UserLogInView.getInstance();

        User user1 = new User("user1", "password1");

        Database.add(user1);

//         Act
        userLogInView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                "Login to your account\n" +
                        "\n" +
                        "Please enter your username\n" +
                        "Please enter your password\n" +
                        "You successfully logged in as user1\n" +
                        "\n" +
                        UI_TEST_GLOBALS.NAVIGATION_BAR_STRING  +
                        UI_GLOBALS.LOG_IN_VIEW_REQUEST_INPUT_MESSAGE + "\n" +
                        UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [x].\n\n";
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

}
