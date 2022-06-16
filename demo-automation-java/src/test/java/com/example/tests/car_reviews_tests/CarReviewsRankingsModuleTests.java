package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarUnderTest;
import com.example.core.utils.listener.ReportListener;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewsModulePage;
import com.example.pages.car_reviews_pages.CarReviewsRankingsModulePage;
import com.example.tests.BaseTest;

@Listeners(ReportListener.class)
public class CarReviewsRankingsModuleTests extends BaseTest{
    @Test(testName = "Verify System Should Navigate To Review Page After Click On Get Reviews Button", dataProviderClass = CarUnderTest.class, dataProvider = "dataForGetCarReviews")
    public void verifySystemShouldNavigateToReviewPageAfterClickOnGetReviewsButton(String year, String make, String model, String zipCode) throws Exception   
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.getCarReviews(year, make, model, zipCode);
        CarReviewsRankingsModulePage carReviewsRankingsModulePage = new CarReviewsRankingsModulePage(driver);
        Assert.assertTrue(carReviewsRankingsModulePage.assertScopeAreUrlAndLblSelectedCarCorrect(year, make, model));
    }
    
    @Test(testName = "Verify Default UI Of Horsepower Table In Rankings Section", dataProviderClass = CarUnderTest.class, dataProvider = "dataForGetCarReviews")
    public void verifyDefaultUIOfHorsepowerTableInRankingsSection(String year, String make, String model, String zipCode) throws Exception   
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.getCarReviews(year, make, model, zipCode);
        CarReviewsRankingsModulePage carReviewsRankingsModulePage = new CarReviewsRankingsModulePage(driver);
        Assert.assertTrue(carReviewsRankingsModulePage.assertScopeAreDefaultUIOfHorsepowerTableDiplayedCorrect());
    }

    @Test(testName = "Verify Default UI Of MPG Combined Table In Rankings Section", dataProviderClass = CarUnderTest.class, dataProvider = "dataForGetCarReviews")
    public void verifyDefaultUIOfMPGCombinedTableInRankingsSection(String year, String make, String model, String zipCode) throws Exception   
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.getCarReviews(year, make, model, zipCode);
        CarReviewsRankingsModulePage carReviewsRankingsModulePage = new CarReviewsRankingsModulePage(driver);
        Assert.assertTrue(carReviewsRankingsModulePage.assertScopeAreDefaultUIOfMPGCombinedTableDiplayedCorrect());
    }

    @Test(testName = "Verify Default UI Of Consumer Ratings Table In Rankings Section", dataProviderClass = CarUnderTest.class, dataProvider = "dataForGetCarReviews")
    public void verifyDefaultUIOfConsumerRatingsTableInRankingsSection(String year, String make, String model, String zipCode) throws Exception   
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.getCarReviews(year, make, model, zipCode);
        CarReviewsRankingsModulePage carReviewsRankingsModulePage = new CarReviewsRankingsModulePage(driver);
        Assert.assertTrue(carReviewsRankingsModulePage.assertScopeAreDefaultUIOfConsumerRatingsTableDiplayedCorrect());
    }
}
