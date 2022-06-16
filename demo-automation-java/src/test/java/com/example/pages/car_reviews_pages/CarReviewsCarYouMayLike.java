package com.example.pages.car_reviews_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.example.pages.BasePage;

public class CarReviewsCarYouMayLike extends BasePage {
    public CarReviewsCarYouMayLike(WebDriver driver) {
        super(driver);
    }

    //declare
    public By txtMessage=By.xpath("//div[@data-cmp='heading']");
    public By txtLabelVihicle=By.xpath("//h1");

    /**
     * Check message display correct when select card vihicle no long avalible
     * @return
     */
    public boolean checkMessageCorrectWhenCarNoLongerAvaiable() {
        return keyword.isMessageCorrect(keyword.findElement(txtMessage), messageExpected);
    }

    /**
     * check systeam navigate correct when select card vihicle avalible
     * @param labelVihicle
     * @return
     */
    public boolean checkRedirectToCarForSaleWithCarSeleted(String labelVihicle) {
        try {
            return keyword.isMessageCorrect(keyword.findElement(txtLabelVihicle), labelVihicle);
        } catch (Exception e) {
            return false;
        }  
    }
    
    //data expected
    String messageExpected="This car is no longer available. One moment while we take you to the search results page.";
    
}
