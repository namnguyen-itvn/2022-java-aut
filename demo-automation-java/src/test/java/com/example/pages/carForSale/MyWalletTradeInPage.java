package com.example.pages.carForSale;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.core.keyword.WebKeyword.chooseTypeOfSelect;
import com.example.pages.BasePage;

public class MyWalletTradeInPage extends BasePage {

    public MyWalletTradeInPage(WebDriver driver) {
        super(driver);
    }

    private By locaTradeInContent = By.xpath("//div[@data-cmp='TradeInPanel']");
    private By locaTradeInText = By.xpath("//div[@class='text-bold text-size-400']");
    private By locatxbTradeIn = By.id("1057225922");

    public By locabtnTradeIn = By.xpath("//div[@class='radio-input-label glyphicon-radio-selected']");
    
    public boolean isTradeInContentDisplay(){
        if (elmIsVisible(locaTradeInContent)==true&
            elmIsVisible(locaTradeInText)==true&
            elmIsVisible(locatxbTradeIn)==true) {
            return true;
        }
        else return false;
    }

    
}
