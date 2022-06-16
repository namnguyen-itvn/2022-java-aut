package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.KeywordUnderTest;
import com.example.pages.BasePage;
import com.example.pages.carForSale.CarForSalePage;
import com.example.pages.carForSale.CarSearchDetailPage;
import com.example.tests.BaseTest;

public class CarForSaleSearchModuleTest extends BaseTest {
    @Test(testName = "Verify Top Of The Page Section Should Be Displayed Correct When First Time Navigate")
    public void verifyTopOfThePageSectionShouldBeDisplayedCorrectWhenFirstTimeNavigate() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSalePage carForSalePage = new CarForSalePage(driver);
        Assert.assertTrue(carForSalePage.isTheTopOfTheCarForSalePageSectionDisplayedAsDefault());
    }

    @Test(testName = "Verify Filter Sort Result Should Be Displayed As Default")
    public void verifyFilterSortResultShouldBeDisplayedAsDefault() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSalePage carForSalePage = new CarForSalePage(driver);
        carForSalePage.isFilterSortValueListDisplayedCorrect();
    }

    @Test(testName = "Verify That The Total Number Of Car Item Results In One Page Should Be 25")
    public void verifyThatThetotalNumberOfCarItemResultsInOnePageShouldBe25() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSalePage carForSalePage = new CarForSalePage(driver);
        Assert.assertTrue(carForSalePage.isTheNumberOfCarCardItemDisplayedCorrectAsRequired());
    }

    @Test(testName = "Verify That User Can Navigate To Vehicle Detail When Clicking On Car Item")
    public void verifyThatUserCanNavigateToVehicleDetailPageWhenClickingOnCarItem() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSalePage carForSalePage = new CarForSalePage(driver);
        String carTitle = carForSalePage.getTileOfCarItem();
        System.out.println(carTitle);
        carForSalePage.clickCarItem();
        CarSearchDetailPage carSearchDetailPage = new CarSearchDetailPage(driver);
        System.out.println(carSearchDetailPage.getCarTitle());
        Assert.assertEquals(carTitle, carSearchDetailPage.getCarTitle());
    }

    @Test(testName = "Verify That Alert Message Should Be Displayed When Searching With Invalid Keyword", dataProvider = "KeywordUnderTest", dataProviderClass = KeywordUnderTest.class)
    public void verifyThatAlertMessageShouldBeDisplayedWhenSearchingWithInvalidKeyword(String keyWord)
            throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        CarForSalePage carForSalePage = new CarForSalePage(driver);
        carForSalePage.searchCar(keyWord);
        Assert.assertTrue(carForSalePage.isAlertMessageFrameDisplayCorrect(carForSalePage.expectedAlertMessage,
                carForSalePage.expectedSubAlertMessage));
    }
}
