package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class CarsForSaleTransmissionPage extends BasePage {

    public CarsForSaleTransmissionPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Element page
     */
    private By lblTransmission = By.xpath("//span[contains(text(),'Transmission')]");
    private By chkTransmissionAutomatic = By.xpath("//div[normalize-space()='Automatic']");
    private By chkTransmissionManual = By.xpath("//div[normalize-space()='Manual']");
    private By tagTransmissionAutomatic = By.xpath("//span[normalize-space()='Automatic']");
    private By iconTransmissionAutomaticX = By
            .xpath("//span[@class='circle-glyph-filter cursor-pointer margin-left-3']");
    private By txlYourSearchClearFilter = By.xpath("//span[@class='text-link']");
    private By lblYourSearchResults = By.xpath("(//div[@class='text-size-md-300 text-size-lg-300 text-right'])[1]");
    private By lblYourSearchResultsAfterChosenOption = By
            .xpath("(//div[@class='text-size-md-300 text-size-lg-300 text-right'])[1]");
    private By lblYourSearch = By.xpath("//span[@class='text-size-400 text-bold text-gray-base']");
    private By itemFirstResult = By.xpath("(//div[@data-cmp='inventorySpotlightListing'])[1]");

    private int beforeResults = 0;
    private int afterResults = 0;

    /**
     * 
     * @param element
     * @return
     */
    private int convertElementToDouble(By element) {
        String beforeConvert = keyword.findElement(element).getText();
        String removeResults = beforeConvert.replace(" Results", "");
        String removeClearFilter = removeResults.replace("|Clear Filters", "");
        String afterConvert = removeClearFilter.replace(",", "");
        int results = Integer.parseInt(afterConvert);
        return results;
    }

    /**
     * 
     * @return
     */
    public boolean isTransmissionDisplayed() {
        beforeResults = convertElementToDouble(lblYourSearchResults);
        keyword.scrollToElement(keyword.findElement(lblTransmission));
        keyword.click(keyword.findElement(lblTransmission));
        if (isElementDisplayed(lblTransmission)) {
            if (isElementDisplayed(chkTransmissionAutomatic) && isElementDisplayed(chkTransmissionManual)) {
                keyword.click(keyword.findElement(chkTransmissionAutomatic));
                keyword.scrollToElement(keyword.findElement(lblYourSearch));
                if (isElementDisplayed(tagTransmissionAutomatic) && isElementDisplayed(iconTransmissionAutomaticX)
                        && isElementDisplayed(txlYourSearchClearFilter) && isElementDisplayed(lblYourSearchResults)) {
                    afterResults = convertElementToDouble(lblYourSearchResultsAfterChosenOption);
                    if (beforeResults != afterResults || beforeResults == afterResults) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /**
     * 
     */
    public void isTransmissionNavigation() {
        keyword.scrollToElement(keyword.findElement(lblTransmission));
        keyword.click(keyword.findElement(lblTransmission));
        keyword.click(keyword.findElement(chkTransmissionAutomatic));
        keyword.scrollToElement(keyword.findElement(lblYourSearch));
        keyword.click(keyword.findElement(itemFirstResult));
    }

}
