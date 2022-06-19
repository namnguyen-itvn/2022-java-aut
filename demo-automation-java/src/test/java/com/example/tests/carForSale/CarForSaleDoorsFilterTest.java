package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarForSaleTestData;
import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleDoorsFilterPage;
import com.example.tests.BaseTest;

public class CarForSaleDoorsFilterTest extends BaseTest {
    @Test(testName = "Verify Doors Filter Is Not Extended")
    public void verifyDoorsFilterIsNotExtended() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleDoorsFilterPage carForSaleDoorsFilterPage = new CarForSaleDoorsFilterPage(driver);
        Assert.assertTrue(carForSaleDoorsFilterPage.checkDoorsFilterShouldNotBeExtended());
    }

    @Test(testName = "Verify Doors Filter Should Be Extended After Click")
    public void verifyDoorsFilterSHouldBeExtendedAfterClick() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleDoorsFilterPage carForSaleDoorsFilterPage = new CarForSaleDoorsFilterPage(driver);
        Assert.assertTrue(carForSaleDoorsFilterPage.checkDoorsFilterShouldBeExtendedAfterClick());
    }

    @Test(testName = "Verify Doors Option Should Be Filtered After Choose", dataProvider = "doorsData", dataProviderClass = CarForSaleTestData.class)
    public void verifyDoorsOptionShouldBeFilteredAfterChoose(String option) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleDoorsFilterPage carForSaleDoorsFilterPage = new CarForSaleDoorsFilterPage(driver);
        carForSaleDoorsFilterPage.chooseDoorsInDoorFilter(option);
        Assert.assertTrue(carForSaleDoorsFilterPage.checkDoorsOptionShouldBeFilteredAfterChose(option));
    }
}
