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
    private By locaTxbTradeIn = By.id("1057225922");
    
    public boolean isTradeInContentDisplay(){
        if (elmIsVisible(locaTradeInContent)==true&
            elmIsVisible(locaTradeInText)==true&
            elmIsVisible(locaTxbTradeIn)==true) {
            return true;
        }
        else return false;
    }
}
