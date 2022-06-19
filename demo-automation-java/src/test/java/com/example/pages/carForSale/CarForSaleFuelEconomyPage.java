package com.example.pages.carForSale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.core.keyword.WebKeyword.chooseTypeOfSelect;
import com.example.pages.BasePage;

public class CarForSaleFuelEconomyPage extends BasePage{

    public CarForSaleFuelEconomyPage(WebDriver driver) {
        super(driver);
    }
    //Action
    
    /**
     * Method for verfy that the UI of fuel economy filter display is correctly with requirement
     * @param expectedFuelEconomy: data to compare with option of fuel economy type
     * @return: true or false
     */
    public boolean isTheFuelEconomyFilterDisplayCorrectAsReqirement(String expectedFuelEconomy){
        keyword.click(linkNotNow);
        keyword.scrollToElement(lblFuelEconomy);
        keyword.click(lblFuelEconomy);
        Select ddlFuelEconomys = new Select(ddlFuelEconomy);
        boolean check = false;
        for (WebElement element : ddlFuelEconomys.getOptions()){
            if (expectedFuelEconomy.contains(keyword.getText(element))){
                check = true;
            }else check = false;
            break;
        }
        return check;
    }

    /**
     * Method for Return The Result Of Fuel Economy Match With Option Was Selected
     * @param fuel: type of fuel
     * @return true or false
     */
    public boolean isReturnTheResultOfFuelEconomyMatchWithOptionWasSelected(String fuel){
        keyword.click(linkNotNow);
        keyword.scrollToElement(lblFuelEconomy);
        keyword.click(lblFuelEconomy);
        keyword.click(ddlFuelEconomy);
        keyword.setValueForSelectElement(ddlFuelEconomy, chooseTypeOfSelect.selectByValue, fuel);
        keyword.scrollToElement(lblYourSearch);
        WebElement btnFilter = keyword.findElementByLocator(By.xpath("//div[contains(@data-cmp, 'chip')]/child::span[contains(text(), '"+fuel+"')]"));
        WebElement linkClearFilter = keyword.findElementByLocator(By.xpath("//span[contains(text(), 'Clear Filters')]"));
        if (keyword.getText(btnFilter).contains(fuel) && isElementEnabled(btnFilter) && isElementEnabled(linkClearFilter)){
            return true;
        }else return false;
    }

    //declare element
    private WebElement linkNotNow = keyword.findElement(By.xpath("//div[@class='popover-content']//div//button[@class='btn btn-link']"));
    private WebElement lblYourSearch = keyword.findElementByLocator(By.xpath("//span[contains(text(), 'Your Search')]"));
    private WebElement lblFuelEconomy = keyword.findElementByLocator(By.xpath("//span[contains(text(), 'Fuel Economy')]/parent::span/parent::div"));
    private WebElement ddlFuelEconomy = keyword.findElementByLocator(By.id("10591868"));
}
