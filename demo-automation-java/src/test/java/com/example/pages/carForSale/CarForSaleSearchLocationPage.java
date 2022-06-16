package com.example.pages.carForSale;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        keyword.scrollToElement(lblSearchLocation);
        if (isElementDisplayed(ddlDistance) && isElementDisplayed(txtZipcode) && isElementDisplayed(checkboxDelivery) && 
            isElementCanClicked(ddlDistance) && isElementCanClicked(txtZipcode) && isElementCanClicked(checkboxDelivery)){
                return true;
        }else return false;
    }
    
    /**
     * Method verify that the list should be showed when user click on Distance combobox in search location module
     * @return true or false
     */
    public boolean isDistanceListShowedWhenUserClickOnDistanceCombobox(){
        keyword.click(ddlDistance);
        List<WebElement> ddlDistances = driver.findElements(By.id("2281868035"));
        
        if (ddlDistances.size() >0){
            return true;
        }
        return false;        
    }

    /**
     * Method verify that search location module should be worked correctly with option Distance
     * @param distance option to chose of Distance combobox
     * @return true or false
     */
    public boolean isReturnTheResultOfDestanceMatchWithOptionWasSelected(String distance){
        keyword.click(ddlDistance);
        keyword.setValueForSelectElement(ddlDistance, chooseTypeOfSelect.selectByValue, distance);
        WebElement sliderDitanceResult = keyword.findElement(By.xpath("//div[@class = 'flickity-slider']"));
        keyword.scrollToElement(lblYourSearch);
        if (isElementDisplayed(sliderDitanceResult)){
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
        keyword.setText(txtZipcode, zipcode);
        Thread.sleep(5000);
        WebElement linkZipCode = keyword.findElement(By.xpath("//span[contains(text(),'90089')]"));        
        WebElement lblHeading = keyword.findElement(By.xpath("//h1[@data-cmp='heading']"));
        System.err.println(keyword.getText(lblHeading));
        if (keyword.getText(lblHeading).contains("in") && isElementDisplayed(linkZipCode)){
            check =  true;
        }else check = false;
        return check;        
    }

    //Declare element
    private WebElement lblYourSearch = keyword.findElement(By.xpath("//span[contains(text(), 'Your Search')]"));
    private WebElement lblSearchLocation = keyword.findElement(By.xpath("//div[@data-cmp = 'filterLocation']"));
    private WebElement ddlDistance = keyword.findElement(By.id("2281868035"));
    private WebElement txtZipcode = keyword.findElement(By.id("2225141853"));
    private WebElement checkboxDelivery = keyword.findElement(By.xpath("//div[contains(text(), 'Include Extended Home Delivery')]"));    
}
