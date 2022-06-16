package com.example.pages.car_reviews_pages;

import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class BuildAndPricePage extends BasePage {
    public BuildAndPricePage() {
    }

    public BuildAndPricePage(WebDriver driver) {}

/**
 * 
 * @return
*/
public boolean isTitlePageBuildAndPriceDisplaysCorrect(String year, String make, String model) {
   
    return isTitlePageDisplaysCorrect(year, make, model);
}
}
