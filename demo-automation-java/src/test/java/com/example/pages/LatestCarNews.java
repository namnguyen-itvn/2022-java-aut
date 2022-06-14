package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LatestCarNews {
    private WebElement keyword;
    WebElement txtUsername = keyword.findElement(By.xpath("//input[@id='user-name']"));
    WebElement txtPassword = keyword.findElement(By.xpath("//input[@id='password']"));
    WebElement btnLogin = keyword.findElement(By.xpath("//input[@id='login-button']")); 
}

