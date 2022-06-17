package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarForSaleTestData;
import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleFuelEconomyPage;
import com.example.tests.BaseTest;

public class CarForSaleFuelEconomyTest extends BaseTest{
    @Test(testName = "Verify That Fuel Economy Filter Should Be Displayed Correct When User Scroll To It", dataProvider = "expectedFuelEconomyDataForTest", dataProviderClass = CarForSaleTestData.class)
    public void verifyThatFuelEconomyFilterShouldBeDisplayedCorrectWhenUserScrollToIt(String fuel_Economy){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleFuelEconomyPage carForSaleFuelEconomyPage = new CarForSaleFuelEconomyPage(driver);
        Assert.assertTrue(carForSaleFuelEconomyPage.isTheFuelEconomyFilterDisplayCorrect(fuel_Economy));
    }

    @Test(testName = "Verify That The Results Should Be Match With Chosen Fuel Economy Option", dataProvider = "fuelEconomyDataForTest", dataProviderClass = CarForSaleTestData.class)
    public void verifyThatTheResultsShouldBeMatchWithChosenFuelEconomyOption(String fuel){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleFuelEconomyPage carForSaleFuelEconomyPage = new CarForSaleFuelEconomyPage(driver);
        Assert.assertTrue(carForSaleFuelEconomyPage.isReturnTheResultOfFuelEconomyMatchWithOptionWasSelected(fuel));
    }
}
