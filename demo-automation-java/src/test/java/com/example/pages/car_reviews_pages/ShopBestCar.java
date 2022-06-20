package com.example.pages.car_reviews_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class ShopBestCar extends BasePage {

    public ShopBestCar(WebDriver driver) {
        super(driver);
    }

    private By imgBestCar = By.xpath("//div[1]/div/div/a[1]/div/div[1]/img");
    private By imgBestSuv = By.xpath("//div[1]/div/div/a[2]/div/div[1]/img");
    private By imgBestTruck = By.xpath("//div[1]/div/div/a[3]/div/div[1]/img");
    private By imgBestMini = By.xpath("//div[1]/div/div/a[4]/div/div[1]/img");
    private By imgBestEv = By.xpath("//div[1]/div/div/a[5]/div/div[1]/img");
    private By imgBestHy = By.xpath("//div[1]/div/div/a[6]/div/div[1]/img");

    private By txtBestCar = By.xpath("//a[1]/div/div[2]/div");
    private By txtBestSuv = By.xpath("//a[2]/div/div[2]/div");
    private By txtBestTruck = By.xpath("//a[3]/div/div[2]/div");
    private By txtBestMini = By.xpath("//a[4]/div/div[2]/div");
    private By txtBestEv = By.xpath("//a[5]/div/div[2]/div");
    private By txtBestHy = By.xpath("//a[6]/div/div[2]/div");

    private By btnBestCar = By.xpath("//div[3]/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div/a[1]");
    private By btnBestSuv = By.xpath("//div[3]/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div/a[2]");
    private By bntBestTruck = By.xpath("//div[3]/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div/a[3]");
    private By bntBestMini = By.xpath("//div[3]/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div/a[4]");
    private By bntBestEv = By.xpath("//div[3]/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div/a[5]");
    private By bntBestHy = By.xpath("//div[3]/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div/a[6]");

    private By lblBestCar = By.xpath("//h1");
    private By lblBestSuv = By.xpath("//h1");
    private By lblBestTruck = By.xpath("//h1");
    private By lblBestMini = By.xpath("//h1");
    private By lblBestEv = By.xpath("//h1");
    private By lblBestHy = By.xpath("//h1");

    public String expectedAlertMessage = "Dont fint out the image or text of the cars";

    public boolean isDisplayedImgCar() {
        return keyword.findElement(imgBestCar).isDisplayed() &
                keyword.findElement(imgBestSuv).isDisplayed() &
                keyword.findElement(imgBestTruck).isDisplayed() &
                keyword.findElement(imgBestMini).isDisplayed() &
                keyword.findElement(imgBestEv).isDisplayed() &
                keyword.findElement(imgBestHy).isDisplayed();
    }

    public boolean isDisplayedTxtCar() {
        return keyword.findElement(txtBestCar).isDisplayed() &
                keyword.findElement(txtBestSuv).isDisplayed() &
                keyword.findElement(txtBestTruck).isDisplayed() &
                keyword.findElement(txtBestMini).isDisplayed() &
                keyword.findElement(txtBestEv).isDisplayed() &
                keyword.findElement(txtBestHy).isDisplayed();
    }

    public void isClickStyleCar(String menuText) {
        switch (menuText) {
            case "Car":
                keyword.findElement(btnBestCar).click();
                break;
            case "Suv":
                keyword.findElement(btnBestSuv).click();
                break;
            case "Truck":
                keyword.findElement(bntBestTruck).click();
                break;
            case "Minivans":
                keyword.findElement(bntBestMini).click();
                break;
            case "Evs":
                keyword.findElement(bntBestEv).click();
                break;
            case "Hybrids":
                keyword.findElement(bntBestHy).click();
                break;
            default:
                System.out.println("Invalid page");
                break;
        }

    }
    public boolean isTitleDisplayedCarCorrect() {
        String expectedTitle = "Best Cars of 2022";
        String actualTitle = keyword.findElement(lblBestCar).getText();
        return actualTitle.equals(expectedTitle);
    }

    public boolean isTitleDisplayedSuvCorrect() {
        String expectedTitle = "Best SUVs of 2022";
        String actualTitle = keyword.findElement(lblBestSuv).getText();
        return actualTitle.equals(expectedTitle);
    }

    public boolean isTitleDisplayedTruckCorrect() {
        String expectedTitle = "Best Trucks of 2022";
        String actualTitle = keyword.findElement(lblBestTruck).getText();
        return actualTitle.equals(expectedTitle);
    }

    public boolean isTitleDisplayedMiniCorrect() {
        String expectedTitle = "Best Vans and Minivans of 2022";
        String actualTitle = keyword.findElement(lblBestMini).getText();
        return actualTitle.equals(expectedTitle);
    }

    public boolean isTitleDisplayedEvCorrect() {
        String expectedTitle = "Best Electric Vehicles of 2022";
        String actualTitle = keyword.findElement(lblBestEv).getText();
        return actualTitle.equals(expectedTitle);
    }

    public boolean isTitleDisplayedHyCorrect() {
        String expectedTitle = "Best Hybrid Vehicles of 2022";
        String actualTitle = keyword.findElement(lblBestHy).getText();
        return actualTitle.equals(expectedTitle);
    }

}
