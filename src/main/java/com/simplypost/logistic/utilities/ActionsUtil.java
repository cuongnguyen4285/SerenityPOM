package com.simplypost.logistic.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class ActionsUtil {

    public static void drawCanvas(WebElement webElement) {
        int height = webElement.getSize().getHeight();
        int width = webElement.getSize().getWidth();
        int offSetY = height / 10;
        int offSetX = width / 10;

        Actions actionBuilder = new Actions(getDriver());
        Action drawOnCanvas = actionBuilder
                .moveToElement(webElement, offSetX * 5, offSetY * 5).clickAndHold()
                .moveByOffset(-offSetX * 3, 0)
                .moveByOffset(0, offSetY * 3)
                .moveByOffset(offSetX * 3, 0)
                .release(webElement)
                .build();
        drawOnCanvas.perform();
    }

    public static void dragAndDrop(WebElement dragable, int dropableOffsetX, int dropableOffsetY) {
        Actions actionBuilder = new Actions(getDriver());
        Action dragAndDrop = actionBuilder.clickAndHold(dragable)
                .moveByOffset(dropableOffsetX, dropableOffsetY)
                .release().build();
        dragAndDrop.perform();

    }

    public static void dragAndDrop(WebElement dragable, WebElement dropable) {
        Actions builder = new Actions(getDriver());
        Action dragAndDrop = builder.clickAndHold(dragable)
                .moveToElement(dropable)
                .release(dropable)
                .build();
        dragAndDrop.perform();
    }

}
