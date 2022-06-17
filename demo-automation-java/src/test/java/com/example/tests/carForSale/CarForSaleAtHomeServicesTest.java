package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.AtHomeServicesUnderTest;
import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleConditionPage;
import com.example.tests.BaseTest;

public class CarForSaleAtHomeServicesTest extends BaseTest {
    @Test(testName = "Verify Results Displayed When User Choose One Option", dataProvider = "optionAtHomeServices", dataProviderClass = AtHomeServicesUnderTest.class)
    public void VerifyResultsDisplayedWhenUserChooseOneOption(String optionAtHomeServices) throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleConditionPage conditionPage = new CarForSaleConditionPage(driver);
        // conditionPage.actionExitAds();
        conditionPage.chooseOptionAtHomeSerVices(optionAtHomeServices);
        Assert.assertTrue(conditionPage.checkOptionCorrectDisplayed(), "false");
    }
}
