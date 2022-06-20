package com.example.tests.car_reviews_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.CarUnderTest;
import com.example.core.datadriven.DataCarSearch;
import com.example.core.datadriven.DataReviewCarUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.BuildAndPricePage;
import com.example.pages.car_reviews_pages.CarReviewPageConsumerReviewModule;
import com.example.pages.car_reviews_pages.CarReviewsDetailModulePage1;
import com.example.pages.car_reviews_pages.CarReviewsModulePage;
import com.example.pages.car_reviews_pages.OverViewModuleCarReviewDetailsPage;
import com.example.pages.car_reviews_pages.SeeCarForSalePage;
import com.example.tests.BaseTest;

public class CarReviewsModuleTests1 extends BaseTest {
    @Test(testName = "Verify that the UI of Car Reviews Module should be displayed as default")
    public void verifyCarReviewsModuleDisplayedAsDefault()
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        Assert.assertTrue(carReviewsModulePage.isCarReviewsModuleDisplayed(), "Page displayed is incorrect");
    }

    @Test(testName = "Verify that the User should navigate to Car Review Details page end to end", dataProviderClass = CarUnderTest.class, dataProvider = "CarUnderTest")
    public void verifyUserNavigateToCarReviewDetailsPageE2E(String year, String make, String model, String zipCode) throws Exception
    {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsModulePage carReviewsModulePage = new CarReviewsModulePage(driver);
        carReviewsModulePage.searchForVehicle(year, make, model, zipCode);

        OverViewModuleCarReviewDetailsPage carReviewDetailsPage = new OverViewModuleCarReviewDetailsPage(driver);
        Assert.assertTrue(carReviewDetailsPage.isPageTitleCorrect(carReviewsModulePage.expectedCarReviewDetailsPageTitle), "Page displayed is incorrect");
    }
    
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
    @Test(testName = "Verify User can navigate to Build & Price page", dataProvider = "DataCarSearch", dataProviderClass = DataCarSearch.class)
    public void verifyUserCanNavigateToBuildPricePage(String year, String make, String model, String zipCode) throws Exception{
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewPageConsumerReviewModule carReviewPageConsumerReviewModule = new CarReviewPageConsumerReviewModule(driver);
        carReviewPageConsumerReviewModule.inputAndSubmitGetCarReview(year, make, model, zipCode);


        CarReviewsDetailModulePage1 carreviewsDetailPage= new CarReviewsDetailModulePage1(driver);
        carreviewsDetailPage.clickOnBuildAndPriceButton(year, make, model);

        BuildAndPricePage buildAndPricePage = new BuildAndPricePage(driver);
        Assert.assertTrue(buildAndPricePage.isTitlePageBuildAndPriceDisplaysCorrect(year, make, model));
    }

    @Test(testName = "Verify User can navigate to See Car For Sale page", dataProvider = "DataCarSearch", dataProviderClass = DataCarSearch.class)
    public void verifyUserCanNavigateToSeeCarForSale(String year, String make, String model,String zipCode) throws Exception{
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewPageConsumerReviewModule carReviewPageConsumerReviewModule = new CarReviewPageConsumerReviewModule(driver);
        carReviewPageConsumerReviewModule.inputAndSubmitGetCarReview(year, make, model, zipCode);


        CarReviewsDetailModulePage1 carreviewsDetailPage= new CarReviewsDetailModulePage1(driver);
        carreviewsDetailPage.clickOnSeeCarForSaleButton(year, make, model);

        SeeCarForSalePage seeCarForSalePage = new SeeCarForSalePage();
        Assert.assertTrue(seeCarForSalePage.isTitlePageSeeCarForSaleDisplaysCorrect(year, make, model));
    }

    @Test(testName = "Verify that Expert Reviews should be displayed as required when it has expert's review", dataProvider = "DataCarSearch", dataProviderClass = DataCarSearch.class)
    public void VerifyThatExpertReviewsShouldDisplayedWhenHasExpertReview(String year, String make, String model,String zipCode) throws Exception{
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewPageConsumerReviewModule carReviewPageConsumerReviewModule = new CarReviewPageConsumerReviewModule(driver);
        carReviewPageConsumerReviewModule.inputAndSubmitGetCarReview(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carreviewsDetailPage= new CarReviewsDetailModulePage1(driver);
        Assert.assertTrue(carreviewsDetailPage.isExpertReviewDisplay(year, make, model)); 
    }

    @Test(testName = "Verify that Expert Reviews should be displayed as required when it hasn't expert's review", dataProvider = "DataNotHasExpertReview", dataProviderClass = DataCarSearch.class)
    public void VerifyThatExpertReviewsShouldDisplayedWhenHasNotExpertReview(String year, String make, String model,String zipCode) throws Exception{
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewPageConsumerReviewModule carReviewPageConsumerReviewModule = new CarReviewPageConsumerReviewModule(driver);
        carReviewPageConsumerReviewModule.inputAndSubmitGetCarReview(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carreviewsDetailPage= new CarReviewsDetailModulePage1(driver);
        Assert.assertTrue(carreviewsDetailPage.isMessageNoHasExpertReviewDisplay()); 
    }

    @Test(testName = "Verify that Zipcode label should be display Error Message when input invalid value", dataProvider = "DataInvalidZipcode", dataProviderClass = DataCarSearch.class)
    public void VerifyThatZipCodeLabelShouldDisplayErrorMessageWhenInputInvalidValue(String year, String make, String model,String zipCode) throws Exception{
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewPageConsumerReviewModule carReviewPageConsumerReviewModule = new CarReviewPageConsumerReviewModule(driver);
        carReviewPageConsumerReviewModule.inputAndSubmitGetCarReview(year, make, model, zipCode);

        CarReviewsDetailModulePage1 carReviewsDetailPage= new CarReviewsDetailModulePage1(driver);
        Assert.assertTrue(carReviewsDetailPage.isInValueMessageDisplayCorrect()); 
    }

}
