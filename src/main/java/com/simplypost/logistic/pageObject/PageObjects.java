package com.simplypost.logistic.pageObject;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PageObjects extends PageObject{

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: scroll to element when it is not on screen
     * @param webElementFacade
     */
    public void scrollIntoView(WebElementFacade webElementFacade) {
        if(webElementFacade != null){
            scrollIntoView(webElementFacade.getWrappedElement());
        }
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: scroll to element when it is not on screen
     * @param webElement
     */
    public void scrollIntoView(WebElement webElement) {
        if(webElement != null){
            evaluateJavascript("arguments[0].scrollIntoView(true);", webElement);
        }
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: set value to element
     * @param webElementFacade
     * @param value
     */
    public void setAttributeValue(WebElementFacade webElementFacade, String value) {
        evaluateJavascript("arguments[0].value=arguments[1];",
                webElementFacade.getWrappedElement(), value);
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: click on element
     * @param webElement
     */
    @Override
    public void clickOn(WebElement webElement) {
        if(webElement != null){
            if (!webElement.isDisplayed()) {
                scrollIntoView(webElement);
            }
            waitABit(1);
            waitFor(webElement).waitUntilClickable();
            super.clickOn(webElement);
        }
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: click on element
     * @param webElement
     * @param value
     */
    @Override
    public void typeInto(WebElement webElement, String value) {
        if (value != null){
            if (!webElement.isDisplayed()) {
                scrollIntoView(webElement);
            }
            waitFor(webElement).waitUntilVisible();
            webElement.clear();
            super.typeInto(webElement, value);
        }
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: get text of element
     * @param webElement
     */
    public String getText(WebElement webElement) {
        if ($(webElement).isCurrentlyVisible()) {
            return webElement.getText();
        } else {
            return webElement.getAttribute("textContent").replaceAll("\\s+", " ").trim();
        }
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: get text of element
     * @param webElement
     */
    public String getText(String webElement) {
        if (webElement == null) {
            return "";
        }
        return getText((WebElement) find(By.xpath(webElement)));
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: select item by text from dropdown list
     * @param webElement
     *  @param text
     */
    public void selectItemByText(WebElementFacade webElement, String text) {
        if(text != null){
            if (!webElement.isDisplayed()) {
                scrollIntoView(webElement);
            }
            waitFor(webElement).waitUntilClickable();
            Select select = new Select(webElement);
            select.selectByVisibleText(text);
        }
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: select item by index from dropdown list
     * @param webElement
     *  @param index
     */
    public void selectItemByIndex(WebElementFacade webElement, int index) {
        waitFor(webElement).waitUntilVisible();
        Select select = new Select(webElement);
        select.selectByIndex(index);
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: select item by value from dropdown list
     * @param webElement
     *  @param value
     */
    public void selectItemByValue(WebElementFacade webElement, String value) {
        if (value != null){
            waitFor(webElement).waitUntilVisible();
            Select select = new Select(webElement);
            select.selectByValue(value);
        }
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: hover on link or element
     * @param webElement
     */
    public void hoverOnLink(WebElement webElement) {
        if(webElement != null) {
            waitFor(ExpectedConditions.visibilityOf(webElement));
            Actions actions = new Actions(getDriver());
            actions.moveToElement(webElement).build().perform();
        }
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: hover on links and or elements
     * @param webElementList
     */
    public void hoverOnMutipleLinks(WebElement... webElementList) {
        Actions actions = new Actions(getDriver());
        for (WebElement element : webElementList) {
            waitABit(1);
            waitFor(element).waitUntilVisible();
            actions.moveToElement(element)
                    .build().perform();
            waitABit(1);
        }
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: check if element presents on web page
     * @param webElement
     */
    public boolean isElementPresent(WebElement webElement){
        boolean isPresent = false;
        if(webElement.isDisplayed()){
            isPresent = true;
        }
        return isPresent;
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: check if element doesn't present on web page
     * @param webElement
     */
    public boolean isElementNotPresent(WebElement webElement){
        boolean isNotPresent = false;
        if(!webElement.isDisplayed()){
            isNotPresent = true;
        }
        return isNotPresent;
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: check if element doesn't present on web page
     * @param webElement
     */
    public boolean isElementNotPresent(String webElement){
        boolean isNotPresent = false;
        if(findAll(webElement).size() <= 0){
            isNotPresent = true;
        }
        return isNotPresent;
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: wait for fixed time
     * @param timeInSecond
     */
    @Override
    public void waitABit(long timeInSecond) {
        super.waitABit(timeInSecond * 1000);
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: close web browser
     */
    public void closeBrowser() {
        getDriver().manage().deleteAllCookies();
        getDriver().quit();
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: close current tab
     */
    public void closeCurrentTab() {
        getDriver().close();
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: wait for element displays
     * @param webElement
     */
    public void waitForElementDisplay(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: wait for element disappears
     * @param webElement
     */
    public void waitForElementDisappear(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: wait for ajax loading disappears
     */
    public void waitForAjaxLoading(){
        String loadingIcon = "//span[contains(text(),'Loading')]";
        waitABit(1);
        int i = 0;
        while(isElementPresent(findBy(loadingIcon)) && i < 60){
            waitABit(1);
            i++;
        }

    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: wait for page loading complete
     */
    public boolean waitForPageLoadComplete(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)getDriver()).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)getDriver()).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: wait for url loads complete
     */
    public void waitForURLLoading(){
        String url = getCurrentURL();

        waitABit(1);
        int i = 0;
        while(url.equalsIgnoreCase("about:blank") && i < 60){
            waitABit(1);
            url = getCurrentURL();
            i++;
        }

    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: switch tab by index
     * @param index
     */
    public void switchToTab(int index){
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(index));
        waitABit(1);
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: get title of page
     */
    public String getCurrrentTitle(){
        return getDriver().getTitle();
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: get url of page
     */
    public String getCurrentURL(){
        return getDriver().getCurrentUrl();
    }

    public void handleAlertPopup(String alertName){
        String window = getDriver().getWindowHandle();
        ((JavascriptExecutor) getDriver()).executeScript("alert('" + alertName + "')");
        getDriver().switchTo().alert().accept();
        getDriver().switchTo().window(window);
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: focus current browser
     */
    public void focusBrowser(){
        String currentWindow = getDriver().getWindowHandle();
        getDriver().switchTo().window(currentWindow);
        //((JavascriptExecutor) getDriver()).executeScript("window.focus();");
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: get current directory of project
     */
    public String getCurrerntDirectory(){
        return System.getProperty("user.dir");
    }

    /** Owner: Cuong Nguyen
     * Update by:
     * Created Date: 22-11-2018
     * Description: use key events
     * @param  keyValue
     */
    public void keyEvents(String keyValue){
        Actions action = new Actions(getDriver());
        action.sendKeys(keyValue).build().perform();
    }

}
