package com.example.tests.car_for_sale_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.car_for_sale_pages.CarForSaleCarOptionPage;
import com.example.pages.car_for_sale_pages.CarForSaleConditionPage;
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

    @Test(testName = "Verify MyWallet Have Three OpTion When User Choose New And CLick First Car")

    public void VerifyMyWalletHaveTwoOpTionWhenUserChooseAndCLickFirstCar() {
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
