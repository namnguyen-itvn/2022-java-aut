package com.example.core.utils.extentreport;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.example.tests.BaseTest;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<String> categoryName = new ThreadLocal<>();

    public static ThreadLocal<String> getCategoryName() {
        return categoryName;
    }

    public static void setCategoryName(String categoryName) {
        getCategoryName().set(categoryName);
    }

	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {
		extent.flush();
	}

	public static synchronized ExtentTest startTest(String testName) {
		ExtentTest test = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

    public static void addScreenShot(Status status, String message) {

        String base64Image;
        try {
            base64Image = "data:image/png;base64,"
                    + ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BASE64);
            getTest().log(status, message, getTest().addScreenCaptureFromBase64String(base64Image).getModel().getMedia().get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

    public static void logMessage(Status status, String message) {
        getTest().log(status, message);
    }
}
