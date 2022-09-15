package com.epam.ta.avic.ui.locators;

import org.openqa.selenium.By;

public enum SignInPageLocators implements BaseLocator {
    SIGN_IN_CAPTION(By.xpath("//div[@class='page-title']"));

    private final By path;

    SignInPageLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
