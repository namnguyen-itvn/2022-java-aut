package com.example.pages.car_reviews_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.core.keyword.WebKeyword.chooseTypeOfSelect;
import com.example.pages.BasePage;

public class CarReviewsDetailNewCarPriceQuotePage extends BasePage {
    public CarReviewsDetailNewCarPriceQuotePage(WebDriver driver) {
        super(driver);
    }
    //Declare
    private By iframeNewCarPriceQuote = By.xpath("//iframe[@title='pricequtoe']");
    private By txtTitleNewCarPriceQuote = By.xpath("//h2[@id='header-text']");
    private By txtDescriptionTitle = By.xpath("//h2[@id='description-title']");
    private By txtDescriptionSubtitle = By.xpath("//p[@id='description-subtitle']");
    private By selectMake = By.xpath("//select[@placeholder='Make']");
    private By selectModel = By.xpath("//select[@placeholder='Model']");
    private By selectStyle = By.xpath("//select[@placeholder='Style/Trim']");
    private By inputZipcode = By.xpath("//input[@id='zipInput']");
    private By btnFindDealers = By.xpath("//button[@id='Step1Button']");

    public By txtChangZipcode=By.xpath("//a[text()='Change ZIP Code']");
    public By txtYearMakeModel=By.xpath("//div[@id='test-vehicleymm']//p");
    public By txtStyle=By.xpath("//div[contains(@class,'css-osapl5-Content')]//div[2]//p");
    public By txtChangVehicle=By.xpath("//div[@id='test-page-content']//a[text()='Change Vehicle']");
    public By btnGetMyFreeQuote=By.xpath("// button[@id='Step2Button']");
    public By checkboxDealer1=By.xpath("//input[@id='dealerkey1']");
    public By checkboxDealer2=By.xpath("//input[@id='dealerkey2']");
    public By checkboxDealer3=By.xpath("//input[@id='dealerkey3']");

    public By txtFirstName=By.xpath("//input[@id='firstName']");
    public By txtLastName=By.xpath("//input[@id='lastName']");
    public By txtEmail=By.xpath("//input[@id='email']");
    public By txtPhone=By.xpath("//input[@id='phoneNumber']");
    public By btnSend=By.xpath("//button[@name='Step3Button']");
    public By linkPolicy=By.xpath("//div[@id='test-page-content']//a[text()='Privacy Policy']");

    public By txtDescriptionSubtitleCYML=By.xpath("//div[contains(@class,'css-8foxlt-HeadingWrapper')]/span");
    public By txtVihicleCard=By.xpath("//div[contains(@class,'efy00sb1')]");
    public By linkBrowseAllListings=By.xpath("//a[@data-analytics='inv_ncymm_buynew_browse_list_btn']");
    public By txtTitleCarYouMayLike=By.xpath("//div[@id='carsforsale']//h3");

    public By txtVihicleCard1=By.xpath("//div[contains(@class,'efy00sb1')][1]/div");
    public By txtYearVihicleCard=By.xpath("//div[contains(@class,'efy00sb1')][1]/div//div[@type='default']/div");
    public By txtMakeModelVihicleCard=By.xpath("//div[contains(@class,'efy00sb1')][1]/div//div[@type='default']/following-sibling::*");

    /**
     * check Car Price Quote Section Display
     * @return
     */
    public boolean checkCarPriceQuoteSectionDisplay() {
        keyword.scrollToElement(keyword.findElement(iframeNewCarPriceQuote));
        return  keyword.checkDisplay(keyword.findElement(iframeNewCarPriceQuote));
    }

    /**
     * check UI New Car Price Quote display correctly
     * @return
     */
    public boolean checkUINewCarPriceQuote() {
        keyword.scrollToElement(keyword.findElement(iframeNewCarPriceQuote));
        driver.switchTo().frame(keyword.findElement(iframeNewCarPriceQuote));
        return keyword.isMessageCorrect(keyword.findElement(txtTitleNewCarPriceQuote), titleSection) && 
        keyword.isMessageCorrect(keyword.findElement(txtDescriptionTitle), descriptionTitleExpected) &&
        keyword.isMessageCorrect(keyword.findElement(txtDescriptionSubtitle), descriptionSubtitleExpected) &&
        keyword.checkClickable(keyword.findElement(selectStyle)) && keyword.checkClickable(keyword.findElement(selectMake)) 
        && keyword.checkClickable(keyword.findElement(selectModel)) &&
        keyword.checkDisplay(keyword.findElement(inputZipcode)) && keyword.checkClickable(keyword.findElement(btnFindDealers));
    }

    /**
     * check Default The Items Of Make Model In Dropdown List
     * @param make
     * @param model
     * @return
     */
    public boolean checkDefaultTheItemsOfMakeModelInDropdownList(String make, String model) {
        keyword.scrollToElement(keyword.findElement(iframeNewCarPriceQuote));
        driver.switchTo().frame(keyword.findElement(iframeNewCarPriceQuote));
        return keyword.isOptionSelectedIsCorrect(keyword.findElement(selectMake),make) && 
        keyword.isOptionSelectedIsCorrect(keyword.findElement(selectModel), model);
    }

