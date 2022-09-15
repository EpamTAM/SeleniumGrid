package com.epam.ta.avic.ui.pages;

import org.openqa.selenium.WebDriver;

import static com.epam.ta.avic.ui.locators.SignInPageLocators.*;

public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public String getPageCaption() {
        return driver.findElement(SIGN_IN_CAPTION.getPath()).getText();
    }
}
