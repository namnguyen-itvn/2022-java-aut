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

    private By tstTitleOfExpertReviewSection = By.cssSelector("h2[class*='css-7q8m0g-StyledHeading2 e148eed11']");
    private By btnAuthorName =By.cssSelector("span[class*='css-dq7l91 e1b9ten30']");
    private By imgAuthorName = By.xpath("//div[@class='eijuktk3 css-5m5jmw-ContentContainer e1qqueke0']//img");
    private By messageNoHasExpertReview = By.xpath("//div[@class='css-de22qy-ColBase e1l0ytpk0']//p[@class='css-113e3v-StyledParagraph emgezi80']");
    

    /**
     * navigate to Build&Price Page went click on button
     * @param year
     * @param make
     * @param model
    */
    public void clickOnBuildAndPriceButton(String year, String make, String model){
        WebElement btnBuildAndPrice  = driver.findElement(By.xpath("//a[@data-analytics='buyused_overview_btn']"));
        keyword.click(btnBuildAndPrice);
    }

    /**
     * navigate to See Car For Sale Page Went Click on this button
      * @param year
     * @param make
     * @param model
    */
    public void clickOnSeeCarForSaleButton(String year, String make, String model){
        WebElement btnSeeCarForSale  = driver.findElement(By.xpath("https://staging.kbb.com/cars-for-sale/used/"+year+"/"+make+"/"+model));
        keyword.click(btnSeeCarForSale);
    }

    
    public void clickForToNavigateAuthorPage(WebElement webElement){
        keyword.click(keyword.findElement(webElement));
    }

    

}
