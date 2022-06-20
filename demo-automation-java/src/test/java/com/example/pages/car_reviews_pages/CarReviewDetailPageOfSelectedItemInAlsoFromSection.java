package com.example.pages.car_reviews_pages;

import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class CarReviewDetailPageOfSelectedItemInAlsoFromSection extends BasePage {

    public CarReviewDetailPageOfSelectedItemInAlsoFromSection(WebDriver driver) {
        super(driver);
    }
    
    public boolean verifyTitleOfBrowserAfterClickOnFirstItemInListAlsoFrom(String string) {
        System.out.println(driver.getTitle().trim());
        return driver.getTitle().trim().contains(string);
    }
}
