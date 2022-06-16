package com.example.pages.car_reviews_pages;

import com.example.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CarReviewDetailPageConsumerReviewModule extends BasePage {
    public CarReviewDetailPageConsumerReviewModule(WebDriver driver) {
        super(driver);
    }

    private WebElement lblTitleConsumerReview = keyword.findElement(By.cssSelector("h2[id='consumerreview']"));
    private WebElement lblConsumerOfOverFlow = keyword.findElement(By.xpath("//div[text()='Consumer']"));
    private WebElement btnReadFullReview = keyword.findElement(By.xpath("//p[text()='Read Consumer Reviews']/parent::button"));
    private List<WebElement> userReviewContain() {
       return keyword.findElements(By.cssSelector(".css-542wex.e9ci9ab0"));
    }

    private void clickToScrollToConsumerReviewSection() {
        keyword.click(lblConsumerOfOverFlow);
    }

    private void clickToSeeFullReview() {
        keyword.click(btnReadFullReview);
    }


    /**
     * return the title of section consumer review is correct or not
     *
     * @param year
     * @param make
     * @param model
     */
    public boolean isTheTitleOfConsumerReviewCorrect(String year, String make, String model) {
        String expectedTitle = year + " " + make + " " + model + "\nKBB.com Consumer Reviews";
        return expectedTitle.equals(lblTitleConsumerReview.getText());
    }

    /**
     * return default page show six review or not
     */
    public boolean isDefaultPageShowSixReviews() {
        clickToScrollToConsumerReviewSection();
        clickToSeeFullReview();
        return EXPECTED_REVIEW_PER_PAGE.equals(userReviewContain().size());
    }

    Integer EXPECTED_REVIEW_PER_PAGE = 6;
}
