package com.example.pages.carForSale;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.core.keyword.WebKeyword.chooseTypeOfSelect;
import com.example.pages.BasePage;

public class MyWalletPage extends BasePage {

    public MyWalletPage(WebDriver driver) {
        super(driver);
    }

    public MyWalletPage() {
    }

    private By lblMyWallet = By.xpath("//div[@data-cmp='myWalletGridContainer']");
    private By puMyWallet = By.cssSelector("[role=document]");
    public By btnCreditTerm = By.xpath("//div[contains(@class,'mywallet-content')]//div[text()='CREDIT & TERM']");
    public By btnDownPayment = By.xpath("//div[contains(@class,'mywallet-content')]//div[text()='DOWN PAYMENT']");
    public By btnTradeIn = By.xpath("//div[contains(@class,'mywallet-content')]//div[text()='TRADE-IN']");
    private By btnCloseWalletPopUp = By.xpath("//button[@class='close']");
    public By ddlCreditRange = By.xpath("//select[@name='creditTierInput']");
    public By ddlTermLength = By.xpath("//select[@name='termLengthInput']");
    private By btnReturnToDashboard = By.xpath("//button[text()='Return to Dashboard']");
    private By rdoGroupCustomRate = By.xpath("//div[@class='radio-group']");
    private By locatorRateNewCar = By.xpath("//span[text()='New Car Loan:'] /span");
    private By locatorRateUsedCar = By.xpath("//span[text()='Used Car Loan:'] /span");
    private By locatorFirstUsedCar = By.xpath(
            "(//div[@data-cmp='inventorySpotlightListing']/descendant::h2[contains(text(),'Used')])[1]/following::span[contains(text(),'See')][1]");
    private By locatorFirstNewCar = By.xpath(
            "(//div[@data-cmp='inventoryListing']/descendant::h2[contains(text(),'New')])[1]/following::span[contains(text(),'See')][1]");
    private By locatorPreviewSummary = By.xpath("//span[contains(text(),'National')]/parent::div");

    public boolean isMyWalletPopUpDisplay() {
        boolean flag = true;
        if (elmIsVisible(puMyWallet) == true && elmIsVisible(btnCreditTerm) == true
                && elmIsVisible(btnDownPayment) == true
                && elmIsVisible(btnTradeIn) == true) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean isXButtonClickable() {
        if (elmIsClickable(btnCloseWalletPopUp) == true) {
            WebElement btnClose = keyword.findElement(btnCloseWalletPopUp);
            keyword.click(btnClose);
            try {
                keyword.findElement(puMyWallet);
                return false;

            } catch (Exception e) {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean compareList(String[] expectedList, By locator) {
        boolean flag = true;
        WebElement element = keyword.findElement(locator);
        ArrayList<String> arr = (ArrayList<String>) keyword.getSelectOptionsList(element);
        for (int i = 0; i < arr.size(); i++) {
            flag = arr.get(i).equals(expectedList[i]);
            if (flag == false) {
                break;
            }
        }
        return flag;
    }

    public boolean isReturnDashboardAndRdoGroupCustomDisplayed() {
        if (elmIsClickable(btnReturnToDashboard) == true && elmIsVisible(rdoGroupCustomRate) == true) {
            return true;
        } else {
            return false;
        }
    }

    public void inputDataForCreditAndTerm(String creditRange, String termLength, String customRate)
            throws InterruptedException {
        String rdoCustomRateLocator = String.format("//div[text()='%s']", customRate);
        WebElement ddlCredit = keyword.findElement(ddlCreditRange);
        WebElement ddlTerm = keyword.findElement(ddlTermLength);
        WebElement rdoCustom = keyword.findElement(By.xpath(rdoCustomRateLocator));
        keyword.setValueForElement(ddlCredit, chooseTypeOfSelect.selectByValue, creditRange);
        keyword.setValueForElement(ddlTerm, chooseTypeOfSelect.selectByValue, termLength);
        keyword.click(rdoCustom);
    }

    public boolean isNewUsedCarLoanCorrect(String newCarLoan, String usedCarLoan) {
        if (isItemCorrect(newCarLoan, locatorRateNewCar) == true
                && isItemCorrect(usedCarLoan, locatorRateUsedCar) == true) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isPreviewSummanyCorrect(String usedCarLoan, String termLength) {
        String expectedPreviewSummary = String.format("National Average Rate %s APR for %s mo.", usedCarLoan, termLength);
        keyword.click(keyword.findElement(btnCloseWalletPopUp));
        keyword.scrollToElement(keyword.findElement(locatorFirstUsedCar));
        keyword.click(keyword.findElement(locatorFirstUsedCar));
        if (keyword.getText(keyword.findElement(locatorPreviewSummary)).equals(expectedPreviewSummary)) {
            System.out.println(keyword.getText(keyword.findElement(locatorPreviewSummary)));
            System.out.println(expectedPreviewSummary);
            return true;
        } else {
            return false;
        }
    }

    public String[] arrTermLength = { "36", "48", "60", "72" };
    public String[] arrCreditRange = { "Excellent (740-900)", "Very Good (700-739)", "Good (670-699)", "Fair (630-669)",
            "Rebuilding (580-629)" };

}
