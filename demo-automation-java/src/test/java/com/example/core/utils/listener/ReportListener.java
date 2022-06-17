package com.example.core.utils.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.example.core.utils.extentreport.ExtentManager;
import com.example.core.utils.extentreport.ExtentTestManager;

public class ReportListener implements ITestListener{

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    private synchronized String getSimpleClassName(ITestResult result) {
        return result.getMethod().getRealClass().getSimpleName();
    }

    private synchronized void addExtentLabelToTest(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS)
            ExtentTestManager.getTest().pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
        else if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
        } else
            ExtentTestManager.getTest().skip(MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE));
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("--------- Executing :- " + getTestName(result) + " ---------");
        ExtentTestManager.startTest(result.getMethod().getMethodName());
        ExtentTestManager.setCategoryName(getSimpleClassName(result));        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(" ---------" + getTestName(result) + " test is passed" + " ---------");
        ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
        addExtentLabelToTest(result);
        ExtentTestManager.endTest();
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(" ---------" + getTestName(result) + " test is failed" + " ---------");
        ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
        ExtentTestManager.getTest().log(Status.FAIL, result.getName() + " Test is failed" +result.getThrowable());
        ExtentTestManager.addScreenShot(Status.FAIL, "Screenshot of web");
        
        addExtentLabelToTest(result);
        ExtentTestManager.endTest();        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, result.getName() + " Test is Skipped" +  result.getThrowable());        
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ExtentTestManager.logMessage(Status.INFO, "Test failed but it is in defined success ratio " + result.getMethod().getMethodName());        
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("---------Start testing " + context.getName() + " ---------");        
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("---------End testing " + context.getName() + " ---------");
        ExtentManager.getInstance().flush();        
    }
    
}
