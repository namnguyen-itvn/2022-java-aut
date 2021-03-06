package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.core.keyword.WebKeyword.chooseTypeOfSelect;
import com.example.pages.BasePage;

public class CarForSaleSearchLocationPage extends BasePage{
    public CarForSaleSearchLocationPage(WebDriver driver) {
        super(driver);
    }
    
    //Action

    /**
     * Method verify that search location module should be displayed is correct
     * @return true or false
     */
    public boolean isSearchLocationIsDisplayCorrect(){
        keyword.click(linkNotNow);
        keyword.scrollToElement(lblSearchLocation);
        if (isElementDisplayed(ddlDistance) == true && 
            isElementDisplayed(txtZipcode) == true && 
            isElementDisplayed(checkboxDelivery) == true && 
            isElementEnabled(ddlDistance) == true && 
            isElementEnabled(txtZipcode) == true && 
            isElementEnabled(checkboxDelivery) == true){
                return true;
        }else return false;
    }
    
    /**
     * Method verify that the list should be showed when user click on Distance combobox in search location module
     * @return true or false
     */
    public boolean isDistanceListShowedWhenUserClickOnDistanceCombobox(String ecpectedDistance){
        keyword.click(linkNotNow);
        keyword.scrollToElement(ddlDistance);
        keyword.click(ddlDistance);
        WebElement ddlDistance = keyword.findElement(By.id("2281868035"));
        Select ddlDistances = new Select(ddlDistance);
        boolean check = false;
        for (WebElement distance : ddlDistances.getOptions()){
            if (ecpectedDistance.contains(keyword.getText(distance))){
                check = true;
            }else check = false;
        }
        return check;         
    }

    /**
     * Method verify that search location module should be worked correctly with option Distance
     * @param distance option to chose of Distance combobox
     * @return true or false
     */
    public boolean isReturnTheResultOfDistanceMatchWithOptionWasSelected(String distance){
        keyword.click(linkNotNow);
        keyword.scrollToElement(lblSearchLocation);
        keyword.click(ddlDistance);
        keyword.setValueForSelectElement(ddlDistance, chooseTypeOfSelect.selectByValue, distance);
        keyword.scrollToElement(linkCarsForSaleHeading);
        WebElement sliderDitanceResult = keyword.waiForLocatorOfElementVisiable(By.xpath("//div[@class = 'flickity-slider']"));
        if (isElementDisplayed(sliderDitanceResult) == true){
            return true;
        }else return false;
    }

    /**
     * Method verify that search location module should be worked correctly with option Zip Code
     * @param zipcode: the zip code mentioned in distancedata.json file
     * @return true or false
     * @throws Exception
     */
    public boolean isReturnTheResultOfZipCodeMatchWithOptionWasSelected(String zipcode) throws Exception{
        boolean check = false;
        keyword.click(linkNotNow);
        keyword.scrollToElement(lblSearchLocation);
        keyword.setText(txtZipcode, zipcode);
        WebElement linkZipCode = keyword.waiForLocatorOfElementVisiable(By.xpath("//span[contains(text(),'90089')]"));        
        WebElement lblHeading = keyword.waiForLocatorOfElementVisiable(By.xpath("//h1[contains(text(), 'in')]"));
        if (keyword.getText(lblHeading).contains("in") && 
            isElementDisplayed(linkZipCode) == true){
            check =  true;
        }else check = false;
        return check;        
    }

    //Declare element
    private WebElement linkCarsForSaleHeading = keyword.findElement(By.xpath("//div[@id='breadcrumbs-container']"));
    private WebElement linkNotNow = keyword.findElement(By.xpath("//div[@class='popover-content']//div//button[@class='btn btn-link']"));
    private WebElement lblSearchLocation = keyword.findElementByLocator(By.xpath("//div[@data-cmp = 'filterLocation']"));
    private WebElement ddlDistance = keyword.findElementByLocator(By.id("2281868035"));
    private WebElement txtZipcode = keyword.findElementByLocator(By.id("2225141853"));
    private WebElement checkboxDelivery = keyword.findElement(By.xpath("//div[contains(text(), 'Include Extended Home Delivery')]"));    
}
