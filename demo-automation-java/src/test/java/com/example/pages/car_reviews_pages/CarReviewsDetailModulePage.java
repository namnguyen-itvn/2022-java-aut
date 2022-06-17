package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;
import com.fasterxml.jackson.databind.node.BooleanNode;

public class CarReviewsDetailModulePage extends BasePage {
    public CarReviewsDetailModulePage() {
    }

    public CarReviewsDetailModulePage(WebDriver driver) {
        super(driver);
    }

    // Declare object
    // Before Click Read More
    private By tabSpecsandFeature = By.xpath("//button[@data-section-name='specs']");
    private By titleSpecsandFeature = By.xpath("//h3[@id='specs-heading']");
    private By iconFuelEconomy = By.xpath("//div[@class='css-2x73up-LeftIconStyle-ResponsiveStyle ewnonp41']");
    private By txtFuelEconomy = By.xpath("//div[@direction='stacked']/div[text()='Fuel Economy']");
    private By iconFuelType = By.xpath("//div[@class='css-1fr5kjr-LeftIconStyle-ResponsiveStyle ewnonp41']");
    private By txtFuelType = By.xpath("//div[@direction='stacked']/div[text()='Fuel Type']");
    private By iconBasicWarranty = By.xpath("//div[@class='css-1v4dzwp-LeftIconStyle-ResponsiveStyle ewnonp41']");
    private By txtBasicWarranty = By.xpath("//div[@direction='stacked']/div[text()='Basic Warranty']");
    private By iconMaxSeating = By.xpath("//div[@class='css-8e4jkk-LeftIconStyle-ResponsiveStyle ewnonp41']");
    private By txtMaxSeating = By.xpath("//div[@direction='stacked']/div[text()='Max Seating']");
    private By iconHorsepower = By.xpath("//div[@class='css-1vk98ap-LeftIconStyle-ResponsiveStyle ewnonp41']");
    private By txtHorsepower = By.xpath("//div[@direction='stacked']/div[text()='Horsepower']");
    private By iconCargoSpace = By.xpath("//div[@class='css-1wwux9p-LeftIconStyle-ResponsiveStyle ewnonp41']");
    private By txtCargoSpace = By.xpath("//div[@direction='stacked']/div[text()='Cargo Space']");
    private By btnReadMore = By.xpath("//button[@aria-label='Expand']/div");
    // After Click Read More
    private By txtDimensions = By.xpath("//h3[text()='Dimensions, Weights & Capacities']");
    private By txtMechanical = By.xpath("//h3[text()='Mechanical']");
    private By txtWarranty = By.xpath("//h3[text()='Warranty']");
    private By txtExterior = By.xpath("//h3[text()='Exterior']");
    private By txtPerformance = By.xpath("//h3[text()='Performance']");
    private By txtTechnology = By.xpath("//h3[text()='Technology']");
    private By txtEntertainment = By.xpath("//h3[text()='Entertainment']");
    private By txtSeating = By.xpath("//h3[text()='Seating']");
    private By txtInterior = By.xpath("//h3[text()='Interior']");
    private By txtSecurity = By.xpath("//h3[text()='Security']");
    private By btnReadLess = By.xpath("//button[@aria-label='Collapse']");
    private By consumerReview = By.xpath("//h2[@id='consumerreview']");
    // Tab Safety
    private By btnSafety = By.xpath("//button[@data-section-name='safety']");
    private By titleSafety = By.xpath("//h3[@class='css-1qmwhcr-StyledHeading3 e148eed12' and contains(text(),'Safety')]");
    private By titleSafetyTechnology = By.xpath("//h3[@class='css-1w44i20-StyledHeading3 e148eed12' and contains(text(),'Safety Technology')]");
    private By contentSafety = By.xpath("//div[@class='css-15p4ec8-GridContainer eds0yfe0']");
    private By lblNotAvailable = By.xpath("//*[@id='safety']//span[text()='Not Available']");
    private By lblCrashTest = By.xpath("//*[@id='safety']//div[text()='Crash Test Rating']");
    private By lblFrontalCrash = By.xpath("//div[text()='Frontal Crash']");
    private By lblSideBarrier = By.xpath("//div[text()='Side Barrier']");
    private By lblRolloverRating = By.xpath("//div[text()='Rollover Rating']");
    private By lblSideCrash = By.xpath("//div[text()='Side Crash']");
    
