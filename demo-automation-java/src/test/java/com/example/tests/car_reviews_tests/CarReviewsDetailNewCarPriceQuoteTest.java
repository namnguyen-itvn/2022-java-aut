package com.example.tests.car_reviews_tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.core.datadriven.InfoCarUnderTest;
import com.example.pages.BasePage;
import com.example.pages.car_reviews_pages.CarReviewsCarYouMayLike;
import com.example.pages.car_reviews_pages.CarReviewsDetailNewCarPriceQuotePage;
import com.example.pages.car_reviews_pages.CarReviewsNewCarPriceQuotePage;
import com.example.tests.BaseTest;

public class CarReviewsDetailNewCarPriceQuoteTest extends BaseTest {
    @Test(testName = "Verify the New Car Price Quote section display", dataProvider = "InfoCarUnderTest", dataProviderClass = InfoCarUnderTest.class)
    public void verifytheNewCarPriceQuotesectiondisplay(String year, String make, String model,
    String makeQuote, String modelQuote, String styleQuote,String zipQuote){
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsNewCarPriceQuotePage CarReviewsNewCarPriceQuotePage = new CarReviewsNewCarPriceQuotePage(driver);
        CarReviewsNewCarPriceQuotePage.inputDataCar(year, make, model);

        CarReviewsDetailNewCarPriceQuotePage CarReviewsDetailNewCarPriceQuotePage = new CarReviewsDetailNewCarPriceQuotePage(driver);
        Assert.assertTrue(CarReviewsDetailNewCarPriceQuotePage.checkCarPriceQuoteSectionDisplay(),
         "The New Car Price Quote section not display");
    }
    
    @Test(testName = "Verify UI Of New Car Price Quote", dataProvider = "InfoCarUnderTest", dataProviderClass = InfoCarUnderTest.class)
    public void verifyUIOfNewCarPriceQuote(String year, String make, String model,
    String makeQuote, String modelQuote, String styleQuote,String zipQuote) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsNewCarPriceQuotePage CarReviewsNewCarPriceQuotePage = new CarReviewsNewCarPriceQuotePage(driver);
        CarReviewsNewCarPriceQuotePage.inputDataCar(year, make, model);

