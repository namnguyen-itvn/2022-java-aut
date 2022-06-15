package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.KbbCarsForSaleDetailVehicle;
import com.example.pages.KbbCarsForSaleDriveType;

public class KbbCarsForSaleDriveTypeTests extends BaseTest {
    @Test(testName = "Verify selected option in Drive Type should be shown in Vehicle Detail Page when click on return result")
    public void verifySelectedOptionInDriveTypeShouldBeShownInVehicleDetailPageWhenClickOnReturnResult ()  
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");

        KbbCarsForSaleDriveType kbbCarsForSaleDriveType = new KbbCarsForSaleDriveType(driver, "AWD/4WD");
        kbbCarsForSaleDriveType.actionSelectOptDriveType();
        Assert.assertTrue(kbbCarsForSaleDriveType.isAllDriveTypeAfterClick());
    }
    @Test(testName = "Verify all check box of Drive Type shouldn't be selected")
    public void VerifyAllCheckBoxOfDriveTypeShouldnNotBeselected ()
    {
        
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        
        KbbCarsForSaleDriveType kbbCarsForSaleDriveType = new KbbCarsForSaleDriveType(driver, "AWD/4WD");
        kbbCarsForSaleDriveType.actionSelectOptDriveType();
        kbbCarsForSaleDriveType.actionNavToCFSVehicleDetails();
        KbbCarsForSaleDetailVehicle kbbCarsForSaleDetailVehicle = new KbbCarsForSaleDetailVehicle(driver, "AWD/4WD");
        Assert.assertTrue(kbbCarsForSaleDetailVehicle.isTypeOfWheelDriveDisplayed());
    }
}