package com.example.pages.car_reviews_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.core.keyword.WebKeyword.chooseTypeOfSelect;
import com.example.pages.BasePage;

public class CarReviewsNewCarPriceQuotePage extends BasePage {
    public CarReviewsNewCarPriceQuotePage(WebDriver driver) {
        super(driver);
    }

    //Declare
    private By selectYear = By.xpath("//form//select[@placeholder='Year']");
    private By selectMake = By.xpath("//form//select[@placeholder='Make']");
    private By selectModel = By.xpath("//form//select[@placeholder='Model']");
    private By btnNext = By.xpath("//form/button[@type='submit']");

    //Action
    /**
     * Fill data for Car reviews
     * @param year
     * @param make
     * @param model
     */

    public void actionExitAds() {
        try {
            WebElement optDiveType = driver.findElement(By.xpath("//button[contains(@aria-label,'Close')]"));
            keyword.click(optDiveType);
        } catch (Exception e){

        }
        
    }
    public void inputDataCar(String year, String make, String model){
        keyword.setValueForElement(keyword.findElement(selectYear), chooseTypeOfSelect.selectByValue, year);
        keyword.setValueForElement(keyword.findElement(selectMake), chooseTypeOfSelect.selectByValue, make);
        keyword.setValueForElement(keyword.findElement(selectModel), chooseTypeOfSelect.selectByValue, model);
        actionExitAds();
        keyword.click(keyword.findElement(btnNext));
    }
}
