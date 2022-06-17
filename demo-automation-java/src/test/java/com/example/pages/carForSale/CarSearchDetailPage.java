package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class CarSearchDetailPage extends BasePage {

    public CarSearchDetailPage(WebDriver driver) {
        super(driver);
    }

    private By lblTitle = By.xpath("//h1[@data-cmp='heading']");

    /*
     * Return the title of car
     */
    public String getCarTitle() {
        return keyword.getText(keyword.findElement(lblTitle));
    }
}