        CarReviewsDetailNewCarPriceQuotePage CarReviewsDetailNewCarPriceQuotePage = new CarReviewsDetailNewCarPriceQuotePage(driver);
        Assert.assertTrue(CarReviewsDetailNewCarPriceQuotePage.checkUINewCarPriceQuote(),
         "UI Of New Car Price Quote display not correct");
    }

    @Test(testName = "Verify Default The Items Of Make Model In DropdownList", dataProvider = "InfoCarUnderTest", dataProviderClass = InfoCarUnderTest.class)
    public void verifyDefaultTheItemsOfMakeModelInDropdownList(String year, String make, String model,
    String makeQuote, String modelQuote, String styleQuote,String zipQuote) {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsNewCarPriceQuotePage CarReviewsNewCarPriceQuotePage = new CarReviewsNewCarPriceQuotePage(driver);
        CarReviewsNewCarPriceQuotePage.inputDataCar(year, make, model);

        CarReviewsDetailNewCarPriceQuotePage CarReviewsDetailNewCarPriceQuotePage = new CarReviewsDetailNewCarPriceQuotePage(driver);
        Assert.assertTrue(CarReviewsDetailNewCarPriceQuotePage.checkDefaultTheItemsOfMakeModelInDropdownList(make, model),
         "The Items Of Make Model In DropdownList display not default");
    }

    @Test(testName = "Verify Make Model Style Can Select And Zip code Can Enter Data", dataProvider = "InfoCarUnderTest", dataProviderClass = InfoCarUnderTest.class)
    public void verifyMakeModelStyleCanSelectAndZipcodeCanEnterData(String year, String make, String model,
    String makeQuote, String modelQuote, String styleQuote,String zipQuote) throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsNewCarPriceQuotePage CarReviewsNewCarPriceQuotePage = new CarReviewsNewCarPriceQuotePage(driver);
        CarReviewsNewCarPriceQuotePage.inputDataCar(year, make, model);

        CarReviewsDetailNewCarPriceQuotePage CarReviewsDetailNewCarPriceQuotePage = new CarReviewsDetailNewCarPriceQuotePage(driver);
        CarReviewsDetailNewCarPriceQuotePage.selectMakeModelStyleAndFillZipcodeData(makeQuote, modelQuote, styleQuote, zipQuote);
    }

    @Test(testName = "Verify Car Price Quote Section Work Correct When Input Valid Data And Click Button Find Dealers", dataProvider = "InfoCarUnderTest", dataProviderClass = InfoCarUnderTest.class)
    public void verifyCarPriceQuoteSectionWorkCorrectWhenInputValidDataAndClickButtonFindDealers(String year, String make, String model,
    String makeQuote, String modelQuote, String styleQuote,String zipQuote) throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsNewCarPriceQuotePage CarReviewsNewCarPriceQuotePage = new CarReviewsNewCarPriceQuotePage(driver);
        CarReviewsNewCarPriceQuotePage.inputDataCar(year, make, model);

        CarReviewsDetailNewCarPriceQuotePage CarReviewsDetailNewCarPriceQuotePage = new CarReviewsDetailNewCarPriceQuotePage(driver);
        CarReviewsDetailNewCarPriceQuotePage.selectMakeModelStyleAndFillZipcodeData(makeQuote, modelQuote, styleQuote, zipQuote);
        CarReviewsDetailNewCarPriceQuotePage.clickButtonFindDealers();
        Assert.assertTrue(CarReviewsDetailNewCarPriceQuotePage.checkCarPriceQuoteSectionWorkCorrectWhenInputValidDataAndClickButtonFindDealers(), 
        "Car Price Quote Section Work not Correct When Input Valid Data and click button find dealers");
    }

    @Test(testName = "Verify Car Price Quote Section Work Correct When Input Valid Data And Click Button Get My Free Quote", dataProvider = "InfoCarUnderTest", dataProviderClass = InfoCarUnderTest.class)
    public void verifyCarPriceQuoteSectionWorkCorrectWhenInputValidDataAndClickButtonGetMyFreeQuote(String year, String make, String model,
    String makeQuote, String modelQuote, String styleQuote,String zipQuote) throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsNewCarPriceQuotePage CarReviewsNewCarPriceQuotePage = new CarReviewsNewCarPriceQuotePage(driver);
        CarReviewsNewCarPriceQuotePage.inputDataCar(year, make, model);

        CarReviewsDetailNewCarPriceQuotePage CarReviewsDetailNewCarPriceQuotePage = new CarReviewsDetailNewCarPriceQuotePage(driver);
        CarReviewsDetailNewCarPriceQuotePage.selectMakeModelStyleAndFillZipcodeData(makeQuote, modelQuote, styleQuote, zipQuote);
        CarReviewsDetailNewCarPriceQuotePage.clickButtonFindDealers();
        CarReviewsDetailNewCarPriceQuotePage.clickButtonGetMyFreeQuote();
        Assert.assertTrue(CarReviewsDetailNewCarPriceQuotePage.checkCarPriceQuoteSectionWorkCorrectWhenInputValidDataAndClickButtonGetMyFreeQuote(), 
        "Car Price Quote Section Work not Correct When Input Valid Data and click button Get My Free Quote");
    }

    @Test(testName = "Verify UI Of Car You May Like", dataProvider = "InfoCarUnderTest", dataProviderClass = InfoCarUnderTest.class)
    public void verifyUIOfCarYouMayLike(String year, String make, String model,
    String makeQuote, String modelQuote, String styleQuote,String zipQuote) throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsNewCarPriceQuotePage CarReviewsNewCarPriceQuotePage = new CarReviewsNewCarPriceQuotePage(driver);
        CarReviewsNewCarPriceQuotePage.inputDataCar(year, make, model);

        CarReviewsDetailNewCarPriceQuotePage CarReviewsDetailNewCarPriceQuotePage = new CarReviewsDetailNewCarPriceQuotePage(driver);
        Assert.assertTrue(CarReviewsDetailNewCarPriceQuotePage.checkUINewCarYouMayLike(), 
        "UI Of Car You May Like display not correct");
    }

    @Test(testName = "Verify UI Of Car You May Like Correct When Car No Longer Avaiable", dataProvider = "InfoCarUnderTest", dataProviderClass = InfoCarUnderTest.class)
    public void verifyUIOfCarYouMayLikeCorrectWhenCarNoLongerAvaiable(String year, String make, String model,
    String makeQuote, String modelQuote, String styleQuote,String zipQuote) throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsNewCarPriceQuotePage CarReviewsNewCarPriceQuotePage = new CarReviewsNewCarPriceQuotePage(driver);
        CarReviewsNewCarPriceQuotePage.inputDataCar(year, make, model);

        CarReviewsDetailNewCarPriceQuotePage CarReviewsDetailNewCarPriceQuotePage = new CarReviewsDetailNewCarPriceQuotePage(driver);
        CarReviewsDetailNewCarPriceQuotePage.clickCardvihicleESC();

        CarReviewsCarYouMayLike CarReviewsCarYouMayLike= new CarReviewsCarYouMayLike(driver);
        Assert.assertTrue(CarReviewsCarYouMayLike.checkMessageCorrectWhenCarNoLongerAvaiable(), 
        "UI Of Car You May Like Not Correct When Car No Longer Avaiable");
    }

    @Test(testName = "Verify UI Of Car You May Like Correct When Car Avaiable", dataProvider = "InfoCarUnderTest", dataProviderClass = InfoCarUnderTest.class)
    public void verifyUIOfCarYouMayLikeCorrectWhenCarAvaiable(String year, String make, String model,
    String makeQuote, String modelQuote, String styleQuote,String zipQuote) throws Exception {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        CarReviewsNewCarPriceQuotePage CarReviewsNewCarPriceQuotePage = new CarReviewsNewCarPriceQuotePage(driver);
        CarReviewsNewCarPriceQuotePage.inputDataCar(year, make, model);

        CarReviewsDetailNewCarPriceQuotePage CarReviewsDetailNewCarPriceQuotePage = new CarReviewsDetailNewCarPriceQuotePage(driver);
        String label=CarReviewsDetailNewCarPriceQuotePage.getLabelVihicle();
        CarReviewsDetailNewCarPriceQuotePage.clickCardvihicle();

        CarReviewsCarYouMayLike CarReviewsCarYouMayLike= new CarReviewsCarYouMayLike(driver);
        Assert.assertTrue(CarReviewsCarYouMayLike.checkRedirectToCarForSaleWithCarSeleted(label), 
        "UI Of Car You May Like Not Correct When Car No Longer Avaiable");
    }
}
