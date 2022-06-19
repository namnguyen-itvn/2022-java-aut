package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.example.core.datadriven.CarForSaleTestData;

import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleBodyStyleFilterPage;
import com.example.tests.BaseTest;

public class CarForSaleBodyStyleFilterTest extends BaseTest {
    @Test(testName = "Verify Body Style On Filter Should Be Extended")
    public void verifyBodyStyleOnFilterShouldBeExtended() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleBodyStyleFilterPage carForSaleBodyStyleFilterPage = new CarForSaleBodyStyleFilterPage(driver);
        Assert.assertTrue(carForSaleBodyStyleFilterPage.checkBodyStyleOnFilterShouldBeExtended());
    }


    @Test(testName = "Verify Body Style Options On Filter Should Be Filted After Choose", dataProvider = "bodyStyleData", dataProviderClass = CarForSaleTestData.class)
    public void verifyBodyStyleOptionsOnFilterShouldBeFiltedAfterChoose(String option) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleBodyStyleFilterPage carForSaleBodyStyleFilterPage = new CarForSaleBodyStyleFilterPage(driver);
        carForSaleBodyStyleFilterPage.chooseOptionInBodyStyle(option);
        Assert.assertTrue(carForSaleBodyStyleFilterPage.checkBodyStyleOptionsOnFilterShouldBeFilteredAfterChose(option));

    }
}
