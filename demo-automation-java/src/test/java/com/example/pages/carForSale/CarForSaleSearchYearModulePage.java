package com.example.pages.carForSale;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    public boolean isTheYearFilterShouldBeDisplayedCorrectWhenUserScrollToIt(){
        if (isElementDisplayed(lblYear) && isElementDisplayed(ddlMinimumYear) && isElementDisplayed(ddlMaximumYear)){
            return true;
        }else return false;
    }

    /**
     * Method verify that the list years should be showed when user click on Minimum year combobox in search year module
     * @return true or false
     */
    public boolean isMiniMumYearListShowedWhenUserClickOnMiniMumYearCombobox(){
        keyword.click(ddlMinimumYear);
        List<WebElement> listMinimumYear = driver.findElements(By.id("614960940"));
        
        if (listMinimumYear.size() >0){
            return true;
        }
        return false;        
    }

    /**
     * Method verify that the list years should be showed when user click on Maximum year combobox in search year module
     * @return true or false
     */
    public boolean isMaximumYearListShowedWhenUserClickOnMaximumYearCombobox(){
        keyword.click(ddlMaximumYear);
        List<WebElement> listMinimumYear = driver.findElements(By.id("2152820002"));
        
        if (listMinimumYear.size() >0){
            return true;
        }
        return false;        
    }

    /**
     * Method verify that search year module should be worked correctly with year was selected
     * @param year
     * @return
     */
    public boolean isTheYearFilterShouldBeDisplayedCorrectWhenUserScrollToIt(String year){
        keyword.click(ddlMinimumYear);
        keyword.setValueForSelectElement(ddlMinimumYear, chooseTypeOfSelect.selectByValue, year);
        WebElement btnCondition = keyword.findElement(By.xpath("//div[contains(@data-cmp, 'chip')]/child::span[contains(text(), '"+year+"')]"));
        WebElement linkClearFilter = keyword.findElement(By.xpath("//span[contains(text(), 'Clear Filters')]"));
        keyword.scrollToElement(lblYourSearch);
        if (isElementEnabled(btnCondition) && isElementEnabled(linkClearFilter)){
            return true;
        }else return false;
    }

    //Declare element
    private WebElement lblYourSearch = keyword.findElement(By.xpath("//span[contains(text(), 'Your Search')]"));
    private WebElement lblYear = keyword.findElement(By.xpath("//span[contains(text(), 'Year')]"));
    private WebElement ddlMinimumYear = keyword.findElement(By.id("614960940"));
    private WebElement ddlMaximumYear = keyword.findElement(By.id("2152820002"));
}
