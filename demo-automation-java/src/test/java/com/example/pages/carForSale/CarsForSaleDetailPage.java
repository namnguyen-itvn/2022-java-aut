package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class CarsForSaleDetailPage extends BasePage{

    public CarsForSaleDetailPage(WebDriver driver) {
        super(driver);
    }

    public CarsForSaleDetailPage() {
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
