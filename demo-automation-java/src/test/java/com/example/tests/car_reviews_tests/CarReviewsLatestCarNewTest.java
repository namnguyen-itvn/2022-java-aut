package com.example.tests.car_reviews_tests;

import com.example.pages.*;
import com.example.pages.car_reviews_pages.AboutTheKelleyBlueBookNewCarReviewsPage;
import com.example.pages.car_reviews_pages.LatestCarNewPage;
import com.example.pages.car_reviews_pages.PopularNewCarsandTrucksPage;
import com.example.pages.car_reviews_pages.PopularNewMakesPage;
import com.example.pages.car_reviews_pages.ShopForTopRatedCarsPage;
import com.example.tests.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CarReviewsLatestCarNewTest extends BaseTest {
    @Test(testName = "Verify that module LatestCarNews displayed list six article and link")
    public void verifThatModuleLatestCarNewsDisplayedListSixArticleAndLink() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        LatestCarNewPage latestCarNewPage = new LatestCarNewPage(driver);      
        Assert.assertTrue(latestCarNewPage.isDisplayedActicle());
    }
    @Test(testName = "Verify that link 'See All Latest News' in module Latest Car News should be clickable.")
    public void verifyThatLinkSeeAllLatestNewsinModuleLatestCarNewsShouldBeClickable() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        LatestCarNewPage latestCarNewPage = new LatestCarNewPage(driver);
        latestCarNewPage.isClickOnLinkSeeAll();
        Assert.assertTrue(latestCarNewPage.isClickOnLinkSeeAllCorrect());
    }

    @Test(testName = "Verify that content 'About the Kelley Blue Book New Car Reviews Page' should be displayed with the short description about it")
    public void verifyThatContentAboutTheKelleyBlueBookNewCarReviewsPageShouldBeDisplayedWithTheShortDescriptionAboutIt() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        AboutTheKelleyBlueBookNewCarReviewsPage aboutTheKelleyBlueBookNewCarReviewsPage = new AboutTheKelleyBlueBookNewCarReviewsPage(driver);
        Assert.assertTrue(aboutTheKelleyBlueBookNewCarReviewsPage.isDisplayedContent());
    }
    @Test(testName = "Verify that module search Shop for Top Rated Cars should be displayed twelve item")
    public void verifyThatModuleSearchShopforTopRatedCarsShouldBeDisplayedTwelveItem() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        ShopForTopRatedCarsPage shopForTopRatedCarsPage = new ShopForTopRatedCarsPage (driver);
        Assert.assertTrue(shopForTopRatedCarsPage.isDisplayedTopRatedCarsPage());
    }

    @Test(testName = "Verify that brand name in module search Shop for Top Rated Cars should be clickable")
    public void verifyThatBrandNameInModuleSearchShopforTopRatedCarsShouldbeClickable() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        ShopForTopRatedCarsPage shopForTopRatedCarsPage = new ShopForTopRatedCarsPage (driver);
        shopForTopRatedCarsPage.isClickOnItem();
        Assert.assertTrue(shopForTopRatedCarsPage.isClickOnFordItemCorrect());
    }

    @Test(testName = "Verify that module search Popular New Makes should be displayed twenty-four item")
    public void verifyThatModulePopularNewMakesShouldBeDisplayedTwentyfourItem() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        PopularNewMakesPage popularNewMakesPage = new PopularNewMakesPage (driver);
        Assert.assertTrue(popularNewMakesPage.isDisplayedPopularNewMakesPage());
    }

    @Test(testName = "Verify that brand name in module search 'Popular New Makes' should be clickable.")
    public void verifyThatBrandNameInModuleSearchPopularNewMakesShouldbeClickable() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        PopularNewMakesPage popularNewMakesPage = new PopularNewMakesPage (driver);
        popularNewMakesPage.isClickOnJeepItem();
        Assert.assertTrue(popularNewMakesPage.isClickOnJeepItemCorrect());
    }

    @Test(testName = "Verify that module search Popular New Cars and Trucks should be displayed twenty-four item")
    public void verifyThatModulePopularNewCarsAndTrucksShouldBeDisplayedTwentyfourItem() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        PopularNewCarsandTrucksPage popularNewCarsandTrucksPage = new PopularNewCarsandTrucksPage (driver);
        Assert.assertTrue(popularNewCarsandTrucksPage.isDisplayedPopularNewCarsandTrucksPage());
    }

    @Test(testName = "Verify that brand name in module search 'Popular New Cars and Trucks' should be clickable.")
    public void verifyThatBrandNameInModuleSearchPopularNewCarsAndTrucksShouldbeClickable() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
        PopularNewCarsandTrucksPage popularNewCarsandTrucksPage = new PopularNewCarsandTrucksPage (driver);
        popularNewCarsandTrucksPage.isClickOnFordF150Item();
        Assert.assertTrue(popularNewCarsandTrucksPage.isClickOnFordF150ItemCorrect());
    }

}
