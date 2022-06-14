package com.example.core.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class WebKeyword {

    private WebDriver driver;
    private WebDriverWait wait;
    private int timeout = 10;

    public WebKeyword(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }

    /**
     * Method to check the url then opening the url
     * 
     * @param url website to open
     * @throws Exception Exception
     */
    public void openUrl(String url) throws Exception {
        if (!(url.startsWith("http://") || url.startsWith("https://"))) {
            throw new Exception("Invalid URL format");
        }
        driver.get(url);
    }

    /**
     * Wait to element visible
     * 
     * @param locator element locator
     * @return element to be located
     */
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Clear text before setting text
     * 
     * @param element element to set text
     * @param text value to set to element
     */
    public void setText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (WebDriverException e) {
            throw new WebDriverException("Element is not enable to set text");
        }
    }

    /**
     * Scroll to the element before execute clicking.
     * 
     * @param element
     */
    public void click(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    /**
     * Method to select value by option of select tag element
     * @param element: element to select value
     * @param option: option to select
     * @param value: value to set to element
     * @return: keyword to select by option for element
     */
    public WebKeyword selectValueByOption(WebElement element, String option, String value){
        Select ddlElement = new Select(element);
        switch (option){
            case "selectByValue":
                ddlElement.selectByValue(value);
                break;
            case "selectByIndex":
                ddlElement.selectByIndex(Integer.parseInt(value));
                break;
            case "selectByVisibleText":
                ddlElement.selectByVisibleText(value);
                break;
        }
        return new WebKeyword(driver);
    }

}
