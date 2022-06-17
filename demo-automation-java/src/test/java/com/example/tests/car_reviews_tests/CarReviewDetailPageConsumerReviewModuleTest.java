package com.example.tests.car_reviews_tests;

import com.example.core.datadriven.InfoCarReviewUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewDetailPageConsumerReviewModule;
import com.example.pages.car_reviews_pages.CarReviewPageConsumerReviewModule;
import com.example.pages.car_reviews_pages.ConsumerReviewPage;
import com.example.pages.car_reviews_pages.WriteAReviewPage;
import com.example.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarReviewDetailPageConsumerReviewModuleTest extends BaseTest {
    private void closePopUp() {
        try {
            keyword.click(keyword.waitForElementToBeClickable(driver.findElement(By.xpath("//button[@aria-label='Close']"))));
        } catch (Exception e) {
        }
        try {
            keyword.click(keyword.waitForElementToBeClickable(driver.findElement(By.cssSelector("#fsrFocusFirst"))));
        } catch (Exception e) {
        }
    }

    private void actionGetReviewAndNavigateToCarDetailPAge(String year, String make, String model, String zipCode) throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPageConsumerReviewModule carReviewPageConsumerReviewModule = new CarReviewPageConsumerReviewModule(driver);
        closePopUp();
        carReviewPageConsumerReviewModule.inputAndSubmitGetCarReview(year, make, model, zipCode);
    }

    @Test(testName = "Verify that the title of section consumer review should be \"[Year] [Make] [Model] KBB.com Consumer Reviews\"",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyTheTitleOfSectionConsumerReview(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPAge(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isTheTitleOfConsumerReviewCorrect(year, make, model));
    }

    @Test(testName = "Verify that by default the application should display six reviews",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyDefaultPageShowSixReviews(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPAge(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isDefaultPageShowSixReviews());
    }

    @Test(testName = "Verify that the browser should navigate to Write Review page when click on \"Write a Review\" button",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyBrowserNavigateToWriteReviewPageWhenClickWriteAReviewButton(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPAge(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        closePopUp();
        carReviewDetailPageConsumerReviewModule.clickWriteAReviewButton();
        WriteAReviewPage writeAReviewPage = new WriteAReviewPage(driver);
        Assert.assertTrue(writeAReviewPage.asserScopeWriteReviewPageDefault(year, make, model));
    }

    @Test(testName = "Verify that the Like icon should be clickable",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyTheLikeIconShouldBeClickable(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPAge(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        closePopUp();
        carReviewDetailPageConsumerReviewModule.clickToSeeFullReview();
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isLikeIconClickable(0));
    }

    @Test(testName = "Verify that the Dislike icon should be clickable",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyTheDislikeIconShouldBeClickable(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPAge(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        closePopUp();
        carReviewDetailPageConsumerReviewModule.clickToScrollToConsumerReviewSection();
        carReviewDetailPageConsumerReviewModule.clickToSeeFullReview();
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isDislikeIconClickable(0));
    }

    @Test(testName = "Verify that when user click on \"Based on [X] Reviews\" or \"See All [X] Reviews\" should navigate to consumer review page",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyNavigateToConsumerReviewPage(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPAge(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        closePopUp();
        carReviewDetailPageConsumerReviewModule.clickToScrollToConsumerReviewSection();
        carReviewDetailPageConsumerReviewModule.clickBtnBaseOnConsumerReview();
        ConsumerReviewPage consumerReviewPage = new ConsumerReviewPage(driver);
        Assert.assertTrue(consumerReviewPage.asserScopeConsumerReviewPageDefault(year, make, model));
    }
}
