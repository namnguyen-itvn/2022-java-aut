package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class OverViewModuleCarReviewDetailsPage extends BasePage{
    public OverViewModuleCarReviewDetailsPage() {
    }

    public OverViewModuleCarReviewDetailsPage(WebDriver driver) {
        super(driver);
    }

    //Declare page object
    WebElement ddYear = keyword.findElement(By.cssSelector("*[aria-label='Year']"));
    WebElement ddCategory = keyword.findElement(By.cssSelector("*[aria-label='Category']"));
    WebElement titleOverViewModule =keyword.findElement(By.cssSelector("div[class*='HeaderAndLabel']>h1"));
    WebElement textLocation = keyword.findElement(By.cssSelector("*[data-lean-auto='location-link']"));
    WebElement lnkChangeVehicle = keyword.findElement(By.cssSelector("data-analytics='chngvhcl_lnk'"));
    WebElement lnkGoToExpertReview = keyword.findElement(By.cssSelector("*[data-analytics='goto_exprev_lnk']"));
    WebElement lnkGoToConsumerReview = keyword.findElement(By.cssSelector("*[data-analytics='goto_consrev_lnk']"));
    WebElement lnkWriteAReview = keyword.findElement(By.cssSelector("*[data-analytics='consrev_lnk']"));
    WebElement btnBuyPrice = keyword.findElement(By.cssSelector("*[data-analytics='buyused_overview_btn']"));
    WebElement btnSeeCar = keyword.findElement(By.cssSelector("*[data-analytics='inv_findinv_btn']"));
    WebElement lnkViewGallery = keyword.findElement(By.cssSelector("button[data-analytics='photo_ucymm_photo_video_thm']"));
    WebElement imgCar = keyword.findElement(By.cssSelector("img[data-analytics='photo_ucymm_photo_video_thm']"));
    
    //Page action
    public boolean isPageTitleCorrect(String expectedTitle){
        return pageTitle().equals(expectedTitle);
    }
}
