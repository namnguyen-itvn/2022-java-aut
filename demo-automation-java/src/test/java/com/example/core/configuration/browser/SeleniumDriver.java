package com.example.core.configuration.browser;

import org.openqa.selenium.WebDriver;

public interface SeleniumDriver {
    WebDriver createDriver();
    public void setDriverOptions(Object options);
    public void setCapabilities(Object capabilities);
}
