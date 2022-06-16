package com.example.pages.car_reviews_pages;

import com.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.example.core.keyword.WebKeyword.chooseTypeOfSelect.selectByValue;
import static com.example.core.keyword.WebKeyword.chooseTypeOfSelect.selectByVisibleText;

public class CarReviewPageConsumerReviewModule extends BasePage {
    public CarReviewPageConsumerReviewModule(WebDriver driver) {
        super(driver);
    }

    private WebElement ddlYears = keyword.findElement(By.cssSelector(".year select"));
    private WebElement ddlMake = keyword.findElement(By.cssSelector(".make select"));
    private WebElement ddlModel = keyword.findElement(By.cssSelector(".model select"));
    private WebElement txtZipCode = keyword.findElement(By.cssSelector(".zipInput > input[type='tel']"));
    private WebElement btnGetReview = keyword.findElement(By.xpath("//span[text()='Get Reviews']/parent::button"));


    public void inputAndSubmitGetCarReview(String year, String make, String model, String zipCode) throws Exception {
        keyword.setValueForSelectElement(ddlYears,selectByValue,year);
        keyword.setValueForSelectElement(ddlMake,selectByValue,make);
        keyword.setValueForSelectElement(ddlModel,selectByValue,model);
        keyword.setText(txtZipCode,zipCode);
        keyword.click(btnGetReview);
    }

}
