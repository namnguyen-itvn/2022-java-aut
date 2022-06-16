package com.example.pages.carForSale;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.pages.BasePage;

public class CarForSaleShowPaymentToggleButtonPage extends BasePage {

    public CarForSaleShowPaymentToggleButtonPage(WebDriver webDriver) {
        super(webDriver);
        //TODO Auto-generated constructor stub
    }

    /**
     * check Show Payment Dialog should be displayed when website URL is navigated to Car For Sale Page
     * @return true
     */
    public boolean checkShowPaymentDialogShouldBeDisplayed() {      
        WebElement dialogShowPayment = keyword.findElement(By.cssSelector("div[class='popover-content']"));
        return dialogShowPayment.isDisplayed();
    }

    /**
     * check Show Payment Dialog should be displayed text New... link Not Now and btn Show Payment
     * @return boolean check
     */
    public boolean checkShowPaymentDialogShouldBeDisplayedCorrectly() {
        boolean check = false;
        WebElement txtNew = keyword.findElement(By.cssSelector("p[class='margin-bottom-4']"));    
        WebElement toggleButtonIsNotChecked = keyword.findElement(By.xpath("//div[@class='display-flex align-items-center']/div/div['react-toggle display-flex align-self-center']"));  
        
        if(toggleButtonIsNotChecked.isDisplayed()) {
            WebElement linkNotNow = keyword.findElement(By.xpath("//div[@class='popover-content']//div//button[@class='btn btn-link']"));
            WebElement btnShowPayMent = keyword.findElement(By.cssSelector("button[class='btn btn-primary']"));
            if(txtNew.isDisplayed() && linkNotNow.isDisplayed() && btnShowPayMent.isDisplayed()) {
                check = true;
            } else {
                check = false;
            }
        }     
        return check;
    }

    /**
     * Check after click link Not Now the toggle button is not anable and estimated payment is displayed 'See estimated payment'
     * @return boolean check
     */
    public boolean checkLinkNotNowWorkCorrectly() {
        boolean check = false;
        WebElement linkNotNow = keyword.findElement(By.xpath("//div[@class='popover-content']//div//button[@class='btn btn-link']"));      
        keyword.click(linkNotNow);
        WebElement toggleButtonIsNotChecked = keyword.findElement(By.xpath("//div[@class='display-flex align-items-center']/div/div['react-toggle display-flex align-self-center']"));
        if(toggleButtonIsNotChecked.isDisplayed() && checkEstimatedPaymentIsDisplayed()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    /**
     * check click Button Show Payment, the UI of page should display price and toggle button is enable
     * @return boolean check
     */
    public boolean checkButtonShowPaymentWorkCorrectly() {
        boolean check = false;
        WebElement btnShowPayMent = keyword.findElement(By.cssSelector("button[class='btn btn-primary']"));
        keyword.click(btnShowPayMent);
        WebElement modalMyWallet = keyword.findElement(By.cssSelector("div[class='modal-content']"));
        if(modalMyWallet.isDisplayed()) {
            WebElement btnCloseModalMyWallet = keyword.findElement(By.cssSelector("button[class='close']"));
            keyword.click(btnCloseModalMyWallet);
            WebElement toggleButtonIsChecked = keyword.findElement(By.xpath("//div[@class='display-flex align-items-center']/div/div['react-toggle react-toggle--checked display-flex align-self-center']"));
            WebElement txtPrice = keyword.findElement(By.cssSelector("span[class='text-link text-size-200 display-block']"));
            if(txtPrice.isDisplayed() && toggleButtonIsChecked.isDisplayed()) {
                check = true;
            } else {
                check = false;
            }
        } else {
            check = false;
        }
        return check;
    }

    /**
     * check Estimated Payment is displayed text 'See estimated payment'
     * @return boolean check
     */
    public boolean checkEstimatedPaymentIsDisplayed() {
        boolean check = false;
        WebElement listLinkEstimatedPayment = keyword.findElement(By.xpath("//span[text()='See estimated payment']"));
            if(listLinkEstimatedPayment.isDisplayed()) {
                check = true;
            } else {
                check = false;
            }
        return check;
    }

    /**
     * check Sort Dropdown List is displayed
     * @return boolean check;
     */
    public boolean checkSortDropdownListIsDisplayed() {
        boolean check = false;
        WebElement ddlSort = keyword.findElement(By.cssSelector("div[class='form-group margin-bottom-0']"));
        if(ddlSort.isDisplayed()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }      
}
