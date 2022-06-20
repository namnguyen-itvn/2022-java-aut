package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewDetailPage;
import com.example.pages.car_reviews_pages.CarReviewDetailPageOfSelectedItemInAlsoFromSection;
import com.example.pages.car_reviews_pages.CarReviewPage;
import com.example.tests.BaseTest;

public class CarReviewModuleAlsoFromTest extends BaseTest {
    @Test(testName = "Verify That The UI Of Also From Section Is Displayed", dataProviderClass = CarUnderTest.class, dataProvider = "CarUnderTest")
    public void verifyThatTheUIOfAlsoFromSectionIsDisplay(String year, String make, String model, String zipcode) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation(year, make, model, zipcode);
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        Assert.assertTrue(carReviewDetailPage.verifyTitleAlsoFromSection(make),
                "Title of Also From section is not matched with default Also From [Make]");
    }

    @Test(testName = "Verify That The Browser Could Be Redirected To Car Review Page Of Item In The Also From List After Click On It", dataProviderClass = CarUnderTest.class, dataProvider = "CarUnderTest")
    public void verifyThatTheBrowserCouldBeRedirectedToCarReviewPageOfItemInTheAlsoFromListAfterClickOnIt(String year,
            String make, String model, String zipcode) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPage carReviewPage = new CarReviewPage(driver);
        carReviewPage.fillInformation(year, make, model, zipcode);
        CarReviewDetailPage carReviewDetailPage = new CarReviewDetailPage(driver);
        String titleOfSelectedItem = carReviewDetailPage.getTitleOfFirstItemInListAlsoFrom();
        carReviewDetailPage.clickOnFirstItemInListAlsoFrom();
        CarReviewDetailPageOfSelectedItemInAlsoFromSection
        carReviewDetailPageOfSelectedItemInAlsoFromSection = new
        CarReviewDetailPageOfSelectedItemInAlsoFromSection(driver);
        Assert.assertTrue(carReviewDetailPageOfSelectedItemInAlsoFromSection.verifyTitleOfBrowserAfterClickOnFirstItemInListAlsoFrom(titleOfSelectedItem),"Title is not matched with name of first item in list");
    }
}
