package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.CarForSalePage;

public class CarForSaleSearchModuleTest extends BaseTest{
    @Test(testName = "Verify top of the page section should be displayed correct when first time navigate")
    public void verifyTopOfThePageSectionShouldBeDisplayedCorrectWhenFirstTimeNavigate(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSalePage carForSalePage = new CarForSalePage(driver);
        Assert.assertTrue(carForSalePage.isTheTopOfTheCarForSalePageSectionDisplayedAsDefault());
    }

    @Test(testName = "Verify Filter Sort Result Should Be Displayed As Default")
    public void verifyFilterSortResultShouldBeDisplayedAsDefault(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSalePage carForSalePage = new CarForSalePage(driver);
        carForSalePage.isFilterSoftValueDisplayedCorrect();
    }

    @Test(testName = "Verify That The total number of car item results in one page should be 25")
    public void verifyThatThetotalNumberOfCarItemResultsInOnePageShouldBe25(){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSalePage carForSalePage = new CarForSalePage(driver);
        Assert.assertTrue(carForSalePage.isTheNumberOfCarCardItemDisplayedCorrectAsRequired());
    }
}
