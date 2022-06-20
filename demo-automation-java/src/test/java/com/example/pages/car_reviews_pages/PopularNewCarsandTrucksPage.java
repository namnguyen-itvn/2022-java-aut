package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class PopularNewCarsandTrucksPage extends BasePage {

    public PopularNewCarsandTrucksPage(WebDriver driver) {
        super(driver);
    }

    public PopularNewCarsandTrucksPage() {
    }

//element

private By listOfPopularNewCarsandTrucksPage = By.xpath("//div[@data-cypress='new-cars-and-trucks']");

public boolean isDisplayedPopularNewCarsandTrucksPage() {
    keyword.scrollToElement(keyword.findElement(listOfPopularNewCarsandTrucksPage));
    return keyword.findElement(listOfPopularNewCarsandTrucksPage).isDisplayed();
}

//Click on link
private By txtFordF150 = By.xpath("//*[@id='nct-ford-f150-0']");

    public void isClickOnFordF150Item() {
        keyword.click(keyword.findElement(txtFordF150));
    }
    public boolean isClickOnFordF150ItemCorrect() {
        String expectedUrl = "https://staging.kbb.com/ford/f150/";
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.equals(expectedUrl);
    }


}