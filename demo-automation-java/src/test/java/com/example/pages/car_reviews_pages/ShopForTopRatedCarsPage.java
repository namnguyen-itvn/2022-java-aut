package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class ShopForTopRatedCarsPage extends BasePage{

    public ShopForTopRatedCarsPage(WebDriver driver) {
        super(driver);
    }

    public ShopForTopRatedCarsPage() {
    }

    private By txtToyotaCamry = By.xpath("//*[@id='strc-toyota-camry-1']");

    private By listOfTopRatedCarsPage = By.xpath("//div[@data-cypress='top-rated-cars']");

    /**
     * Check Top rated car displayed or not
     * @return
     */
    public boolean isDisplayedTopRatedCarsPage() {
        keyword.scrollToElement(keyword.findElement(listOfTopRatedCarsPage));
        return keyword.findElement(listOfTopRatedCarsPage).isDisplayed();
    }
    
    public void isClickOnItem() {
        keyword.click(keyword.findElement(txtToyotaCamry));
    }
    
    public boolean isClickOnFordItemCorrect() {
        String expectedUrl = "https://staging.kbb.com/cars-for-sale/new/toyota/camry";
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.equals(expectedUrl);
    }

}
