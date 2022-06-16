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
    @Test(testName = "Verify Search Location Filter Should Be Displayed Correct When User Scroll To It", priority = 1)
    public void verifySearchLocationFilterShouldBeDisplayedCorrectWhenUserScrollToIt(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchLocationPage carForSaleSearchLocationPage = new CarForSaleSearchLocationPage(driver);
        Assert.assertTrue(carForSaleSearchLocationPage.isSearchLocationIsDisplayCorrect());
    }

    @Test(testName = "Verify That The List Distance Should Be Displayed When User Click On Distance Combobox.", priority = 2)
    public void verifyThatTheListDistanceShouldBeDisplayedWhenUserClickOnDistanceCombobox(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchLocationPage carForSaleSearchLocationPage = new CarForSaleSearchLocationPage(driver);
        Assert.assertTrue(carForSaleSearchLocationPage.isDistanceListShowedWhenUserClickOnDistanceCombobox());
    }

    @Test(testName = "verify That Return The Result Of Destance Should Be Matched With Option Was Selected", dataProvider = "distanceData", dataProviderClass = CarForSaleTestData.class, priority = 3)
    public void verifyThatReturnTheResultOfDestanceShouldBeMatchedWithOptionWasSelected(String distance_Miles){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchLocationPage carForSaleSearchLocationPage = new CarForSaleSearchLocationPage(driver);
        Assert.assertTrue(carForSaleSearchLocationPage.isReturnTheResultOfDestanceMatchWithOptionWasSelected(distance_Miles));
    }

    @Test(testName = "verify That Return The Result Of Zip Code Should Be Matched With Option Was Selected", dataProvider = "zipCodeData", dataProviderClass = CarForSaleTestData.class, priority = 4)
    public void verifyThatReturnTheResultOfZipCodeShouldBeMatchedWithOptionWasSelected(String zipCode) throws Exception{
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchLocationPage carForSaleSearchLocationPage = new CarForSaleSearchLocationPage(driver);
        Assert.assertTrue(carForSaleSearchLocationPage.isReturnTheResultOfZipCodeMatchWithOptionWasSelected(zipCode));
    }
}
