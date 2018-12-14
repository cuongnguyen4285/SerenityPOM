package com.simplypost.logistic.features.mobile;

import com.simplypost.logistic.constants.TestAccounts;
import com.simplypost.logistic.platform.mobile.steps.LoginStepsFromMobile;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class LoginFromMobileFeature {
    @Managed(uniqueSession = true)
    WebDriver webBrowser;

    @Steps
    LoginStepsFromMobile loginStepsFromMobile;

    @Before
    public void beforeTest(){
    }

    @Title("Verify Ops can login with Ops account successfully")
    @Issue("POS-1001")
    @Test
    public void verifyOpsCanLoginWithOpsAccountSuccessfully(){
        loginStepsFromMobile.login(TestAccounts.ADMIN_USERNAME, TestAccounts.PASSWORD);
    }

    @After
    public void afterTest(){
    }

}
