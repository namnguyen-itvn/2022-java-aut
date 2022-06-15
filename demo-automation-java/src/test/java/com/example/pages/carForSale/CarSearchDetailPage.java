package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarSearchDetailPage extends BasePage{

    public CarSearchDetailPage(WebDriver driver) {
        super(driver);
    }

    public CarSearchDetailPage() {}
    
    /*
     * Return the title of car
     */
    public String getCarTitle(){
        WebElement lblTitle = keyword.findElement(By.xpath("//h1[@data-cmp='heading']"));
        return keyword.getText(lblTitle);
    }
}
