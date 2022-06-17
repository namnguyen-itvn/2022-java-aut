package com.example.pages.car_reviews_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import com.example.core.keyword.WebKeyword.chooseTypeOfSelect;
import com.example.pages.BasePage;

public class CarReviewsModulePage extends BasePage{
    public CarReviewsModulePage() {
    }

    public CarReviewsModulePage(WebDriver driver) {
        super(driver);
    }

    //Declare object
    WebElement boxSelectAVehicle = keyword.findElement(By.cssSelector("div[class*='StyledBox-airforceblue'"));
    WebElement headingSelectAVehicle = keyword.findElement(By.cssSelector("*[class*='StyledBox-airforceblue'] p[class*='StyledHeading']"));
    WebElement msgSelectAVehicle = keyword.findElement(By.cssSelector("*[class*='StyledBox-airforceblue'] *[type='body']"));
    WebElement ddYear = keyword.findElement(By.cssSelector("*[aria-label='Year']"));
    WebElement ddMake = keyword.findElement(By.cssSelector("*[aria-label='Make']"));
    WebElement ddModel = keyword.findElement(By.cssSelector("*[aria-label='Model']"));
    WebElement txtZipcode = keyword.findElement(By.cssSelector("*[class^='zipcode']"));
    WebElement btnGetReviews = keyword.findElement(By.cssSelector("*[class*='WrappedButton']"));

    //Page aciton
    /**
    * Check Select A Vehicle box background color is displayed correct or not
    * 
    * @return
    */
    public boolean isSelectAVehicleBoxBackgroundColorCorrect(WebElement element){
        Color elementColour = Color.fromString(element.getCssValue("background-color"));
        if (
            elementColour.asHex().equals("#2b5195") &&
            isElementDisplayed(element)
        ) return true;
        return false;
    }

    /**
     * Verify car review mudule is displayed correct or not
     * @return
     */
    public boolean isCarReviewsModuleDisplayed(){
        if (
            isSelectAVehicleBoxBackgroundColorCorrect(boxSelectAVehicle) &&
            isElementDisplayed(headingSelectAVehicle) &&
            isElementTextEqualExpectedText(msgSelectAVehicle,expectedSelectAVehicleMessage) &&
            isElementEnabled(ddYear) &&
            !isElementEnabled(ddMake) &&
            !isElementEnabled(ddModel) &&
            isElementEnabled(txtZipcode) &&
            !isElementEnabled(btnGetReviews)
        ) return true;
        return false;
    }

    /**
     * Search for vehicle action
     * @param year
     * @param make
     * @param model
     * @param zipCode
     * @throws Exception
     */
    public void searchForVehicle(String year, String make, String model, String zipCode) throws Exception{
        keyword.setValueForSelectElement(ddYear, chooseTypeOfSelect.selectByValue, year);
        keyword.setValueForSelectElement(ddMake, chooseTypeOfSelect.selectByValue, make);
        keyword.setValueForSelectElement(ddModel, chooseTypeOfSelect.selectByValue, model);

        expectedCarReviewDetailHeaderTitle = "Used " + year + " " + make +" " + model;
        expectedCarReviewDetailsPageTitle = expectedCarReviewDetailHeaderTitle + " Values & Cars for Sale | Kelley Blue Book";

        keyword.setText(txtZipcode, zipCode);

        keyword.click(btnGetReviews);
    }

    //Expected value
    public String expectedSelectAVehicleMessage = "Get the straight story from our experts and real-world feedback from consumers like you.";
    public String expectedCarReviewDetailHeaderTitle = "";
    public String expectedCarReviewDetailsPageTitle = "";
}
