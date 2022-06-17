package com.example.tests.carForSale;

import org.testng.annotations.Test;

import com.example.core.datadriven.CarForSaleTestData;
import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleSearchYearModulePage;
import com.example.tests.BaseTest;

public class CarForSaleSearchYearModuleTest extends BaseTest{
    @Test(testName = "Verify That Fuel Type Filter Should Be Displayed Correct When User Scroll To It")
    public void verifyThatFuelTypeFilterShouldBeDisplayedCorrectWhenUserScrollToIt(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchYearModulePage carForSaleSearchYearModulePage = new CarForSaleSearchYearModulePage(driver);
        carForSaleSearchYearModulePage.isTheYearFilterShouldBeDisplayedCorrectWhenUserScrollToIt();
    }

    @Test(testName = "Verify That The List Minimum Year Should Be Displayed When User Click On MiniMum Year Combobox.", priority = 2)
    public void verifyThatTheListMinimumYearShouldBeDisplayedWhenUserClickOnMinimumYearCombobox(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchYearModulePage carForSaleSearchYearModulePage = new CarForSaleSearchYearModulePage(driver);
        carForSaleSearchYearModulePage.isMiniMumYearListShowedWhenUserClickOnMiniMumYearCombobox();
    }

    @Test(testName = "Verify That The List Maximum Year Should Be Displayed When User Click On Maximum Year Combobox.", priority = 3)
    public void verifyThatTheListMaximumYearShouldBeDisplayedWhenUserClickOnMaximumYearCombobox(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchYearModulePage carForSaleSearchYearModulePage = new CarForSaleSearchYearModulePage(driver);
        carForSaleSearchYearModulePage.isMaximumYearListShowedWhenUserClickOnMaximumYearCombobox();
    }

    @Test(testName = "verify That Return The Result The Year Of Car Should Be Matched With Option Was Selected", dataProvider = "yearDataForTest", dataProviderClass = CarForSaleTestData.class, priority = 4)
    public void verifyThatReturnTheResultByYearShouldBeMatchedWithOptionWasSelected(String year){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchYearModulePage carForSaleSearchYearModulePage = new CarForSaleSearchYearModulePage(driver);
        carForSaleSearchYearModulePage.isTheYearFilterShouldBeDisplayedCorrectWhenUserScrollToIt(year);
    }
}
