package com.example.tests.carForSale;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.pages.BasePage;
import com.example.pages.carForSale.MyWalletPage;
import com.example.pages.carForSale.MyWalletTradeInPage;
import com.example.tests.BaseTest;

public class MyWalletTradeInTests extends BaseTest {
    @Test(testName = "Verify that My Wallet pop up should be display when click on Update Wallet button")
    public void verifyThatMyWalletPopUpShoubleBeDisplayWhenClickOnUpdateWalletButton() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        Thread.sleep(2000);
        basePage.clickAction(basePage.btnUpdateWallet);
        MyWalletPage myWalletPage = new MyWalletPage(driver);
        basePage.clickAction(myWalletPage.btnTradeIn);
        MyWalletTradeInPage myWalletTradeInPage = new MyWalletTradeInPage(driver);
        Assert.assertTrue(myWalletTradeInPage.isTradeInContentDisplay());
    }

    @Test(testName = "Verify that My Wallet pop up should be display when click on Update Wallet button")
    public void verifyThatMyWalletPopUpShoubleBeDisplayWhenClickOnUpdateWalletButton2() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
        Thread.sleep(2000);
        basePage.clickAction(basePage.btnUpdateWallet);
        MyWalletPage myWalletPage = new MyWalletPage(driver);
        basePage.clickAction(myWalletPage.btnTradeIn);
        MyWalletTradeInPage myWalletTradeInPage = new MyWalletTradeInPage(driver);
        basePage.clickAction(myWalletTradeInPage.locabtnTradeIn);
        Assert.assertTrue(myWalletTradeInPage.isTradeInContentDisplay());
    }
}
