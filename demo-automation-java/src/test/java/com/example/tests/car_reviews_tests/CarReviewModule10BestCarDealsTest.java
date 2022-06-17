package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReview10BestCarDeals;
import com.example.pages.car_reviews_pages.CarReviewDetailPage;
import com.example.pages.car_reviews_pages.CarReviewPage;
import com.example.tests.BaseTest;

public class CarReviewModule10BestCarDealsTest extends BaseTest {
    @Test
    public void verifyThatTheUIOf10BestCarDealsSectiondisplay() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation();
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        Assert.assertTrue(carReviewDetailPage.verifyImgAndTitle(), "Img or Title is not displayed");
    }

    @Test
    public void verifyThatUserCouldOf10BestCarDealsPageAfterClickShopNowButton() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation();
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        carReviewDetailPage.clickOnShopNowButton();
        CarReview10BestCarDeals carReview10BestCarDeals = new CarReview10BestCarDeals(driver);
        Assert.assertTrue(carReview10BestCarDeals.verifyTitlePage(), "Title is not correct");
    }
}
