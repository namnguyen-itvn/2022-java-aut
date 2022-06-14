package com.example.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    public ProductPage() {};

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public int getQuantityOfProducts() {
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        return products.size();
    }

    public boolean checkProductInformation(String name, String desc, double price) {
        String xpathProductName = "//div[normalize-space()='" + name + "']";
        String xpathProduct = xpathProductName + "/ancestor::div[@class='inventory_item']";
        WebElement lblProductDesc = keyword.findElement(By.xpath(xpathProduct + "//div[@class='inventory_item_desc']"));
        WebElement lblProductPrice = keyword.findElement(By.xpath(xpathProduct + "//div[@class='inventory_item_price']"));
        String productDesc = lblProductDesc.getText();
        double productPrice = Double.parseDouble(lblProductPrice.getText().substring(1));
        return productDesc.equals(desc) && productPrice == price;
    }

    public boolean addProductToCart(String name, String desc, double price) {
        if (checkProductInformation(name, desc, price)) {
            String xpathProductName = "//div[normalize-space()='" + name + "']";
            String xpathProduct = xpathProductName + "/ancestor::div[@class='inventory_item']";    
            WebElement btnAddToCart = keyword.findElement(By.xpath(xpathProduct + "//button[contains(@class, 'btn_inventory')]"));
            keyword.click(btnAddToCart);
            return true;
        } else {
            return false;
        }
    }

    public boolean isCartEmpty() {
        List<WebElement> cartChild = driver.findElements(By.xpath("//a[@class='shopping_cart_link']/*"));
        if (cartChild.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean isTitleCorrect(String title) {
        WebElement productsPageTitle = keyword.findElement(By.xpath("//span[@class='title']"));
        return productsPageTitle.getText().equals(title);
    }

}
