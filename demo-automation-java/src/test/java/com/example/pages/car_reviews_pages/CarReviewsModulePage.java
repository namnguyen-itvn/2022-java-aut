package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.core.keyword.WebKeyword.chooseTypeOfSelect;
import com.example.pages.BasePage;

public class CarReviewsModulePage extends BasePage{
    public CarReviewsModulePage() {
    }

    public CarReviewsModulePage(WebDriver driver) {
        super(driver);
    }

    private WebElement ddlYear = driver.findElement(By.cssSelector("select[placeholder='Year']"));
    private WebElement ddlMake = driver.findElement(By.cssSelector("select[placeholder='Make']"));
    private WebElement ddlModel = driver.findElement(By.cssSelector("select[placeholder='Model']"));
    private WebElement txtZIPCode = driver.findElement(By.cssSelector("input[type='tel']"));
    private WebElement btnGetReview = driver.findElement(By.cssSelector("form button[type='submit']"));         

    public void getCarReviews(String year, String make, String model, String zipCode) throws Exception {
        keyword.setValueForElement(ddlYear, chooseTypeOfSelect.selectByVisibleText, year);
        keyword.setValueForElement(ddlMake, chooseTypeOfSelect.selectByVisibleText, make);
        keyword.setValueForElement(ddlModel, chooseTypeOfSelect.selectByVisibleText, model); 
        keyword.setText(txtZIPCode, zipCode);
        keyword.click(btnGetReview);
        Thread.sleep(10000);  
    }
}
