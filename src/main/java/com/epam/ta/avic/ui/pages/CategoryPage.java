package com.epam.ta.avic.ui.pages;

import com.epam.ta.avic.ui.locators.CategoryPageLocators;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends BasePage{

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getCategoryTitle(){
        return driver.findElement(CategoryPageLocators.CATEGORY_TITLE.getPath()).getText();
    }
}
