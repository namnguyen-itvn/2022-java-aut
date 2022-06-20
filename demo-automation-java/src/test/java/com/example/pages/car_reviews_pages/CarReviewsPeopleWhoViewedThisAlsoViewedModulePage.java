package com.example.pages.car_reviews_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarReviewsPeopleWhoViewedThisAlsoViewedModulePage extends BasePage {    
    public CarReviewsPeopleWhoViewedThisAlsoViewedModulePage(WebDriver driver) {
        super(driver);
    }

    private WebElement lblSelectedCar = driver.findElement(By.cssSelector(".css-1ceovnz-HeaderAndLabel>h1"));
    private WebElement lblPeopleAlsoViewed = driver.findElement(By.cssSelector(".css-gf467u.e10oadt71"));
    private By imgVehicles = By.xpath("//div[@data-partner='cvre']");
    private WebElement btnSeeMore = driver.findElement(By.xpath("//button[@data-analytics='readmore_ucymm_alsoviewed_btn']"));
    private By btnSeeLess = By.xpath("//button[@data-analytics='readless_ucymm_alsoviewed_btn']");
    private WebElement lblOtherWagon = driver.findElement(By.cssSelector(".css-gf467u.e1fn9flx0"));
        
    /*
     * verify url correct or not
     */
    public boolean isUrlCorrect(String year, String make, String model){
        String expectedUrl = "https://staging.kbb.com/"+  make.toLowerCase() +"/"+ model.toLowerCase() +"/"+ year +"/";
        if(driver.getCurrentUrl().contentEquals(expectedUrl)){
            return true;
        }else{
            return false;
        }
    }

    /*
     * verify vehicle title correct or not
     */
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

    /*
     * verify the number of vehicles displayed by default in peole also viewed
     */
    public boolean isTheNumberOfVehiclesIsDisplayedCorrectlyAsRequired() {
        List<WebElement> vehicleItems = keyword.findElements(imgVehicles);
        if (vehicleItems.size() == numberOfVehiclesDisplayedByDefault) {
            return true;
        } else
            return false;
    }

    /*
     * verify the number of vehicles displayed in peole also viewed after user click on see more button
     */
    public boolean isTheNumberOfVehiclesIsDisplayedCorrectlyAfterUserClickOnSeeMoreButton() {
        keyword.click(btnSeeMore);
        List<WebElement> vehicleItems = keyword.findElements(imgVehicles);
        if (vehicleItems.size() == (numberOfVehiclesDisplayedByDefault + 4)) {
            return true;
        } else
            return false;
    }

    /*
     * verify the number of vehicles displayed in peole also viewed after user click on see less button
     */
    public boolean isTheNumberOfVehiclesIsDisplayedCorrectlyAfterUserClickOnSeeLessButton() {
        keyword.scrollToElement(btnSeeMore);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)", "");
        keyword.clickWithOutScroll(btnSeeMore);
        do{
            keyword.scrollToElement(btnSeeMore);
            js.executeScript("window.scrollBy(0,-500)", "");
            keyword.clickWithOutScroll(btnSeeMore);
        }while (isSeeLessButtonDisplayed() == false);
        keyword.clickWithOutScroll(keyword.findElement(btnSeeLess));
        keyword.scrollToElement(lblPeopleAlsoViewed);
        if (isTheNumberOfVehiclesIsDisplayedCorrectlyAsRequired() == true) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * verify see less button is diplayed or not
     */
    public boolean isSeeLessButtonDisplayed() {
        try {
            keyword.scrollToElement(lblOtherWagon);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,-500)", "");
            driver.findElement(btnSeeLess);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /*
     * verify People Also Viewed section displayed correct or not when first time navigate
     */
    public boolean assertScopeIsDefaultUIOfPeopleAlsoViewedDisplayedCorrectAsRequired(){
        keyword.scrollToElement(lblPeopleAlsoViewed);
        if(isElementDisplayed(lblPeopleAlsoViewed) == true 
        && isElementDisplayed(btnSeeMore) == true
        && isTheNumberOfVehiclesIsDisplayedCorrectlyAsRequired() == true){
            return true;
        }else{
            return false;
        }
    }

    /*
     * verify url and vehicle title correct or not
     */
    public boolean assertScopeIsUrlAndLblSelectedCarCorrect(String year, String make, String model){
        if(isLblSelectedCarCorrect(year, make, model) == true && isUrlCorrect(year, make, model) == true){
            return true;
        }else{
            return false;
        }
    }

    private int numberOfVehiclesDisplayedByDefault = 4; 
}
