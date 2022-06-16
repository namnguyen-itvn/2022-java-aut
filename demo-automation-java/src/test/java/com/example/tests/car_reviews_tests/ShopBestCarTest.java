package com.example.tests.car_reviews_tests;
import com.example.pages.*;
import com.example.pages.car_reviews_pages.ShopBestCar;
import com.example.tests.BaseTest;
import org.testng.annotations.Test;

public class ShopBestCarTest extends BaseTest {

    @Test(priority = 1, testName = "Verify that six types car should be displayed on the left of content with image and title")
    public void VerifythatSixTypesCarDisplayedOnTheLeftContentWihtImageAndTitle() {

        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        ShopBestCar shopBestCar = new ShopBestCar(driver);
        shopBestCar.isDisplayedImgCar();
        shopBestCar.isDisplayedTxtCar();

    }

    @Test(priority = 2, testName = "Verify that the best car should be clicked")
    public void VerifyThatTheBestCarShouldBeClicked() {

        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        ShopBestCar shopBestCar = new ShopBestCar(driver);
        shopBestCar.isClickStyleCar("Car");
        shopBestCar.isTitleDisplayedCarCorrect();

    }

    @Test(priority = 3, testName = "Verify that the best suv should be clicked")
    public void VerifyThatTheBestSuvShouldBeClicked() {

        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        ShopBestCar shopBestCar = new ShopBestCar(driver);
        shopBestCar.isClickStyleCar("Suv");
        shopBestCar.isTitleDisplayedSuvCorrect();

    }

    @Test(priority = 4, testName = "Verify that the best Truck should be clicked")
    public void VerifyThatTheBestTruckShouldBeClicked() {

        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        ShopBestCar shopBestCar = new ShopBestCar(driver);
        shopBestCar.isClickStyleCar("Truck");
        shopBestCar.isTitleDisplayedTruckCorrect();

    }

    @Test(priority = 5, testName = "Verify that the best minivans should be clicked")
    public void VerifyThatTheBestMinivansShouldBeClicked() {

        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        ShopBestCar shopBestCar = new ShopBestCar(driver);
        shopBestCar.isClickStyleCar("Minivans");
        shopBestCar.isTitleDisplayedMiniCorrect();
    }

    @Test(priority = 6, testName = "Verify that the best evs should be clicked")
    public void VerifyThatTheBestEvsShouldBeClicked() {

        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        ShopBestCar shopBestCar = new ShopBestCar(driver);
        shopBestCar.isClickStyleCar("Evs");
        shopBestCar.isTitleDisplayedEvCorrect();
    }
    
    @Test(priority = 7, testName = "Verify that the best hybrids should be clicked")
    public void VerifyThatTheBestHybridsShouldBeClicked() {

        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");

        ShopBestCar shopBestCar = new ShopBestCar(driver);
        shopBestCar.isClickStyleCar("Hybrids");
        shopBestCar.isTitleDisplayedHyCorrect();
    }
    
}
