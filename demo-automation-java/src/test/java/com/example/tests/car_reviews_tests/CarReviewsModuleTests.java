package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.OverViewModuleCarReviewDetailsPage;
import com.example.pages.car_reviews_pages.CarReviewsModulePage;
import com.example.tests.BaseTest;

public class CarReviewsModuleTests extends BaseTest{
    @Test(testName = "Verify that the UI of Car Reviews Module should be displayed as default")
    public void verifyCarReviewsModuleDisplayedAsDefault()
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        Assert.assertTrue(carReviewsModulePage.isCarReviewsModuleDisplayed(), "Page displayed is incorrect");
    }

    @Test(testName = "Verify that the User should navigate to Car Review Details page end to end", dataProviderClass = CarUnderTest.class, dataProvider = "CarUnderTest")
    public void verifyUserNavigateToCarReviewDetailsPageE2E(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);

        OverViewModuleCarReviewDetailsPage carReviewDetailsPage = new OverViewModuleCarReviewDetailsPage(driver);
        Assert.assertTrue(carReviewDetailsPage.isPageTitleCorrect(carReviewsModulePage.expectedCarReviewDetailsPageTitle), "Page displayed is incorrect");
    }
}
