package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.FeaturesUnderTest;
import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleConditionPage;
import com.example.tests.BaseTest;

public class CarForSaleFeaturesTest extends BaseTest {
    @Test(testName = "Verify Results Displayed When User Choose One Option Features", dataProvider = "optionFeatures", dataProviderClass = FeaturesUnderTest.class)
    public void VerifyResultsDisplayedWhenUserChooseOneOptionFeatures(String optionFeatures) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleConditionPage conditionPage = new CarForSaleConditionPage(driver);
        conditionPage.chooseOptionFeatures(optionFeatures);
        Assert.assertTrue(conditionPage.checkOptionCorrectDisplayed(), "false");
    }
}
