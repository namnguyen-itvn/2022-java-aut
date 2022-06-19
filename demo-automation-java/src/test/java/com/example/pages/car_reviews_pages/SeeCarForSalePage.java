package com.example.pages.car_reviews_pages;

import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class SeeCarForSalePage extends BasePage {
    public SeeCarForSalePage() {
    }

    public SeeCarForSalePage(WebDriver driver) {}

/**
 * 
 * @return
*/
public boolean isTitlePageBuildAndPriceDisplaysCorrect(String year, String make, String model) {
   String expcetedTitleSeeForSale = "Used "+year+" "+make+" "+model+" for Sale (Test Drive at Home) - Kelley Blue Book";
    return driver.getTitle().trim().equals(expcetedTitleSeeForSale);
}
}
