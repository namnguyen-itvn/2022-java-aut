package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarForSaleTestData;
import com.example.core.utils.listener.ReportListener;
import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleSearchLocationPage;
import com.example.tests.BaseTest;

@Listeners(ReportListener.class)
public class CarForSaleSearchLocationTest extends BaseTest{
    @Test(testName = "Verify Search Location Filter Should Be Displayed Correct When User Scroll To It")
    public void verifySearchLocationFilterShouldBeDisplayedCorrectWhenUserScrollToIt(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchLocationPage carForSaleSearchLocationPage = new CarForSaleSearchLocationPage(driver);
        Assert.assertTrue(carForSaleSearchLocationPage.isSearchLocationIsDisplayCorrect());
    }

    @Test(testName = "Verify That The List Distance Should Be Displayed When User Click On Distance Combobox", dataProvider = "expectedDistanceData", dataProviderClass = CarForSaleTestData.class)
    public void verifyThatTheListDistanceShouldBeDisplayedWhenUserClickOnDistanceCombobox(String expectedDistance){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchLocationPage carForSaleSearchLocationPage = new CarForSaleSearchLocationPage(driver);
        Assert.assertTrue(carForSaleSearchLocationPage.isDistanceListShowedWhenUserClickOnDistanceCombobox(expectedDistance));
    }

    @Test(testName = "verify That Return The Result Of Distance Should Be Matched With Option Was Selected", dataProvider = "distanceDataForTest", dataProviderClass = CarForSaleTestData.class)
    public void verifyThatReturnTheResultOfDistanceShouldBeMatchedWithOptionWasSelected(String distance_Miles){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchLocationPage carForSaleSearchLocationPage = new CarForSaleSearchLocationPage(driver);
        Assert.assertTrue(carForSaleSearchLocationPage.isReturnTheResultOfDistanceMatchWithOptionWasSelected(distance_Miles));
    }

    @Test(testName = "verify That Return The Result Of Zip Code Should Be Matched With Option Was Selected", dataProvider = "zipCodeDataForTest", dataProviderClass = CarForSaleTestData.class)
    public void verifyThatReturnTheResultOfZipCodeShouldBeMatchedWithOptionWasSelected(String zipCode) throws Exception{
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchLocationPage carForSaleSearchLocationPage = new CarForSaleSearchLocationPage(driver);
        Assert.assertTrue(carForSaleSearchLocationPage.isReturnTheResultOfZipCodeMatchWithOptionWasSelected(zipCode));
    }
}
