package com.example.pages.carForSale;

import java.util.List;

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
    }

    // action exit ads

    public void actionExitAds() {

        try {

            WebElement optDiveType = keyword.findElement(By.xpath("//button[@id='fsrFocusFirst']"));

            keyword.click(optDiveType);

        } catch (Exception e) {

        }

    }

    /**
     * Check Three element is Displayed
     * 
     * @return
     */
    public boolean checkOptionCorrectDisplayed() {
        keyword.scrollToElement(titleModuleYourSearch);
        WebElement optionConditionYourSearch = keyword.findElement(By.xpath(
                "//div[@class='chip btn input-chip display-inline-flex align-items-center margin-right-2 margin-bottom-2 text-bold']"));
        WebElement clearFilterLink = keyword.findElement(By.xpath(
                "//span[@class='text-link']"));
        keyword.waitForElementVisibilities(optionConditionYourSearch);
        keyword.waitForElementVisibilities(clearFilterLink);
        if (isElementDisplayed(optionConditionYourSearch) == true
                && isElementDisplayed(clearFilterLink) == true
                && isElementDisplayed(titleModuleYourSearch) == true) {
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

    /**
     * Begin Module At Home Services
     */

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
    }

    /**
     * End module At Home Services
     */

    /**
     * Begin Module Cylinders
     */
    private By moduleCylinders = By.xpath("//span[contains(text(),'Cylinders')]");
    private By option3Cylinder = By.xpath("//div[normalize-space()='3 Cylinder']");
    private By option4Cylinder = By.xpath("//div[normalize-space()='4 Cylinder']");
    private By option5Cylinder = By.xpath("//div[normalize-space()='5 Cylinder']");
    private By option6Cylinder = By.xpath("//div[normalize-space()='6 Cylinder']");
    private By option8Cylinder = By.xpath("//div[normalize-space()='8 Cylinder']");
    private By option10Cylinder = By.xpath("//div[normalize-space()='10 Cylinder']");
    private By optionSeeMore = By
            .xpath("//div[@title='Cylinders']//div[@class='text-link'][normalize-space()='See More']");

    public void chooseOptionCylinders(String optionCylinders) {
        actionExitAds();
        keyword.scrollToElement(moduleAtHomeServices);
        keyword.click(keyword.findElement(moduleCylinders));
        switch (optionCylinders) {
            case "option3Cylinder":
                keyword.click(keyword.findElement(option3Cylinder));
                break;
            case "option4Cylinder":
                keyword.click(keyword.findElement(option4Cylinder));
                break;
            case "option5Cylinder":
                keyword.click(keyword.findElement(option5Cylinder));
                break;
            case "option6Cylinder":
                keyword.click(keyword.findElement(option6Cylinder));
                break;
            case "option8Cylinder":
                keyword.click(keyword.findElement(option8Cylinder));
                break;
            case "option10Cylinder":
                keyword.click(keyword.findElement(option10Cylinder));
                break;
            case "optionSeeMore":
                keyword.click(keyword.findElement(optionSeeMore));
                break;
            default:
                System.out.println("Invalid page");
                break;
        }
        actionExitAds();
    }

    private By optionCylindersList = By.xpath("//div[@class='columns columns-4']");

    public boolean isTheNumberOfPopUpSeeMoreDisplayedCorrectAsRequired() {
        List<WebElement> moreOptionCylinders = keyword.findElement(optionCylindersList)
                .findElements(By.xpath("//div[@role='dialog']//label"));
        if (moreOptionCylinders.size() == 12) {
            return true;
        } else
            return false;
    }

    /**
     * End Module Cylinders
     */

    private By moduleFeatures = By.xpath(
            "(//div[@class='display-flex accordion-panel-toggle justify-content-between padding-4'])[8]");
    private By dualRealWheels = By.xpath("//div[normalize-space()='Dual Rear Wheels']");
    private By keylessEntry = By.xpath("//div[normalize-space()='Keyless Entry']");
    private By premiumWheels = By.xpath("//div[normalize-space()='Premium Wheels']");
    private By roofRack = By.xpath("//div[normalize-space()='Roof Rack']");
    private By trailerHitch = By.xpath("//div[normalize-space()='Trailer Hitch']");
    private By disabilityEquipped = By.xpath("///div[contains(text(),'Disability Equipped')]");
    private By adaptiveCruiseControl = By.xpath("//div[normalize-space()='Adaptive Cruise Control']");
    private By androidAuto = By.xpath("//div[normalize-space()='Android Auto']");
    private By appleCarPlay = By.xpath("//div[normalize-space()='Apple CarPlay']");
    private By automaticParking = By.xpath("//div[normalize-space()='Automatic Parking']");
    private By BluetoothAndHandsFree = By.xpath("//div[normalize-space()='Bluetooth, Hands-Free']");
    private By cruiseControl = By.xpath("//div[normalize-space()='Cruise Control']");
    private By dVDPlayer = By.xpath("//div[normalize-space()='DVD Player']");
    private By headUpDisplay = By.xpath("//div[normalize-space()='Head-Up Display']");
    private By keylessStart = By.xpath("//div[normalize-space()='Keyless Start']]");
    private By navigation = By.xpath("//div[normalize-space()='Navigation']");
    private By portableAudioConnection = By.xpath("//div[normalize-space()='Portable Audio Connection']");
    private By premiumAudio = By.xpath("//div[normalize-space()='Premium Audio']");
    private By rainSensingWipers = By.xpath("//div[normalize-space()='Rain Sensing Wipers']");
    private By satelliteRadio = By.xpath("//div[normalize-space()='Satellite Radio']");
    private By wiFiHotspot = By.xpath("//div[normalize-space()='WiFi Hotspot']");
    private By row3rdSeats = By.xpath("//div[normalize-space()='3rd Row Seats']");
    private By heatedSeats = By.xpath("//div[normalize-space()='Heated Seats']");
    private By leatherSeats = By.xpath("//div[normalize-space()='Leather Seats']");
    private By backupCamera = By.xpath("//div[normalize-space()='Backup Camera']");
    private By sunroof = By.xpath("//div[normalize-space()='Sunroof']");
    private By brakeAssist = By.xpath("//div[normalize-space()='Brake Assist']");
    private By crossTrafficAlert = By.xpath("//div[contains(text(),'Cross Traffic Alert')]");
    private By nightVision = By.xpath("//div[normalize-space()='Night Vision']");
    private By securitySystem = By.xpath("//div[normalize-space()='Security System']");

    public void chooseOptionFeatures(String optionFeatures) {
        actionExitAds();
        keyword.scrollAndClick(keyword.findElement(moduleFeatures));
        switch (optionFeatures) {
            case "dualRealWheels":
                keyword.scrollAndClick(keyword.findElement(dualRealWheels));
                break;
            case "keylessEntry":
                keyword.scrollAndClick(keyword.findElement(keylessEntry));
                break;
            case "automaticParking":
                keyword.scrollAndClick(keyword.findElement(automaticParking));
                break;
            case "roofRack":
                keyword.scrollAndClick(keyword.findElement(roofRack));
                break;
            case "trailerHitch":
                keyword.scrollAndClick(keyword.findElement(trailerHitch));
                break;
            case "disabilityEquipped":
                keyword.scrollAndClick(keyword.findElement(disabilityEquipped));
                break;
            case "adaptiveCruiseControl":
                keyword.scrollAndClick(keyword.findElement(adaptiveCruiseControl));
                break;
            case "androidAuto":
                keyword.scrollAndClick(keyword.findElement(androidAuto));
                break;
            case "appleCarPlay":
                keyword.scrollAndClick(keyword.findElement(appleCarPlay));
                break;
            case "keylessStart":
                keyword.scrollAndClick(keyword.findElement(keylessStart));
                break;
            case "navigation":
                keyword.scrollAndClick(keyword.findElement(navigation));
                break;
            case "portableAudioConnection":
                keyword.scrollAndClick(keyword.findElement(portableAudioConnection));
                break;
            case "premiumAudio":
                keyword.scrollAndClick(keyword.findElement(premiumAudio));
                break;
            case "rainSensingWipers":
                keyword.scrollAndClick(keyword.findElement(rainSensingWipers));
                break;
            case "premiumWheels":
                keyword.clickByJS(keyword.findElement(premiumWheels));
                break;
            case "satelliteRadio":
                keyword.scrollAndClick(keyword.findElement(satelliteRadio));
                break;
            case "cruiseControl":
                keyword.scrollAndClick(keyword.findElement(cruiseControl));
                break;
            case "backupCamera":
                keyword.scrollAndClick(keyword.findElement(backupCamera));
                break;
            case "heatedSeats":
                keyword.scrollAndClick(keyword.findElement(heatedSeats));
                break;
            case "BluetoothAndHandsFree":
                keyword.scrollAndClick(keyword.findElement(BluetoothAndHandsFree));
                break;
            case "wiFiHotspot":
                keyword.scrollAndClick(keyword.findElement(wiFiHotspot));
                break;
            case "dVDPlayer":
                keyword.scrollAndClick(keyword.findElement(dVDPlayer));
                break;
            case "headUpDisplay":
                keyword.scrollAndClick(keyword.findElement(headUpDisplay));
                break;
            case "row3rdSeats":
                keyword.scrollAndClick(keyword.findElement(row3rdSeats));
                break;
            case "leatherSeats":
                keyword.scrollAndClick(keyword.findElement(leatherSeats));
                break;
            case "sunroof":
                keyword.scrollAndClick(keyword.findElement(sunroof));
                break;
            case "brakeAssist":
                keyword.scrollAndClick(keyword.findElement(brakeAssist));
                break;
            case "crossTrafficAlert":
                keyword.scrollAndClick(keyword.findElement(crossTrafficAlert));
                break;
            case "nightVision":
                keyword.scrollAndClick(keyword.findElement(nightVision));
                break;
            case "securitySystem":
                keyword.scrollAndClick(keyword.findElement(securitySystem));
                break;
            default:
                System.out.println("Invalid page");
                break;
        }
        actionExitAds();
    }
}
