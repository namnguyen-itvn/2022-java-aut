package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarForSaleTestData;
import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleSellerTypeFilterPage;
import com.example.tests.BaseTest;

public class CarForSaleSellerTypeFilterTest extends BaseTest{
    
    @Test(testName = "Verify Seller Type Filter Is Not Extended")
    public void verifyDoorsFilterIsNotExtended() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSellerTypeFilterPage carForSaleSellerTypeFilterPage = new CarForSaleSellerTypeFilterPage(driver);
        Assert.assertTrue(carForSaleSellerTypeFilterPage.checkSellterTypeFilterShouldNotBeExtended());
    }

    @Test(testName = "Verify Seller Type Filter Should Be Extended After Click")
    public void verifySellerTypeFilterSHouldBeExtendedAfterClick() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSellerTypeFilterPage carForSaleSellerTypeFilterPage = new CarForSaleSellerTypeFilterPage(driver);
        Assert.assertTrue(carForSaleSellerTypeFilterPage.checkSellerTypeFilterShouldBeExtendedAfterClick());
    }

    @Test(testName = "Verify Seller Type Option Should Be Filtered After Choose", dataProvider = "typeSellerData", dataProviderClass = CarForSaleTestData.class)
    public void verifyDoorsOptionShouldBeFilteredAfterChoose(String option) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSellerTypeFilterPage carForSaleSellerTypeFilterPage = new CarForSaleSellerTypeFilterPage(driver);
        carForSaleSellerTypeFilterPage.chooseSellerTypeInSellerTypeFilter(option);
        Assert.assertTrue(carForSaleSellerTypeFilterPage.checkTypeSellersOptionShouldBeFilteredAfterChose(option));
    }
}
