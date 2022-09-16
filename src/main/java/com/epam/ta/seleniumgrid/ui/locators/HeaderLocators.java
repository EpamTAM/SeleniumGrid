package com.epam.ta.avic.ui.locators;

import org.openqa.selenium.By;

public enum HeaderLocators implements BaseLocator {

    SHOP_CART_BUTTON(By.xpath("//div[contains(@class, 'header-bottom__cart active-cart')]")),
    SIGN_IN_BUTTON(By.xpath("//div[contains(@class, 'header-bottom__login')]//div[contains(@class, 'header-bottom__right-icon')]/../..")),
    SHOP_CART_PRODUCTS_COUNT(By.xpath("//div[contains(@class, 'header-bottom__cart')]//div[@class='active-cart-item js_cart_count']"));

    private final By path;

    HeaderLocators(By path) {
        this.path = path;
    }


    @Override
    public By getPath() {
        return path;
    }
}
