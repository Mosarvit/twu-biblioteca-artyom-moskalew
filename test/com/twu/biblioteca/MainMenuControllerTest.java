package com.twu.biblioteca;

import com.twu.biblioteca.controllers.MainMenuController;
import com.twu.biblioteca.views.MainMenuView;
import com.twu.biblioteca.views.View;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.hamcrest.core.Is.is;

public class MainMenuControllerTest {
    @Test
    public void startWrongOptionChosen2Test() throws AWTException {
//         Arrange
        MainMenuController mainMenuController = new MainMenuController(MainMenuView.getInstance());

//         Act
        String actualOutput = mainMenuController.processUserInput("abc");
        View actualView = mainMenuController.getNextView();

//        Assert
        String expectedOutput = "This is not a valid menu option. Please try again.\n";
        View expectedView = MainMenuView.getInstance();
        Assert.assertThat(actualOutput, is(expectedOutput));
        Assert.assertThat(actualView, is(expectedView));
    }
}
