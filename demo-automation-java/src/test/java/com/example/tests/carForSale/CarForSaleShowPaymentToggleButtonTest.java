package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleShowPaymentToggleButtonPage;
import com.example.tests.BaseTest;

public class CarForSaleShowPaymentToggleButtonTest extends BaseTest {

    @Test(testName ="Verify Dialog Should Display On Show Payment Toggle Button When Website URL navigate to Car For Sale Page")
    public void verifyDialoShouldDisplayOngShowPaymentToggleButtonWhenWebsiteURLNavigateToCarForSalePage() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleShowPaymentToggleButtonPage carForSaleShowPaymentToggleButtonPage = new CarForSaleShowPaymentToggleButtonPage(driver);   
        Assert.assertTrue(carForSaleShowPaymentToggleButtonPage.checkShowPaymentDialogShouldBeDisplayed());
    }

    @Test(testName = "Verify Dialog Should Display On Show Payment Toggle Button Correctly When Website URL navigate to Car For Sale Page")
    public void verifyDialoShouldDisplayOngShowPaymentToggleButtonCorrectlyWhenWebsiteURLNavigateToCarForSalePage() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleShowPaymentToggleButtonPage carForSaleShowPaymentToggleButtonPage = new CarForSaleShowPaymentToggleButtonPage(driver);
        Assert.assertTrue(carForSaleShowPaymentToggleButtonPage.checkShowPaymentDialogShouldBeDisplayedCorrectly());
    }

    @Test(testName = "Verify After Click Link Not Now, The UI Of Page Should Display As Requirement")
    public void verifyAfterClickLinkNotNowTheUIOfPageShouldDisplayAsRequirement() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleShowPaymentToggleButtonPage carForSaleShowPaymentToggleButtonPage = new CarForSaleShowPaymentToggleButtonPage(driver);
        Assert.assertTrue(carForSaleShowPaymentToggleButtonPage.checkLinkNotNowWorkCorrectly());
    }

    @Test(testName = "Verify After Click Button Show Payment, The UI Of Page Should Display As Requirement")
    public void verifyAfterClickButtonShowPaymentTheUIOfPageShouldDisplayAsRequirement() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleShowPaymentToggleButtonPage carForSaleShowPaymentToggleButtonPage = new CarForSaleShowPaymentToggleButtonPage(driver);
        Assert.assertTrue(carForSaleShowPaymentToggleButtonPage.checkButtonShowPaymentWorkCorrectly());
    }
}
