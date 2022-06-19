package com.example.pages.car_reviews_pages;

import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class BuildAndPricePage extends BasePage {
    public BuildAndPricePage() {
    }

    public BuildAndPricePage(WebDriver driver) {}

    /**
     * return true or false  for verify title page displays correct with the form
     * @param year
     * @param make
     * @param model
     * @return
    */
    public boolean isTitlePageDisplaysCorrect(String year, String make, String model){
        String expcetedTitle= year+" "+make+" "+model+" | Select Vehicle Style | Kelley Blue Book";
        //String expcetedTitle= "2019 Honda Civic | Select Vehicle Style | Kelley Blue Book";
        return pageTitle().equals(expcetedTitle);
        //return true;
    }

    /**
    * title page correct with the form  or not
    * @return
    */
    public boolean isTitlePageBuildAndPriceDisplaysCorrect(String year, String make, String model) {
   
    return isTitlePageDisplaysCorrect(year, make, model);
    }
}
