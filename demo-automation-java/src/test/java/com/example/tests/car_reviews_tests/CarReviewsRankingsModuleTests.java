package com.example.tests.car_reviews_tests;

import org.testng.annotations.Test;

import com.example.core.datadriven.CarUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewsModulePage;
import com.example.pages.car_reviews_pages.CarReviewsRankingsModulePage;
import com.example.tests.BaseTest;

public class CarReviewsRankingsModuleTests extends BaseTest{
    @Test(testName = "E2E User Should Navigate To Review Page", dataProviderClass = CarUnderTest.class, dataProvider = "dataForGetCarReviews")
    public void verifySystemShouldNavigateToReviewPage(String year, String make, String model, String zipCode) throws Exception   
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.getCarReviews(year, make, model, zipCode);
        CarReviewsRankingsModulePage carReviewsRankingsModulePage = new CarReviewsRankingsModulePage(driver);
    }    
}
