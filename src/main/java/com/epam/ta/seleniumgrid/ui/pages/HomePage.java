package com.epam.ta.avic.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.ta.avic.ui.locators.HomePageLocators.*;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super (driver);
        closePopUpIfVisible();
   }

    public HomePage closePopUpIfVisible() {
        try {
            new WebDriverWait(driver, 20L)
                    .until(ExpectedConditions.elementToBeClickable((POP_UP_CLOSE_BUTTON.getPath())));
            driver.findElement(POP_UP_CLOSE_BUTTON.getPath()).click();
        } catch (TimeoutException e) {
        }

        return this;
    }

    public Header getHeader(){
        return new Header(driver);
    }

    public CategoryPage openMenuItem(WebElement webElement) {
        webElement.click();
        return new CategoryPage(driver);
    }

    public SubCategoryPage openSubMenuItem(WebElement parent, WebElement webElement) {
        Actions moveMouse = new Actions(driver);
        moveMouse.moveToElement(parent)
                .build().perform();

        webElement.click();
        return new SubCategoryPage(driver);
    }

    public SubCategoryPage openSubMenuItem(By parent, By webElement) {
        Actions moveMouse = new Actions(driver);
        moveMouse.moveToElement(driver.findElement(parent))
                .build().perform();
        new WebDriverWait(driver, 60L )
                .until(ExpectedConditions.elementToBeClickable(webElement));
        driver.findElement(webElement).click();
        return new SubCategoryPage(driver);
    }
}
