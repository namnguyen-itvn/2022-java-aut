package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.CylinderUnderTest;
import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleConditionPage;
import com.example.tests.BaseTest;

public class CarForSaleCylindersTest extends BaseTest {
    @Test(testName = "Verify Results Displayed When User Choose One Option At Home Services", dataProvider = "optionCylinders", dataProviderClass = CylinderUnderTest.class)
    public void VerifyResultsDisplayedWhenUserChooseOneOptioncylinders(String optionCylinders) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleConditionPage conditionPage = new CarForSaleConditionPage(driver);
        conditionPage.chooseOptionCylinders(optionCylinders);
        Assert.assertTrue(conditionPage.checkOptionCorrectDisplayed(), "false");
    }

    @Test(testName = "Verify That The Total Number Of See More Cylinder Results In Pop Up Should Be 12")
    public void VerifyThatTheTotalNumberOfSeeMoreCylinderResultsInPopUpShouldBe12() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleConditionPage conditionPage = new CarForSaleConditionPage(driver);
        conditionPage.chooseOptionCylinders("optionSeeMore");
        Assert.assertTrue(conditionPage.isTheNumberOfPopUpSeeMoreDisplayedCorrectAsRequired(),
                "false");
    }
}