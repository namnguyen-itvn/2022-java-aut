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

    private WebElement lblTitleConsumerReview = keyword.findElement(By.cssSelector("h1.eisth832"));
    private WebElement lblConsumerOfOverFlow = keyword.findElement(By.xpath("//div[text()='Consumer']"));
    private WebElement btnReadFullReview = keyword.findElement(By.xpath("//p[text()='Read Consumer Reviews']/parent::button"));
    private WebElement btnWriteAReview = keyword.findElement(By.xpath("//span[text()='Write a Review']/parent::a"));
    private WebElement btnBaseOnReview = keyword.findElement(By.xpath("//a[@data-analytics='consrev_basedonrev_top_lnk']"));
    private WebElement lblRateScore = keyword.findElement(By.cssSelector("#consumerreview .css-1ohwf54"));

    private WebElement lblRateStarConsumer = keyword.findElement(By.xpath("//div[contains(@class,'css-lyztuj')]//div[@class='css-lgzq0v-StarRating']"));
    private WebElement lblConsumerRating = keyword.findElement(By.cssSelector("#consumerreview div.css-4eaujp"));
    private WebElement lblPercent = keyword.findElement(By.cssSelector(".css-17ce8km.e1agtnah0"));
    private WebElement lblRecommendVehicle = keyword.findElement(By.cssSelector(".css-ntz4v8.e1agtnah1"));
    private WebElement lblTrendingTop = keyword.findElement(By.cssSelector("h4.css-eck5q1-StyledHeading4"));
    private By btnClearFilter = By.xpath("//a[@data-analytics='cr_clear_filters']");
    private List<WebElement> listStarLine = keyword.findElements(By.cssSelector("div.css-1upilqn.eov6l8h0"));
    private List<WebElement> listShortBarRating = keyword.findElements(By.cssSelector("#consumerreview div.css-1a6lgqy-ShortHandBarRating"));

    private List<WebElement> listTagsOptionTopic() {
        return keyword.findElements(By.cssSelector("div.css-1hnrv7x-ToggleDiv"));
    }

    private WebElement btnOptionTopic(String topic) {
        return keyword.findElement(By.xpath("//div[contains(@class,'css-1c5vle7-Label') and text()='" + topic + "']"));
    }

    private List<WebElement> btnLikeIconOfReview() {
        return keyword.findElements(By.xpath("//a[@aria-label='helpful']"));
    }

    private List<WebElement> lblLikeNumber() {
        return keyword.findElements(By.xpath("//span[@data-testid='positive']"));
    }

    private List<WebElement> btnDislikeIconOfReview() {
        return keyword.findElements(By.xpath("//a[@aria-label='notHelpful']"));
    }

    private List<WebElement> userReviewContain() {
        return keyword.findElements(By.cssSelector(".css-542wex.e9ci9ab0"));
    }

    public void clickToScrollToConsumerReviewSection() {
        keyword.click(lblConsumerOfOverFlow);
    }

    public void clickToSeeFullReview() {

        keyword.clickByJS(btnReadFullReview);
    }

    public void clickWriteAReviewButton() {
        keyword.clickByJS(btnWriteAReview);
    }

    public void clickBtnBaseOnConsumerReview() {
        keyword.clickByJS(btnBaseOnReview);
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

    /**
     * return is Like Icon Clickable or not
     */
    public boolean isLikeIconClickable(int index) {
        clickToScrollToConsumerReviewSection();
        clickToSeeFullReview();
        return isElementEnabled(btnLikeIconOfReview().get(index));
    }

    /**
     * return is Like Icon Clickable or not
     */
    public boolean isDislikeIconClickable(int index) {
        return isElementEnabled(btnDislikeIconOfReview().get(index));
    }

    Integer EXPECTED_REVIEW_PER_PAGE = 6;
    String EXPECTED_LBL_CONSUMER_RATING = "Consumer Rating";
    String EXPECTED_RECOMMEND_VEHICLE = "Recommend this vehicle";
    String EXPECTED_TRENDING_TOPICS = "Trending Topics in KBB.com Consumer Review";
}

