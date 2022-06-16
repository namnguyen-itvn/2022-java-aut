package com.example.pages.car_for_sale_pages;

import java.util.concurrent.TimeUnit;

import javax.lang.model.util.ElementScanner6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarForSaleConditionPage extends BasePage {

    public CarForSaleConditionPage(WebDriver driver) {
        super(driver);
    }

    private WebElement optionNew = keyword.findElement(By.xpath("//div[contains(text(),'New')]"));
    private WebElement optionUsed = keyword.findElement(By.xpath("//div[contains(text(),'Used')]"));
    private WebElement optionManufacturerCertified = keyword
            .findElement(By.xpath("//div[normalize-space()='Manufacturer Certified']"));
    private WebElement optionThirdPartyCertified = keyword
            .findElement(By.xpath("//div[contains(text(),'Third-Party Certified')]"));

    public void chooseOptionCondition(String optionCondition) {
        switch (optionCondition) {
            case "New":
                keyword.click(optionNew);
                break;
            case "Used":
                keyword.click(optionUsed);
                break;
            case "ManufacturerCertified":
                keyword.click(optionManufacturerCertified);
                break;
            case "ThirdPartyCertified":
                keyword.click(optionThirdPartyCertified);
                break;
            default:
                System.out.println("Invalid page");
                break;
        }
    }

    // action exit ads

    public void actionExitAds() {

        try {

            WebElement optDiveType = keyword.findElement(By.xpath("//button[@id='fsrFocusFirst']"));

            keyword.click(optDiveType);

        } catch (Exception e) {

            try {

                WebElement optDiveType2 = keyword.findElement(
                        By.cssSelector("button.QSIWebResponsiveDialog-Layout1-SI_5d3NX5IIzg7mUmN_close-btn"));

                keyword.click(optDiveType2);

            } catch (Exception a) {

            }

        }

    }

    public boolean checkElementDisplayed(WebElement element) {
        if (element.isDisplayed()) {

            return true;
        } else
            return false;
    }

    public boolean checkOptionCorrectDisplayed() {
        WebElement optionConditionYourSearch = keyword.findElement(By.xpath(
                "//div[@class='chip btn input-chip display-inline-flex align-items-center margin-right-2 margin-bottom-2 text-bold']"));
        WebElement clearFilterLink = keyword.findElement(By.xpath(
                "//span[@class='text-link']"));

        if (checkElementDisplayed(optionConditionYourSearch) == true
                && checkElementDisplayed(clearFilterLink) == true) {

            return true;
        } else
            return false;
    }

    public void chooseCar() {
        WebElement firstProductOfListCar = keyword.findElement(By.xpath(
                "(//div[@class='col-xs-8 item-card-content display-flex flex-column justify-content-between'])[2]"));
        keyword.click(firstProductOfListCar);

    }

}
