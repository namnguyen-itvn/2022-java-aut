package com.example.tests.carForSale;

import com.example.core.utils.listener.ReportListener;
import com.example.pages.*;
import com.example.pages.carForSale.CarForSaleConditionPage;
import com.example.tests.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class TestMainWorkFlow1 extends BaseTest {

    @Test(testName = "Demo Navigate To The Page")

    public void demoNavigateToThePage() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Sale");
    }

}
