package com.simplypost.logistic.platform.web.steps;

import com.simplypost.logistic.platform.web.pages.AdminHomePage;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.MatcherAssert.assertThat;

public class LogoutStep {

    AdminHomePage adminHomePage;

    @Step("Logout Admin Home page")
    public LogoutStep logout(){
        adminHomePage.logOut();
        return this;
    }

    @Step("Clear browser")
    public LogoutStep clearBrowser(){
        adminHomePage.closeBrowser();
        return this;
    }
}
