package com.example.pages.carForSale;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
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
    private By locatorBtnDownPayment = By.xpath("//div[text()='DOWN PAYMENT']/parent::div/parent::div/parent::div");
    private By locatorRdoPercentageOfPrice = By.xpath("//div[text()='Percentage of Price']");
    private By locatorRdoDollarAmount = By.xpath("//div[text()='Dollar Amount']");
    private By locatorTxtDownPayment = By.xpath("//input[@name='downPaymentAmount']");
    private By locatorTextPayment = By.xpath("//div[text()='DOWN PAYMENT']/parent::div/following-sibling::div/span");
    private By lblDefaultDollarPayment = By.xpath("//input[@value='4000']");
    private By lblDefaultPercentPayment = By.xpath("//input[@value='20']");
    private By lblSaving = By.xpath("//span[text()='Saving...']");
    private By lblSaved = By.xpath("//span[text()='Saved']");
    private By btnSeeDetailsUsedCarFirst = By.xpath(
            "(//div[@data-cmp='inventorySpotlightListing']/descendant::h2[contains(text(),'Used')])[1]/following::span[contains(text(),'See')][1]");
    private By btnNewCarFirst = By.xpath(
            "(//div[@data-cmp='inventoryListing']/descendant::h2[contains(text(),'New')])[1]");
    private By btnViewVehicleDetails = By.xpath("//a[text()='View vehicle details']");
    private By valueDownPaymentDetailsPage = By.xpath("//div[text()='DOWN PAYMENT']/parent::div/parent::div/div/span");
    private By locatorValueDownPaymentOfDealOverview = By.xpath("//input[@id='downPaymentInput-finance']");
    private By locatorPriceCar = By.xpath("//span[@data-cmp='firstPrice']");
    private By locatorValuePaymentOfDealOverview = By.xpath("//input[@id='downPaymentInput-finance']");

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

    public void inputDataForDownPayment(String percentageOfPrice, String dollarAmount, String downPayment)
            throws Exception {
        try {
            clickAction(locatorBtnDownPayment);
            if (percentageOfPrice.equals("1") && dollarAmount.equals("0") && downPayment != null) {
                clickAction(locatorRdoPercentageOfPrice);
            } else if (percentageOfPrice.equals("1") && dollarAmount.equals("0") && downPayment != null) {
                clickAction(locatorRdoDollarAmount);
            }
            WebElement txtDownPayment = keyword.findElement(locatorTxtDownPayment);
            WebElement btnClose = keyword.findElement(btnCloseWalletPopUp);
            txtDownPayment.click();
            if (percentageOfPrice.equals("1") && dollarAmount.equals("0") && downPayment != null) {
                keyword.findElement(lblDefaultPercentPayment).clear();
            } else if (percentageOfPrice.equals("0") && dollarAmount.equals("1") && downPayment != null) {
                keyword.findElement(lblDefaultDollarPayment).clear();
            }
            keyword.setText(txtDownPayment, downPayment);
            keyword.click(keyword.findElement(lblSaving));
            keyword.click(keyword.findElement(lblSaved));
            keyword.click(btnClose);
        } catch (WebDriverException e) {
            throw new WebDriverException("Element is not enable to select");
        }
    }

    public boolean isDownPaymentDisplayCorrect(String percentageOfPrice, String dollarAmount, String downPayment) {
        String textPayment = keyword.getText(keyword.findElement(locatorTextPayment));
        System.out.println(textPayment);
        if (percentageOfPrice.equals("1") && dollarAmount.equals("0") && downPayment != null) {
            String expectedTextPayment = downPayment + '%';
            System.out.println(expectedTextPayment);
            if (expectedTextPayment.equals(textPayment)) {
                return true;
            } else {
                return false;
            }
        } else if (percentageOfPrice.equals("1") && dollarAmount.equals("0") && downPayment != null) {
            System.out.println(downPayment);
            if (downPayment.equals(textPayment)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isDownPaymentInDetailsPageCorrect(String percentageOfPrice, String dollarAmount,
            String downPayment) {
        WebElement btnNewCar = keyword.findElement(btnNewCarFirst);
        keyword.click(btnNewCar);
        String textPayment = keyword.getText(keyword.findElement(valueDownPaymentDetailsPage));
        if (percentageOfPrice.equals("1") && dollarAmount.equals("0") && downPayment != null) {
            String expectedTextPayment = downPayment + '%';
            System.out.println(expectedTextPayment);
            if (expectedTextPayment.equals(textPayment)) {
                return true;
            } else {
                return false;
            }
        } else if (percentageOfPrice.equals("1") && dollarAmount.equals("0") && downPayment != null) {
            System.out.println(downPayment);
            if (downPayment.equals(textPayment)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isDownPaymentOfDealOverviewCorrect(String percentageOfPrice, String dollarAmount,
            String downPayment) throws InterruptedException {
        WebElement btnNewCar = keyword.findElement(btnNewCarFirst);
        keyword.click(btnNewCar);
        String textPriceCar = keyword.getText(keyword.findElement(locatorPriceCar));
        System.out.println(textPriceCar);
        String removeCommaTextPriceCar = textPriceCar.replaceAll(",", "");
        int numberPriceCar = Integer.valueOf(removeCommaTextPriceCar);
        System.out.println(numberPriceCar);
        int expectedDownPaymentOfOverview = 0;
        if (percentageOfPrice.equals("1") && dollarAmount.equals("0")) {
            expectedDownPaymentOfOverview = numberPriceCar * Integer.parseInt(downPayment) / 100;
        } else if (percentageOfPrice.equals("0") && dollarAmount.equals("1")) {
            expectedDownPaymentOfOverview = Integer.parseInt(downPayment);
        }
        WebElement valueDownPaymentOfDealOverview = keyword.findElement(locatorValuePaymentOfDealOverview);
        keyword.scrollToElement(valueDownPaymentOfDealOverview);
        Thread.sleep(2000);
        String elementValue = driver.findElement(locatorValuePaymentOfDealOverview).getAttribute("value");
        System.out.println(elementValue);
        String removeCurrency = elementValue.substring(1);
        String removeComma = removeCurrency.replaceAll(",", "");
        int actualDownPaymentOfOverview = Integer.valueOf(removeComma);
        System.out.println(actualDownPaymentOfOverview);
        if (expectedDownPaymentOfOverview == actualDownPaymentOfOverview) {
            return true;
        } else {
            return false;
        }
    }

    public String[] arrTermLength = { "36", "48", "60", "72" };
    public String[] arrCreditRange = { "Excellent (740-900)", "Very Good (700-739)", "Good (670-699)", "Fair (630-669)",
            "Rebuilding (580-629)" };

}
