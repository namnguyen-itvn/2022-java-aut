package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewsModulePage;
import com.example.tests.BaseTest;

public class CarReviewsModuleTests extends BaseTest{
    @Test(testName = "Verify that the UI of Car Reviews section should be displayed as default")
    public void verifyCheckoutCompletePageElementCorrect()
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        Assert.assertTrue(carReviewsModulePage.isCarReviewsModuleDisplayed(), "Page displayed is incorrect");
    }
}
