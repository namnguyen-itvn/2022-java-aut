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
     *  Navigate to page
     * @param menuText
     * @return the page with driver
     */
    public void navigateToPage(String menuText) {
        switch(menuText) {
            case "Sale":
                WebElement menuCarForSale = keyword.findElement(By.xpath("//div/a[text()='Cars for Sale']"));
                keyword.click(menuCarForSale);
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

    /**
     * Check element is displayed or not
     * @param element
     * @return
     */
    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }

    /**
     * Action to close ad popup
     */
    public void actionExitAds() {
        try {
            WebElement optDiveType = keyword.findElement(By.xpath("//button[@id='fsrFocusFirst']"));
            keyword.click(optDiveType);
        } catch (Exception e) {
            try {
                WebElement optDiveType2 = keyword.findElement(
                        By.cssSelector("button.QSIWebResponsiveDialog-Layout1-SI_5d3NX5IIzg7mUmN_close-btn"));
                keyword.click(optDiveType2);
            } catch (Exception a) {
            }
        }
    }

    /**
     *
     * @param locator
     * @return Element displayed or not
     */
    public boolean isElementDisplayed(By locator) {
        return keyword.findElement(locator).isDisplayed();
    }

    /**
     * Check element is enabled or not
     * @param element
     * @return
     */
    public boolean isElementEnabled(WebElement element){
        return element.isEnabled();
    }

    /**
     * Check element text is match expected text or not
     *
     * @param element to get text
     * @param expectedText expected text
     * @return True (Match) || False (Not Match)
     */
    public boolean isElementTextEqualExpectedText(WebElement element, String expectedText){
        return keyword.getText(element).equals(expectedText);
    }

    /**
     * Get page title
     * @return
     */
    public String pageTitle() {
        return driver.getTitle();
    }

    /**
     *
     * @param locator
     * @return Element enabled or not
     */
    public boolean isElementEnabled(By locator) {
        return keyword.findElement(locator).isEnabled();
    }

    /**
     *
     * @param locator
     * @return text in element
     */
    public String getText(By locator) {
        return keyword.getText(keyword.findElement(locator));
    }
}
