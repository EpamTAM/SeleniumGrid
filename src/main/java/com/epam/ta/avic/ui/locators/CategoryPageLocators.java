package com.epam.ta.avic.ui.locators;

import org.openqa.selenium.By;

public enum CategoryPageLocators implements BaseLocator{
    CATEGORY_TITLE (By.xpath("//h1[@class='page-title']"));

    private final By path;
    CategoryPageLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
