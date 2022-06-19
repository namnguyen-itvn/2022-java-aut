package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewCompareMorePage;
import com.example.pages.car_reviews_pages.CarReviewDetailPage;
import com.example.pages.car_reviews_pages.CarReviewPage;
import com.example.pages.car_reviews_pages.SeeDetailPage;
import com.example.tests.BaseTest;

public class CarReviewModuleCompareCarTest extends BaseTest {
    @Test(testName = "Verify That The UI Of Compare Cars Section Is Display", dataProviderClass = CarUnderTest.class, dataProvider = "CarUnderTest")
    public void verifyThatTheUIOfCompareCarsSectionIsDisplay(String year,String make,String model,String zipcode) throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation(year,make,model,zipcode);
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        Assert.assertTrue(carReviewDetailPage.verifyUIOfCompareCarsSection());
    }

    @Test(testName = "Verify That The User Could Be Redirected To SeeDetails Page After Click SeeDetail Button", dataProviderClass = CarUnderTest.class, dataProvider = "CarUnderTest")
    public void verifyThatTheUserCouldBeRedirectedToSeeDetailsPageAfterClickSeeDetailButton(String year,String make,String model,String zipcode) throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation(year,make,model,zipcode);
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        carReviewDetailPage.clickOnSeeDetailButton();
        SeeDetailPage seeDetailPage = new SeeDetailPage(driver);
        Assert.assertTrue(seeDetailPage.verifyTitleSeeDetailPage(),"Title is not correct");
    }

    @Test(testName = "Verify That The User Could Be Redirected To Compare Page After Click Compare More Link", dataProviderClass = CarUnderTest.class, dataProvider = "CarUnderTest")
    public void verifyThatTheUserCouldBeRedirectedToComparePageAfterClickCompareMoreLink(String year,String make,String model,String zipcode) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation(year,make,model,zipcode);
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        carReviewDetailPage.clickOnCompareMoreLink();
        CarReviewCompareMorePage carReviewCompareMorePage = new CarReviewCompareMorePage(driver);
        Assert.assertTrue(carReviewCompareMorePage.verifyTitleConpareMorePage(),"Title is not correct");
    }
}
