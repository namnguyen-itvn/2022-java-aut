package com.example.tests;


import com.example.core.configuration.Configuration;
import com.example.core.configuration.drivers.Chrome;
import com.example.core.driver.DriverFactory;
import com.example.core.keyword.WebKeyword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static WebDriver driver;
    public WebKeyword keyword;
    public Configuration config;
    public WebDriverWait wait;

    /**
     * Method get driver to use for add screen shot method in ExtentTestManager class
     * @return: driver
     */
    public static WebDriver getDriver(){
        if(driver == null){
            driver = new Chrome().createDriver();
            return driver;
        }
        return driver;
    }

    @BeforeMethod
    public void setUp() throws Exception {                
        try {            
            config = new Configuration("src/test/java/com/example/core/configuration/config.properties");
            driver = DriverFactory.getDriver(config.getProperty("browser"));
            keyword = new WebKeyword(driver);            
            keyword.openUrl(config.getProperty("url"));
            int implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            this.wait = new WebDriverWait(driver, implicitWait);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
