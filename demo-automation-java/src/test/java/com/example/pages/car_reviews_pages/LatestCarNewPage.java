package com.example.pages.car_reviews_pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.BasePage;

public class LatestCarNewPage extends BasePage{

    public LatestCarNewPage() {
    }

    public LatestCarNewPage(WebDriver driver) {
        super(driver);
    }
  //
    private By listOfLatestCarNew = By.cssSelector("[class*='EditorialStandardContainer']");
    
    public boolean isDisplayedActicle() {
        // WebElement webElement=driver.findElement(By.xpath("//div[div[contains(@class,'EditorialStandardContainer')]]"));
        // List<WebElement> webElement1=webElement.findElements(listOfLatestCarNew);
        keyword.scrollToElement(keyword.findElement(listOfLatestCarNew));
        return keyword.findElement(listOfLatestCarNew).isDisplayed();
    }
    //2
    private By lnkSeeAll = By.xpath("//span[@class='css-163lgdq-textButton-white']");

    public void isClickOnLinkSeeAll() {
        keyword.click(keyword.findElement(lnkSeeAll));
    }

    //
    public boolean isClickOnLinkSeeAllCorrect() {
        String expectedUrl = "https://staging.kbb.com/car-news/";
        String actualUrl =driver.getCurrentUrl().trim();
        return actualUrl.equals(expectedUrl);
    }
}
