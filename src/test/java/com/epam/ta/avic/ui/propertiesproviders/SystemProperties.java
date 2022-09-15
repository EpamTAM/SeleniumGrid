package com.epam.ta.avic.ui.propertiesproviders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SystemProperties {

    private FileInputStream fis;
    private Properties properties;

    public SystemProperties() {
        try {
            fis = new FileInputStream("src/test/resources/system.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseURL(){
        return properties.getProperty("baseURL");
    }

    public String getBrowser(){
        return properties.getProperty("browser");
    }

    public  String getChromeWebDriverPath(){
        return properties.getProperty("chromeWebDriverPath");
   }

   public String getFireFoxWebDriverPath(){
       return properties.getProperty("fireFoxWebDriverPath");
   }
}
