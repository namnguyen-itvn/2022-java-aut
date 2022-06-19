package com.example.pages.carForSale;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.pages.BasePage;

public class CarForSaleMake extends BasePage {
    public CarForSaleMake(WebDriver driver,String MakeElement) {
        super(driver);
        this.MakeElement = MakeElement;
    }

    //Cars for sale element
    private String MakeElement = "BMW";
    
    private WebElement ddlMake = keyword.findElement(By.xpath("//span[text()='Make']/parent::span/parent::div"));
    private WebElement lblResults = keyword.findElement(By.cssSelector("div.text-size-md-300"));

    private By localblResults = By.cssSelector("div.text-size-md-300");

    private By locatagMake  = By.xpath(String.format("//span[text()='%s']",MakeElement));
    private By locatagMakeXIcon = By.xpath(String.format("//span[text()='%s']/parent::*/span/span",MakeElement));

    private By localblClearFilters = By.xpath("//span[@class='text-link']");
    private By locaimgFirstResults = By.xpath("(//div[@data-cmp='itemCard'])[1]");

    private By locaListOptMake = By.xpath("//input[@value='ACURA']/parent::label/parent::div/label");
    private By locaListOptSeries = By.xpath("//input[@value='M3_SERIES']/parent::label/parent::div/label");
    private By locaListOptModel = By.xpath("//input[@value='BMW230I']/parent::label/parent::div/label");


    //Result before and after change
    private double beforeResults = 0;   
    private double afterResults = 0;

    /**
     *  Return tag Price Rating 'Good Price' is correct or not
     * @return
     */
    public boolean isTagMakeDisplayed(){
        //after click
        WebElement tagMakeMake = keyword.findElement(locatagMake );
        WebElement tagDiveTypeDiveTypeXIcon = keyword.findElement(locatagMakeXIcon);
        if(tagMakeMake .isDisplayed()==true & tagDiveTypeDiveTypeXIcon.isDisplayed()==true){
            return true;
        }
        else return false;
    }

    //action select opt Price Ratinge and compare result before and after click
    public void actionSelectOptMake(){
        waitNoCondition();
        keyword.scrollToElement(ddlMake);
        waitNoCondition();
        keyword.clickWithOutScroll(ddlMake);
        beforeResults = parseStringResultsToNumber(lblResults.getText());
        List<WebElement> listOptMake = driver.findElements(locaListOptMake);
        keyword.click(listOptMake.get(6));

        waitNoCondition();
        List<WebElement> listOptSeries = driver.findElements(locaListOptSeries);
        keyword.scrollToElement(listOptSeries.get(8));
        keyword.clickWithOutScroll(listOptSeries.get(8));

        waitNoCondition();
        List<WebElement> listOptModel = driver.findElements(locaListOptModel);
        keyword.scrollToElement(listOptModel.get(8));
        keyword.clickWithOutScroll(listOptModel.get(8));
        
        waitNoCondition();
        WebElement lblResults2 = keyword.findElement(localblResults);
        afterResults = parseStringResultsToNumber(lblResults2.getText());
    }

    //wait with No Condition
    public void waitNoCondition(){
        By locabtnExitAds = By.xpath("//button[@id='fsrFocusFirst']");
        WebDriverWait wait1 = new WebDriverWait(driver, 3);
        try {
            WebElement btnExitAds = wait1.until(ExpectedConditions.visibilityOfElementLocated(locabtnExitAds));
        } catch (Exception e) {
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

    //action navigate to cars-for-sale vehicle details page
    public void actionNavToCFSVehicleDetails(){
        actionSelectOptMake();
        WebElement imgFirstResults = keyword.findElement(locaimgFirstResults);
        keyword.click(imgFirstResults);
    }

    /**
     *  Return AllMakeAfterClick is correct or not
     * @return
     */
    public boolean isAllMakeAfterClick(){
        if (isNumberOfResultsChange()==true &
            isTagMakeDisplayed()==true &
            islblClearFiltersDisplayed()==true) {
            return true;
        }
        else return false;
    }

    public boolean isCheckBoxNotSelect() throws InterruptedException{
        waitNoCondition();
        keyword.scrollToElement(ddlMake);
        waitNoCondition();
        
        List<WebElement> listOpt = driver.findElements(locaListOptMake);
        for (WebElement webElement : listOpt) {
            if (webElement.isSelected() == true ) {
            return false;
        }
        }return true;
    }

    public String firstCarPageTitle() {
        return driver.getTitle();
    } 
    public String expectedFirstCar = "Used 2016 Toyota Camry  for sale in Little Rock, AR 72210: Sedan Details - 502188902 - Autotrader";
    public boolean isTitleCorrected(String expectedTitle) {
        return firstCarPageTitle().equals(expectedTitle);
    }
    
}