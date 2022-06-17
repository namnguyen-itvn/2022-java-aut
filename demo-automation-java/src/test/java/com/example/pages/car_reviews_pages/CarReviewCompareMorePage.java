package com.example.pages.car_reviews_pages;

import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class CarReviewCompareMorePage extends BasePage {

    public CarReviewCompareMorePage(WebDriver driver) {
        super(driver);
    }
  
    public boolean verifyTitleConpareMorePage()
	{
		return driver.getTitle().trim().equals(expectedTitle);
	}

	public static String expectedTitle="Car Comparison Results | Kelley Blue Book";
    

}
