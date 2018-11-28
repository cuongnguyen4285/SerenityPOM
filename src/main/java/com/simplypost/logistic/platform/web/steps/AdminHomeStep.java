package com.simplypost.logistic.platform.web.steps;

import com.simplypost.logistic.platform.web.pages.AdminHomePage;
import com.simplypost.logistic.utilities.AssertUtil;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AdminHomeStep {

    AdminHomePage adminHomePage;

    @Step("Should see Simplypost Logo on Admin Home page")
    public AdminHomeStep shouldSeeSimplypostLogoOnAdminHomePage(){
        AssertUtil.assertThatEqual(true, adminHomePage.isLogoPresent());
        return this;
    }

    @Step("Logout Admin Home page")
    public AdminHomeStep logout(){
        adminHomePage.logOut();
        return this;
    }

    @Step("Clear browser")
    public AdminHomeStep clearBrowser(){
        adminHomePage.closeBrowser();
        return this;
    }
}
