package com.example.pages.car_for_sale_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarForSaleCarOptionPage extends BasePage {

    public CarForSaleCarOptionPage(WebDriver driver) {
        super(driver);
    }

    private WebElement myWallet = keyword.findElement(By.xpath(
            "//body/div[@id='mountNode']/div/div[@data-cmp='TabNavBarContainer']/div[@data-cmp='stickyContainer']/div/div[@id='calculatePayment']/div[@class='container']/div[@class='row padding-vertical-4 padding-vertical-md-5']/div[@id='nativeDealContainer']/div[1]"));

    public int getQuantityOfMyWallet() {
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='nav nav-tabs']//li"));
        return products.size();
    }

    public boolean checkDisplayMyWallet() {
        if (myWallet.isDisplayed() == true) {
            return true;
        } else {
            return false;
        }
    }
}
