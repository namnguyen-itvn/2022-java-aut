package com.example.pages.carForSale;

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

    private WebElement optionNew = keyword.findElement(By.xpath("(//div[normalize-space()='New'])[1]"));
    private WebElement optionUsed = keyword.findElement(By.xpath("(//div[normalize-space()='Used'])[1]"));
    private WebElement optionManufacturerCertified = keyword
            .findElement(By.xpath("//div[normalize-space()='Manufacturer Certified']"));
    private WebElement optionThirdPartyCertified = keyword
            .findElement(By.xpath("//div[contains(text(),'Third-Party Certified')]"));

    private WebElement titleModuleYourSearch = keyword.findElement(By.xpath(
            "//span[@class='text-size-400 text-bold text-gray-base']"));

    public void chooseOptionCondition(String optionCondition) {
        actionExitAds();
        keyword.scrollToElement(optionNew);
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
        actionExitAds();
        keyword.scrollToElement(titleModuleYourSearch);
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

    /**
     * Check element is Displayed
     * 
     * @param element
     * @return
     */
    public boolean checkElementDisplayed(WebElement element) {
        if (element.isDisplayed()) {

            return true;
        } else
            return false;
    }

    /**
     * Check Three element is Displayed
     * 
     * @return
     */
    public boolean checkOptionCorrectDisplayed() {
        WebElement optionConditionYourSearch = keyword.findElement(By.xpath(
                "//div[@class='chip btn input-chip display-inline-flex align-items-center margin-right-2 margin-bottom-2 text-bold']"));
        WebElement clearFilterLink = keyword.findElement(By.xpath(
                "//span[@class='text-link']"));
        keyword.waitForElementVisibilities(optionConditionYourSearch);
        if (checkElementDisplayed(optionConditionYourSearch) == true
                && checkElementDisplayed(clearFilterLink) == true
                && checkElementDisplayed(titleModuleYourSearch) == true) {

            return true;
        } else
            return false;
    }

    /**
     * Negative to page car for sale option
     */
    public void chooseCar() {
        WebElement firstProductOfListCar = keyword.findElement(By.xpath(
                "(//div[@class='col-xs-8 item-card-content display-flex flex-column justify-content-between'])[2]"));
        keyword.click(firstProductOfListCar);
    }

    private WebElement moduleAtHomeServices = keyword
            .findElement(By.xpath("//span[contains(text(),'At Home Services')]"));
    private By videoWalkaround = By.xpath("//div[normalize-space()='Video Walkaround']");
    private By testDrive = By.xpath("//div[normalize-space()='Test Drive']");
    private By onlinePaperwork = By.xpath("//div[contains(text(),'Online Paperwork')]");
    private By delivery = By.xpath("//div[normalize-space()='Delivery']");
    private By buyOnline = By.xpath("//div[normalize-space()='Buy Online']");

    public void chooseOptionAtHomeSerVices(String optionAtHomeServices) {
        actionExitAds();
        keyword.scrollToElement(moduleAtHomeServices);
        keyword.click(moduleAtHomeServices);
        switch (optionAtHomeServices) {
            case "videoWalkaround":
                keyword.click(keyword.findElement(videoWalkaround));
                break;
            case "testDrive":
                keyword.click(keyword.findElement(testDrive));
                break;
            case "onlinePaperwork":
                keyword.click(keyword.findElement(onlinePaperwork));
                break;
            case "delivery":
                keyword.click(keyword.findElement(delivery));
                break;
            case "buyOnline":
                keyword.click(keyword.findElement(buyOnline));
                break;
            default:
                System.out.println("Invalid page");
                break;
        }
        actionExitAds();
        keyword.scrollToElement(titleModuleYourSearch);
    }
}
