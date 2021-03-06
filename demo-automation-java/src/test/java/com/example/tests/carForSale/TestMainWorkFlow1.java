package com.example.tests.carForSale;

import com.example.core.utils.listener.ReportListener;
import com.example.pages.*;
import com.example.tests.BaseTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class TestMainWorkFlow1 extends BaseTest {
    
    @Test(testName = "Verify that content 'About the Kelley Blue Book New Car Reviews' should be displayed with the short description about it")
    public void verifyThatContentAboutTheKelleyBlueBookNewCarReviewsShouldBeDisplayedWithTheShortDescriptionAboutIt() {
        BasePage basePage = new BasePage(driver);
        basePage.navigateToPage("Reviews");
    }

}
