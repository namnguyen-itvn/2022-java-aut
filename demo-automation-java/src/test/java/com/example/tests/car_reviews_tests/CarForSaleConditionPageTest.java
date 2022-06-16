package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleCarOptionPage;
import com.example.pages.carForSale.CarForSaleConditionPage;
import com.example.tests.BaseTest;

public class CarForSaleConditionPageTest extends BaseTest {
    @Test(testName = "Verify Results Displayed When User Choose New Option")

    public void VerifyResultsDisplayedWhenUserChooseNewOption() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleConditionPage conditionPage = new CarForSaleConditionPage(driver);
        conditionPage.actionExitAds();
        conditionPage.chooseOptionCondition("New");
        Assert.assertTrue(conditionPage.checkOptionCorrectDisplayed());
    }

    @Test(testName = "Verify Results Displayed When User Choose Used Option")

    public void VerifyResultsDisplayedWhenUserChooseUsedOption() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleConditionPage conditionPage = new CarForSaleConditionPage(driver);
        conditionPage.actionExitAds();
        conditionPage.chooseOptionCondition("Used");
        Assert.assertTrue(conditionPage.checkOptionCorrectDisplayed());
    }

    @Test(testName = "Verify MyWallet Have Three OpTion When User Choose New And CLick First Car")

    public void VerifyMyWalletHaveThreeOpTionWhenUserChooseNewAndCLickFirstCar() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleConditionPage conditionPage = new CarForSaleConditionPage(driver);
        conditionPage.actionExitAds();
        conditionPage.chooseOptionCondition("New");
        conditionPage.actionExitAds();
        conditionPage.chooseCar();
        CarForSaleCarOptionPage carOptionPage = new CarForSaleCarOptionPage(driver);
        Assert.assertTrue(carOptionPage.checkDisplayMyWallet());
        Assert.assertEquals(carOptionPage.getQuantityOfMyWallet(), 3);
    }

    @Test(testName = "Verify MyWallet Have Two OpTion When User Choose ManufacturerCertified And CLick First Car")

    public void VerifyMyWalletHaveTwoOpTionWhenUserChooseManufacturerCertifiedAndCLickFirstCar() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleConditionPage conditionPage = new CarForSaleConditionPage(driver);
        conditionPage.actionExitAds();
        conditionPage.chooseOptionCondition("ManufacturerCertified");
        conditionPage.actionExitAds();
        conditionPage.chooseCar();
        CarForSaleCarOptionPage carOptionPage = new CarForSaleCarOptionPage(driver);
        Assert.assertTrue(carOptionPage.checkDisplayMyWallet());
        Assert.assertEquals(carOptionPage.getQuantityOfMyWallet(), 2);
    }
}
