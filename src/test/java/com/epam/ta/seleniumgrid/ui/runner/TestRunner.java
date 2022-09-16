package com.epam.ta.avic.ui.runner;

import com.epam.ta.avic.ui.propertiesproviders.SystemProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestRunner {
    protected static WebDriver driver;
    private SystemProperties systemProperties = new SystemProperties();
    protected SoftAssert softAssert;

    @BeforeClass
    public void getDriver() {
        switch (systemProperties.getBrowser()) {
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", systemProperties.getChromeWebDriverPath());
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox":{
                System.setProperty("webdriver.gecko.driver", systemProperties.getFireFoxWebDriverPath());
                driver = new FirefoxDriver();
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid browser");
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(120l, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void quiteDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    public void setUp() {
        driver.get(systemProperties.getBaseURL());
    }
}
