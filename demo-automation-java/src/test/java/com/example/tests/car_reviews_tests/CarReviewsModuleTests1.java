package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.DataReviewCarUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewsDetailModulePage1;
import com.example.pages.car_reviews_pages.CarReviewsModulePage;
import com.example.tests.BaseTest;

public class CarReviewsModuleTests1 extends BaseTest {
    @Test(testName = "Verify that the Specifications Section should be displayed after clicking on Tab Specs & Features on Menu Tab Overview Before Click Readmore Button",dataProviderClass = DataReviewCarUnderTest.class, dataProvider = "DataReviewCarUnderTest")
    public void verifythatheSpecificationsSectionshouldbedisplayedafterclickingonTabSpecsandFeaturesonMenuTabOverviewBeforeClickReadmoreButton(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carReviewsDetailModulePage = new CarReviewsDetailModulePage1(driver);
        carReviewsDetailModulePage.clickTabSpecsandFeature();
        Assert.assertTrue(carReviewsDetailModulePage.isCarReviewsSpecificationModuleDisplayed());
    }
    
    @Test(testName = "Verify that the Specifications Section should be displayed after clicking on Tab Specs & Features on Menu Tab Overview After Click Readmore Button",dataProviderClass = DataReviewCarUnderTest.class, dataProvider = "DataReviewCarUnderTest")
    public void verifythatheSpecificationsSectionshouldbedisplayedafterclickingonTabSpecsandFeaturesonMenuTabOverviewAfterClickReadmoreButton(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carReviewsDetailModulePage = new CarReviewsDetailModulePage1(driver);
        carReviewsDetailModulePage.clickTabSpecsandFeature();
        carReviewsDetailModulePage.clickReadMoreInSpecsandFeature();
        Thread.sleep(2000);
        carReviewsDetailModulePage.isCarReviewsSpecificationModuleDisplayedAfterClickReadMore();
    }

    @Test(testName = "Verify that the Specifications Section should be displayed after clicking on Tab Specs & Features on Menu Tab Overview Before Click Readmore Button",dataProviderClass = DataReviewCarUnderTest.class, dataProvider = "DataReviewCarUnderTest")
    public void verifythatheSpecificationsSectionshouldbedisplayedafterclickingonTabSpecsandFeaturesonDynamicMenuTabOverview(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carReviewsDetailModulePage = new CarReviewsDetailModulePage1(driver);
        carReviewsDetailModulePage.scrollDown();
        carReviewsDetailModulePage.clickTabSpecsandFeature();
        Assert.assertTrue(carReviewsDetailModulePage.isCarReviewsSpecificationModuleDisplayed());
    }

    @Test(testName = "Verify that Title of Safety Section Should Be Displayed Correctly after clicking on Tab Safety on Menu Tab Overview",dataProviderClass = DataReviewCarUnderTest.class, dataProvider = "DataReviewCarUnderTest")
    public void verifythatTitleofSafetySectionShouldBeDisplayedCorrectlyafterclickingonTabSafetyonMenuTabOverview(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carReviewsDetailModulePage = new CarReviewsDetailModulePage1(driver);
        carReviewsDetailModulePage.clickSafety();

        Assert.assertTrue(carReviewsDetailModulePage.isTitileIsTrueTabSafety(year, make, model));
    }

    @Test(testName = "Verify that content of Safety Section should be displayed after clicking on Tab Safety on Menu Tab Overview",dataProviderClass = DataReviewCarUnderTest.class, dataProvider = "DataReviewCarUnderTest")
    public void verifyThatContentofSafetySectionShouldBeDisplayedAfterClickingOnTabSafetyonMenuTabOverview(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carReviewsDetailModulePage = new CarReviewsDetailModulePage1(driver);
        carReviewsDetailModulePage.clickSafety();
        Assert.assertTrue(carReviewsDetailModulePage.isContentofTabSafetyDisplayed(year, make, model));
    }

    @Test(testName = "Verify that content of Safety Section should be displayed after clicking Tab Safety on Dynamic Menu Tab Overview",dataProviderClass = DataReviewCarUnderTest.class, dataProvider = "DataReviewCarUnderTest")
    public void verifyThatTitleofSafetySectionShouldBeDisplayedAfterClickingOnTabSafetyonDynamicMenuTabOverview(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carReviewsDetailModulePage = new CarReviewsDetailModulePage1(driver);
        carReviewsDetailModulePage.scrollDown();
        carReviewsDetailModulePage.clickSafety();
        Assert.assertTrue(carReviewsDetailModulePage.isTitileIsTrueTabSafety(year, make, model));
    }
    
    @Test(testName = "Verify that content of Safety Section should be displayed after clicking Tab Safety on Dynamic Menu Tab Overview",dataProviderClass = DataReviewCarUnderTest.class, dataProvider = "DataReviewCarUnderTest")
    public void verifyThatContentofSafetySectionShouldBeDisplayedAfterClickingOnTabSafetyonDynamicMenuTabOverview(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carReviewsDetailModulePage = new CarReviewsDetailModulePage1(driver);
        carReviewsDetailModulePage.scrollDown();
        carReviewsDetailModulePage.clickSafety();
        Assert.assertTrue(carReviewsDetailModulePage.isContentofTabSafetyDisplayed(year, make, model));
    }

    @Test(testName = "Verify that the  Styles Section should be displayed after clicking on Tab Styles on Menu Tab Overview",dataProviderClass = DataReviewCarUnderTest.class, dataProvider = "DataReviewCarUnderTest")
    public void verifyThatTheStylesSectionShouldBeDisplayedAfterClickingOnTabStylesOnMenuTabOverview(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carReviewsDetailModulePage = new CarReviewsDetailModulePage1(driver);
        carReviewsDetailModulePage.clickStyles();
        Assert.assertTrue(carReviewsDetailModulePage.lblLowestPriceDisplayed());
        Assert.assertTrue(carReviewsDetailModulePage.isContainersStylesDisplayedCorrectly(year, make, model));
    }
    
    @Test(testName = "Verify That The Best Cars Section Should Be Displayed When Scrolling Down",dataProviderClass = DataReviewCarUnderTest.class, dataProvider = "DataReviewCarUnderTest")
    public void verifyThatTheBestCarsSectionShouldBeDisplayedWhenScrollingDown(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carReviewsDetailModulePage = new CarReviewsDetailModulePage1(driver);
        carReviewsDetailModulePage.scrolltoBestCar();
        Assert.assertTrue(carReviewsDetailModulePage.isContainerBestCarDisplayedCorrectly());
    }

    @Test(testName = "verify That The Other Years Section Should Be Displayed When Scrolling Down",dataProviderClass = DataReviewCarUnderTest.class, dataProvider = "DataReviewCarUnderTest")
    public void verifyThatTheOtherYearsSectionShouldBeDisplayedWhenScrollingDown(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carReviewsDetailModulePage = new CarReviewsDetailModulePage1(driver);
        Assert.assertTrue(carReviewsDetailModulePage.isContentOtherYearDisplayCorrectly(make, model));
    }
}
