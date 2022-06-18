package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.core.datadriven.PriceAndPaymentUnderTest;
import com.example.core.utils.listener.ReportListener;
import com.example.pages.BasePage;
import com.example.tests.BaseTest;
import com.example.pages.carForSale.CarsForSaleDetailVehicle;
import com.example.pages.carForSale.CarsForSalePriceAndPayment;

@Listeners(ReportListener.class)
public class CarsForSalePriceAndPaymentTests extends BaseTest{
    @Test(testName = "Verify defaul display of Price & Payment")
    public void verifyDefaulDisplayOfPriceAndPayment ()
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        
        CarsForSalePriceAndPayment carsForSalePriceAndPayment = new CarsForSalePriceAndPayment(driver);
        Assert.assertTrue(carsForSalePriceAndPayment.isMaxMinPriceTextHintCorrect());
    }

    @Test(testName = "Verify PriceCar In The Vehicle Detail Page Should Match With Demo Data For Min PriceAnd Max PriceOf Price And Payment ",dataProvider = "PriceAndPaymentUnderTest", dataProviderClass = PriceAndPaymentUnderTest.class)
    public void verifyPriceCarInTheVehicleDetailPageShouldMatchWithDemoDataForMinPriceAndMaxPriceOfPriceAndPayment (String min,String max)
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        
        CarsForSalePriceAndPayment carsForSalePriceAndPayment = new CarsForSalePriceAndPayment(driver);
        carsForSalePriceAndPayment.actionSetPrice(min, max);
        carsForSalePriceAndPayment.actionNavToCFSVehicleDetails();
        CarsForSaleDetailVehicle carsForSaleDetailVehicle = new CarsForSaleDetailVehicle(driver);
        Assert.assertTrue(carsForSaleDetailVehicle.isCarPriceCorectWithPricePayment(min, max));
    }

}
