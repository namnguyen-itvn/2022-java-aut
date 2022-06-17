package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewCompareMorePage;
import com.example.pages.car_reviews_pages.CarReviewDetailPage;
import com.example.pages.car_reviews_pages.CarReviewPage;
import com.example.pages.car_reviews_pages.SeeDetailPage;
import com.example.tests.BaseTest;

public class CarReviewModuleCompareCarTest extends BaseTest {
    @Test
    public void verifyThatTheUIOfCompareCarsSectionIsDisplay() throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation();
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        Assert.assertTrue(carReviewDetailPage.verifyUIOfCompareCarsSection());
    }

    @Test
    public void verifyThatTheUserCouldNavigateToSeeDetailsPageEndToEnd() throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation();
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        carReviewDetailPage.clickOnSeeDetailButton();
        SeeDetailPage seeDetailPage = new SeeDetailPage(driver);
        Assert.assertTrue(seeDetailPage.verifyTitleSeeDetailPage(),"Title is not correct");
    }
    @Test
    public void verifyThatTheUserCouldNavigateToComparePageEndToEnd() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation();
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        carReviewDetailPage.clickOnCompareMoreLink();
        CarReviewCompareMorePage carReviewCompareMorePage = new CarReviewCompareMorePage(driver);
        Assert.assertTrue(carReviewCompareMorePage.verifyTitleConpareMorePage(),"Title is not correct");

    }
}
