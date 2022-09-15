package com.epam.ta.avic.ui.locators;

import org.openqa.selenium.By;

public enum HomePageLocators implements BaseLocator {

    POP_UP_CLOSE_BUTTON(By.xpath(".//div[@id ='js_popUp']//button[@title='Close']")),
    MENU_ITEM_COMPUTERS(By.xpath("//a[@href='https://avic.ua/ua/elektronika' and @class='sidebar-item']")),
    MENU_ITEM_COMPUTERS_BY_INDEX(By.xpath("(//span[@class='sidebar-item-title'])[3]")),
    MENU_SUBMENU_ITEM_MONITORS(By.xpath("//a[@href='https://avic.ua/ua/monitoryi' and @class='sidebar-item']")),
    MENU_SUBMENU_ITEM_SYSTEM_BLOCKS(By.xpath("//a[@href='https://avic.ua/ua/gotovyie-pk' and @class='sidebar-item']"));

    private final By path;

     HomePageLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
