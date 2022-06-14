package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class LoginPage extends BasePage {

    public LoginPage() {};

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage actionLogin(String username, String password) {
        WebElement txtUsername = keyword.findElement(By.xpath("//input[@id='user-name']"));
        WebElement txtPassword = keyword.findElement(By.xpath("//input[@id='password']"));
        WebElement btnLogin = keyword.findElement(By.xpath("//input[@id='login-button']"));

        keyword.setText(txtUsername, username);
        keyword.setText(txtPassword, password);
        keyword.click(btnLogin);

        return new ProductPage(driver);
    }

    public String getLoginButtonColor() {
        WebElement btnLogin = keyword.findElement(By.xpath("//input[@id='login-button']"));
        String color = btnLogin.getCssValue("background-color");
        return Color.fromString(color).asHex();
    }

    public boolean isUsernameTextboxDisplayed() {
        WebElement txtUsername = keyword.findElement(By.xpath("//input[@id='user-name']"));
        return txtUsername.isDisplayed();
    }

    public boolean isPasswordTextboxDisplayed() {
        WebElement txtPassword = keyword.findElement(By.xpath("//input[@id='password']"));
        return txtPassword.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        WebElement btnLogin = keyword.findElement(By.xpath("//input[@id='login-button']"));
        return btnLogin.isDisplayed();
    }
    //TrangDT35
}
