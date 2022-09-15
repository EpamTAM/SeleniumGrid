package com.epam.ta.avic.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.List;

import static com.epam.ta.avic.ui.locators.ShopCartModalLocators.*;

public class ShopCartModal extends BasePage {

    public ShopCartModal(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return driver.findElement(SHOP_CART_MODAL.getPath()).getAttribute("style")
                .equals("display: inline-block;");
    }

    public String getTitle() {
        return driver.findElement(SHOP_CART_MODAL_CAPTION.getPath()).getText();
    }

    public Header closeShopCart() {
        new WebDriverWait(driver, 60L)
                .until(ExpectedConditions.elementToBeClickable(SHOP_CART_MODAL_CLOSE_BUTTON.getPath()))
                .click();
        return new Header(driver);
    }

    public Header removeFirstProduct() {
        List<WebElement> productsList = driver.findElements(SHOP_CART_MODAL_PRODUCTS_LIST.getPath());
        if (productsList.size() != 0) {
            new WebDriverWait(driver, 60L)
                    .until(ExpectedConditions.presenceOfNestedElementLocatedBy(productsList.get(0), SHOP_CART_MODAL_REMOVE_PRODUCT_BUTTON.getPath()));
            WebElement removeButton = productsList.get(0).findElement(SHOP_CART_MODAL_REMOVE_PRODUCT_BUTTON.getPath());
            new WebDriverWait(driver, 60l)
                    .until(ExpectedConditions.elementToBeClickable(removeButton));
            removeButton.click();
        }
        return new Header(driver);
    }

    public BigDecimal getProductItemPrice(int productNumber) {
        new WebDriverWait(driver, 60L)
                .until(ExpectedConditions.visibilityOfElementLocated(SHOP_CART_MODAL.getPath()));
        List<WebElement> productsList = driver.findElements(SHOP_CART_MODAL_PRODUCTS_LIST.getPath());
        BigDecimal productItemPrice = BigDecimal.ZERO;
        if (productsList.size() != 0) {
            String stItemPrice = productsList.get(productNumber - 1).findElement(SHOP_CART_MODAL_PRODUCT_ITEM_PRICE.getPath()).getText();
            productItemPrice = BigDecimal.valueOf(Integer.parseInt(stItemPrice.split(" ")[0]));
        }
       return productItemPrice;
    }

    public BigDecimal getTotalProductsPrice() {
        new WebDriverWait(driver, 60L)
                .until(ExpectedConditions.visibilityOfElementLocated(SHOP_CART_MODAL.getPath()));
        String stItemPrice = driver.findElement(SHOP_CART_MODAL_TOTAL_PRODUCTS_PRICE.getPath()).getText();
        BigDecimal productItemPrice = BigDecimal.valueOf(Integer.parseInt(stItemPrice.split(" ")[0]));
        return productItemPrice;
    }

    public int getProductAmount(int productNumber) {
        new WebDriverWait(driver, 60L)
                .until(ExpectedConditions.visibilityOfElementLocated(SHOP_CART_MODAL.getPath()));
        List<WebElement> productsList = driver.findElements(SHOP_CART_MODAL_PRODUCTS_LIST.getPath());
        if (productsList.size() != 0) {
            new WebDriverWait(driver, 60l)
                    .until(ExpectedConditions.elementToBeClickable(productsList.get(productNumber - 1).findElement(SHOP_CART_MODAL_PRODUCT_AMOUNT.getPath())));
            new WebDriverWait(driver, 60l)
                    .until(ExpectedConditions.attributeToBeNotEmpty( productsList.get(productNumber - 1).findElement(SHOP_CART_MODAL_PRODUCT_AMOUNT.getPath()),"value"));
            WebElement weProductAmount = productsList.get(productNumber - 1).findElement(SHOP_CART_MODAL_PRODUCT_AMOUNT.getPath());
            String productAmount = weProductAmount.getAttribute("value");
            return Integer.parseInt(productAmount);
        }
        return 0;
    }

    public void increaseProductAmount(int productNumber){
        List<WebElement> productsList = driver.findElements(SHOP_CART_MODAL_PRODUCTS_LIST.getPath());
        if (productsList.size() != 0) {
            productsList.get(productNumber - 1).findElement(SHOP_CART_MODAL_INCREASE_PRODUCT_AMOUNT_BUTTON.getPath()).click();
        }
    }
}
