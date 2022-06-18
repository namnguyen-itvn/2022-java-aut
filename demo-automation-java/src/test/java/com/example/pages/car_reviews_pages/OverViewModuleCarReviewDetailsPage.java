package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import com.example.pages.BasePage;

public class OverViewModuleCarReviewDetailsPage extends BasePage{

    public OverViewModuleCarReviewDetailsPage(WebDriver driver) {
        super(driver);
    }

    //Declare page object
    WebElement ddYear = keyword.findElement(By.cssSelector("*[aria-label='Year']"));
    WebElement ddCategory = keyword.findElement(By.cssSelector("*[aria-label='Category']"));
    WebElement titleOverViewModule =keyword.findElement(By.cssSelector("div[class*='HeaderAndLabel']>h1"));
    WebElement lnkChangeVehicle = keyword.findElement(By.cssSelector("*[data-analytics='chngvhcl_lnk']"));
    WebElement lnkGoToExpertReview = keyword.findElement(By.cssSelector("*[data-analytics='goto_exprev_lnk']"));
    WebElement lnkGoToConsumerReview = keyword.findElement(By.cssSelector("*[data-analytics='goto_consrev_lnk']"));
    WebElement lnkWriteAReview = keyword.findElement(By.cssSelector("*[data-analytics='consrev_lnk']"));
    WebElement btnBuyPrice = keyword.findElement(By.cssSelector("*[data-analytics='buyused_overview_btn'] span"));
    WebElement btnSeeCar = keyword.findElement(By.cssSelector("*[data-analytics='inv_findinv_btn'] span"));
    WebElement lnkViewGallery = keyword.findElement(By.cssSelector("button[data-analytics='photo_ucymm_photo_video_thm']"));
    WebElement imgCar = keyword.findElement(By.cssSelector("img[data-analytics='photo_ucymm_photo_video_thm']"));
    
    //Page action
    /**
     * Check page title match expected
     * @param expectedTitle
     * @return
     */
    public boolean isPageTitleCorrect(String expectedTitle){
        return pageTitle().equals(expectedTitle);
    }

    //Page aciton
    /**
    * Check Button background color is displayed correct or not
    * 
    * @return
    */
    public boolean isBtnBackgroundColorCorrect(WebElement element, String color){
        Color elementColour = Color.fromString(element.getCssValue("background-color"));
        System.out.println(elementColour.asHex());
        System.out.println(color);
        if (
            elementColour.asHex().equals(color) &&
            isElementDisplayed(element)
        ) return true;
        return false;
    }

    /**
     * Verify over view mudule of car review details page is displayed correct or not
     * @return
     */
    public boolean isOverViewModuleCarReviewDetailsPageDisplayed(String expectedCarReviewHeaderTitle){
        if (
            isElementDisplayed(ddYear) &&
            isElementDisplayed(ddCategory) &&
            isElementTextEqualExpectedText(titleOverViewModule, expectedCarReviewHeaderTitle) &&
            isElementEnabled(lnkChangeVehicle) &&
            isElementEnabled(lnkGoToExpertReview) &&
            isElementEnabled(lnkGoToConsumerReview) &&
            isElementEnabled(lnkWriteAReview) &&
            isBtnBackgroundColorCorrect(btnBuyPrice,"#f3bc2a") &&
            isBtnBackgroundColorCorrect(btnSeeCar, "#006bc2") &&
            isElementEnabled(lnkViewGallery) &&
            isElementEnabled(imgCar)
        ) return true;
        return false;
    }
}
