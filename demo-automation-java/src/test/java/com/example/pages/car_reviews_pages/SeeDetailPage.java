package com.example.pages.car_reviews_pages;

import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class SeeDetailPage extends BasePage {
    public SeeDetailPage(WebDriver driver)
	{
		super(driver);
	}

	public boolean verifyTitleSeeDetailPage()
	{
		return driver.getTitle().trim().equals(expectedTitle);
	}

	public boolean verifyTitleAndName() {
		CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
		return carReviewDetailPage.getTitleAndNameOfSecondCar().contains(expectedTitle);
	}



	public static String expectedTitle="New 2021 Hyundai Veloster Reviews, Pricing & Specs | Kelley Blue Book";
}
