package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSalePage;
import com.example.pages.carForSale.CarSearchDetailPage;
import com.example.tests.BaseTest;

public class CarForSaleDetailTest extends BaseTest {
    @Test(testName = "Verify That Price Section Should Be Displayed As Default")
    public void verifyThatPriceSectionShouldBeDisplayedAsDefault() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        basePage.actionExitAds();

        CarForSalePage carForSalePage = new CarForSalePage(driver);
        carForSalePage.clickCarItem();
        basePage.actionExitAds();

        CarSearchDetailPage carSearchDetailPage = new CarSearchDetailPage(driver);
        carSearchDetailPage.scrollToPriceSection();
        Assert.assertTrue(carSearchDetailPage.isPriceDetailSectionDisplayedAsDefault());
    }

    @Test(testName = "Verify That Tab Fair Price Should Be Displayed As Default")
    public void verifyThatTabFairPriceShouldBeDisplayedAsDefault() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        basePage.actionExitAds();

        CarForSalePage carForSalePage = new CarForSalePage(driver);
        carForSalePage.clickCarItem();
        basePage.actionExitAds();

        CarSearchDetailPage carSearchDetailPage = new CarSearchDetailPage(driver);
        carSearchDetailPage.scrollToPriceSection();
        Assert.assertTrue(carSearchDetailPage.isTabFairMarketDisplayedAsDefault());
    }

    @Test(testName = "Verify That Tab Price Breakdown And Offers Should Be Displayed As Default")
    public void verifyThatTabPriceBreakdownAndOffersShouldBeDisplayedAsDefault(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        basePage.actionExitAds();

        CarForSalePage carForSalePage = new CarForSalePage(driver);
        carForSalePage.clickCarItem();
        basePage.actionExitAds();

        CarSearchDetailPage carSearchDetailPage = new CarSearchDetailPage(driver);
        carSearchDetailPage.scrollToPriceSection();
        carSearchDetailPage.clickTabPriceBreakDown();
        Assert.assertTrue(carSearchDetailPage.isTabPriceBreakdownDisplayedAsDefault());
    }

    @Test(testName = "Verify That Listing Price Should Be Equal With First Price")
    public void verifyThatListingPriceShouldBeEqualWithFirstPrice(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        basePage.actionExitAds();

        CarForSalePage carForSalePage = new CarForSalePage(driver);
        carForSalePage.clickCarItem();
        basePage.actionExitAds();

        CarSearchDetailPage carSearchDetailPage = new CarSearchDetailPage(driver);
        String firstPriceValue = carSearchDetailPage.getFirstPriceValue();
        carSearchDetailPage.scrollToPriceSection();
        carSearchDetailPage.clickTabPriceBreakDown();
        System.out.println(firstPriceValue);
        Assert.assertTrue(carSearchDetailPage.isListingPriceEqualWithFirstPrice(firstPriceValue));
    }
}
