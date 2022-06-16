package com.example.pages.carForSale;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class KbbCarsForSaleDriveType extends BasePage {
    public KbbCarsForSaleDriveType(WebDriver driver,String DriveTypeElement) {
        super(driver);
        this.DiveTypeElement = DriveTypeElement;
    }

    //Cars for sale element
    private String DiveTypeElement = "AWD/4WD";
    
    private WebElement ddlDiveType = keyword.findElement(By.xpath("//span[text()='Drive Type']/parent::span/parent::div"));
    private WebElement lblResults = keyword.findElement(By.cssSelector("div.text-size-md-300"));

    private By localblResults = By.cssSelector("div.text-size-md-300");
    private By locachbDiveType = By.xpath("//span[text()='Drive Type']/parent::span/parent::div/parent::div//div[@data-cmp='checkboxGroup']");
    private By locatagDiveTypeDriveType = By.xpath(String.format("//span[text()='%s']",DiveTypeElement));
    private By locatagDiveTypeDriveTypeXIcon = By.xpath(String.format("//span[text()='%s']/parent::*/span/span",DiveTypeElement));
    private By locaoptDiveType = By.xpath(String.format("//div[text()='%s']",DiveTypeElement));
    private By locabtnExitAds = By.xpath("//button[@id='fsrFocusFirst']");
    private By locabtnExitAds2 = By.cssSelector("button.QSIWebResponsiveDialog-Layout1-SI_5d3NX5IIzg7mUmN_close-btn");
    private By localblClearFilters = By.xpath("//span[@class='text-link']");
    private By locaimgFirstResults = By.xpath("(//div[@data-cmp='itemCard'])[1]");


    //Result before and after change
    private double beforeResults = 0;
    private double afterResults = 0;

    //first img


    /**
     *  Return DiveTypeCheckbox is correct or not
     * @return
     */
    public boolean isDiveTypeCheckboxDisplayed(){
        WebElement chbDiveType = keyword.findElement(locachbDiveType);
        if(chbDiveType.isDisplayed()==true){
            return true;
        }
        else return false;
    }

    /**
     *  Return tagDiveTypeAWD is correct or not
     * @return
     */
    public boolean isTagDiveTypeDisplayed(){
        //after click
        WebElement tagDiveTypeDriveType = keyword.findElement(locatagDiveTypeDriveType);
        WebElement tagDiveTypeDiveTypeXIcon = keyword.findElement(locatagDiveTypeDriveTypeXIcon);
        if(tagDiveTypeDriveType.isDisplayed()==true & tagDiveTypeDiveTypeXIcon.isDisplayed()==true){
            return true;
        }
        else return false;
    }

    //action select opt Drive type and compare result before and after click
    public void actionSelectOptDriveType(){
        actionExitAds();
        keyword.scrollToElement(ddlDiveType);
        keyword.click(ddlDiveType);
        beforeResults = parseStringResultsToNumber(lblResults.getText());
        WebElement optDiveType = keyword.findElement(locaoptDiveType);
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
     *  Return tagDiveTypeAWD is correct or not
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
        WebElement imgFirstResults = keyword.findElement(locaimgFirstResults);
        keyword.scrollToElement(imgFirstResults);
        keyword.click(imgFirstResults);
    }

    /**
     *  Return AllDriveTypeAfterClick is correct or not
     * @return
     */
    public boolean isAllDriveTypeAfterClick(){
        if (isDiveTypeCheckboxDisplayed()==true &
            isNumberOfResultsChange()==true &
            isTagDiveTypeDisplayed()==true &
            islblClearFiltersDisplayed()==true) {
            return true;
        }
        else return false;
    }


    
}
