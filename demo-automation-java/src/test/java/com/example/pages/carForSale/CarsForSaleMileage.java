package com.example.pages.carForSale;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.core.keyword.WebKeyword.chooseTypeOfSelect;
import com.example.pages.BasePage;

public class CarsForSaleMileage extends BasePage {
    public CarsForSaleMileage(WebDriver driver) {
        super(driver);
    }

    // car4sale Mileage element
    private WebElement btnMileage = keyword.findElement(By.xpath("//span[text()='Mileage']/parent::span/parent::div"));
    private By locasltMileage = By.xpath("//select[@id='1819194850']");
    private By locaoptMileageAny = By.xpath("//select[@id='1819194850']/option[@label='Any']");
    private By locaimgFirstResults = By.xpath("(//div[@data-cmp='itemCard'])[1]");


    //action ClickBtnMileage
    public void actionClickBtnMileage(){
        actionExitAds();
        keyword.scrollToElement(btnMileage);
        keyword.click(btnMileage);
    }


    /**
     *  Return MinPriceTextHint is correct or not
     * @return
     */
    public boolean isSelectOptAnyCorrect(){
        WebElement optMileageAny = keyword.findElement(locaoptMileageAny);
        if (optMileageAny.isSelected()==true) {
            return true;
        }
        else return false;
    }

    //action select optMileageUnder
    /**
     *  action select optMileageUnder
     * @param value
     * @return
     */
    public void actionSelectOptMileage(String value){
        WebElement sltMileage = keyword.findElement(locasltMileage);
        keyword.setValueForElement(sltMileage, chooseTypeOfSelect.selectByValue, value);
        actionExitAds();
    }

    //action navigate to cars-for-sale vehicle details page
    public void actionNavToCFSVehicleDetails(){
        WebElement imgFirstResults = keyword.findElement(locaimgFirstResults);
        keyword.scrollToElement(imgFirstResults);
        keyword.click(imgFirstResults);
        actionExitAds();
    }


    //action exit ads: including 2 ads, if showing 2 ads in a row, it will fail
    public void actionExitAds(){
        By locabtnExitAds = By.xpath("//button[@id='fsrFocusFirst']");
        By locabtnExitAds2 = By.cssSelector("button.QSIWebResponsiveDialog-Layout1-SI_5d3NX5IIzg7mUmN_close-btn");
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
    public void actionExitAds1(){
        By locabtnExitAds = By.xpath("//button[@id='fsrFocusFirst']");
        try {
            WebElement btnExitAds = keyword.findElement(locabtnExitAds);
            keyword.click(btnExitAds);
        } catch (Exception e) {
        }
    }


}