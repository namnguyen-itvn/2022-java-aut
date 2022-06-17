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
     * @param element
     * @return
     */
    private boolean isElementDisplayed(By element) {
        return keyword.findElement(element).isDisplayed();
    }

    /**
     * 
     * @param element
     */
    private void scrollOnElement(By element) {
        keyword.scrollToElement(keyword.findElement(element));
    }

    /**
     * 
     * @return
     */
    public boolean isTransmissionResult(){
        scrollOnElement(lblCarsForSaleDetailPageResult);
        if(isElementDisplayed(lblCarsForSaleDetailPageResult))
            return true;
        return false;
    }
}
