package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSalePriceRating;
import com.example.tests.BaseTest;

public class CarForSalePriceRatingTest extends BaseTest {
    @Test(testName = "Verify Good Price should be displayed in Vehicle Detail Page when click on return result")
    public void verifyGoodPriceShouldBeDisplayedinVehicleDetailPageWhenClickOnReturnResult ()  
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSalePriceRating carForSalePriceRating = new CarForSalePriceRating(driver, "Good Price");
        carForSalePriceRating.actionSelectOptPriceRating();
        Assert.assertTrue(carForSalePriceRating.isAllPriceRatingAfterClick());
    }

    @Test(testName = "Verify all element in Price Rating filter should be displayed correct when first time navigate")
    public void verifyAllElementInPriceRatingFilterShouldBeDisplayedCorrectWhenFirstTimeNavigate() throws InterruptedException  
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSalePriceRating carForSalePriceRating = new CarForSalePriceRating(driver, "Good Price");
        Assert.assertTrue(carForSalePriceRating. isCheckBoxNotSelect());
    }

    @Test(testName = "Verify title page of first car should be displayed in Vehicle Detail Page when click on return result")
    public void verifyTitlePageOfFirstCarShouldBbeDisplayedInVehicleDetailPageWhenClickOnReturnResult() throws InterruptedException  
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");

        CarForSalePriceRating carForSalePriceRating = new CarForSalePriceRating(driver, "Good Price");
        carForSalePriceRating.actionNavToCFSVehicleDetails();
        Assert.assertTrue(carForSalePriceRating.isTitleCorrected(carForSalePriceRating.expectedFirstCar));
    }
    
}
 
 		
