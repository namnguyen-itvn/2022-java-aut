package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarReviewsRankingsModulePage extends BasePage {

    public CarReviewsRankingsModulePage() {
    }
    
    public CarReviewsRankingsModulePage(WebDriver driver) {
        super(driver);
    }

    private WebElement lblSelectedCar = driver.findElement(By.cssSelector(".css-1ceovnz-HeaderAndLabel>h1"));
    private WebElement lblSelectedCarRankings = driver.findElement(By.cssSelector("div[data-cypress='rankings-section']>div>h3"));
    private WebElement lblHorsepower = driver.findElement(By.cssSelector("button#rankhp"));
    private WebElement lblMPGCombined = driver.findElement(By.cssSelector("button#rankmpg"));
    private WebElement lblConsumerRatings = driver.findElement(By.cssSelector("button#rankconsrat"));
    private WebElement lblRank = driver.findElement(By.xpath("//div[normalize-space()='Rank']"));
    private WebElement lblVehicles = driver.findElement(By.xpath("//div[normalize-space()='Vehicles']"));
    private WebElement lblHP = driver.findElement(By.xpath("//div[normalize-space()='HP']"));
    private By lblMPG = By.xpath("//div[normalize-space()='MPG']");
    private By lblRating = By.xpath("//div[normalize-space()='Rating']");
    private WebElement lblSelectForScroll = driver.findElement(By.cssSelector("a[title='2.0T Premium Wagon 4D'] span[class='css-8ae4hg-default']"));
    

    public boolean isUrlCorrect(String year, String make, String model){
        String expectedUrl = "https://staging.kbb.com/"+  make.toLowerCase() +"/"+ model.toLowerCase() +"/"+ year +"/";
        if(driver.getCurrentUrl().contentEquals(expectedUrl)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isLblSelectedCarCorrect(String year, String make, String model){
        String expectedLabel = year + " " + make + " " + model;
        if (Integer.parseInt(year) < 2021) {
            expectedLabel = "Used " + expectedLabel;
        }
        if(isElementTextEqualExpectedText(lblSelectedCar, expectedLabel)){
            return true;
        }else{
            return false;
        }
    }

    public boolean assertScopeAreDefaultUIOfHorsepowerTableDiplayedCorrect(){
        keyword.scrollToElement(lblSelectedCarRankings);
        if(isElementDisplayed(lblSelectedCarRankings) == true && isElementDisplayed(lblHorsepower) == true
        && isElementDisplayed(lblRank) == true && isElementDisplayed(lblVehicles) == true
        && isElementDisplayed(lblHP) == true){
            return true;
        }else{
            return false;
        }
    }

    public boolean assertScopeAreDefaultUIOfMPGCombinedTableDiplayedCorrect(){
        keyword.scrollToElement(lblSelectForScroll);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        keyword.click(lblMPGCombined);
        if(isElementDisplayed(lblSelectedCarRankings) == true && isElementDisplayed(lblMPGCombined) == true
        && isElementDisplayed(lblRank) == true && isElementDisplayed(lblVehicles) == true
        && isElementDisplayed(keyword.findElement(lblMPG)) == true){
            return true;
        }else{
            return false;
        }
    }

    public boolean assertScopeAreDefaultUIOfConsumerRatingsTableDiplayedCorrect(){
        keyword.scrollToElement(lblSelectForScroll);
        keyword.click(lblConsumerRatings);
        if(isElementDisplayed(lblSelectedCarRankings) == true && isElementDisplayed(lblConsumerRatings) == true
        && isElementDisplayed(lblRank) == true && isElementDisplayed(lblVehicles) == true
        && isElementDisplayed(keyword.findElement(lblRating)) == true){
            return true;
        }else{
            return false;
        }
    }

    public boolean assertScopeAreUrlAndLblSelectedCarCorrect(String year, String make, String model){
        if(isLblSelectedCarCorrect(year, make, model) == true && isUrlCorrect(year, make, model) == true){
            return true;
        }else{
            return false;
        }
    }
}
