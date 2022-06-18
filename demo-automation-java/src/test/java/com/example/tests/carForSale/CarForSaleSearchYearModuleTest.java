package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarForSaleTestData;
import com.example.core.utils.listener.ReportListener;
import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleSearchYearModulePage;
import com.example.tests.BaseTest;

@Listeners(ReportListener.class)
public class CarForSaleSearchYearModuleTest extends BaseTest{
    @Test(testName = "Verify That Fuel Type Filter Should Be Displayed Correct When User Scroll To It")
    public void verifyThatFuelTypeFilterShouldBeDisplayedCorrectWhenUserScrollToIt(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchYearModulePage carForSaleSearchYearModulePage = new CarForSaleSearchYearModulePage(driver);
        Assert.assertTrue(carForSaleSearchYearModulePage.isTheYearFilterShouldBeDisplayedCorrectWhenUserScrollToIt());
    }

    @Test(testName = "Verify That The List Minimum Year Should Be Displayed When User Click On MiniMum Year Combobox", dataProvider = "expectedYearData", dataProviderClass = CarForSaleTestData.class)
    public void verifyThatTheListMinimumYearShouldBeDisplayedWhenUserClickOnMinimumYearCombobox(String years){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchYearModulePage carForSaleSearchYearModulePage = new CarForSaleSearchYearModulePage(driver);
        Assert.assertTrue(carForSaleSearchYearModulePage.isMiniMumYearListShowedWhenUserClickOnMiniMumYearCombobox(years));
    }

    @Test(testName = "Verify That The List Maximum Year Should Be Displayed When User Click On Maximum Year Combobox", dataProvider = "expectedYearData", dataProviderClass = CarForSaleTestData.class)
    public void verifyThatTheListMaximumYearShouldBeDisplayedWhenUserClickOnMaximumYearCombobox(String year){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchYearModulePage carForSaleSearchYearModulePage = new CarForSaleSearchYearModulePage(driver);
        Assert.assertTrue(carForSaleSearchYearModulePage.isMaximumYearListShowedWhenUserClickOnMaximumYearCombobox(year));
    }

    @Test(testName = "verify That Return The Result The Year Of Car Should Be Matched With Option Was Selected", dataProvider = "yearDataForTest", dataProviderClass = CarForSaleTestData.class)
    public void verifyThatReturnTheResultByYearShouldBeMatchedWithOptionWasSelected(String year){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchYearModulePage carForSaleSearchYearModulePage = new CarForSaleSearchYearModulePage(driver);
        Assert.assertTrue(carForSaleSearchYearModulePage.isTheYearFilterShouldBeDisplayedCorrectWhenUserScrollToIt(year));
    }

    @Test(testName = "verify That Return The Result The Year Of Car Should Be Matched With Option Was Selected", dataProvider = "yearDataForTest", dataProviderClass = CarForSaleTestData.class)
    public void verifyThatTheYearSelectedShouldBeDisplayedInTheMessageOnVehicleDetailsPageWhenUserClickOnCarItem(String year){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSearchYearModulePage carForSaleSearchYearModulePage = new CarForSaleSearchYearModulePage(driver);
        Assert.assertTrue(carForSaleSearchYearModulePage.isYearSelectedDisplayInTheMessageOnVehicleDetailsPage(year));
    }
}
