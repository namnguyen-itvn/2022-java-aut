package com.example.tests.car_reviews_tests;

import org.testng.annotations.Test;

import com.example.core.datadriven.CarUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewDetailPage;
import com.example.pages.car_reviews_pages.CarReviewPage;
import com.example.tests.BaseTest;

public class CarReviewModulePhotoSection extends BaseTest {
    @Test(testName = "Verify That The UI Of Photos Section Will Be Displayed", dataProviderClass = CarUnderTest.class, dataProvider = "CarUnderTest")
    public void verifyThatTheUIOfPhotosSectionWillBeDisplayed(String year,String make,String model,String zipcode) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation(year,make,model,zipcode);
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        Assert.assertTrue(carReviewDetailPage.verifyTheUIOfPhotosSectionWillBeDisplay(year,make,model));
    }
}
