package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarReview10BestCarDeals extends BasePage {

    public CarReview10BestCarDeals(WebDriver driver) {
        super(driver);
    }
    
    private WebElement txtTitlePage=keyword.findElement(By.xpath("//*[@class='tdb-title-text']"));

    /*
     * Check the title page after redirected change or not
     * Return true if title change as expected
     */
    public boolean verifyTitlePage() {
        return txtTitlePage.getText().trim().contains(expectedTitle);
    }

    public static String expectedTitle="10 Best Car Deals";
}
