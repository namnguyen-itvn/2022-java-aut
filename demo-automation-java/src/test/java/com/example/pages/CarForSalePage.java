package com.example.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class CarForSalePage extends BasePage {

    public CarForSalePage() {
    }

    public CarForSalePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchTextBoxDisplayed() {
        WebElement txtSearch = keyword.findElement(By.xpath("//input[@type='text']"));
        return txtSearch.isDisplayed();
    }

    public boolean isSearchPlaceHolderDisplayedCorrect() {
        WebElement txtSearch = keyword.findElement(By.xpath("//input[@type='text']"));
        String actualPlaceHolder = txtSearch.getAttribute("placeholder");
        String expectedPlaceHolder = "Search by Make, Model, Body Style or Keyword";
        return actualPlaceHolder.equals(expectedPlaceHolder);
    }

    public boolean isSearchButtonDisplayed() {
        WebElement btnSearch = keyword.findElement(By.xpath("//button[@type='submit']//child::span"));
        return btnSearch.isDisplayed();
    }

    public boolean isCarForSalesBreadcrumbsEnabled() {
        WebElement carForSales = keyword.findElement(By.xpath("//a[@label='Cars for Sale']"));
        return carForSales.isEnabled();
    }

    public boolean isTitleDisplayedCorrect() {
        String expectedTitle = "Cars for Sale Nationwide";
        WebElement lblTitle = keyword.findElement(By.xpath("//h1[@data-cmp='heading']"));
        String actualTitle = lblTitle.getText();
        return actualTitle.equals(expectedTitle);
    }

    public boolean isIconZipcodeDisplayed() {
        WebElement iconZipcode = keyword.findElement(By.cssSelector("span[class='glyphicon glyphicon-map-marker']"));
        return iconZipcode.isDisplayed();
    }

    public boolean isTheTopOfTheCarForSalePageSectionDisplayedAsDefault() {
        if (isSearchTextBoxDisplayed() & isSearchPlaceHolderDisplayedCorrect() & isSearchButtonDisplayed()
                & isCarForSalesBreadcrumbsEnabled() & isTitleDisplayedCorrect() & isIconZipcodeDisplayed()) {
            return true;
        } else
            return false;
    }

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

    public boolean isTheNumberOfCarCardItemDisplayedCorrectAsRequired(){
        WebElement carList = keyword.findElement(By.xpath("//div[@data-qaid='cntnr-listings']"));
        List<WebElement> carItem = carList.findElements(By.xpath("//div[@data-cmp='inventoryListing']"));
        if(carItem.size()==25){
            return true;
        }
        else return false;
    }
}
