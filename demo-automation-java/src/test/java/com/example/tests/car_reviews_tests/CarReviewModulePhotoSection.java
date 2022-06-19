package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewDetailPage;
import com.example.pages.car_reviews_pages.CarReviewPage;
import com.example.tests.BaseTest;

public class CarReviewModulePhotoSection extends BaseTest {
    @Test
    public void verifyThatTheUIOf10BestCarDealsSectiondisplay() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation();
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        carReviewDetailPage.verifyNumberOfPhotoSection();
    }
    @Test
    public void test() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation();
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        carReviewDetailPage.getText();
    }
}
