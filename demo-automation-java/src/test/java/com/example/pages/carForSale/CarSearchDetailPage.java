package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class CarSearchDetailPage extends BasePage {

    public CarSearchDetailPage(WebDriver driver) {
        super(driver);
    }

    public CarSearchDetailPage() {
    }

    private By lblTitle = By.xpath("//h1[@data-cmp='heading']");
    private By lblFirstPrice = By.xpath("//div[@class='panel-body']/descendant::span[@class='first-price']");
    private By priceSection = By.xpath("//div[id='pricingDetailsSection']");
    private By lblVehicleSection = By.xpath("//div[@id='vehicleFeatures']//div[@data-cmp='heading']");
    private By lblPriceSection = By.xpath("//div[@id='pricingSection']/div[@data-cmp='heading']");
    private By tabFairMarket = By.xpath("//a[@id='pricing-tabs-tab-1']");
    private By tabPriceBreakdown = By.xpath("//a[@id='pricing-tabs-tab-2']");
    private By lblTitleTabFair = By.xpath("//div[@id='kbbPriceAdvisorSection']/div[@data-cmp='heading']");
    private By lblMessageTabFair = By.xpath("//div[@id='kbbPriceAdvisorSection']/div[@class='text-left']/p");
    private By lblTitleTabPriceBreakdown = By
            .xpath("//div[@id='pricing-tabs-pane-2']/descendant::div[@data-cmp='heading']");
    private By lblMessageTabPrice = By.xpath("//div[@id='pricing-tabs-pane-2']/descendant::div[@class='text-left']");
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
        if (getText(lblPriceSection).equals(expLabelPriceSection)
                & getText(tabFairMarket).equals(expLabelTabFairMarket)
                & getText(tabPriceBreakdown).equals(expLabelTabPriceBreakDown)) {
            return true;
        } else
            return false;
    }

    /**
     * 
     * @return
     */
    public boolean isTabPriceBreakdownDisplayedAsDefault(){
        if(getText(lblTitleTabFair).equals(expTitleTabFair)&getText(lblMessageTabFair).equals(expMessageTabFair)){
            return true;
        }
        else return false;
    }

    /**
     * Action to scroll to price section
     */
    public void scrollToPriceSection(){
        keyword.scrollToElement(keyword.findElement(lblVehicleSection));
    }

    String expTitleTabFair = "Kelley Blue Book® Fair Market Range";
    String expMessageTabFair = "Updated weekly, the Kelley Blue Book® Price Advisor helps you better understand what others have been paying for this car recently.";
    String expLabelPriceSection = "Pricing Details";
    String expLabelTabFairMarket = "Fair Market Range";
    String expLabelTabPriceBreakDown = "Price Breakdown and Offers";
}
