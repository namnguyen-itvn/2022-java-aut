package com.example.pages.car_reviews_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarReviewsDetailModulePage1 extends BasePage {
    public CarReviewsDetailModulePage1(WebDriver driver) {
        super(driver);
    }

    /**
     * Declcart object
     */
    String expectTitleSpec = "Specifications";
    /**
     * Declare element of tab Specs before click readmore
     */
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
    /**
     * Declare element of tab Specs after click readmore
     */
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
    /**
     * Declare element of tab Safety
     */
    private By btnSafety = By.xpath("//button[@data-section-name='safety']");
    private By titleSafety = By
            .xpath("//h3[@class='css-1qmwhcr-StyledHeading3 e148eed12' and contains(text(),'Safety')]");
    private By titleSafetyTechnology = By
            .xpath("//h3[@class='css-1w44i20-StyledHeading3 e148eed12' and contains(text(),'Safety Technology')]");
    private By contentSafety = By
            .xpath("//div[@data-cypress='safety-without-rating']//div[@class='css-zzr0gm-Gridcontainers eds0yfe0']");
    private By lblNotAvailable = By.xpath("//*[@id='safety']//span[text()='Not Available']");
    private By lblCrashTest = By.xpath("//*[@id='safety']//div[text()='Crash Test Rating']");
    private By lblFrontalCrash = By.xpath("//div[text()='Frontal Crash']");
    private By lblSideBarrier = By.xpath("//div[text()='Side Barrier']");
    private By lblRolloverRating = By.xpath("//div[text()='Rollover Rating']");
    private By lblSideCrash = By.xpath("//div[text()='Side Crash']");
    /**
     * Declare element of tab Styles
     */
    private By btnStyles = By.xpath("//button[@data-section-name='styles']");
    private By titleStyles = By
            .xpath("//h3[@class='css-1qmwhcr-StyledHeading3 e148eed12' and contains(text(),'Styles')]");
    private By containersStyles = By.cssSelector(".card-heading.css-1jfingr.erywcq01");
    private By lblLowestPrice = By.xpath("//div[@id='styles']//div[text()='Lowest-Priced']");
    private By titlecontainers;
    private By txtCombineFuelEconomy;
    private By txtSeatingStyles;
    private By txtHorsePowerStyles;
    private By txtEngine;
    private By btnSelectStyles;


    /**
     * Declare element of BestCar
     */
    private By titleBestCar = By.xpath("//div[@id='rankings-header']");
    private By containersBestCar = By.cssSelector(".css-18ruswi-Label.e9vui824");
    private By linkToBestCarTopic = By.xpath(
            "//div[@data-cypress='rankings-section']//a[@href='https://www.kbb.com/cars/best-luxury-full-size-cars/' and text()]");
    private By linkToReadHowWeRateCars = By.xpath(
            "//div[@data-cypress='rankings-section']//a[@href='https://www.kbb.com/car-news/how-kelley-blue-book-rates-cars' and text()]");
    private By bestSuggestions = By
            .xpath("//div[@id='app']//h3[@class='css-1w44i20-StyledHeading3 e148eed12' and contains(text(),'Best')]");
    private By linkSeeAllBestCar = By.xpath(
            "//div[@data-cypress='rankings-section']//a[@href='https://www.kbb.com/cars/best-luxury-full-size-cars/']/span");

    /**
     * Declare element of Other Year
     */
    private By titleOtherYear = By.xpath("//div//h4[text()='Other Years']");
    private By containersContentOtherYear = By.xpath(
            "//li[@class='evwqgx80 css-y8n0kn-CommonListItem-CustomListItem e3ol5gl0']/span/a[@data-analytics='ymm_otheryears_lnk']");
    private By contentOtherYear;
 /**
     * Declare element Expert Review Section
     */
    private By tstTitleOfExpertReviewSection = By.cssSelector("h2[class*='css-7q8m0g-StyledHeading2 e148eed11']");
    private By btnAuthorName =By.cssSelector("span[class*='css-dq7l91 e1b9ten30']");
    private By imgAuthor = By.xpath("//div[@class='eijuktk3 css-5m5jmw-ContentContainer e1qqueke0']//img");
    private By expertReview= By.cssSelector("div[data-analytics*='readmore_ucymm_expert_review_btn']"); 
    private By btnSeeMoreReview = By.cssSelector("button[class*='css-92974k-FocusWrapper e1july549']");
    private By messageNoHasExpertReview = By.xpath("//div[@class='css-de22qy-ColBase e1l0ytpk0']//p[@class='css-113e3v-StyledParagraph emgezi80']");
    private By codeInvalidMessage = By.xpath("//span[@class='css-tiv2r2-StyledError e2plhlo1']");
    private By btnGetReviews = By.xpath("//button[@class='css-1hn5qfm-transitionRules-default-WrappedButton']");

    /**
     * funtion Click to Tab
     */
    public void clickTabSpecsandFeature() {
        keyword.click(keyword.findElement(tabSpecsandFeature));
    }

    public void clickReadMoreInSpecsandFeature() {
        keyword.click(keyword.findElement(btnReadMore));
    }

    public void clickSafety() {
        keyword.click(keyword.findElement(btnSafety));
    }

    public void clickStyles() {
        keyword.click(keyword.findElement(btnStyles));
    }
 /**
     * funtion Scroll
     */
    public void scrollDown() {
        keyword.scrollToElement(keyword.findElement(consumerReview));
    }

    public void scrolltoBestCar() {
        keyword.scrollToElement(keyword.findElement(titleBestCar));
    }

    /**
     * Add element to list
     * 
     * @param element
     * @return List Element
     */
    private List<WebElement> listcontainers(By element) {
        return keyword.findElements(element);
    }

    /**
     * Check Lowest Price displayed correct or not
     * 
     * @return
     */
    public boolean lblLowestPriceDisplayed() {
        if (isElementDisplayed(keyword.findElement(lblLowestPrice)))
            return true;
        return false;
    }
    
    /**
     * Check element car review is displayed or not
     * 
     * @param
     * @return Correct or not
     */
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

    /**
     * Check element car review is displayed or not after click read more
     * 
     * @param
     * @return
     */
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

    /**
     * Check title of tab safety displayed correct or not
     * 
     * @param year
     * @param make
     * @param model
     * @return
     */
    public boolean isTitileIsTrueTabSafety(String year, String make, String model) {
        String expectTitleSafeTy = year + " " + make + " " + model + " Safety";
        if (isElementTextEqualExpectedText(keyword.findElement(titleSafety), expectTitleSafeTy))
            return true;
        return false;
    }

    /**
     * check content of tab safety displayed correcr or not
     * 
     * @param year
     * @param make
     * @param model
     * @return
     */
    public boolean isContentofTabSafetyDisplayed(String year, String make, String model) {
        String expectTitleSafeTy = year + " " + make + " " + model + " Safety" + " Technology";
        if (isElementDisplayed(keyword.findElement(contentSafety)) &&
                isElementDisplayed(keyword.findElement(lblNotAvailable)) &&
                isElementDisplayed(keyword.findElement(lblCrashTest)) &&
                isElementDisplayed(keyword.findElement(lblFrontalCrash)) &&
                isElementDisplayed(keyword.findElement(lblRolloverRating)) &&
                isElementDisplayed(keyword.findElement(lblSideBarrier)) &&
                isElementDisplayed(keyword.findElement(lblSideCrash)) &&
                isElementTextEqualExpectedText(keyword.findElement(titleSafetyTechnology), expectTitleSafeTy))
            return true;
        return false;
    }

    /**
     * check elemnt in container of tab Styles displayed correct or not
     * 
     * @param year
     * @param make
     * @param model
     * @return
     */
    public boolean isContainersStylesDisplayedCorrectly(String year, String make, String model) {

        String expectTitleStyle = year + " " + make + " " + model + " Styles";
       
        for (int i = 1; i < listcontainers(containersStyles).size(); i++) {
            titlecontainers = By.xpath("//div[@id='styles']//a[" + i + "]//h3");
            txtCombineFuelEconomy = By.xpath("//div[@id='styles']//a[" + i + "]//div[text()='Combined Fuel Economy']");
            txtSeatingStyles = By.xpath("//div[@id='styles']//a[" + i + "]//div[text()='Seating']");
            txtHorsePowerStyles = By.xpath("//div[@id='styles']//a[" + i + "]//div[text()='Horsepower']");
            txtEngine = By.xpath("//div[@id='styles']//a[" + i + "]//div[text()='Engine']");
            btnSelectStyles = By.xpath("//div[@id='styles']//a[" + i + "]//span[text()='Select']");

            if (isElementDisplayed(keyword.findElement(titlecontainers)) &&
                    isElementDisplayed(keyword.findElement(txtCombineFuelEconomy)) &&
                    isElementDisplayed(keyword.findElement(txtSeatingStyles)) &&
                    isElementDisplayed(keyword.findElement(txtHorsePowerStyles)) &&
                    isElementDisplayed(keyword.findElement(txtEngine)) &&
                    isElementEnabled(keyword.findElement(btnSelectStyles)) &&
                    isElementTextEqualExpectedText(keyword.findElement(titleStyles), expectTitleStyle))
                return true;
            else
                break;
        }
        return false;
    }

    /**
     * check element in container of best car displayed correct or not
     * @return
     */
    public boolean isContainerBestCarDisplayedCorrectly() {
        Integer totalcontainerss = 4;
        if (totalcontainerss.equals(listcontainers(containersBestCar).size()) &&
                isElementDisplayed(keyword.waitForElementToBeClickable(keyword.findElement(linkToBestCarTopic))) &&
                isElementDisplayed(keyword.waitForElementToBeClickable(keyword.findElement(linkToReadHowWeRateCars))) &&
                isElementDisplayed(keyword.waitForElementToBeClickable(keyword.findElement(linkSeeAllBestCar))) &&
                isElementDisplayed(keyword.findElement(bestSuggestions)))
            return true;
        return false;
    }

    /**
     * Check content of Other Year displayed correct or not
     * @param make
     * @param model
     * @return
     */
    public boolean isContentOtherYearDisplayCorrectly(String make, String model)
    {
        keyword.scrollToElement(keyword.findElement(titleOtherYear));
        String expectContent = make + " " + model;
        for(int i = 1;i<listcontainers(containersContentOtherYear).size();i++)
        {
            contentOtherYear = By.xpath("//li[" + i + "]/span/a[@data-analytics='ymm_otheryears_lnk']");
            if(keyword.findElement(contentOtherYear).getText().contains(expectContent)==true)
                return true;
            else
                break;
        }
        return false;
    }

    /**
     * navigate to Build&Price Page went click on button
     * @param year
     * @param make
     * @param model
    */
    public void clickOnBuildAndPriceButton(String year, String make, String model){
        WebElement btnBuildAndPrice  = driver.findElement(By.xpath("//a[@data-analytics='buyused_overview_btn']"));
        keyword.click(btnBuildAndPrice);
    }

    /**
     * navigate to See Car For Sale Page Went Click on this button
      * @param year
     * @param make
     * @param model
    */
    public void clickOnSeeCarForSaleButton(String year, String make, String model){
        WebElement btnSeeCarForSale  = driver.findElement(By.xpath("//a[@data-analytics='inv_findinv_btn']"));
        keyword.click(btnSeeCarForSale);
    }

    /**
     * Click on the img or the name of Author when has Expert Review Section
     * @param webElement
    */
    public void clickOnImgAuthorToNavigateAuthorPage(){
        keyword.click(keyword.findElement(imgAuthor));
    }

    /**
     * Click on the img or the name of Author when has Expert Review Section
     * @param webElement
    */
    public void clickOnAuthorNameToNavigateAuthorPage(){
        keyword.click(keyword.findElement(btnAuthorName));
    }


    /**
     * Verify the Expert Review display or not
     * @param year
     * @param make
     * @param model
     * @return
    */
    public boolean isExpertReviewDisplay(String year,String make,String model){
        String expectTitleExpertReview=year + " " + make + " " + model + " Review";
        if(isElementDisplayed(keyword.findElement(tstTitleOfExpertReviewSection))
        &&isElementDisplayed(keyword.findElement(expertReview))
        &&isElementDisplayed(keyword.findElement(btnSeeMoreReview))
        &&isElementTextEqualExpectedText(keyword.findElement(tstTitleOfExpertReviewSection), expectTitleExpertReview))
        return true;
        return false;
    }

    /**
     * return the message no has expert Review display or not
     * @return
    */
    public boolean isMessageNoHasExpertReviewDisplay(){
        if(isElementDisplayed(keyword.findElement(messageNoHasExpertReview)))
            return true;
        return false;
    }

    /**
     * 
     * @return
    */
    public boolean isInValueMessageDisplayCorrect(){
        String expcetedMessage = "ZIP Code is invalid.";
        if(isElementDisplayed(keyword.findElement(codeInvalidMessage))&&isElementTextEqualExpectedText(keyword.findElement(codeInvalidMessage),expcetedMessage )&&isElementEnabled(keyword.findElement(btnGetReviews))==false)return true;
        return false;
    }
}
