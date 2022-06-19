package com.example.pages.car_reviews_pages;

import com.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ConsumerReviewPage extends BasePage{
    WebElement lblHeader = keyword.findElement(By.cssSelector("h1.css-aubi8m-StyledHeading1"));
    WebElement lblCarName = keyword.findElement(By.cssSelector("div.css-4eaujp"));
    List<WebElement> reviewContainer(){
        return keyword.findElements(By.cssSelector("div.css-542wex"));
    }
    public ConsumerReviewPage(WebDriver driver) {
        super(driver);
    }

    private boolean isHeaderCorrect(){
        return EXPECTED_HEADER.equals(lblHeader.getText());
    }
    private boolean isCarNameIsCorrect(String year, String make, String model) {
        String expectedTitle = year + " " + make + " " + model;
        return expectedTitle.equals(lblCarName.getText());
    }
    public boolean asserScopeConsumerReviewPageDefault(String expectedYear, String expectedMake, String expectedModel){
        boolean result = true;
        if(!isCarNameIsCorrect(expectedYear,expectedMake,expectedModel)){
            result=false;
        }
        if(!isHeaderCorrect()){
            result=false;
        }
        return result;
    }

    String EXPECTED_HEADER="Consumer Reviews";
}
