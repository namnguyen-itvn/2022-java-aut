package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class PopularNewMakesPage extends BasePage {

    public PopularNewMakesPage(WebDriver driver) {
        super(driver);
    }

    public PopularNewMakesPage() {
    }

    //Displayed
    private By listOfPopularNewMakesPage = By.xpath("//div[@data-cypress='new-makes']");

    public boolean isDisplayedPopularNewMakesPage() {
        keyword.scrollToElement(keyword.findElement(listOfPopularNewMakesPage));
        return keyword.findElement(listOfPopularNewMakesPage).isDisplayed();
    }

    //Click on link
    private By txtJeep = By.xpath("//*[@id='nm-jeep-10']");

    public void isClickOnJeepItem() {
        keyword.click(keyword.findElement(txtJeep));
    }
    public boolean isClickOnJeepItemCorrect() {
        String expectedUrl = "https://staging.kbb.com/jeep/";
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.equals(expectedUrl);
    }

    
}
