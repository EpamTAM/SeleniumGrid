package com.epam.ta.avic.ui.pages;


import org.openqa.selenium.WebDriver;


public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

}
