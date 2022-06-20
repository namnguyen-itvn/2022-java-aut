package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarReviewsFAQsModulePage extends BasePage {

    public CarReviewsFAQsModulePage(WebDriver driver) {
        super(driver);
    }

    private WebElement lblSelectedCar = driver.findElement(By.cssSelector(".css-1ceovnz-HeaderAndLabel>h1"));
    private WebElement lblFAQs = driver.findElement(By.cssSelector(".css-m5oe7l-StyledHeading3.e148eed12"));
    private WebElement lblfirstQuestion = driver.findElement(By.xpath("//h4[normalize-space()='Is 2012 a good year for a Audi A3?']"));
    private WebElement lblfirstAnswer = driver.findElement(By.cssSelector(".css-13q1jog-GridContainer.eds0yfe0>div:nth-child(1)>div"));
    private WebElement lblsecondQuestion = driver.findElement(By.xpath("//h4[normalize-space()='Is the Audi A3 2012 a good Wagon?']"));
    private WebElement lblsecondAnswer = driver.findElement(By.cssSelector(".css-13q1jog-GridContainer.eds0yfe0>div:nth-child(2)>div"));
    private WebElement lblthirdQuestion = driver.findElement(By.xpath("//h4[normalize-space()='What is the MPG for a 2012 Audi A3?']"));
    private WebElement lblthirdAnswer = driver.findElement(By.xpath("//div[normalize-space()='The 2012 Audi A3 gets 22 mpg in the city and 28 mpg on the highway.']"));
    
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
     * verify FAQs Section displayed correct or not when first time navigate
     */
    public boolean assertScopeIsDefaultUIOfFAQsSectionDiplayedCorrect(){
        keyword.scrollToElement(lblFAQs);
        if(isElementDisplayed(lblfirstQuestion) == true
        && isElementDisplayed(lblfirstAnswer) == true
        && isElementDisplayed(lblsecondQuestion) == true
        && isElementDisplayed(lblsecondAnswer) == true
        && isElementDisplayed(lblthirdQuestion) == true
        && isElementDisplayed(lblthirdAnswer) == true
        && isElementTextEqualExpectedText(lblfirstQuestion, firstQuestion) == true
        && isElementTextEqualExpectedText(lblfirstAnswer, firstAnswer) == true
        && isElementTextEqualExpectedText(lblsecondQuestion, secondQuestion) == true
        && isElementTextEqualExpectedText(lblsecondAnswer, secondAnswer) == true
        && isElementTextEqualExpectedText(lblthirdQuestion, thirdQuestion) == true
        && isElementTextEqualExpectedText(lblthirdAnswer, thirdAnswer) == true)
        {
            return true;
        }else{
            return false;
        }
    }

    /*
     * verify url and vehicle title correct or not
     */
    public boolean assertScopeAreUrlAndLblSelectedCarCorrect(String year, String make, String model){
        if(isLblSelectedCarCorrect(year, make, model) == true && isUrlCorrect(year, make, model) == true){
            return true;
        }else{
            return false;
        }
    }

    public String firstQuestion = "Is 2012 a good year for a Audi A3?";
    public String firstAnswer = "According to the experts at Kelley Blue Book, the 2012 Audi A3 scores 3.8 out of 5 stars. Owners of the vehicle give it 4.6 out of 5 stars. To find out if the 2012 A3 is the right car for you, check out the pros and cons, trims, specs and options at Kelley Blue Book.";
    public String secondQuestion = "Is the Audi A3 2012 a good Wagon?";
    public String secondAnswer = "According to the experts at Kelley Blue Book, the 2012 Audi A3 scores 3.8 out of 5 stars. Owners of the vehicle give it 4.6 out of 5 stars. To find out if the 2012 A3 is the right car for you, check out the pros and cons, trims, specs and options at Kelley Blue Book.";
    public String thirdQuestion = "What is the MPG for a 2012 Audi A3?";
    public String thirdAnswer = "The 2012 Audi A3 gets 22 mpg in the city and 28 mpg on the highway.";
}
