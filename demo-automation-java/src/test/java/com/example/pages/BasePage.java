package com.example.pages;

import com.example.core.configuration.Configuration;
import com.example.core.keyword.WebKeyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebKeyword keyword;
    public WebDriverWait wait;

    public BasePage() {};

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.keyword = new WebKeyword(driver);

        try {
            Configuration config = new Configuration("src/test/java/com/example/core/configuration/config.properties");
            int implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            this.wait = new WebDriverWait(driver, implicitWait);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/**
 *  Navigate to page
 * @param menuText
 * @return the page with driver
 */
    public BasePage navigateToPage(String menuText) {
        WebElement btnMenu = keyword.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        switch(menuText) {
            case "Shop":
                keyword.click(btnMenu);
                WebElement mnuShop = keyword.findElement(By.xpath("//a[@id='inventory_sidebar_link']"));
                keyword.click(mnuShop);
                return new ProductPage(driver);
            case "Logout":
                keyword.click(btnMenu);
                WebElement mnuLogout = keyword.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
                keyword.click(mnuLogout);
                return new LoginPage(driver);
            case "Cart":
                WebElement btnCart = keyword.findElement(By.xpath("//a[@class='shopping_cart_link']"));
                keyword.click(btnCart);
                return null; //new CartPage(driver);
            default:
                System.out.println("Invalid page");
                return new BasePage(driver);
        }

    }

}