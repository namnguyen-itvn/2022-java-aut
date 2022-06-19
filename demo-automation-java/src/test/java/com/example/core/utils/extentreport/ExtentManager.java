package com.example.core.utils.extentreport;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;
    private static String reportFileName = "Test-Automation-Report" + ".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilePath = System.getProperty("user.dir") + fileSeperator + "src/test/java/com/example/core/reports";
    private static String reportFileLocation = reportFilePath + fileSeperator + reportFileName;

    public static ExtentReports getInstance(){
        if (extent == null){
            createInstance();
        }
        return extent;
    }

    //Create an extent report instance
    public static ExtentReports createInstance(){

        String fileName = getReportPath(reportFilePath);       
        ExtentSparkReporter reporter = new ExtentSparkReporter(fileName);
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle(reportFileName);
        reporter.config().setEncoding("utf-8");
        reporter.config().setReportName(reportFileName);
        reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
 
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("OS",  System.getProperty("os.name"));
        extent.setSystemInfo("Java",  System.getProperty("java.specification.version"));
        extent.setSystemInfo("User",  System.getProperty("user.name"));
		extent.setSystemInfo("Framework Name", "Selenium Java Framework");
		extent.setSystemInfo("Author", "AUT-01");
 
        return extent;
    }

    //Create the report path
    private static String getReportPath(String path) {
        
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
        	if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
		return reportFileLocation;
    }

}
