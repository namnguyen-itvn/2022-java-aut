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

    public CarForSalePage() {
    }

    public CarForSalePage(WebDriver driver) {
        super(driver);
    }

    WebElement txtSearch = keyword.findElement(By.xpath("//input[@type='text']"));
    WebElement btnSearch = keyword.findElement(By.xpath("//button[@type='submit']//child::span"));
    WebElement carForSales = keyword.findElement(By.xpath("//a[@label='Cars for Sale']"));
    WebElement lblTitle = keyword.findElement(By.xpath("//h1[@data-cmp='heading']"));
    WebElement iconZipcode = keyword.findElement(By.cssSelector("span[class='glyphicon glyphicon-map-marker']"));
    WebElement carList = keyword.findElement(By.xpath("//div[@data-qaid='cntnr-listings']"));
    WebElement carItem = keyword.findElement(By.xpath("(//div[@data-cmp='inventorySpotlightListing'])[1]"));
    WebElement lblCarTitle = keyword.findElement(By.xpath("(//div[@data-cmp='inventorySpotlightListing'])[1]/descendant::h2"));


    /*
     * Return Search text box displayed or not
     */
    public boolean isSearchTextBoxDisplayed() {
        return txtSearch.isDisplayed();
    }

    /*
     * Return Search Place Holder Displayed correct or not
     */
    public boolean isSearchPlaceHolderDisplayedCorrect() {
        String actualPlaceHolder = txtSearch.getAttribute("placeholder");
        String expectedPlaceHolder = "Search by Make, Model, Body Style or Keyword";
        return actualPlaceHolder.equals(expectedPlaceHolder);
    }

    /*
     * Return Search Button Displayed correct or not
     */
    public boolean isSearchButtonDisplayed() {
        return btnSearch.isDisplayed();
    }

    /*
     * Return Car For Sales BreadCrums Enabled to click or not
     */
    public boolean isCarForSalesBreadcrumbsEnabled() {
        return carForSales.isEnabled();
    }

    /*
     * Return Title Displayed correct or not
     */
    public boolean isTitleDisplayedCorrect() {
        String expectedTitle = "Cars for Sale Nationwide";
        String actualTitle = lblTitle.getText();
        return actualTitle.equals(expectedTitle);
    }

    /*
     * Return Icon Zipcode Displayed or not
     */
    public boolean isIconZipcodeDisplayed() {
        return iconZipcode.isDisplayed();
    }

    /*
     * Verify the top of the cars for sale section displayed as default
     */
    public boolean isTheTopOfTheCarForSalePageSectionDisplayedAsDefault() {
        if (isSearchTextBoxDisplayed() & isSearchPlaceHolderDisplayedCorrect() & isSearchButtonDisplayed()
                & isCarForSalesBreadcrumbsEnabled() & isTitleDisplayedCorrect() & isIconZipcodeDisplayed()) {
            return true;
        } else
            return false;
    }

    /*
     * Return value list of filter sort displayed correct or not
     */
    public void isFilterSoftValueDisplayedCorrect(){
        WebElement ddlSort = keyword.findElement(By.id("149138475"));
        Select select = new Select(ddlSort);
        List actualDropdownValues = new ArrayList();
        for (WebElement element : select.getOptions()) {
            actualDropdownValues.add(keyword.getText(element));
        }
        List expectedDropdownValues = new ArrayList();
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
            Assert.assertTrue(actualDropdownValues.get(i).equals(expectedDropdownValues.get(i)),"The actual result of filter sort doesn't match with expected result");
        }
    }

    /*
     * Return The number of car car item displayed correct as required or not
     */
    public boolean isTheNumberOfCarCardItemDisplayedCorrectAsRequired(){
        List<WebElement> carItem = carList.findElements(By.xpath("//div[@data-cmp='inventoryListing']"));
        if(carItem.size()==25){
            return true;
        }
        else return false;
    }

    /*
     * Action click car item
     */
    public void clickCarItem(){
        carItem.click();
    }

    /*
     * Return the title of car item
     */
    public String getTileOfCarItem(){
        return keyword.getText(lblCarTitle);
    }
}
