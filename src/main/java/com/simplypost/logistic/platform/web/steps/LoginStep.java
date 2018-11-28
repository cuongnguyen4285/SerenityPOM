package com.simplypost.logistic.platform.web.steps;

import com.simplypost.logistic.platform.web.pages.LoginPage;
import com.simplypost.logistic.utilities.SerenityUtil;
import net.thucydides.core.annotations.Step;

public class LoginStep {

    LoginPage loginPage;

    @Step("Login with userName {0} and password {1}")
    public LoginStep login(String userName, String password){
        loginPage.openAt(SerenityUtil.getBaseUrl());
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        loginPage.waitForAjaxLoading();
        return this;
    }



}
