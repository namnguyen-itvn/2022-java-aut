package com.example.pages.car_reviews_pages;

import com.aventstack.extentreports.Status;
import com.example.core.utils.extentreport.ExtentManager;
import com.example.core.utils.extentreport.ExtentTestManager;
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
    private WebElement btnReadConsumerReview = keyword.findElement(By.xpath("//p[text()='Read Consumer Reviews']/parent::button"));
    private WebElement btnWriteAReview = keyword.findElement(By.xpath("//span[text()='Write a Review']/parent::a"));
    private WebElement btnBaseOnReview = keyword.findElement(By.xpath("//a[@data-analytics='consrev_basedonrev_top_lnk']"));
    private WebElement lblRateScore = keyword.findElement(By.cssSelector("#consumerreview .css-1ohwf54"));
    private By btnClearFilter= By.xpath("//a[@data-cy='clear_filter_button']");
    public By lblFilterInfo =By.xpath("//p[@data-cy='filter_info']/span[@class='css-4epbhr']");

    private WebElement btnOptionTopic(String topic) {
        return keyword.findElement(By.xpath("//div[contains(@class,'css-1c5vle7-Label') and text()='" + topic + "']"));
    }

    private WebElement lblCheckOfTrendTopic(String topicName){
        return keyword.findElement(By.xpath("//input[@name='trending' and @value='"+topicName+"']"));
    }

    private List<WebElement> listElementFullStarOfReview(Integer indexOfReview) {
        return keyword.findElements(By.xpath("//div[@data-cy='consumer_review_" + indexOfReview + "']//img[@alt='fullStar']"));
    }

    private List<WebElement> btnLikeIconOfReview() {
        return keyword.findElements(By.xpath("//a[@aria-label='helpful']"));
    }

    private WebElement lblLikePercentOfStar(int star) {
        return keyword.findElement(By.xpath("//div[@data-analytics='cr_filter_" + star + "_stars_reviews']//div[contains(@class,'eov6l8h1')]//span[contains(@class,'css-1jyh237-PercentageNumber')]"));
    }

    private List<WebElement> btnDislikeIconOfReview() {
        return keyword.findElements(By.xpath("//a[@aria-label='notHelpful']"));
    }

    private List<WebElement> userReviewContain() {
        return keyword.findElements(By.cssSelector(".css-542wex.e9ci9ab0"));
    }

    /**
     * Click label "Consumer" of overflow on the top to scroll down to Consumer section
     */
    public void clickToScrollToConsumerReviewSection() {
        keyword.click(lblConsumerOfOverFlow);
    }

    /**
     * Click to show full review
     */
    public void clickToSeeFullReview() {
        keyword.clickByJS(btnReadConsumerReview);
    }

    /**
     * Click on Write a review button
     */
    public void clickWriteAReviewButton() {
        keyword.clickByJS(btnWriteAReview);
    }

    /**
     * Click on Base On Consumer Review
     */
    public void clickBtnBaseOnConsumerReview() {
        keyword.clickByJS(btnBaseOnReview);
    }

    /**
     * Click on Star line
     */
    public void clickToChooseFilterByStar(Integer star) {
        keyword.clickByJS(lblLikePercentOfStar(star));;
    }

    /**
     * Click on Trending topic Tag
     */
    public void clickToChooseFilterByTrendingTopic(String topic) {
        keyword.clickByJS(btnOptionTopic(topic));;
    }

    /**
     * Click on Link text to Clear filter
     */
    public void clickOnClearFilter(){
        keyword.clickByJS(keyword.findElement(btnClearFilter));
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
        return isElementEnabled(btnLikeIconOfReview().get(index));
    }

    /**
     * return is Like Icon Clickable or not
     */
    public boolean isDislikeIconClickable(int index) {
        return isElementEnabled(btnDislikeIconOfReview().get(index));
    }

    /**
     * return is Score Rated Equal Average Of Percent Per Star or not
     */
    public boolean isScoreRatedEqualAverageOfPercentPerStar() {
        double averagePercentPerStar = 0;
        for (int i = 1; i <= 5; i++) {
            Double percent = Double.valueOf(keyword.getText(lblLikePercentOfStar(i)).replace("%", "").trim());
            averagePercentPerStar += (i * (percent / 100));
        }
        averagePercentPerStar = Math.round(averagePercentPerStar);
        System.out.println(lblRateScore);
        System.out.println(String.valueOf(averagePercentPerStar));
        return keyword.getText(lblRateScore).equals(String.valueOf(averagePercentPerStar));
    }

    /**
     * return is Rated Star Of Reviews Match With The Star User Choose or not
     * @param star the number of the star which user choose
     */
    public boolean isRatedStarOfReviewsMatchWithTheStarUserChoose(Integer star) {
        boolean result = true;
        for (int i = 0; i < EXPECTED_REVIEW_PER_PAGE; i++) {
            keyword.scrollToElement(userReviewContain().get(i));
            if (star.equals(listElementFullStarOfReview(i).size())) {
                result = true;
            } else {
                result = false;
                ExtentTestManager
                    .getTest()
                    .log(Status.FAIL, "Rated star of review number " + (i + 1)
                        + " not match with the star chosen by user");
                break;
            }
        }
        return result;
    }

    /**
     * @param topic user chose before
     * @param expectedFilterInfo filter info before click chose filter
     * @return is The Filter Cleared or not
     */
    public boolean isTheFilterCleared(String topic,String expectedFilterInfo){
        boolean result = true;
        if(lblCheckOfTrendTopic(topic).isSelected()){
            result = false;
        }
        if(!expectedFilterInfo.equals(getText(lblFilterInfo))){
            ExtentTestManager
                .getTest()
                .log(Status.FAIL,"Filter info still not clear filter");
            result = false;
        }
        return result;
    }

    Integer EXPECTED_REVIEW_PER_PAGE = 6;
}

