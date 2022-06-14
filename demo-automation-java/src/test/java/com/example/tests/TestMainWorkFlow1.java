package com.example.tests;

import com.example.core.datadriven.AccountUnderTest;
import com.example.pages.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMainWorkFlow1 extends BaseTest {
    
    @Test(dataProvider = "AccountUnderTest", dataProviderClass = AccountUnderTest.class, priority = 1)
    public void verifyUserCanLoginAndLogoutSuccessfully(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.actionLogin(username, password);

        // Verify the product page title
        String productPageTitle = "PRODUCTS";
        Assert.assertTrue(productPage.isTitleCorrect(productPageTitle), "Product page title doesn't match");
        // Verify there are six products displayed on product page
        Assert.assertTrue(productPage.getQuantityOfProducts() == 6, "Quantity of products doesn't match");

        LoginPage loginPageAfterLogout = (LoginPage) productPage.navigateToPage("Logout");

        // Verify the username/password textboxes are displayed
        Assert.assertTrue(loginPageAfterLogout.isUsernameTextboxDisplayed(), "Username textbox isn't displayed");
        Assert.assertTrue(loginPageAfterLogout.isPasswordTextboxDisplayed(), "Password textbox isn't displayed");
        // Verify the Login button is displayed
        Assert.assertTrue(loginPageAfterLogout.isLoginButtonDisplayed(), "Login button isn't displayed");
        // Verify the Login button is displayed as red color
        String redColorHexCode = "#e2231a";
        Assert.assertTrue(loginPageAfterLogout.getLoginButtonColor().equals(redColorHexCode), "The Login button's color doesn't match");
    }
}
