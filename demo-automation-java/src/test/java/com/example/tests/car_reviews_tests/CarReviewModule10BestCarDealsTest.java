package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReview10BestCarDeals;
import com.example.pages.car_reviews_pages.CarReviewDetailPage;
import com.example.pages.car_reviews_pages.CarReviewPage;
import com.example.tests.BaseTest;

public class CarReviewModule10BestCarDealsTest extends BaseTest {
    @Test(testName = "Verify That The UI Of 10 Best Car Deals Section Is Displayed", dataProviderClass = CarUnderTest.class, dataProvider = "CarUnderTest")
    public void verifyThatTheUIOf10BestCarDealsSectionIsDisplayed(String year,String make,String model,String zipcode) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation(year,make,model,zipcode);
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        Assert.assertTrue(carReviewDetailPage.verifyImgAndTitle(), "Img or Title is not displayed");
    }

    @Test(testName = "Verify That User Could Be Redirected Of 10 Best Car Deals Page After Click ShopNow Button", dataProviderClass = CarUnderTest.class, dataProvider = "CarUnderTest")
    public void verifyThatUserCouldBeRedirectedOf10BestCarDealsPageAfterClickShopNowButton(String year,String make,String model,String zipcode) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation(year,make,model,zipcode);
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        carReviewDetailPage.clickOnShopNowButton();
        CarReview10BestCarDeals carReview10BestCarDeals = new CarReview10BestCarDeals(driver);
        Assert.assertTrue(carReview10BestCarDeals.verifyTitlePage(), "Title is not correct");
    }
}
