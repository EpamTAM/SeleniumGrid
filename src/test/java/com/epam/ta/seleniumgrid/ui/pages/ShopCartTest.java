package com.epam.ta.avic.ui.pages;

import com.epam.ta.avic.ui.runner.TestRunner;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static com.epam.ta.avic.ui.locators.HomePageLocators.*;
import static com.epam.ta.avic.ui.locators.SubCategoryPageLocators.*;

public class ShopCartTest extends TestRunner {

    @Test(description = "Verifies that user is able to open ShopCart")
    public void verifyThatShopCartOpens() {
        ShopCartModal shopCart = new HomePage(driver)
                .getHeader()
                .openShopCart();
        Boolean actualResult = shopCart.isDisplayed();
        softAssert.assertTrue(actualResult);
        String actualTitle = shopCart.getTitle();
        String expectedTitle = "Кошик";
        softAssert.assertEquals(actualTitle, expectedTitle);
        softAssert.assertAll();
    }

    @Test(description = "Verifies that product count in the ShopCart button changes after add goods in the ShopCart")
    public void verifyThatProductCountIncreaseAfterAddProduct() {
        HomePage homePage = new HomePage(driver);
        int expectedCount = homePage
                .getHeader()
                .getShopCartProductCount();
        SubCategoryPage subCategoryPage = homePage
                .openSubMenuItem(driver.findElement(MENU_ITEM_COMPUTERS.getPath())
                        , driver.findElement(MENU_SUBMENU_ITEM_SYSTEM_BLOCKS.getPath()));
        subCategoryPage
                .addProductShopCart(driver.findElement(SUB_CATEGORY_FIRST_PRODUCT.getPath()))
                .closeShopCart();
        expectedCount++;
        int actualCount = homePage
                .getHeader()
                .getShopCartProductCount();
        softAssert.assertEquals(actualCount, expectedCount);
        subCategoryPage.addProductShopCart(driver.findElement(SUB_CATEGORY_SECOND_PRODUCT.getPath()))
                .closeShopCart();
        expectedCount++;
        actualCount = homePage
                .getHeader()
                .getShopCartProductCount();
        softAssert.assertEquals(actualCount, expectedCount);
        subCategoryPage.addProductShopCart(driver.findElement(SUB_CATEGORY_THIRD_PRODUCT.getPath()))
                .closeShopCart();
        expectedCount++;
        actualCount = homePage
                .getHeader()
                .getShopCartProductCount();
        softAssert.assertEquals(actualCount, expectedCount);
    }

    @Test(description = "Verifies that user is able to remove products from ShopCart")
    public void verifyRemoveProductFromShopCart() {
        HomePage homePage = new HomePage(driver);
        Header header = homePage.getHeader();
        int countProduct = header.getShopCartProductCount();
        for (int i = 1; i <= countProduct; i++) {
            header.openShopCart()
                    .removeFirstProduct();
            homePage.closePopUpIfVisible();
            softAssert.assertEquals(header.getShopCartProductCount(), --countProduct);
        }
        softAssert.assertAll();
    }

    @Test(description = "Verifies that user is able to increase amount selected product and total sum is correct")
    public void verifyThatProductAmountIncreasesAndTotalSumIsCorrect() {
        HomePage homePage = new HomePage(driver);
        ShopCartModal shopCartModal = homePage.openSubMenuItem(MENU_ITEM_COMPUTERS.getPath()
                        , MENU_SUBMENU_ITEM_SYSTEM_BLOCKS.getPath())
                .addProductShopCart(SUB_CATEGORY_SECOND_PRODUCT.getPath());

        BigDecimal productItemPrice = shopCartModal.getProductItemPrice(1);
        BigDecimal productsTotalPrice = shopCartModal.getTotalProductsPrice();

        softAssert.assertEquals(productItemPrice, productsTotalPrice);

        int expectedProductAmount = shopCartModal.getProductAmount(1);
        shopCartModal.increaseProductAmount(1);
        int ActualProductAmount = shopCartModal.getProductAmount(1);
        softAssert.assertEquals(ActualProductAmount, ++expectedProductAmount);
        shopCartModal.removeFirstProduct();
        softAssert.assertAll();
    }
}
