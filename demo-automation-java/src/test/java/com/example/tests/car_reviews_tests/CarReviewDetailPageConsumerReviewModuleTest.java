package com.example.tests.car_reviews_tests;

import com.example.core.datadriven.InfoCarReviewUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewDetailPageConsumerReviewModule;
import com.example.pages.car_reviews_pages.CarReviewPageConsumerReviewModule;
import com.example.pages.car_reviews_pages.ConsumerReviewPage;
import com.example.pages.car_reviews_pages.WriteAReviewPage;
import com.example.tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarReviewDetailPageConsumerReviewModuleTest extends BaseTest {

    private void actionGetReviewAndNavigateToCarDetailPage(String year, String make, String model, String zipCode) throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        CarReviewPageConsumerReviewModule carReviewPageConsumerReviewModule = new CarReviewPageConsumerReviewModule(driver);
        carReviewPageConsumerReviewModule.inputAndSubmitGetCarReview(year, make, model, zipCode);
    }

    @Test(testName = "Verify that the title of section consumer review should be \"[Year] [Make] [Model] KBB.com Consumer Reviews\"",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyTheTitleOfSectionConsumerReview(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPage(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isTheTitleOfConsumerReviewCorrect(year, make, model));
    }

    @Test(testName = "Verify that by default the application should display six reviews",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyDefaultPageShowSixReviews(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPage(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isDefaultPageShowSixReviews());
    }

    @Test(testName = "Verify that the browser should navigate to Write Review page when click on \"Write a Review\" button",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyBrowserNavigateToWriteReviewPageWhenClickWriteAReviewButton(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPage(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        carReviewDetailPageConsumerReviewModule.clickWriteAReviewButton();
        WriteAReviewPage writeAReviewPage = new WriteAReviewPage(driver);
        Assert.assertTrue(writeAReviewPage.asserScopeWriteReviewPageDefault(year, make, model));
    }

    @Test(testName = "Verify that the Like icon should be clickable",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyTheLikeIconShouldBeClickable(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPage(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        carReviewDetailPageConsumerReviewModule.clickToSeeFullReview();
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isLikeIconClickable(0));
    }

    @Test(testName = "Verify that the Dislike icon should be clickable",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyTheDislikeIconShouldBeClickable(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPage(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        carReviewDetailPageConsumerReviewModule.clickToScrollToConsumerReviewSection();
        carReviewDetailPageConsumerReviewModule.clickToSeeFullReview();
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isDislikeIconClickable(0));
    }

    @Test(testName = "Verify that when user click on \"Based on [X] Reviews\" or \"See All [X] Reviews\" should navigate to consumer review page",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyNavigateToConsumerReviewPage(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPage(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        carReviewDetailPageConsumerReviewModule.clickToScrollToConsumerReviewSection();
        carReviewDetailPageConsumerReviewModule.clickBtnBaseOnConsumerReview();
        ConsumerReviewPage consumerReviewPage = new ConsumerReviewPage(driver);
        Assert.assertTrue(consumerReviewPage.asserScopeConsumerReviewPageDefault(year, make, model));
    }

    @Test(testName = "Verify the Score rated match with average of Percent Per Star",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyTheScoreRatedShouldMatchWithAverageOfPercentPerStar(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPage(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        carReviewDetailPageConsumerReviewModule.clickToScrollToConsumerReviewSection();
        carReviewDetailPageConsumerReviewModule.clickToSeeFullReview();
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isScoreRatedEqualAverageOfPercentPerStar());
    }

    @Test(testName = "Verify that the Rated star of reviews are matching with the star of filter when user filter by star ",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyTheRatedStarOfReviewsMatchWithFilter(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPage(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        carReviewDetailPageConsumerReviewModule.clickToScrollToConsumerReviewSection();
        carReviewDetailPageConsumerReviewModule.clickToSeeFullReview();
        carReviewDetailPageConsumerReviewModule.clickToChooseFilterByStar(4);
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isRatedStarOfReviewsMatchWithTheStarUserChoose(4));
    }

    @Test(testName = "Verify that the application clear the filter when user click on Clear filter ",
        dataProviderClass = InfoCarReviewUnderTest.class, dataProvider = "InfoCarReviewUnderTest")
    public void verifyTheFilterClearedWhenUserClickOnClearFilter(String year, String make, String model, String zipCode) throws Exception {
        actionGetReviewAndNavigateToCarDetailPage(year, make, model, zipCode);
        CarReviewDetailPageConsumerReviewModule carReviewDetailPageConsumerReviewModule = new CarReviewDetailPageConsumerReviewModule(driver);
        carReviewDetailPageConsumerReviewModule.clickToScrollToConsumerReviewSection();
        carReviewDetailPageConsumerReviewModule.clickToSeeFullReview();
        String expectedInfoFilterBeforeClickFilter =
            carReviewDetailPageConsumerReviewModule.getText(carReviewDetailPageConsumerReviewModule.lblFilterInfo);
        carReviewDetailPageConsumerReviewModule.clickToChooseFilterByTrendingTopic("Looks");
        carReviewDetailPageConsumerReviewModule.clickOnClearFilter();
        Assert.assertTrue(carReviewDetailPageConsumerReviewModule.isTheFilterCleared("Looks", expectedInfoFilterBeforeClickFilter));
    }

}
