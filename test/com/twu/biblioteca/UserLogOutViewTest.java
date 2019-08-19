package com.twu.biblioteca;

import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.views.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;


public class UserLogOutViewTest {


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
        Session.clear();
    }

    @Test
    public void userLoginTestTest_2() {
//         Arrange
        IOHandler iOHandler = new IOHandler();
        UserLogOutView userLogOutView = UserLogOutView.getInstance();

        User user1 = new User("123-4567", "password1");
        Session.setLoggedInUser(user1);

        Database.add(user1);

//         Act
        View returnedView = userLogOutView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                UI_GLOBALS.USER_LOG_OUT_HEADER + UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.USER_LOG_OUT_VIEW_SUCCESSFULLY_LOGGED_OUT_MESSAGE + UI_GLOBALS.LINE_BREAK
                ;

        Assert.assertThat(actualOutput, is(expectedOutput));
        Assert.assertThat(Session.userIsLoggedIn(), is(false));
        Assert.assertThat(returnedView, is(AccountInfoView.getInstance()));
    }


}
