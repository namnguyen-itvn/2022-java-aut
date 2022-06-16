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

    //Result before and after change
    private double beforeResults = 0;
    private double afterResults = 0;

    //first img


    /**
     *  Return DiveTypeCheckbox is correct or not
     * @return
     */
    public boolean isDiveTypeCheckboxDisplayed(){
        WebElement chbDiveType = keyword.findElement(By.xpath("//span[text()='Drive Type']/parent::span/parent::div/parent::div//div[@data-cmp='checkboxGroup']"));
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
        WebElement tagDiveTypeAWD = keyword.findElement(By.xpath(String.format("//span[text()='%s']",DiveTypeElement)));
        WebElement tagDiveTypeAWDXIcon = keyword.findElement(By.xpath(String.format("//span[text()='%s']/parent::*/span/span",DiveTypeElement)));
        if(tagDiveTypeAWD.isDisplayed()==true & tagDiveTypeAWDXIcon.isDisplayed()==true){
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
        WebElement optDiveType = keyword.findElement(By.xpath(String.format("//div[text()='%s']",DiveTypeElement)));
        keyword.click(optDiveType);

        actionExitAds();

        // WebElement lblResults2 = keyword.findElement(By.cssSelector("div.text-size-md-300");
        WebElement lblResults2 = keyword.findElement(By.cssSelector("div.text-size-md-300"));
        afterResults = parseStringResultsToNumber(lblResults2.getText());

        actionExitAds();
    }

    //action exit ads
    public void actionExitAds(){
        try {
            WebElement optDiveType = keyword.findElement(By.xpath("//button[@id='fsrFocusFirst']"));
            keyword.click(optDiveType);
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
     *  Return tagDiveTypeAWD is correct or not
     * @return
     */
    public boolean islblClearFiltersDisplayed(){
        WebElement lblClearFilters = keyword.findElement(By.xpath("//span[@class='text-link']"));
        if(lblClearFilters.isDisplayed()==true){
            return true;
        }
        else return false;
    }

    //action navigate to cars-for-sale vehicle details page
    public void actionNavToCFSVehicleDetails(){
        WebElement imgFirstResults = keyword.findElement(By.xpath("(//div[@data-cmp='itemCard'])[1]"));
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
