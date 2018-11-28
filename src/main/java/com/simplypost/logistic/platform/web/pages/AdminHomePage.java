package com.simplypost.logistic.platform.web.pages;

import com.simplypost.logistic.pageObject.PageObjects;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class AdminHomePage extends PageObjects {

    @FindBy(xpath = "//img[@class='logo-default']")
    WebElementFacade logoIcon;
    @FindBy(xpath = "//li[contains(@class,'dropdown-user')]/a")
    WebElementFacade userProfileLink;
    @FindBy(xpath = "//a[@ng-click='$ctrl.logout()']")
    WebElementFacade logOutLink;


    public boolean isLogoPresent(){
        return isElementPresent(logoIcon);
    }

    public void logOut() {
        clickOn(userProfileLink);
        clickOn(logOutLink);
    }

}
