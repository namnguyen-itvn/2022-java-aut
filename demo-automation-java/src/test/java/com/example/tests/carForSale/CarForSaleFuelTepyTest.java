package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarForSaleTestData;
import com.example.core.utils.listener.ReportListener;
import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleFuelTepyPage;
import com.example.tests.BaseTest;

@Listeners(ReportListener.class)
public class CarForSaleFuelTepyTest extends BaseTest{
    @Test(testName = "Verify That Fule Type Filter Display Correctly As Requirement")
    public void verifyThatFuleTypeFilterDisplayCorrectlyAsRequirement(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleFuelTepyPage carForSaleFuelTepyPage = new CarForSaleFuelTepyPage(driver);
        Assert.assertTrue(carForSaleFuelTepyPage.isFuleTypeFilterDisplayCorrectlyAsRequirement());
    }

    @Test(testName = "Verify That Return The Results Should Match With Fuel Type Selected", dataProvider = "fuelTypeData", dataProviderClass = CarForSaleTestData.class)
    public void verifyThatReturnTheResultsShouldMatchWithFuelTypeSelected(String fuel){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleFuelTepyPage carForSaleFuelTepyPage = new CarForSaleFuelTepyPage(driver);
        Assert.assertTrue(carForSaleFuelTepyPage.isReturnTheResultShouldMatchWithFuelTypeSelected(fuel));
    }
}
