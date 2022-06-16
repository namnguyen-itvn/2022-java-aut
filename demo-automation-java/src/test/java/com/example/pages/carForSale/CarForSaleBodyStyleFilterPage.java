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
     * check Body Style Options On Filter Should Be Filtered After Chose
     * @return boolean check
     */
    public boolean checkBodyStyleOptionsOnFilterShouldBeFilteredAfterChose() {
        boolean check = false;
        WebElement bodyStyleOptions = keyword.findElement(By.xpath("//div[text()='Convertible']"));
        keyword.click(bodyStyleOptions);
        WebElement linkBodyStyle = keyword.findElement(By.cssSelector("a[label ='Convertible']"));
        keyword.scrollToElement(linkBodyStyle);
        WebElement txtYourSearchBodyStyle = keyword.findElement(By.xpath("//span[text()='Convertible']"));
        keyword.scrollToElement(txtYourSearchBodyStyle);
        WebElement linkClearFilters = keyword.findElement(By.xpath("//span[text()='Clear Filters']"));
        keyword.scrollToElement(linkClearFilters);
        if (linkBodyStyle.isDisplayed() && txtYourSearchBodyStyle.isDisplayed() && linkClearFilters.isDisplayed()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

}
