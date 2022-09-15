package com.epam.ta.avic.ui.locators;

import org.openqa.selenium.By;

public enum SubCategoryPageLocators implements BaseLocator {
    SUB_CATEGORY_TITLE(By.xpath("//div[@class='page-title page-title-category']")),
    SUB_CATEGORY_PRODUCTS_LIST(By.xpath("//div[contains(@class,'item-prod')]")),
    SUB_CATEGORY_FIRST_PRODUCT(By.xpath("//div[contains(@class,'item-prod')][1]")),
    SUB_CATEGORY_SECOND_PRODUCT(By.xpath("//div[contains(@class,'item-prod')][2]")),
    SUB_CATEGORY_THIRD_PRODUCT(By.xpath("//div[contains(@class,'item-prod')][3]")),
    PRODUCT_BUY_BUTTON(By.xpath(".//a[@class='prod-cart__buy']"));

    private final By path;

    SubCategoryPageLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
