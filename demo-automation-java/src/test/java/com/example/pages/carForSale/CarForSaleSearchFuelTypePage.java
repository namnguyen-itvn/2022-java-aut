package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarForSaleSearchFuelTypePage extends BasePage{

    public CarForSaleSearchFuelTypePage(WebDriver driver) {
        super(driver);
    }

    //Action
    /**
     * Method for verify that fuel type filter display correctly as requirement
     * @return true or false
     */
    public boolean isFuleTypeFilterDisplayCorrectlyAsRequirement(){
        keyword.click(linkNotNow);
        keyword.scrollToElement(lblFuelType);
        if (isElementEnabled(optAlternative) == true && 
            isElementEnabled(optDiesel) == true && 
            isElementEnabled(optElectric) == true && 
            isElementEnabled(optGasonline) == true && 
            isElementEnabled(optHybrid) == true && 
            isElementEnabled(optHydrogen) == true){
                return true;
            }else return false;
    }

    /**
     * Method for verify that return the result should match with fuel type selected
     * @param fuel: fuel type selected
     * @return: true or false
     */
    public boolean isReturnTheResultShouldMatchWithFuelTypeSelected(String fuel){
        keyword.click(linkNotNow);
        keyword.scrollToElement(lblFuelType);
        WebElement optsFuelType = keyword.findElement(By.xpath("//div[contains(text(), '"+fuel+"')]"));
        keyword.click(optsFuelType);
        WebElement linkFuelType = keyword.findElement(By.xpath("//a[contains(text(), '"+fuel+"')]"));
        keyword.scrollToElement(linkFuelType);
        WebElement btnFilter = keyword.findElement(By.xpath("//div[contains(@data-cmp, 'chip')]/child::span[contains(text(), '"+fuel+"')]"));
        WebElement linkClearFilter = keyword.findElement(By.xpath("//span[contains(text(), 'Clear Filters')]"));
        if (keyword.getText(btnFilter).contains(fuel) && 
            isElementEnabled(linkFuelType) == true &&
            isElementEnabled(btnFilter) == true && 
            isElementEnabled(linkClearFilter) == true){
                return true;
            }else return false;
    }

    //Declare element
    private WebElement linkNotNow = keyword.findElement(By.xpath("//div[@class='popover-content']//div//button[@class='btn btn-link']"));
    private WebElement lblFuelType = keyword.findElementByLocator(By.xpath("//span[contains(text(), 'Fuel Type')]/parent::span/parent::div"));
    private WebElement optAlternative = keyword.findElement(By.xpath("//div[contains(text(), 'Alternative')]"));
    private WebElement optDiesel = keyword.findElement(By.xpath("//div[contains(text(), 'Diesel')]"));
    private WebElement optElectric = keyword.findElement(By.xpath("//div[contains(text(), 'Electric')]"));
    private WebElement optGasonline = keyword.findElement(By.xpath("//div[contains(text(), 'Gasoline')]"));
    private WebElement optHybrid = keyword.findElement(By.xpath("//div[contains(text(), 'Hybrid')]"));
    private WebElement optHydrogen = keyword.findElement(By.xpath("//div[contains(text(), 'Hydrogen')]"));
    
}
