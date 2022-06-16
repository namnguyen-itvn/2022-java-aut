package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;


public class CarreviewsDetailPage extends BasePage {
    public CarreviewsDetailPage() {
    }

    public CarreviewsDetailPage(WebDriver driver) {
        super(driver);
    }

    WebElement tstTitleOfExpertReviewSection = keyword.findElement(By.cssSelector("h2[class*='css-7q8m0g-StyledHeading2 e148eed11']"));
    WebElement btnAuthorName =keyword.findElement(By.cssSelector("span[class*='css-dq7l91 e1b9ten30']"));

    
    public void clickOnBuildAndPriceButton(String year, String make, String model){
        WebElement btnBuildAndPrice  = driver.findElement(By.xpath("//a[@href='https://staging.kbb.com/"+make+"/"+model+"/"+year+"/styles/?intent=buy-used']"));
        keyword.click(btnBuildAndPrice);
    }

    public void clickOnSeeCarForSaleButton(String year, String make, String model){
        WebElement btnSeeCarForSale  = driver.findElement(By.xpath("https://staging.kbb.com/cars-for-sale/used/"+year+"/"+make+"/"+model));
        keyword.click(btnSeeCarForSale);
    }
}
