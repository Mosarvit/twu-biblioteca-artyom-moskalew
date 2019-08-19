package com.twu.biblioteca;

import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.views.UI_GLOBALS;
import com.twu.biblioteca.views.UserLogInView;
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
    public void userLoginTestTest_1() {
//         Arrange
        System.setIn(new ByteArrayInputStream("username1\npassword1\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        UserLogInView userLogInView = UserLogInView.getInstance();

        User user1 = new User("username1", "password1");

        Database.add(user1);

//         Act
        userLogInView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                UI_GLOBALS.USER_LOG_IN_VIEW_HEADER + UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.USER_LOG_IN_VIEW_REQUEST_USERNAME + UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.USER_LOG_IN_VIEW_REQUEST_PASSWORD + UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.USER_LOG_IN_VIEW_SUCCESSFUL_LOG_IN_MESSAGE_PART + "username1" + UI_GLOBALS.LINE_BREAK
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void userLoginTestTest_2() {
//         Arrange
        System.setIn(new ByteArrayInputStream("username1\npassword2\nx\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        UserLogInView userLogInView = UserLogInView.getInstance();

        User user1 = new User("username1", "password1");

        Database.add(user1);

//         Act
        userLogInView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                UI_GLOBALS.USER_LOG_IN_VIEW_HEADER + UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.USER_LOG_IN_VIEW_REQUEST_USERNAME + UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.USER_LOG_IN_VIEW_REQUEST_PASSWORD + UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.USER_LOG_IN_VIEW_FAILED_LOG_IN_MESSAGE_PART + UI_GLOBALS.LINE_BREAK
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

}
