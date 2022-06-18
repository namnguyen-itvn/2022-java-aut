package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.example.core.datadriven.DriveTypeUnderTest;
import com.example.core.utils.listener.ReportListener;
import com.example.pages.BasePage;
import com.example.pages.carForSale.CarsForSaleDetailVehicle;
import com.example.pages.carForSale.CarsForSaleDriveType;
import com.example.tests.BaseTest;

@Listeners(ReportListener.class)
public class CarsForSaleDriveTypeTests extends BaseTest {
    @Test(testName = "Verify Drive Type section UI and Result Number should display correct when select option in drive type",dataProvider = "DriveTypeUnderTest", dataProviderClass = DriveTypeUnderTest.class)
    public void verifyDriveTypeSectionUIAndResultNumberShouldDisplayCorrectWhenSelectOptionInDrivetype (String DriveType)  
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");

        CarsForSaleDriveType kbbCarsForSaleDriveType = new CarsForSaleDriveType(driver);
        kbbCarsForSaleDriveType.actionSelectOptDriveType(DriveType);
        Assert.assertTrue(kbbCarsForSaleDriveType.isAllDriveTypeAfterClick(DriveType));
    }

    @Test(testName = "Verify selected option in Drive Type should be shown in Vehicle Detail Page when click on return result",dataProvider = "DriveTypeUnderTest", dataProviderClass = DriveTypeUnderTest.class)
    public void verifySelectedOptionInDriveTypeShouldBeShownInVehicleDetailPageWhenClickOnReturnResult (String DriveType)
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        
        CarsForSaleDriveType kbbCarsForSaleDriveType = new CarsForSaleDriveType(driver);
        kbbCarsForSaleDriveType.actionSelectOptDriveType(DriveType);
        kbbCarsForSaleDriveType.actionNavToCFSVehicleDetails();
        CarsForSaleDetailVehicle kbbCarsForSaleDetailVehicle = new CarsForSaleDetailVehicle(driver);
        Assert.assertTrue(kbbCarsForSaleDetailVehicle.isTypeOfWheelDriveDisplayed(DriveType));
    }

}