package com.epam.ta.avic.ui.pages;

import com.epam.ta.avic.ui.locators.SubCategoryPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.epam.ta.avic.ui.locators.SubCategoryPageLocators.*;

public class SubCategoryPage extends BasePage{

    public SubCategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getSubCategoryTitle() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(SubCategoryPageLocators.SUB_CATEGORY_TITLE.getPath()).getText();
    }

    public ShopCartModal addProductShopCart(WebElement product) {
        if (product.findElements(PRODUCT_BUY_BUTTON.getPath()).size() != 0) {
            product.findElement(PRODUCT_BUY_BUTTON.getPath()).click();
            return new ShopCartModal(driver);
        } else {
            throw new IllegalArgumentException("Product can't be bought");
        }
    }

    public ShopCartModal addProductShopCart(By productXpath) {
        if (driver.findElement(productXpath).findElements(PRODUCT_BUY_BUTTON.getPath()).size() != 0) {
            driver.findElement(productXpath).findElement(PRODUCT_BUY_BUTTON.getPath()).click();
            return new ShopCartModal(driver);
        } else {
            throw new IllegalArgumentException("Product can't be bought");
        }
    }
}
