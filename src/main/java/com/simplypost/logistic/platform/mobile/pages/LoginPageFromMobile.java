package com.simplypost.logistic.platform.mobile.pages;

import com.simplypost.logistic.pageObject.PageObjects;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.*;

public class LoginPageFromMobile extends PageObjects {

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@label='Log In']")
    WebElement userNameTextbox;

    @iOSFindBy(xpath="com.flipkart.android:id/et_password")
    WebElement passWordTextbox;

    @iOSFindBy(xpath="com.flipkart.android:id/btn_mlogin")
    WebElement loginButton;

    public void typeUserName(String userName){
        typeInto(userNameTextbox, userName);
    }

    public void typePassword(String passWord){
        typeInto(passWordTextbox, passWord);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }

}
