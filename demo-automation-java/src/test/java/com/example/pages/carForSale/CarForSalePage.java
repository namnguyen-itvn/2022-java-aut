package com.example.pages.carForSale;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.example.pages.BasePage;

public class CarForSalePage extends BasePage {

    public CarForSalePage(WebDriver driver) {
        super(driver);
    }

    private By txtSearch = By.xpath("//input[@type='text']");
    private By btnSearch = By.xpath("//button[@aria-label='search-btn']");
    private By carForSales = By.xpath("//a[@label='Cars for Sale']");
    private By lblTitle = By.xpath("//h1[@data-cmp='heading']");
    private By iconZipcode = By.cssSelector("span[class='glyphicon glyphicon-map-marker']");
    private By carList = By.xpath("//div[@data-qaid='cntnr-listings']");
    private By carItem = By.xpath("(//div[@data-cmp='inventorySpotlightListing'])[1]");
    private By lblCarTitle = By.xpath("(//div[@data-cmp='inventorySpotlightListing'])[1]/descendant::h2");
    private By lblCarDistance = By.xpath(
            "(//div[@data-cmp='inventorySpotlightListing'])[1]/descendant::div[@class='row']/descendant::div[@class='text-bold']");
    private By lblCarPrice = By
            .xpath("(//div[@data-cmp='inventorySpotlightListing'])[1]/descendant::span[@class='first-price']");
    private By lblSeePayMent = By
            .xpath("(//div[@data-cmp='inventorySpotlightListing'])[1]/descendant::span[contains(text(),'See')]");
    private By imgCar = By.xpath("(//div[@data-cmp='inventorySpotlightListing'])[1]/descendant::img");
    private By ddlSort = By.id("149138475");
    private By lblAlertMessage = By
            .xpath("//div[@id='showSupplementalMessage']/preceding::div[contains(text(),'Due')]");
    private By lblSubAlertMessage = By.xpath("//div[@id='showSupplementalMessage']");
    public String expectedAlertMessage = "Due to nationwide inventory shortages, we were unable to find  matches for your search.";
    public String expectedSubAlertMessage = "Try changing your search criteria or remove filters.";

    /*
     * Return Search Place Holder Displayed correct or not
     */
    public boolean isSearchPlaceHolderDisplayedCorrect() {
        String actualPlaceHolder = keyword.findElement(txtSearch).getAttribute("placeholder");
        String expectedPlaceHolder = "Search by Make, Model, Body Style or Keyword";
        return actualPlaceHolder.equals(expectedPlaceHolder);
    }

    /*
     * Return Title Displayed correct or not
     */
    public boolean isTitleDisplayedCorrect() {
        String expectedTitle = "Cars for Sale Nationwide";
        String actualTitle = keyword.findElement(lblTitle).getText();
        return actualTitle.equals(expectedTitle);
    }

    /*
     * Verify the top of the cars for sale section displayed as default
     */
    public boolean isTheTopOfTheCarForSalePageSectionDisplayedAsDefault() {
        if (isElementDisplayed(txtSearch) & isSearchPlaceHolderDisplayedCorrect() & isElementDisplayed(btnSearch)
                & isElementEnabled(carForSales) & isTitleDisplayedCorrect() & isElementDisplayed(iconZipcode)) {
            return true;
        } else
            return false;
    }

    /*
     * Return value list of filter sort displayed correct or not
     */
    public void isFilterSortValueListDisplayedCorrect() {
        Select select = new Select(keyword.findElement(ddlSort));
        List<String> actualDropdownValues = new ArrayList<String>();
        for (WebElement element : select.getOptions()) {
            actualDropdownValues.add(keyword.getText(element));
        }
        List<String> expectedDropdownValues = new ArrayList<String>();
        expectedDropdownValues.add("Relevance");
        expectedDropdownValues.add("Price - Lowest");
        expectedDropdownValues.add("Price - Highest");
        expectedDropdownValues.add("Distance - Closest");
        expectedDropdownValues.add("Date - Oldest");
        expectedDropdownValues.add("Date - Newest");
        expectedDropdownValues.add("Mileage - Lowest");
        expectedDropdownValues.add("Mileage - Highest");
        expectedDropdownValues.add("Year - Oldest");
        expectedDropdownValues.add("Year - Newest");
        for (int i = 0; i < actualDropdownValues.size(); i++) {
            Assert.assertTrue(actualDropdownValues.get(i).equals(expectedDropdownValues.get(i)),
                    "The actual result of filter sort doesn't match with expected result");
        }
    }

    /*
     * Return The number of car car item displayed correct as required or not
     */
    public boolean isTheNumberOfCarCardItemDisplayedCorrectAsRequired() {
        List<WebElement> carItem = keyword.findElement(carList)
                .findElements(By.xpath("//div[@data-cmp='inventoryListing']"));
        if (carItem.size() == 25) {
            return true;
        } else
            return false;
    }

    /*
     * Action click car item
     */
    public void clickCarItem() {
        keyword.click(keyword.findElement(carItem));
    }

    /*
     * Return the title of car item
     */
    public String getTileOfCarItem() {
        return keyword.getText(keyword.findElement(lblCarTitle));
    }

    /**
     * 
     * @param expectedAlertMessage
     * @return Alert Message Display Correct or not
     */
    public boolean isAlertMessageDisplayCorrect(String expectedAlertMessage) {
        String actualAlertMessage = keyword.getText(keyword.findElement(lblAlertMessage));
        return actualAlertMessage.equals(expectedAlertMessage);
    }

    /**
     * 
     * @param expectedSubAlertMessage
     * @return Alert Sub Message Display Correct or not
     */
    public boolean isSubAlertMessageDisplayCorrect(String expectedSubAlertMessage) {
        String actualSubAlertMessage = keyword.getText(keyword.findElement(lblSubAlertMessage));
        return actualSubAlertMessage.equals(expectedSubAlertMessage);
    }

    /**
     * Action to press button Search
     * 
     * @throws Exception
     */
    public void searchCar(String invalidKeyWord) throws Exception {
        keyword.setText(keyword.findElement(txtSearch), invalidKeyWord);
        keyword.pressEnter(keyword.findElement(txtSearch));
    }

    /**
     * 
     * @param expectedAlertMessage
     * @param expectedSubAlertMessage
     * @return Alert Message Frame Display Correct or not
     */
    public boolean isAlertMessageFrameDisplayCorrect(String expectedAlertMessage, String expectedSubAlertMessage) {
        if (isAlertMessageDisplayCorrect(expectedAlertMessage)
                & isSubAlertMessageDisplayCorrect(expectedSubAlertMessage)) {
            return true;
        } else
            return false;
    }

    /**
     * 
     * @return Car Card Itam Display Correct or not
     */
    public boolean isCarCardItemDisplayCorrect() {
        if (isElementDisplayed(imgCar) & isElementDisplayed(lblCarTitle) & isElementDisplayed(lblCarDistance)
                & isElementDisplayed(lblCarPrice)
                & isElementDisplayed(lblSeePayMent)) {
            return true;
        } else
            return false;
    }

}
