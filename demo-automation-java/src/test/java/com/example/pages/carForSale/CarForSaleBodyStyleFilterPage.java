package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarForSaleBodyStyleFilterPage extends BasePage {

    public CarForSaleBodyStyleFilterPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    
    /**
     * check Body Style On Filter Should Be Extended
     * @return boolean check
     */
    public boolean checkBodyStyleOnFilterShouldBeExtended() {
        boolean check = false;
        WebElement bodyStyleFilter = keyword.findElement(By.xpath("//div[@class='accordion-panel-content-wrapper padding-horizontal-4 collapse in']//div[@class='accordion-panel-content']/div/div[@class='checkbox-group row']"));
        if(bodyStyleFilter.isDisplayed()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    /**
     * choose option in Body Style
     * @param option
     */
    public void chooseOptionInBodyStyle(String option) {
        WebElement elementToSeeAllBodyStyle = keyword.findElement(By.xpath("//div[text()='Alternative']"));
        keyword.scrollToElement(elementToSeeAllBodyStyle);
        switch(option) {
            case "Convertible": 
                WebElement convertibleOptions = keyword.findElement(By.xpath("//div[text()='Convertible']/preceding-sibling::div"));
                keyword.click(convertibleOptions);
                break;
            case "Coupe":
                WebElement coupeOptions = keyword.findElement(By.xpath("//div[text()='Coupe']/preceding-sibling::div"));
                keyword.click(coupeOptions);
                break;
            case "Hatchback":
                WebElement hatchbackOptions = keyword.findElement(By.xpath("//div[text()='Hatchback']/preceding-sibling::div"));
                keyword.click(hatchbackOptions);
                break;
            case "Sedan":
                WebElement sedanOptions = keyword.findElement(By.xpath("//div[text()='Sedan']/preceding-sibling::div"));
                keyword.click(sedanOptions);
                break;
            case "SUV / Crossover":
                WebElement suvOptions = keyword.findElement(By.xpath("//div[text()='SUV / Crossover']/preceding-sibling::div"));
                keyword.click(suvOptions);
                break;
            case "Truck":
                WebElement truckOptions = keyword.findElement(By.xpath("//div[text()='Truck']/preceding-sibling::div"));
                keyword.click(truckOptions);
                break;
            case "Van / Minivan":
                WebElement vanOptions = keyword.findElement(By.xpath("//div[text()='Van / Minivan']/preceding-sibling::div"));
                keyword.click(vanOptions);
                break;
            case "Wagon":
                WebElement wagonOptions = keyword.findElement(By.xpath("//div[text()='Wagon']/preceding-sibling::div"));
                keyword.click(wagonOptions);
                break;
        }        
    }

    /**
     * check body style opton on filter should be filtered after chose
     * @return boolean check
     */
    public boolean checkBodyStyleOptionsOnFilterShouldBeFilteredAfterChose(String option) {
        boolean check = false;
        WebElement linkOption = keyword.findElement(By.cssSelector("a[label ='"+option+"']"));
        keyword.scrollToElement(linkOption);
        WebElement txtYourSearchBodyStyle = keyword.findElement(By.xpath("//span[text()='"+option+"']"));
        keyword.scrollToElement(txtYourSearchBodyStyle);
        WebElement linkClearFilters = keyword.findElement(By.xpath("//span[text()='Clear Filters']"));
        keyword.scrollToElement(linkClearFilters);
        if (linkOption.isDisplayed() && txtYourSearchBodyStyle.isDisplayed() && linkClearFilters.isDisplayed()) {
            check = true;
        } else {
            check = false;
        }
        return check; 
    }   
}
