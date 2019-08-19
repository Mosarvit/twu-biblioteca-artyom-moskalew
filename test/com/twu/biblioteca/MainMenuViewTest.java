package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Database;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.views.BrowseBooksView;
import com.twu.biblioteca.views.MainMenuView;
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


public class MainMenuViewTest {


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
    public void loggedOutUserTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("x\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        MainMenuView mainMenuView = MainMenuView.getInstance();

//         Act
        mainMenuView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                UI_GLOBALS.MAIN_MENU_VIEW_HEADER + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.MAIN_MENU_LOGGED_OUT_USER_MESSAGE + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK +
                UI_TEST_GLOBALS.LOGGED_OUT_USER_NAVIGATION_BAR +
                UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.MAIN_MENU_VIEW_REQUEST_INPUT_MESSAGE + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [x]." + UI_GLOBALS.LINE_BREAK +
                UI_GLOBALS.LINE_BREAK
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void loggedIntUserTest() {
//         Arrange
        System.setIn(new ByteArrayInputStream("x\n".getBytes()));
        IOHandler iOHandler = new IOHandler();
        MainMenuView mainMenuView = MainMenuView.getInstance();
        Session.setLoggedInUser(new User("123-4567", "password1"));

//         Act
        mainMenuView.enter(iOHandler);

//        Assert
        String actualOutput = outContent.toString();
        String expectedOutput =
                UI_GLOBALS.MAIN_MENU_VIEW_HEADER +UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.MAIN_MENU_LIBRARY_NAME + "123-4567" + UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.MAIN_MENU_PASSWORD + "password1" + UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.LINE_BREAK +
                        UI_TEST_GLOBALS.LOGGED_IN_USER_NAVIGATION_BAR_STRING +
                        UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.MAIN_MENU_VIEW_REQUEST_INPUT_MESSAGE + UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.YOU_SELECTED_MESSAGE_PART + " [x]." + UI_GLOBALS.LINE_BREAK +
                        UI_GLOBALS.LINE_BREAK
                ;
        Assert.assertThat(actualOutput, is(expectedOutput));
    }
}
