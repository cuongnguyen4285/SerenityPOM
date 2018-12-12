package com.simplypost.logistic.features.web.adminPortal.login;

import com.simplypost.logistic.platform.web.steps.LogoutStep;
import com.simplypost.logistic.platform.web.steps.LoginStep;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.simplypost.logistic.constants.TestAccounts;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

@Narrative(text = {"As Ops, I want to login with Ops account"})

@WithTags({
        @WithTag(type = "Feature", name = "Login"),
        @WithTag(type = "Web", name = "Regression"),
        @WithTag(type = "Web_Priority", name = "P2")

})
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginFeatures {

    @Managed(uniqueSession = true)
    WebDriver webBrowser;

    @Steps
    LoginStep loginStep;
    @Steps
    LogoutStep logoutStep;

    @Before
    public void beforeTest(){
    }

    @Title("Verify Ops can login with Ops account successfully")
    @Issue("POS-1001")
    @Test
    public void verifyOpsCanLoginWithOpsAccountSuccessfully(){
        loginStep.login(TestAccounts.ADMIN_USERNAME, TestAccounts.PASSWORD);
        loginStep.shouldSeeSimplypostLogoOnAdminHomePage();
        logoutStep.logout();
    }

    @After
    public void afterTest(){
       logoutStep.clearBrowser();
    }

}
