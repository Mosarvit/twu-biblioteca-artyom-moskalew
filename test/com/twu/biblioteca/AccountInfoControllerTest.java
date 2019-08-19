package com.twu.biblioteca;

import com.twu.biblioteca.controllers.AccountInfoController;
import com.twu.biblioteca.views.AccountInfoView;
import com.twu.biblioteca.views.UI_GLOBALS;
import com.twu.biblioteca.views.View;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.hamcrest.core.Is.is;

public class AccountInfoControllerTest {
    @Test
    public void startWrongOptionChosen2Test() throws AWTException {
//         Arrange
        AccountInfoController accountInfoController = new AccountInfoController(AccountInfoView.getInstance());

//         Act
        String actualOutput = accountInfoController.processUserInput("abc");
        View actualView = accountInfoController.getNextView();

//        Assert
        String expectedOutput = UI_GLOBALS.ACCOUNT_INFO_INVALID_USER_INPUT_MESSAGE;
        View expectedView = AccountInfoView.getInstance();
        Assert.assertThat(actualOutput, is(expectedOutput));
        Assert.assertThat(actualView, is(expectedView));
    }
}
