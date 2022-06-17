package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.carForSale.CarsForSaleDetailPage;
import com.example.pages.carForSale.CarsForSalePage;
import com.example.tests.BaseTest;

public class CarsForSaleTest extends BaseTest{
    @Test(testName = "Verify The Transmission Module Interface Should Be Properly Displayed By Default")
    public void verifyTheTransmissionModuleInterfaceShouldBeProperlyDisplayedByDefault() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarsForSalePage carForSalePage = new CarsForSalePage(driver);
        Assert.assertTrue(carForSalePage.isTransmissionDisplayed());
    }

    @Test(testName = "Verify The Results Transmission Module Returns Should Be Displayed With The Selected Mode")
    public void verifyTheResultsTransmissionModuleReturnsShouldBeDisplayedWithTheSelectedMode() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarsForSalePage carForSalePage = new CarsForSalePage(driver);
        carForSalePage.isTransmissionNavigation();
        CarsForSaleDetailPage carSearchDetailPage = new CarsForSaleDetailPage(driver);
        Assert.assertTrue(carSearchDetailPage.isTransmissionResult());
    }
}
