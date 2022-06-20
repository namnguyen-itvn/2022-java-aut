package com.example.core.keyword;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class WebKeyword {

    private WebDriver driver;
    private WebDriverWait wait;
    private int timeout = 5;

    public WebKeyword(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }

    /**
     * Options for select value
     */
    public enum chooseTypeOfSelect {
        selectByValue,
        selectByVisibleText,
        selectByIndex
    }

    /**
     * set value for Element by Select
     *
     * @param webElement element to set value
     * @param type       type of select element (e.g selectByValue,
     *                   selectByVisibleText, selectByIndex)
     * @param value      value of element
     * @return WebKeyword to set value for element
     */
    public WebKeyword setValueForSelectElement(WebElement webElement, chooseTypeOfSelect type, String value) {
        Select ddlElement = new Select(waitForElementClickable(webElement));
        switch (type) {
            case selectByValue:
                ddlElement.selectByValue(value);
                break;
            case selectByVisibleText:
                ddlElement.selectByVisibleText(value);
                break;
            case selectByIndex:
                ddlElement.selectByIndex(Integer.parseInt(value));
                break;
        }
        return new WebKeyword(driver);
    }

    /**
     * Get all option in drop down list
     *
     * @param element drop down list
     * @return List of options
     */
    public List<String> getSelectOptionsList(WebElement element) {
        List<String> optionsList = new ArrayList<String>();
        for (WebElement item : new Select(element).getOptions())
            optionsList.add(item.getText());
        return optionsList;
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
     * Scroll to element and click
     * @param webElement
     * @return
     */
    public WebKeyword scrollAndClick(WebElement webElement) {
        scrollToElement(webElement);
        waitForElementToBeClickable(webElement).click();
        return new WebKeyword(driver);
    }

    /**
     * Wait to element visible
     *
     * @param locator: By.xpath or By.cssSelector...
     * @return element to be located
     */
    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Wait to element visible
     *
     * @param element: By.xpath or By.cssSelector...
     * @return element to be located
     */
    public WebElement findElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Keyword for set text to element
     *
     * @param webElement: element to set text
     * @param text:       text
     * @return: keyword to set text for element
     * @throws Exception: exception
     */
    public WebKeyword setText(WebElement webElement, String text) throws Exception {
        try {
            waitForElementVisibilities(webElement).clear();
            waitForElementVisibilities(webElement).sendKeys(text);
        } catch (Exception e) {
            throw new Exception("Element is not enable to set text");
        }
        return new WebKeyword(driver);
    }

    /**
     * Keyword for set text to element
     *
     * @param webElement: element to set text
     * @return: keyword to set text for element
     * @throws Exception: exception
     */
    public WebKeyword pressEnter(WebElement webElement) throws Exception {
        try {
            waitForElementVisibilities(webElement).sendKeys(Keys.ENTER);
        } catch (Exception e) {
            throw new Exception("Element is not enable to send key");
        }
        return new WebKeyword(driver);
    }

    /**
     * Keyword for get text of element
     *
     * @param webElement: element to get text
     * @return: keyword to get text from element
     */
    public String getText(WebElement webElement) {
        scrollToElement(webElement);
        return waitForElementVisibilities(webElement).getText();
    }

    public String getTextWithOutScroll(WebElement webElement) {
        return waitForElementVisibilities(webElement).getText();
    }

    /**
     * Keyword for click on element
     *
     * @param webElement: element to click
     * @return: keyword to click on element
     */
    public WebKeyword click(WebElement webElement) {
        waitForElementToBeClickable(webElement).click();
        return new WebKeyword(driver);
    }

    /**
     * Keyword for click on element
     *
     * @param webElement: element to click
     * @return: keyword to click on element
     */
    public WebKeyword clickWithOutScroll(WebElement webElement) {
        waitForElementVisibilities(webElement);
        waitForElementToBeClickable(webElement).click();
        return new WebKeyword(driver);
    }

    /**
     * Keyword for click on element but used by JavaScript for some situation that
     * throw Click Exception
     *
     * @param webElement: element to click
     * @return: keyword to click on element
     */
    public WebKeyword clickByJS(WebElement webElement) {
        scrollToElement(webElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
        return new WebKeyword(driver);
    }
 
    /**
     * Wait for element clickable
     *
     * @param webElement
     * @return
     */
    public WebElement waitForElementClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /*
     * wait for element visibilities in page
     */
    public WebElement waitForElementVisibilities(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * 
     * wait for element enable
     */
    public WebElement waitForElementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Keyword for scroll to element
     *
     * @param webElement: element
     * @return: keyword for scroll to element
     */
    public WebKeyword scrollToElement(WebElement webElement){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        return new WebKeyword(driver);
    }
    
    // KeyWord from NhatNM19
    /**
     * wait element display
     *
     * @param wElement
     * @return
     */
    public WebElement waitForElementIsDisplay(WebElement wElement) {
        return wait.until(ExpectedConditions.visibilityOf(wElement));
    }

    /**
     * wait elemnt able click
     *
     * @param mwElement
     * @return
     */
    public WebElement waitForElementIsClickable(WebElement mwElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(mwElement));
    }

    /**
     * check element disolay
     *
     * @param webElement
     * @return
     */
    public boolean checkDisplay(WebElement webElement) {
        return waitForElementIsDisplay(webElement).isDisplayed();
        // return waitForElementVisibilities(webElement).isDisplayed();
    }

    /**
     * check element able to click
     *
     * @param webElement
     * @return
     */
    public boolean checkClickable(WebElement webElement) {
        return waitForElementIsDisplay(webElement).isEnabled();
        // return waitForElementToBeClickable(webElement).isEnabled();
    }

    /**
     * check message correct with message expected
     *
     * @param webElement
     * @param expectedMessage
     * @return
     */
    public boolean isMessageCorrect(WebElement webElement, String expectedMessage) {
        return waitForElementIsDisplay(webElement).getText().equals(expectedMessage);
    }

    /**
     * check option diplay correct with data input
     *
     * @param webElement
     * @param dataInput
     * @return
     */
    public boolean isOptionSelectedIsCorrect(WebElement webElement, String dataInput) {
        Select select = new Select(waitForElementIsDisplay(webElement));
        System.out.println(select.getFirstSelectedOption().getText());
        return select.getFirstSelectedOption().getText().equals(dataInput);
    }

    /**
     * Get text element
     *
     * @param webElement
     * @return
     */
    public String getTextElenment(WebElement webElement) {
        return waitForElementIsDisplay(webElement).getText();
    }

    /**
     * Method for wait locator of element visiable in page of website
     * @param locator: like "By.xpath(""), By.cssSelector("")..."
     * @return: element
     */
    public WebElement waiForLocatorOfElementVisiable(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait to locator of element visible
     /**KeyWord from ChauTA1
     * Keyword to find list element
     *
     * @param locator: By.xpath or By.cssSelector...
     * @return element to be located
     */
    public WebElement findElementByLocator(By locator) {
        return driver.findElement(locator);
    }
    public List<WebElement> findElements(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
