package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class AboutTheKelleyBlueBookNewCarReviewsPage extends BasePage {

    public AboutTheKelleyBlueBookNewCarReviewsPage(WebDriver driver) {
        super(driver);
    }

    public AboutTheKelleyBlueBookNewCarReviewsPage() {
    }
    private By Content = By.xpath("//div[@id='app']/descendant::h2[contains(text(),'About')]/following::p/parent::div");

    public boolean isDisplayedContent(){
        keyword.scrollToElement(keyword.findElement(Content));
        return keyword.findElement(Content).isDisplayed();
    }
    
}
