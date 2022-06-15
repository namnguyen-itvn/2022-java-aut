package com.example.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.core.configuration.drivers.Chrome;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    
    public static WebDriver getDriver(String browser){
        switch (browser){
            case "CHROME":
                return new Chrome().createDriver();
            default:
                System.out.println("Browser " + browser + " is in valid. Use chrome instead.");
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }    
}
