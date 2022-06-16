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

    public BasePage() {
    }

    ;

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
     * @param byWebElement
     * @return webElement is display or not
     */
    public boolean isWebElementDisplayed(By byWebElement) {
        return keyword.findElement(byWebElement).isDisplayed();
    }
}
