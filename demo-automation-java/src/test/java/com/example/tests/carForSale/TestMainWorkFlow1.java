package com.example.tests.carForSale;

import com.example.pages.*;
import com.example.tests.BaseTest;

import org.testng.annotations.Test;

public class TestMainWorkFlow1 extends BaseTest {
    
    @Test(testName = "Demo Navigate To The Page")
    public void demoNavigateToThePage() {

        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
    }
}