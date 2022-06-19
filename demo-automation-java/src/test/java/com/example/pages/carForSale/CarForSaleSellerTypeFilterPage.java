package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarForSaleSellerTypeFilterPage extends BasePage {
    public CarForSaleSellerTypeFilterPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    /**
     * check Seller Type Filter Default Is Not Extended
     * @return boolean check
     */
    public boolean checkSellterTypeFilterShouldNotBeExtended() {
        boolean check = false;
        WebElement sellerTypeFilter = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4']//span[text()='Seller Type']"));
        if(sellerTypeFilter.isDisplayed()) {
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
    public boolean checkSellerTypeFilterShouldBeExtendedAfterClick() {
        boolean check = false;
        WebElement sellerTypeFilterBeforeExtending = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4']//span[text()='Seller Type']/parent::span/parent::div"));
        if(sellerTypeFilterBeforeExtending.isDisplayed()) {
            keyword.click(sellerTypeFilterBeforeExtending);
            WebElement sellerTypeFilterAfterExtending = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4 active']//span[text()='Seller Type']/parent::span/parent::div/following-sibling::div"));
            if(sellerTypeFilterAfterExtending.isDisplayed()) {
                check = true;
            } else {
                check = false;
            }
        }
        return check;
    }

    /**
     * choose seller type option in door filter
     * @param option
     */
    public void chooseSellerTypeInSellerTypeFilter(String option) {
        switch(option) {
            case "Dealer":
                WebElement dealerOption = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4 active']//span[text()='Seller Type']/parent::span/parent::div/following-sibling::div//div[text()='Dealer']"));
                keyword.click(dealerOption);
                break;
            case "Private Seller":
                WebElement privateSellerOption = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4 active']//span[text()='Seller Type']/parent::span/parent::div/following-sibling::div//div[text()='Private Seller']"));
                keyword.click(privateSellerOption);
                break;
        }
    }

    /**
     * Check Doors Option Should Be Filtered After Chose
     * @return boolean check
     */
    public boolean checkTypeSellersOptionShouldBeFilteredAfterChose(String option) {
        boolean check = false;
        WebElement typeSellerFilterBeforeExtending = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4']//span[text()='Seller Type']/parent::span/parent::div"));
        if(typeSellerFilterBeforeExtending.isDisplayed()) {
            keyword.click(typeSellerFilterBeforeExtending);
            WebElement typeSellerFilterAfterExtending = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4 active']//span[text()='Seller Type']/parent::span/parent::div/following-sibling::div"));
            if(typeSellerFilterAfterExtending.isDisplayed()) {
                WebElement typeSellerOption = keyword.findElement(By.xpath("//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4 active']//span[text()='Seller Type']/parent::span/parent::div/following-sibling::div//div[text()='"+option+"']"));
                keyword.click(typeSellerOption);
                WebElement txtYourSearchTypeSellerOption = keyword.findElement(By.xpath("//div[text()='"+option+"']"));
                keyword.scrollToElement(txtYourSearchTypeSellerOption);
                WebElement linkClearFilters = keyword.findElement(By.xpath("//span[text()='Clear Filters']"));
                keyword.scrollToElement(linkClearFilters);
                if(txtYourSearchTypeSellerOption.isDisplayed() && linkClearFilters.isDisplayed()) {
                    check = true;
                } else {
                    check = false;
                }          
            } else {
                check = false;
            }
        } else {
            check = false;
        }
        return check;
    }
}
