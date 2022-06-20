package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSaleSortDropDownListPage;
import com.example.tests.BaseTest;

public class CarForSaleSortDropDownListTest extends BaseTest {   
    @Test(testName = "Verify Sort Dropdown List Should Display 'Relevance' As Default")
    public void verifySortDropDownListShouldDisplayRelevanceAsDefault() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSaleSortDropDownListPage carForSaleSortDropDownListPage = new CarForSaleSortDropDownListPage(driver);
        Assert.assertTrue(carForSaleSortDropDownListPage.checkSortDropDownListIsDisplayedRevalanceAsDefault());
    }

    //*******************Issue *****************************/
    
    // @Test(testName = "Verify Sort Dropdown List Should Be Sorted By Chosen Option")
    // public void verifySortDropdownListShouldBeSortedByChosenOption() throws NumberFormatException, IOException {
    //     BasePage basePage = new BasePage(driver);
    //     basePage.navigateToPage("Sale");
    //     CarForSaleSortDropDownListPage carForSaleSortDropDownListPage = new CarForSaleSortDropDownListPage(driver);
    //     Assert.assertTrue(carForSaleSortDropDownListPage.checkSortDropdownListIsSortedByChosenSortOptionExpectSponsoredCars());
    // }
}
