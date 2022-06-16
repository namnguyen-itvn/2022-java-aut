package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.MileageUnderTest;
import com.example.pages.BasePage;
import com.example.tests.BaseTest;
import com.example.pages.carForSale.CarsForSaleDetailVehicle;
import com.example.pages.carForSale.CarsForSaleMileage;

public class CarsForSaleMileageTests extends BaseTest{
    @Test(testName = "Verify default data of Mileage's dropdownlist is Any")
    public void verifyDefaultDataOfMileageDropdownlistIsAny ()
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        
        CarsForSaleMileage carsForSaleMileage = new CarsForSaleMileage(driver);
        carsForSaleMileage.actionClickBtnMileage();
        Assert.assertTrue(carsForSaleMileage.isSelectOptAnyCorrect());
    }

    @Test(testName = "Verify selected option in Mileage should be shown in Vehicle Detail Page when click on return result",dataProvider = "MileageUnderTest", dataProviderClass = MileageUnderTest.class)
    public void verifySelectedOptionInMileageShouldBeShownInVehicleDetailPageWhenClickOnReturnResult (String value)
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        
        CarsForSaleMileage carsForSaleMileage = new CarsForSaleMileage(driver);
        carsForSaleMileage.actionClickBtnMileage();
        carsForSaleMileage.actionSelectOptMileage(value);
        carsForSaleMileage.actionNavToCFSVehicleDetails();
        CarsForSaleDetailVehicle carsForSaleDetailVehicle = new CarsForSaleDetailVehicle(driver);
        Assert.assertTrue(carsForSaleDetailVehicle.isCarPriceCorectWithMileage(value));
    }
}