    /**
     * fill data for New Car Price Quote Section
     * @param makeQuote
     * @param modelQuote
     * @param styleQuote
     * @param zipQuote
     * @throws Exception
     */
    public void selectMakeModelStyleAndFillZipcodeData(String makeQuote, String modelQuote, String styleQuote,String zipQuote) throws Exception {
        keyword.scrollToElement(keyword.findElement(iframeNewCarPriceQuote));
        driver.switchTo().frame(keyword.findElement(iframeNewCarPriceQuote));
        keyword.setValueForElement(keyword.findElement(selectMake), chooseTypeOfSelect.selectByVisibleText, makeQuote);
        Thread.sleep(2000);
        keyword.setValueForElement(keyword.findElement(selectModel), chooseTypeOfSelect.selectByVisibleText, modelQuote);
        Thread.sleep(2000);
        keyword.setValueForElement(keyword.findElement(selectStyle), chooseTypeOfSelect.selectByVisibleText, styleQuote);
        keyword.setText(keyword.findElement(inputZipcode),zipQuote);
    }

    /**
     * Close Ads
     */
    public void actionExitAds() {
        try {
            WebElement optDiveType = driver.findElement(By.xpath("//button[contains(@aria-label,'Close')]"));
            keyword.click(optDiveType);
        } catch (Exception e){

        }
        
    }
    /**
     * Click button Find Dealers
     */
    public void clickButtonFindDealers() {
        actionExitAds();
        //keyword.click(keyword.findElement(btnFindDealers));
        keyword.waitForElementIsClickable(keyword.findElement(btnFindDealers)).click();
    }

    /**
     * Check New Car Price Quote UI Correct when fill data and click button Find Dealers
     * @return
     */
    public boolean checkCarPriceQuoteSectionWorkCorrectWhenInputValidDataAndClickButtonFindDealers() {
        return  keyword.checkDisplay(keyword.findElement(txtTitleNewCarPriceQuote))&& 
        keyword.checkDisplay(keyword.findElement(txtDescriptionTitle)) &&  keyword.checkDisplay(keyword.findElement(txtDescriptionSubtitle)) &&
        keyword.checkClickable(keyword.findElement(txtChangZipcode)) &&  keyword.checkDisplay(keyword.findElement(txtYearMakeModel)) && 
        keyword.checkClickable(keyword.findElement(txtChangVehicle)) &&  keyword.checkClickable(keyword.findElement(btnGetMyFreeQuote));
        //&&  keyword.checkDisplay(keyword.findElement(txtStyle));// && checkSelect(checkboxDealer1) 
        // && checkSelect(checkboxDealer2) && checkSelect(checkboxDealer3)
    }

    /**
     * Check UI New Car You May Like correct
     * @return
     */
    public boolean checkUINewCarYouMayLike() {
        keyword.scrollToElement(keyword.findElement(txtTitleCarYouMayLike));
        System.out.println(keyword.waitForElementIsDisplay(keyword.findElement(txtDescriptionSubtitleCYML)).getText());
        return keyword.isMessageCorrect(keyword.findElement(txtDescriptionSubtitleCYML), descriptionSubtitleCYMLExpected) &&
        checkNumberVihicleCard() && keyword.checkClickable(keyword.findElement(linkBrowseAllListings)) &&
        keyword. checkDisplay(keyword.findElement(linkBrowseAllListings));
    }

    /**
     * Check list card vihicle
     * @return
     */
    public boolean checkNumberVihicleCard() {
        List<WebElement> listCard = driver.findElements(txtVihicleCard);
        return listCard.size()==12;
    }

    /**
     * Click on card vihicle and press ESC
     */
    public void clickCardvihicleESC() throws InterruptedException {
        keyword.scrollToElement(keyword.findElement(txtTitleCarYouMayLike));
        keyword.click(keyword.findElement(txtVihicleCard1));
        // Actions action = new Actions(driver);
        // Thread.sleep(2000);
	    // action.sendKeys(Keys.ESCAPE);
        // action.sendKeys(Keys.ESCAPE);
        // Thread.sleep(4000);
    }

    /**
     * Click on card vihicle
     */
    public void clickCardvihicle(){
        keyword.scrollToElement(keyword.findElement(txtTitleCarYouMayLike));
        keyword.click(keyword.findElement(txtVihicleCard1));
    }

    /**
     * Get label of vehicle selected
     * @return
     */
    public String getLabelVihicle() {
        System.out.println(keyword.getTextElenment(keyword.findElement(txtYearVihicleCard))+" "+keyword.getTextElenment(keyword.findElement(txtMakeModelVihicleCard)));
        return keyword.getTextElenment(keyword.findElement(txtYearVihicleCard))+" "+keyword.getTextElenment(keyword.findElement(txtMakeModelVihicleCard));
    }

    //data expected
    String  titleSection="New Car Price Quote";
    String descriptionTitleExpected="Get the best deal on a new car!";
    String descriptionSubtitleExpected="Compare prices from three local dealers.";
    String descriptionSubtitleCYMLExpected="We’Ve Rounded Up Cars That Could Be Your Perfect Match.";

}
