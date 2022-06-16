package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.BuildAndPricePage;
import com.example.pages.car_reviews_pages.CarReviewsModulePage;
import com.example.pages.car_reviews_pages.CarreviewsDetailPage;
import com.example.pages.car_reviews_pages.OverViewModuleCarReviewDetailsPage;
import com.example.tests.BaseTest;

public class OverViewModuleCarReviewDetailsPageTests extends BaseTest{
    @Test(testName = "Verify that the User should navigate to Car Review Details page end to end", dataProviderClass = CarUnderTest.class, dataProvider = "CarUnderTest")
    public void verifyUserNavigateToCarReviewDetailsPageE2E(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);
        CarreviewsDetailPage carreviewsDetailPage= new CarreviewsDetailPage(driver);
        carreviewsDetailPage.clickOnBuildAndPriceButton(year,make,model);
        BuildAndPricePage buildAndPricePage = new BuildAndPricePage(driver);
        Assert.assertTrue(buildAndPricePage.isTitlePageBuildAndPriceDisplaysCorrect(year, make, model));
    }
}
