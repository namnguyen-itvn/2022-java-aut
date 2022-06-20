package com.example.pages.car_reviews_pages;

import com.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WriteAReviewPage extends BasePage {
    public WriteAReviewPage(WebDriver driver) {
        super(driver);
    }
    private WebElement lblHeader = keyword.findElement(By.cssSelector("div.css-1ceovnz-HeaderAndLabel>h1"));
    private WebElement lblCarDetail = keyword.findElement(By.cssSelector("h1.css-19m85bw-StyledHeading1"));


    private boolean isHeaderCorrect(){
        return EXPECTED_HEADER.equals(lblHeader.getText());
    }
    private boolean isCarDetailIsCorrect(String year, String make, String model) {
            String expectedCarName = year + " " + make + " " + model;
            return expectedCarName.equals(lblCarDetail.getText());
    }

    public boolean asserScopeWriteReviewPageDefault(String expectedYear, String expectedMake, String expectedModel){
        boolean result = true;
        if(!isCarDetailIsCorrect(expectedYear,expectedMake,expectedModel)){
            result=false;
        }
        if(!isHeaderCorrect()){
            result=false;
        }
        return result;
    }

    String EXPECTED_HEADER="Write a Review";
}
