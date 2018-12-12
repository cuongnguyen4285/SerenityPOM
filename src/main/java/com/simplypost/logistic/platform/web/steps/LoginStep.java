package com.simplypost.logistic.platform.web.steps;

import com.simplypost.logistic.platform.web.pages.AdminHomePage;
import com.simplypost.logistic.platform.web.pages.LoginPage;
import com.simplypost.logistic.utilities.AssertUtil;
import com.simplypost.logistic.utilities.SerenityUtil;
import net.thucydides.core.annotations.Step;

public class LoginStep {

    LoginPage loginPage;
    AdminHomePage adminHomePage;

    @Step("Login with userName {0} and password {1}")
    public LoginStep login(String userName, String password){
        loginPage.openAt(SerenityUtil.getBaseUrl());
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        loginPage.waitForAjaxLoading();
        return this;
    }

    @Step("Should see Simplypost Logo on Admin Home page")
    public LoginStep shouldSeeSimplypostLogoOnAdminHomePage(){
        AssertUtil.assertThatEqual(true, adminHomePage.isLogoPresent());
        return this;
    }


}
