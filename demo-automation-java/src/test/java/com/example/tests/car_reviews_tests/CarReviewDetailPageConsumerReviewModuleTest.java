package com.example.tests.car_reviews_tests;

import com.example.core.datadriven.InfoCarReviewUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewDetailPageConsumerReviewModule;
import com.example.pages.car_reviews_pages.CarReviewPageConsumerReviewModule;
import com.example.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarReviewDetailPageConsumerReviewModuleTest extends BaseTest {

    private void navigateToCarReviewPage(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
    }

    @Test(testName = "Verify that the title of section consumer review should be \"[Year] [Make] [Model] KBB.com Consumer Reviews\"",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyTheTitleOfSectionConsumerReview(String year, String make, String model, String zipCode) throws Exception {
        navigateToCarReviewPage();
        CarReviewPageConsumerReviewModule carReviewPageConsumerReviewModule = new CarReviewPageConsumerReviewModule(driver);
        carReviewPageConsumerReviewModule.inputAndSubmitGetCarReview(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isTheTitleOfConsumerReviewCorrect(year, make, model));
    }

    @Test(testName = "Verify that by default the application should display six reviews",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyDefaultPageShowSixReviews(String year, String make, String model, String zipCode) throws Exception {
        navigateToCarReviewPage();
        CarReviewPageConsumerReviewModule carReviewPageConsumerReviewModule = new CarReviewPageConsumerReviewModule(driver);
        carReviewPageConsumerReviewModule.inputAndSubmitGetCarReview(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isDefaultPageShowSixReviews());
    }

}
