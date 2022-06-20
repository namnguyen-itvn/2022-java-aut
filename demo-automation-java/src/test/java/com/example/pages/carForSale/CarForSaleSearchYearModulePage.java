package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.core.keyword.WebKeyword.chooseTypeOfSelect;
import com.example.pages.BasePage;

public class CarForSaleSearchYearModulePage extends BasePage{

    public CarForSaleSearchYearModulePage(WebDriver driver) {
        super(driver);
    }

    //Action
    
    /**
     * Method verify that search year module should be displayed is correct
     * @return true or false
     */
    public boolean isTheYearFilterShouldBeDisplayedCorrectAsReqirementWhenUserScrollToIt(){
        keyword.click(linkNotNow);
        keyword.scrollToElement(lblYear);
        if (isElementDisplayed(lblYear) == true && 
            isElementDisplayed(ddlMinimumYear) == true && 
            isElementDisplayed(ddlMaximumYear) == true){
            return true;
        }else return false;
    }

    /**
     * Method verify that the list years should be showed when user click on Minimum year combobox in search year module
     * @return true or false
     */
    public boolean isMiniMumYearListShowedWhenUserClickOnMiniMumYearCombobox(String years){
        keyword.click(linkNotNow);
        keyword.scrollToElement(lblYear);
        keyword.click(ddlMinimumYear);
        Select ddlMinimumYears = new Select(ddlMinimumYear);
        boolean check = false;
        for (WebElement year : ddlMinimumYears.getOptions()){
            if (years.contains(keyword.getText(year))){
                check = true;
            }else check = false;
        }
        return check;
    }

    /**
     * Method verify that the list years should be showed when user click on Maximum year combobox in search year module
     * @return true or false
     */
    public boolean isMaximumYearListShowedWhenUserClickOnMaximumYearCombobox(String years){
        keyword.click(linkNotNow);
        keyword.scrollToElement(lblYear);
        keyword.click(ddlMaximumYear);
        Select ddlMaximunYears = new Select(ddlMaximumYear);
        boolean check = false;
        for (WebElement year : ddlMaximunYears.getOptions()){
            if (years.contains(keyword.getText(year))){
                check = true;
            }else check = false;
        }
        return check;      
    }

    /**
     * Method verify that search year module should be worked correctly with year was selected
     * @param year
     * @return
     */
    public boolean isTheYearFilterShouldBeDisplayedCorrectWhenUserScrollToIt(String year){
        keyword.click(linkNotNow);
        keyword.scrollToElement(lblYear);
        keyword.click(ddlMinimumYear);
        keyword.setValueForSelectElement(ddlMinimumYear, chooseTypeOfSelect.selectByValue, year);
        WebElement btnCondition = keyword.findElementByLocator(By.xpath("//div[contains(@data-cmp, 'chip')]/child::span[contains(text(), '"+year+"')]"));
        WebElement linkClearFilter = keyword.findElementByLocator(By.xpath("//span[contains(text(), 'Clear Filters')]"));
        keyword.scrollToElement(lblYourSearch);
        if (isElementEnabled(btnCondition) == true && 
            isElementEnabled(linkClearFilter) == true){
            return true;
        }else return false;
    }

    /**
     * Method for verify that the Year Selected should be Display In The Message On Vehicle Details Page
     * @param year
     * @return
     */
    public boolean isYearSelectedDisplayInTheTitleOfCarOnVehicleDetailsPage(String year){
        keyword.click(linkNotNow);
        keyword.scrollToElement(lblYear);
        keyword.click(ddlMinimumYear);
        keyword.setValueForSelectElement(ddlMinimumYear, chooseTypeOfSelect.selectByValue, year);
        keyword.click(ddlMaximumYear);
        keyword.setValueForSelectElement(ddlMaximumYear, chooseTypeOfSelect.selectByValue, year);
        WebElement itemCar = keyword.waiForLocatorOfElementVisiable(By.xpath("(//div[@data-cmp='inventorySpotlightListing'])[last()]/descendant::h2[contains(text(), '"+year+"')]/ancestor::div[@data-cmp = 'delayedImpressionWaypoint']"));
        keyword.scrollToElement(itemCar);        
        keyword.click(itemCar);
        WebElement lblHeadingOfCar = keyword.waiForLocatorOfElementVisiable(By.xpath("//h1[@data-cmp='heading' and contains(text(), '"+year+"')]"));
        if (keyword.getTextElenment(lblHeadingOfCar).contains(year)){
            return true;
        }else return false;
    }

    //Declare element
    private WebElement linkNotNow = keyword.findElement(By.xpath("//div[@class='popover-content']//div//button[@class='btn btn-link']"));
    private WebElement lblYourSearch = keyword.findElementByLocator(By.xpath("//span[contains(text(), 'Your Search')]"));
    private WebElement lblYear = keyword.findElementByLocator(By.xpath("//span[contains(text(), 'Year')]"));
    private WebElement ddlMinimumYear = keyword.findElementByLocator(By.id("614960940"));
    private WebElement ddlMaximumYear = keyword.findElementByLocator(By.id("2152820002"));
}
