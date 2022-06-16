package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.core.datadriven.CreditAndTermUnderTest;
import com.example.pages.BasePage;
import com.example.pages.carForSale.MyWalletPage;
import com.example.tests.BaseTest;

public class MyWalletTests extends BaseTest {
    @Test(testName = "Verify that My Wallet pop up shouble be display when click on Update Wallet button")
    public void verifyThatMyWalletPopUpShoubleBeDisplayWhenClickOnUpdateWalletButton() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        basePage.clickAction(basePage.btnUpdateWallet);
        MyWalletPage myWalletPage = new MyWalletPage(driver);
        Assert.assertTrue(myWalletPage.isMyWalletPopUpDisplay());
    }

    @Test(testName = "Verify that X button of Wallet pop up shouble be clickable")
    public void verifyThatXButtonOfWalletPopUpShoubleBeClickable() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        basePage.clickAction(basePage.btnUpdateWallet);
        MyWalletPage myWalletPage = new MyWalletPage(driver);
        Assert.assertTrue(myWalletPage.isXButtonClickable());
    }

    @Test(testName = "Verify that Credit Range drop down list should be display and include all expected data")
    public void verifyThatCreditRangeDropDownListShouldBeDisplayAndIncludeAllExpectedData()
            throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        basePage.clickAction(basePage.btnUpdateWallet);
        MyWalletPage myWalletPage = new MyWalletPage(driver);
        basePage.clickAction(myWalletPage.btnCreditTerm);
        Assert.assertTrue(myWalletPage.compareList(myWalletPage.arrCreditRange, myWalletPage.ddlCreditRange));

    }

    @Test(testName = "Verify that Term Lenght drop down list should be display and include all expected data")
    public void verifyThatTermLenghtDropDownListShouldBeDisplayAndIncludeAllExpectedData() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        basePage.clickAction(basePage.btnUpdateWallet);
        MyWalletPage myWalletPage = new MyWalletPage(driver);
        basePage.clickAction(myWalletPage.btnCreditTerm);
        Assert.assertTrue(myWalletPage.compareList(myWalletPage.arrTermLength, myWalletPage.ddlTermLength));
    }

    @Test(testName = "Verify that Return to Dashboard should be clickable and Do you want to use a custom rate radio button group shouble display")
    public void verifyThatReturnToDashboardClickableAndDoYouWantToUseACustomRateRdoGroupDisplay()
            throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        basePage.clickAction(basePage.btnUpdateWallet);
        MyWalletPage myWalletPage = new MyWalletPage(driver);
        basePage.clickAction(myWalletPage.btnCreditTerm);
        Assert.assertTrue(myWalletPage.isReturnDashboardAndRdoGroupCustomDisplayed());
    }

    @Test(testName = "Verify that New Car Loan and Used Car Loan should be display and have value match with expected data when user choose option No of Do you want to use a custom rate?", dataProvider = "CreditAndTermUnderTest", dataProviderClass = CreditAndTermUnderTest.class)
    public void verifyNewCarLoanUsedCarLoanShouldHaveValueMatchWithExpectedDataWhenUserChooseOptionNoCustomRate(
            String creditRange, String termLength, String customRate, String newCarLoan, String usedCarLoan) throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        Thread.sleep(3000);
        basePage.clickAction(basePage.btnUpdateWallet);
        MyWalletPage myWalletPage = new MyWalletPage(driver);
        basePage.clickAction(myWalletPage.btnCreditTerm);
        myWalletPage.inputDataForCreditAndTerm(creditRange, termLength, customRate);
        Assert.assertTrue(myWalletPage.isNewUsedCarLoanCorrect(newCarLoan, usedCarLoan));
    }

  
}