    String expectTitleSpec = "Specifications";

    public void clickTabSpecsandFeature() {
        keyword.click(keyword.findElement(tabSpecsandFeature));
    }

    public void clickReadMoreInSpecsandFeature() {
        keyword.click(keyword.findElement(btnReadMore));
    }

    public void clickSafety()
    {
        keyword.click(keyword.findElement(btnSafety));
    }

    public boolean isCarReviewsSpecificationModuleDisplayed() {
        if (isElementDisplayed(keyword.findElement(titleSpecsandFeature)) &&
                isElementDisplayed(keyword.findElement(iconFuelEconomy)) &&
                isElementDisplayed(keyword.findElement(txtFuelEconomy)) &&
                isElementDisplayed(keyword.findElement(iconFuelType)) &&
                isElementDisplayed(keyword.findElement(txtFuelType)) &&
                isElementDisplayed(keyword.findElement(iconBasicWarranty)) &&
                isElementDisplayed(keyword.findElement(txtBasicWarranty)) &&
                isElementDisplayed(keyword.findElement(iconMaxSeating)) &&
                isElementDisplayed(keyword.findElement(txtMaxSeating)) &&
                isElementDisplayed(keyword.findElement(iconHorsepower)) &&
                isElementDisplayed(keyword.findElement(txtHorsepower)) &&
                isElementDisplayed(keyword.findElement(iconCargoSpace)) &&
                isElementDisplayed(keyword.findElement(txtCargoSpace)) &&
                isElementEnabled(keyword.findElement(btnReadMore)) &&
                isElementTextEqualExpectedText(keyword.findElement(titleSpecsandFeature), expectTitleSpec))
            return true;
        return false;
    }

    public boolean isCarReviewsSpecificationModuleDisplayedAfterClickReadMore() {
        if (isElementDisplayed(keyword.findElement(titleSpecsandFeature)) &&
                isElementDisplayed(keyword.findElement(txtDimensions)) &&
                isElementDisplayed(keyword.findElement(txtMechanical)) &&
                isElementDisplayed(keyword.findElement(txtWarranty)) &&
                isElementDisplayed(keyword.findElement(txtExterior)) &&
                isElementDisplayed(keyword.findElement(txtPerformance)) &&
                isElementDisplayed(keyword.findElement(txtTechnology)) &&
                isElementDisplayed(keyword.findElement(txtEntertainment)) &&
                isElementDisplayed(keyword.findElement(txtSeating)) &&
                isElementDisplayed(keyword.findElement(txtInterior)) &&
                isElementDisplayed(keyword.findElement(txtSecurity)) &&
                isElementDisplayed(keyword.findElement(iconCargoSpace)) &&
                isElementDisplayed(keyword.findElement(txtCargoSpace)) &&
                isElementEnabled(keyword.findElement(btnReadLess)))
            return true;
        return false;
    }

    public boolean isTitileIsTrueTabSafety(String year,String  make, String model)
    {
        String expectTitleSafeTy = year + " " + make + " " + model + " Safety";
        if(isElementTextEqualExpectedText(keyword.findElement(titleSafety), expectTitleSafeTy))
            return true;
        return false;
    }

    public boolean isTitileIsTrueTabSafetyTechnology(String year,String  make, String model)
    {
        String expectTitleSafeTy = year + " " + make + " " + model + " Safety" + " Technology";
        if(isElementDisplayed(keyword.findElement(contentSafety))&&
        isElementTextEqualExpectedText(keyword.findElement(titleSafetyTechnology), expectTitleSafeTy))
            return true;
        return false;
    }

    public void scrollDown()
    {
        keyword.scrollToElement(keyword.findElement(consumerReview));
    }
}
