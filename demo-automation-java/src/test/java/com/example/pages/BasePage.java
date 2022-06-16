package com.example.pages;

import com.example.core.keyword.WebKeyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebKeyword keyword;
    public WebDriverWait wait;

    public BasePage() {};

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

    /**
     * Check element is displayed or not
     * @param element
     * @return
     */
    public boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
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

}