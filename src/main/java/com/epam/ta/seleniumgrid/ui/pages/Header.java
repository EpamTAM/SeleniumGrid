package com.epam.ta.avic.ui.pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.ta.avic.ui.locators.HeaderLocators.*;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

    public SignInPage openSignInPage() {
        driver.findElement(SIGN_IN_BUTTON.getPath()).click();
        return new SignInPage(driver);
    }

    public ShopCartModal openShopCart() {
        new WebDriverWait(driver, 60L)
                .until(ExpectedConditions.presenceOfElementLocated(SHOP_CART_BUTTON.getPath()));
        new WebDriverWait(driver, 60L)
                .until(ExpectedConditions.elementToBeClickable(SHOP_CART_BUTTON.getPath()));
        driver.findElement(SHOP_CART_BUTTON.getPath()).click();

        return new ShopCartModal(driver);
    }

    public int getShopCartProductCount() {
        new WebDriverWait(driver, 50L)
                .until(ExpectedConditions.presenceOfElementLocated(SHOP_CART_PRODUCTS_COUNT.getPath()));
        new WebDriverWait(driver, 60L).
                until(new ExpectedCondition<Boolean>() {
                    @NullableDecl
                    @Override
                    public Boolean apply(@NullableDecl WebDriver webDriver) {
                        return !webDriver.findElement(SHOP_CART_PRODUCTS_COUNT.getPath()).getText().equals("");
                    }
                });

        return Integer.parseInt(driver.findElement(SHOP_CART_PRODUCTS_COUNT.getPath()).getText());
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }
}
