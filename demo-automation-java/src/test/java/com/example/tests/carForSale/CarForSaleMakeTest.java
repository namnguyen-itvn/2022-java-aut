package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleMake;
import com.example.pages.carForSale.CarsForSaleDetailVehicle;
import com.example.tests.BaseTest;

public class CarForSaleMakeTest extends BaseTest {
    @Test(testName = "Verify BMW should be displayed in Vehicle Detail Page when click on return result")
    public void verifyGoodPriceShouldBeDisplayedinVehicleDetailPageWhenClickOnReturnResult ()  
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleMake carForSaleMake = new CarForSaleMake(driver, "BMW");
        carForSaleMake.actionSelectOptMake();
        Assert.assertTrue(carForSaleMake.isAllMakeAfterClick());
    }

    @Test(testName = "Verify all element in Make filter should be displayed correct when first time navigate")
    public void verifyAllElementInMakeFilterShouldBeDisplayedCorrectWhenFirstTimeNavigate() throws InterruptedException  
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleMake carForSaleMake = new CarForSaleMake(driver, "BMW");
        Assert.assertTrue(carForSaleMake. isCheckBoxNotSelect());
    }

   
}
 
 		
