package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;
import com.google.common.base.CaseFormat;

public class CarForSaleDoorsFilterPage extends BasePage {

    public CarForSaleDoorsFilterPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    /**
     * check Doors Filter Default Is Not Extended
     * @return boolean check
     */
    public boolean checkDoorsFilterShouldNotBeExtended() {
        boolean check = false;
        WebElement doorsFilter = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4']//span[text()='Doors']"));
        if(doorsFilter.isDisplayed()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }
    
    /**
     * check Doors Filter Should Be Extended After Click
     * @return boolean check
     */
    public boolean checkDoorsFilterShouldBeExtendedAfterClick() {
        boolean check = false;
        WebElement doorsFilterBeforeExtending = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4']//span[text()='Doors']/parent::span/parent::div"));
        if(doorsFilterBeforeExtending.isDisplayed()) {
            keyword.click(doorsFilterBeforeExtending);
            WebElement doorsFilterAfterExtending = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4 active']//span[text()='Doors']/parent::span/parent::div/following-sibling::div"));
            if(doorsFilterAfterExtending.isDisplayed()) {
                check = true;
            } else {
                check = false;
            }
        }
        return check;
    }

    /**
     * choose door option in door filter
     * @param option
     */
    public void chooseDoorsInDoorFilter(String option) {
        WebElement doorsFilterBeforeExtending = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4']//span[text()='Doors']"));
        keyword.click(doorsFilterBeforeExtending);
        switch(option) {
            case "Two Door":
                WebElement twoDoorOption = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4 active']//span[text()='Doors']/parent::span/parent::div/following-sibling::div//div[text()='Two Door']"));
                keyword.click(twoDoorOption);
                break;
            case "Three Door":
                WebElement threeDoorOption = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4 active']//span[text()='Doors']/parent::span/parent::div/following-sibling::div//div[text()='Three Door']"));
                keyword.click(threeDoorOption);
                break;
            case "Four Door":
                WebElement fourDoorOption = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4 active']//span[text()='Doors']/parent::span/parent::div/following-sibling::div//div[text()='Four Door']"));
                keyword.click(fourDoorOption);
                break;
            case "Five Door":
                WebElement fiveDoorOption = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4 active']//span[text()='Doors']/parent::span/parent::div/following-sibling::div//div[text()='Five Door']"));
                keyword.click(fiveDoorOption);
                break;
            }
    }

    /**
     * Check Doors Option Should Be Filtered After Chose
     * @return boolean check
     */
    public boolean checkDoorsOptionShouldBeFilteredAfterChose(String option) {
        boolean check = false;
        WebElement doorsFilterAfterExtending = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4 active']//span[text()='Doors']/parent::span/parent::div/following-sibling::div"));
        if(doorsFilterAfterExtending.isDisplayed()) {
            WebElement doorsOption = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4 active']//span[text()='Doors']/parent::span/parent::div/following-sibling::div//div[text()='"+option+"']"));
            keyword.click(doorsOption);
            WebElement txtYourSearchDoorsOption = keyword.findElement(By.xpath("//span[text()='"+option+"']"));
            keyword.scrollToElement(txtYourSearchDoorsOption);
            WebElement linkClearFilters = keyword.findElement(By.xpath("//span[text()='Clear Filters']"));
            keyword.scrollToElement(linkClearFilters);
            if(txtYourSearchDoorsOption.isDisplayed() && linkClearFilters.isDisplayed()) {
                    check = true;
            } else {
                    check = false;
            }                
        } else {
            check = false;
        }
        return check; 
    }         
}
