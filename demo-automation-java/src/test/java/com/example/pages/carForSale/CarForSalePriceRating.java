package com.example.pages.carForSale;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarForSalePriceRating extends BasePage {
    public CarForSalePriceRating(WebDriver driver,String PriceRatingElement) {
        super(driver);
        this.PriceRatingElement = PriceRatingElement;
    }

    //Cars for sale element
    private String PriceRatingElement = "Good Price";
    
    private WebElement ddlPriceRating = keyword.findElement(By.xpath("//span[text()='Price Rating']/parent::span/parent::div"));
    private WebElement lblResults = keyword.findElement(By.cssSelector("div.text-size-md-300"));


    private By localblResults = By.cssSelector("div.text-size-md-300");
    private By locatagPriceRatingPriceRating  = By.xpath(String.format("//span[text()='%s']",PriceRatingElement));
    private By locatagPriceRatingXIcon = By.xpath(String.format("//span[text()='%s']/parent::*/span/span",PriceRatingElement));
    private By locaoptPriceRating = By.xpath(String.format("//div[text()='%s']",PriceRatingElement));
    private By locabtnExitAds = By.xpath("//button[@id='fsrFocusFirst']");
    private By locabtnExitAds2 = By.cssSelector("button.QSIWebResponsiveDialog-Layout1-SI_5d3NX5IIzg7mUmN_close-btn");
    private By localblClearFilters = By.xpath("//span[@class='text-link']");
    private By locaimgFirstResults = By.xpath("(//div[@data-cmp='itemCard'])[1]");
    private By locaMoreInfo = By.xpath("//span[@id='dealInfo']");
    private By locaoptPriceRating1 = By.xpath("//input[@value='goodprice']");
    private By locaoptPriceRating2 = By.xpath("//input[@value='greatprice']");

    //Result before and after change

    private double beforeResults = 0;
    private double afterResults = 0;



    /**
     *  Return tag Price Rating 'Good Price' is correct or not
     * @return
     */
    public boolean isTagPriceRatingDisplayed(){
        //after click
        WebElement tagPriceRatingPriceRating = keyword.findElement(locatagPriceRatingPriceRating );
        WebElement tagDiveTypeDiveTypeXIcon = keyword.findElement(locatagPriceRatingXIcon);
        if(tagPriceRatingPriceRating .isDisplayed()==true & tagDiveTypeDiveTypeXIcon.isDisplayed()==true){
            return true;
        }
        else return false;
    }

    //action select opt Price Ratinge and compare result before and after click
    public void actionSelectOptPriceRating(){
        actionExitAds();
        keyword.scrollToElement(ddlPriceRating);
        keyword.click(ddlPriceRating);
        beforeResults = parseStringResultsToNumber(lblResults.getText());
        WebElement optDiveType = keyword.findElement(locaoptPriceRating );
        keyword.click(optDiveType);

        actionExitAds();

        WebElement lblResults2 = keyword.findElement(localblResults);
        afterResults = parseStringResultsToNumber(lblResults2.getText());

        actionExitAds();
    }

    //action exit ads
    public void actionExitAds(){
        try {
            WebElement btnExitAds = keyword.findElement(locabtnExitAds);
            keyword.click(btnExitAds);
        } catch (Exception e) {
            try {
                WebElement btnExitAds2 = keyword.findElement(locabtnExitAds2);
                keyword.click(btnExitAds2);
            } catch (Exception a) {
            }
        }
    }

    /**  
     *  Return Number of results is change or not
     * @return
     */
    public boolean isNumberOfResultsChange(){
        if(beforeResults!=afterResults){
             return true;
        }
        else return false;
    }

    //func convert string to number Results
    public double parseStringResultsToNumber(String input)
    {
        String removeResults = input.replace(" Results","");
        String removeComma = removeResults.replace(",","");
        String removeClear = removeComma.replace("|Clear Filters","");
        System.out.println(removeClear);
        double number=Float.parseFloat(removeClear);
        
        return number;
    }

    /**
     *  Return tag Price Rating "Good Price" is correct or not
     * @return
     */
    public boolean islblClearFiltersDisplayed(){
        WebElement lblClearFilters = keyword.findElement(localblClearFilters);
        if(lblClearFilters.isDisplayed()==true){
            return true;
        }
        else return false;
    }

    public boolean isMoreInfoDisplayed(){
        WebElement lblMoreInfo = keyword.findElement(locaMoreInfo);
        if(lblMoreInfo.isDisplayed()==true){
            return true;
        }
        else return false;
    }

    //action navigate to cars-for-sale vehicle details page
    public void actionNavToCFSVehicleDetails(){
        actionSelectOptPriceRating();
        WebElement imgFirstResults = keyword.findElement(locaimgFirstResults);
        keyword.scrollToElement(imgFirstResults);
        keyword.click(imgFirstResults);
    }

    /**
     *  Return AllPriceRatingAfterClick is correct or not
     * @return
     */
    public boolean isAllPriceRatingAfterClick(){
        if (isNumberOfResultsChange()==true &
            isTagPriceRatingDisplayed()==true &
            islblClearFiltersDisplayed()==true) {
            return true;
        }
        else return false;
    }

    public boolean isCheckBoxNotSelect() throws InterruptedException{
        actionExitAds();
        keyword.scrollToElement(ddlPriceRating);
        keyword.click(ddlPriceRating);
        actionExitAds();
        Thread.sleep(3000);
        WebElement optDiveType1 = keyword.findElement(locaoptPriceRating1);
        WebElement optDiveType2 = keyword.findElement(locaoptPriceRating2);
        
        if (optDiveType1.isSelected() == false &
            optDiveType2.isSelected() == false &
            isMoreInfoDisplayed() == true ) {
            return true;
        }
        else return false;
    }

    public String firstCarPageTitle() {
        return driver.getTitle();
    } 
    public String expectedFirstCar = "Used 2015 Ford Edge SEL for sale in Amherst, OH 44001: Sport Utility Details - 470064485 - Autotrader";
    public boolean isTitleCorrected(String expectedTitle) {
        return firstCarPageTitle().equals(expectedTitle);
    }

    
    
}