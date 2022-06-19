package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.carForSale.CarsForSaleTransmissionDetailPage;
import com.example.pages.carForSale.CarsForSaleTransmissionPage;
import com.example.tests.BaseTest;

public class CarsForSaleTransmissionTest extends BaseTest{
    @Test(testName = "Verify The Transmission Module Interface Should Be Properly Displayed By Default")
    public void verifyTheTransmissionModuleInterfaceShouldBeProperlyDisplayedByDefault() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarsForSaleTransmissionPage carForSaleTransmssionPage = new CarsForSaleTransmissionPage(driver);
        Assert.assertTrue(carForSaleTransmssionPage.isTransmissionDisplayed());
    }

    @Test(testName = "Verify The Results Transmission Module Returns Should Be Displayed With The Selected Mode")
    public void verifyTheResultsTransmissionModuleReturnsShouldBeDisplayedWithTheSelectedMode() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarsForSaleTransmissionPage carForSaleTransmissionPage = new CarsForSaleTransmissionPage(driver);
        carForSaleTransmissionPage.isTransmissionNavigation();
        CarsForSaleTransmissionDetailPage carsForSaleTransmissionDetailPage = new CarsForSaleTransmissionDetailPage(driver);
        Assert.assertTrue(carsForSaleTransmissionDetailPage.isTransmissionResult());
    }
}
