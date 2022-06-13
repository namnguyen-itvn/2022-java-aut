package com.example.tests;

import java.util.concurrent.TimeUnit;

import com.example.core.configuration.Configuration;
import com.example.core.driver.DriverFactory;
import com.example.core.keyword.WebKeyword;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver driver;
    public WebKeyword keyword;
    public Configuration config;

    @BeforeMethod
    public void setUp() throws Exception {
        config = new Configuration("src/test/java/com/example/core/configuration/config.properties");
        driver = DriverFactory.getDriver(config.getProperty("browser"));
        keyword = new WebKeyword(driver);
        driver.manage().window().maximize();
        keyword.openUrl(config.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
