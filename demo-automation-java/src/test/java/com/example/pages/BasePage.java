package com.example.pages;

import com.example.core.configuration.Configuration;
import com.example.core.driver.DriverFactory;
import com.example.core.keyword.WebKeyword;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public Configuration config;
    public WebDriver driver;
    public WebKeyword keyword;
    public WebDriverWait wait;
    public By btnUpdateWallet = By.xpath("//span/following-sibling::div/button");

    public BasePage() {
    };

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.keyword = new WebKeyword(driver);
    }

    /**
     * Navigate to page
     * 
     * @param menuText
     * @return the page with driver
     */
    public void navigateToPage(String menuText) {

        switch (menuText) {
            case "Sale":
                WebElement menuCarForSale = keyword.findElement(By.xpath("//div/a[text()='Cars for Sale']"));
                keyword.click(menuCarForSale);
                try {
                    config = new Configuration("src/test/java/com/example/core/configuration/config.properties");
                    int implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
                    driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Reviews":
                WebElement menuCarReview = keyword.findElement(By.xpath("//div/a[text()='Car Reviews']"));
                keyword.click(menuCarReview);
                break;
            default:
                System.out.println("Invalid page");
                break;
        }

    }

    public boolean elmIsVisible(By locator) {
        return keyword.findElement(locator).isDisplayed();
    }

    public boolean elmIsClickable(By locator) {
        return keyword.findElement(locator).isEnabled();
    }

    public boolean elmIsSelected(By locator) {
        return keyword.findElement(locator).isSelected();
    }

    public void clickAction(By locator) {
        keyword.scrollToElement(keyword.findElement(locator));
        WebElement element = keyword.findElement(locator);
        keyword.click(element);
    }

    public boolean isItemCorrect(String expectedItem, By locator) {
        WebElement element = keyword.findElement(locator);
        String item = keyword.getText(element);
        return item.equals(expectedItem);
    }

}