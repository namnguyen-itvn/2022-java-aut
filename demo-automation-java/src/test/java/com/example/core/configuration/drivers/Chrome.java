package com.example.core.configuration.drivers;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.example.core.configuration.browser.SeleniumDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome implements SeleniumDriver{

    private ChromeOptions options;
    private DesiredCapabilities capabilities;

    private ChromeOptions getOptions(){
        if(options == null){
            options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addExtensions(new File("src/test/java/com/example/core/configuration/browser/adblock_1_42_4_0_chrome.crx"));
            options.merge(capabilities);
        }
        return options;
    }

    private DesiredCapabilities getCapabilities(){
        if(capabilities == null){
            capabilities = DesiredCapabilities.chrome();
            capabilities.setAcceptInsecureCerts(true);
            capabilities.setJavascriptEnabled(true);
        }
        return capabilities;
    }

    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(getOptions().merge(getCapabilities()));
    }

    @Override
    public void setDriverOptions(Object options) {
        this.options = (ChromeOptions) options;
    }

    @Override
    public void setCapabilities(Object capabilities) {
        this.capabilities = (DesiredCapabilities) capabilities;
    }
}
