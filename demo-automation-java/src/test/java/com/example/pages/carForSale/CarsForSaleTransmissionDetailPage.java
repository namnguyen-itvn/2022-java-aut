package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class CarsForSaleTransmissionDetailPage extends BasePage{

    public CarsForSaleTransmissionDetailPage(WebDriver driver) {
        super(driver);
    }
    
    private By lblCarsForSaleDetailPageResult = By.xpath("//div[contains(text(),'Automatic Transmission')]");

    /**
     * 
     * @return
     */
    public boolean isTransmissionResult(){
        keyword.scrollToElement(keyword.findElement(lblCarsForSaleDetailPageResult));
        if(isElementDisplayed(lblCarsForSaleDetailPageResult))
            return true;
        return false;
    }
}
