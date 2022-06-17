package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.carForSale.CarsForSaleDetailVehicle;
import com.example.pages.carForSale.CarsForSaleDriveType;
import com.example.tests.BaseTest;

public class CarsForSaleDriveTypeTests extends BaseTest {
    @Test(testName = "Verify Drive Type section UI and Result Number should display correct when select option in drive type")
    public void verifyDriveTypeSectionUIAndResultNumberShouldDisplayCorrectWhenSelectOptionInDrivetype ()  
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");

        CarsForSaleDriveType kbbCarsForSaleDriveType = new CarsForSaleDriveType(driver, "AWD/4WD");
        kbbCarsForSaleDriveType.actionSelectOptDriveType();
        Assert.assertTrue(kbbCarsForSaleDriveType.isAllDriveTypeAfterClick());
    }

    @Test(testName = "Verify selected option in Drive Type should be shown in Vehicle Detail Page when click on return result")
    public void verifySelectedOptionInDriveTypeShouldBeShownInVehicleDetailPageWhenClickOnReturnResult ()
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        
        CarsForSaleDriveType kbbCarsForSaleDriveType = new CarsForSaleDriveType(driver, "AWD/4WD");
        kbbCarsForSaleDriveType.actionSelectOptDriveType();
        kbbCarsForSaleDriveType.actionNavToCFSVehicleDetails();
        CarsForSaleDetailVehicle kbbCarsForSaleDetailVehicle = new CarsForSaleDetailVehicle(driver, "AWD/4WD");
        Assert.assertTrue(kbbCarsForSaleDetailVehicle.isTypeOfWheelDriveDisplayed());
    }

    @Test(testName = "Verify selected option in Drive Type should be shown in Vehicle Detail Page when click on return result")
    public void verifySelectedOptionInDriveTypeShouldBeShownInVehicleDetailPageWhenClickOnReturnResult2 ()
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        
        CarsForSaleDriveType kbbCarsForSaleDriveType = new CarsForSaleDriveType(driver, "AWD/4WD");
        kbbCarsForSaleDriveType.isCheckBoxNotSelect();
    }
}