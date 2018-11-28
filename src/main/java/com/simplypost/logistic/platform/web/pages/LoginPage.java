package com.simplypost.logistic.platform.web.pages;


import com.simplypost.logistic.pageObject.PageObjects;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

/** Owner: Cuong Nguyen
 * Created Date: 24-11-2018
 * Updated by:
 */
public class LoginPage extends PageObjects {

    @FindBy(xpath = "//input[@ng-model='email']")
    WebElementFacade usernameTextbox;
    @FindBy(xpath = "//input[@ng-model='password']")
    WebElementFacade passwordTextbox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElementFacade loginButton;
    @FindBy(xpath = "//div[contains(@class,'alert')]")
    WebElementFacade errorMessage;

    public void enterUsername(String username) {
        waitForElementDisplay(usernameTextbox);
        typeInto(usernameTextbox, username);
    }

    public void enterPassword(String password) {
        waitFor(passwordTextbox).waitUntilVisible();
        typeInto(passwordTextbox, password);
    }

    public void clickLogin() {
        clickOn(loginButton);
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

}
