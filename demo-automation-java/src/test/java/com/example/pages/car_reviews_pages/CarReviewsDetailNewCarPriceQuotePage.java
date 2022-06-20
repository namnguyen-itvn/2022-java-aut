package com.example.pages.car_reviews_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    private By txtChangZipcode=By.xpath("//a[text()='Change ZIP Code']");
    private By txtYearMakeModel=By.xpath("//div[@id='test-vehicleymm']//p");
    private By txtStyle=By.xpath("//div[contains(@class,'css-osapl5-Content')]//div[2]//p");
    private By txtChangVehicle=By.xpath("//div[@id='test-page-content']//a[text()='Change Vehicle']");
    private By btnGetMyFreeQuote=By.xpath("// button[@id='Step2Button']");
    private By checkboxDealer1=By.xpath("//input[@id='dealerkey1']");
    private By checkboxDealer2=By.xpath("//input[@id='dealerkey2']");
    private By checkboxDealer3=By.xpath("//input[@id='dealerkey3']");

    private By txtFirstName=By.xpath("//input[@id='firstName']");
    private By txtLastName=By.xpath("//input[@id='lastName']");
    private By txtEmail=By.xpath("//input[@id='email']");
    private By txtPhone=By.xpath("//input[@id='phoneNumber']");
    private By btnSend=By.xpath("//button[@name='Step3Button']");
    private By linkPolicy=By.xpath("//div[@id='test-page-content']//a[text()='Privacy Policy']");

    private By txtDescriptionSubtitleCYML=By.xpath("//div[contains(@class,'css-8foxlt-HeadingWrapper')]/span");
    private By txtVihicleCard=By.xpath("//div[contains(@class,'efy00sb1')]");
    private By linkBrowseAllListings=By.xpath("//a[@data-analytics='inv_ncymm_buynew_browse_list_btn']");
    private By txtTitleCarYouMayLike=By.xpath("//div[@id='carsforsale']//h3");

    private By txtVihicleCard1=By.xpath("//div[contains(@class,'efy00sb1')][1]/div");
    private By txtYearVihicleCard=By.xpath("//div[contains(@class,'efy00sb1')][1]/div//div[@type='default']/div");
    private By txtMakeModelVihicleCard=By.xpath("//div[contains(@class,'efy00sb1')][1]/div//div[@type='default']/following-sibling::*");

    

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
        actionExitAds();
        keyword.scrollToElement(keyword.findElement(iframeNewCarPriceQuote));
        driver.switchTo().frame(keyword.findElement(iframeNewCarPriceQuote));
        keyword.setValueForSelectElement(keyword.findElement(selectMake), chooseTypeOfSelect.selectByVisibleText, makeQuote);
        Thread.sleep(2000);
        keyword.setValueForSelectElement(keyword.findElement(selectModel), chooseTypeOfSelect.selectByVisibleText, modelQuote);
        Thread.sleep(2000);
        keyword.setValueForSelectElement(keyword.findElement(selectStyle), chooseTypeOfSelect.selectByVisibleText, styleQuote);
        keyword.setText(keyword.findElement(inputZipcode),zipQuote);
        actionExitAds();
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
        WebElement element = keyword.findElement(btnFindDealers);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
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
    }

    /**
     * Click button Get My Free Quote
     */
    public void clickButtonGetMyFreeQuote() {
        actionExitAds();
        keyword.waitForElementIsClickable(keyword.findElement(btnGetMyFreeQuote)).click();
    }

    /**
     * Check Check car price quote section work correct when fill data and click button get my free quote
     * @return
     */
    public boolean checkCarPriceQuoteSectionWorkCorrectWhenInputValidDataAndClickButtonGetMyFreeQuote() {
        return keyword.checkDisplay(keyword.findElement(txtDescriptionTitle)) && 
        keyword.checkDisplay(keyword.findElement(txtDescriptionSubtitle)) &&
        keyword.checkDisplay(keyword.findElement(txtFirstName)) &&  keyword.checkDisplay(keyword.findElement(txtLastName)) && 
        keyword.checkDisplay(keyword.findElement(txtEmail)) && keyword.checkDisplay(keyword.findElement(txtPhone)) &&  
        keyword.checkClickable(keyword.findElement(btnSend)) && keyword.checkClickable(keyword.findElement(linkPolicy));
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

    public void clickOnBuildAndPriceButton(String year, String make, String model){
        WebElement btnBuildAndPrice  = driver.findElement(By.xpath("//a[@href='https://staging.kbb.com/"+make+"/"+model+"/"+year+"/styles/?intent=buy-used']"));
        keyword.click(btnBuildAndPrice);
    }

    public void clickOnSeeCarForSaleButton(String year, String make, String model){
        WebElement btnSeeCarForSale  = driver.findElement(By.xpath("https://staging.kbb.com/cars-for-sale/used/"+year+"/"+make+"/"+model));
        keyword.click(btnSeeCarForSale);
    }

    //data expected
    private String  titleSection="New Car Price Quote";
    private String descriptionTitleExpected="Get the best deal on a new car!";
    private String descriptionSubtitleExpected="Compare prices from three local dealers.";
    private String descriptionSubtitleCYMLExpected="We’Ve Rounded Up Cars That Could Be Your Perfect Match.";

}
