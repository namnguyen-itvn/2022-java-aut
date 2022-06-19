package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class CarSearchDetailPage extends BasePage {

    public CarSearchDetailPage(WebDriver driver) {
        super(driver);
    }

    private By lblTitle = By.xpath("//h1[@data-cmp='heading']");
    private By lblFirstPrice = By.xpath("//div[@class='panel-body']/descendant::span[@class='first-price']");
    private By lblVehicleSection = By.xpath("//div[@id='vehicleFeatures']//div[@data-cmp='heading']");
    private By lblPriceSection = By.xpath("//div[@id='pricingSection']/div[@data-cmp='heading']");
    private By tabFairMarket = By.xpath("//a[@id='pricing-tabs-tab-1']");
    private By tabPriceBreakdown = By.xpath("//a[@id='pricing-tabs-tab-2']");
    private By lblTitleTabFair = By.xpath("//div[@id='kbbPriceAdvisorSection']/div[@data-cmp='heading']");
    private By lblMessageTabFair = By.xpath("//div[@id='kbbPriceAdvisorSection']/div[@class='text-left']/p");
    private By lblTitleTabPriceBreakdown = By
            .xpath("//div[@id='pricing-tabs-pane-2']/descendant::div[@data-cmp='heading']");
    private By lblMessageTabPrice = By.xpath("//div[@id='pricing-tabs-pane-2']/descendant::div[@class='text-left']/p");
    private By lblListing = By.xpath("//div[@data-cmp='pricingBreakdown']/descendant::div[contains(text(),'Listing')]");
    private By lblPriceListing = By.xpath(
            "//div[@data-cmp='pricingBreakdown']/descendant::div[contains(text(),'Listing')]/following-sibling::div");

    /*
     * Return the title of car
     */
    public String getCarTitle() {
        return keyword.getText(keyword.findElement(lblTitle));
    }

    /**
     * 
     * @return Price Detail Section Displayed As Default or not
     */
    public boolean isPriceDetailSectionDisplayedAsDefault() {
        if (getText(lblPriceSection).equals(expectedLabelPriceSection)
                & getText(tabFairMarket).equals(expectedLabelTabFairMarket)
                & getText(tabPriceBreakdown).equals(expectedLabelTabPriceBreakDown)) {
            return true;
        } else
            return false;
    }

    /**
     * 
     * @return Tab Fair Market Displayed As Default
     */
    public boolean isTabFairMarketDisplayedAsDefault() {
        if (getText(lblTitleTabFair).equals(expectedTitleTabFair)
                & getText(lblMessageTabFair).equals(expectedMessageTabFair)) {
            return true;
        } else
            return false;
    }

    /**
     * Action to scroll to price section
     */
    public void scrollToPriceSection() {
        keyword.scrollToElement(keyword.findElement(lblVehicleSection));
    }

    /**
     * Action to click tab price break down
     */
    public void clickTabPriceBreakDown() {
        keyword.clickWithOutScroll(keyword.findElement(tabPriceBreakdown));
    }

    /**
     * 
     * @return Tab Price Breakdown Displayed As Default
     */
    public boolean isTabPriceBreakdownDisplayedAsDefault() {
        System.out.println(getText(lblMessageTabPrice));
        if (getText(lblTitleTabPriceBreakdown).equals(expectedTitleTabPriceBreakDown)
                & getText(lblMessageTabPrice).equals(expectedMessageTabPriceBreakDown)
                & getText(lblListing).equals(expectedLabelListing)) {
            return true;
        } else
            return false;
    }

    /**
     * 
     * @return Listing price is equal with first price or not
     */
    public boolean isListingPriceEqualWithFirstPrice(String firstPrice) {
        String priceListingValue = getText(lblPriceListing).substring(getText(lblPriceListing).lastIndexOf("$") + 1);
        System.out.println(priceListingValue);
        if (priceListingValue.equals(firstPrice)) {
            return true;
        } else
            return false;
    }

    /**
     * 
     * @return First Price Value
     */
    public String getFirstPriceValue() {
        return getText(lblFirstPrice);
    }

    String expectedTitleTabFair = "Kelley Blue Book® Fair Market Range";
    String expectedMessageTabFair = "Updated weekly, the Kelley Blue Book® Price Advisor helps you better understand what others have been paying for this car recently.";
    String expectedLabelPriceSection = "Pricing Details";
    String expectedLabelTabFairMarket = "Fair Market Range";
    String expectedLabelTabPriceBreakDown = "Price Breakdown and Offers";
    String expectedTitleTabPriceBreakDown = "Price Breakdown";
    String expectedMessageTabPriceBreakDown = "Contact the dealer for further pricing details.";
    String expectedLabelListing = "Listing Price";
}