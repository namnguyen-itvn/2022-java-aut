package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarUnderTest;
import com.example.core.utils.listener.ReportListener;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewsModulePage;
import com.example.pages.car_reviews_pages.CarReviewsPeopleWhoViewedThisAlsoViewedModulePage;
import com.example.tests.BaseTest;

@Listeners(ReportListener.class)
public class CarReviewsPeopleWhoViewedThisAlsoViewedModuleTests extends BaseTest{
    @Test(testName = "Verify System Should Navigate To Review Page After Click On Get Reviews Button", dataProviderClass = CarUnderTest.class, dataProvider = "dataForGetCarReviews")
    public void verifySystemShouldNavigateToReviewPageAfterClickOnGetReviewsButton(String year, String make, String model, String zipCode) throws Exception   
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.getCarReviews(year, make, model, zipCode);
        CarReviewsPeopleWhoViewedThisAlsoViewedModulePage carReviewsPeopleWhoViewedThisAlsoViewedModulePage = new CarReviewsPeopleWhoViewedThisAlsoViewedModulePage(driver);
        Assert.assertTrue(carReviewsPeopleWhoViewedThisAlsoViewedModulePage.assertScopeIsUrlAndLblSelectedCarCorrect(year, make, model));
    }
    
    @Test(testName = "Verify Default UI Of People Who Viewed This Also Viewed Section", dataProviderClass = CarUnderTest.class, dataProvider = "dataForGetCarReviews")
    public void verifyDefaultUIOfPeopleWhoViewedThisAlsoViewedSection(String year, String make, String model, String zipCode) throws Exception   
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.getCarReviews(year, make, model, zipCode);
        CarReviewsPeopleWhoViewedThisAlsoViewedModulePage carReviewsPeopleWhoViewedThisAlsoViewedModulePage = new CarReviewsPeopleWhoViewedThisAlsoViewedModulePage(driver);
        Assert.assertTrue(carReviewsPeopleWhoViewedThisAlsoViewedModulePage.assertScopeIsDefaultUIOfPeopleAlsoViewedDisplayedCorrectAsRequired());
    }

    @Test(testName = "Verify The Number Of Vehicles Is Displayed Correctly After User Click On See More Button", dataProviderClass = CarUnderTest.class, dataProvider = "dataForGetCarReviews")
    public void verifyTheNumberOfVehiclesIsDisplayedCorrectlyAfterUserClickOnSeeMoreButton(String year, String make, String model, String zipCode) throws Exception   
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.getCarReviews(year, make, model, zipCode);
        CarReviewsPeopleWhoViewedThisAlsoViewedModulePage carReviewsPeopleWhoViewedThisAlsoViewedModulePage = new CarReviewsPeopleWhoViewedThisAlsoViewedModulePage(driver);
        Assert.assertTrue(carReviewsPeopleWhoViewedThisAlsoViewedModulePage.isTheNumberOfVehiclesIsDisplayedCorrectlyAfterUserClickOnSeeMoreButton());
    }

    @Test(testName = "Verify The Number Of Vehicles Is Displayed Correctly After User Click On See Less Button", dataProviderClass = CarUnderTest.class, dataProvider = "dataForGetCarReviews")
    public void verifyTheNumberOfVehiclesIsDisplayedCorrectlyAfterUserClickOnSeeLessButton(String year, String make, String model, String zipCode) throws Exception   
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.getCarReviews(year, make, model, zipCode);
        CarReviewsPeopleWhoViewedThisAlsoViewedModulePage carReviewsPeopleWhoViewedThisAlsoViewedModulePage = new CarReviewsPeopleWhoViewedThisAlsoViewedModulePage(driver);
        Assert.assertTrue(carReviewsPeopleWhoViewedThisAlsoViewedModulePage.isTheNumberOfVehiclesIsDisplayedCorrectlyAfterUserClickOnSeeLessButton());
    }
}
