package com.simplypost.logistic.platform.ios.steps;

import com.simplypost.logistic.platform.ios.pages.LoginPageFromMobile;
import net.thucydides.core.annotations.Step;

public class LoginStepsFromMobile {

    LoginPageFromMobile loginPageFromMobile;

    @Step("Login with userName {0} and passWord {1}")
    public LoginStepsFromMobile login(String userName, String passWord){
        loginPageFromMobile.typeUserName(userName);
        loginPageFromMobile.typePassword(passWord);
        loginPageFromMobile.clickLoginButton();
        return this;
    }
}