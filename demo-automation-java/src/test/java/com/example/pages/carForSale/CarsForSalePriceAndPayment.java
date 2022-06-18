package com.example.pages.carForSale;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.pages.BasePage;

public class CarsForSalePriceAndPayment extends BasePage {
    public CarsForSalePriceAndPayment(WebDriver driver) {
        super(driver);
    }

    // car4sale ePriceAndPayment element
    private WebElement txbMinPrice = keyword.findElement(By.id("622192741"));
    private WebElement txbMaxPrice = keyword.findElement(By.id("564749857"));
    private WebElement btnMonthlyPayment = keyword.findElement(By.cssSelector("div[data-cmp='MyFilterWallet'] div.react-toggle input"));
    private By locaimgFirstResults = By.xpath("(//div[@data-cmp='itemCard'])[1]");


    /**
     *  Return MinPriceTextHint is correct or not
     * @return
     */
    public boolean isMinPriceTextHintCorrect(){
        if (txbMinPrice.getAttribute("placeholder").contains("54")) {
            return true;
        }
        else return false;
    }

        /**
     *  Return MaxPriceTextHint is correct or not
     * @return
     */
    public boolean isMaxPriceTextHintCorrect(){
        if (txbMaxPrice.getAttribute("placeholder").contains("9,999,999")) {
            return true;
        }
        else return false;
    } 

    /**
     *  Return BtnMonthlyPayment is correct or not
     * @return
     */
    public boolean isBtnMonthlyPaymentNotSet(){
        System.out.println(txbMaxPrice.getAttribute("placeholder"));
        if (btnMonthlyPayment.isSelected()==false) {
            return true;
        }
        else return false;
    } 

        /**
     *  Return MinMaxPriceTextHint and btnMonthlyPayment is correct or not
     * @return
     */
    public boolean isMaxMinPriceTextHintCorrect(){
        if (isMaxPriceTextHintCorrect()==true & 
            isMinPriceTextHintCorrect()==true &
            isBtnMonthlyPaymentNotSet()==true) {
            return true;
        }
        else return false;
    }

            /**
     *  action setValue for maxmin price 
     * @param min
     * @param max
     */
    //action setValue for maxmin price 
    public void actionSetPrice(String min, String max){
        waitNoCondition();
        keyword.scrollToElement(txbMaxPrice);
        try {
            keyword.setText(txbMinPrice, min);
            keyword.setText(txbMaxPrice, max);
        } catch (Exception e) {
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        waitNoCondition();
    }
    
    //action navigate to detail vehicle [effect with ads]
    public void actionNavToCFSVehicleDetails(){
        WebElement imgFirstResults = keyword.findElement(locaimgFirstResults);
        keyword.scrollToElement(imgFirstResults);
        keyword.click(imgFirstResults);
        waitNoCondition(); 
    }

    //wait with No Condition
    public void waitNoCondition(){
        By locabtnExitAds = By.xpath("//button[@id='fsrFocusFirst']");
        WebDriverWait wait1 = new WebDriverWait(driver, 3);
        try {
            WebElement btnExitAds = wait1.until(ExpectedConditions.visibilityOfElementLocated(locabtnExitAds));
        } catch (Exception e) {
        }
    }
}