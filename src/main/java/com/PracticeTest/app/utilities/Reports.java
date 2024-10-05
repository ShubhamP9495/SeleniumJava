package com.PracticeTest.app.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Reporter;

public class Reports {

    protected static ExtentHtmlReporter extentHtmlReporter;

    protected static ExtentReports extentReports;

    protected static ExtentTest extentTest;

    public static void setupReports(String ReportName, String className)
    {
        System.out.println(ReportName);
        extentHtmlReporter = new ExtentHtmlReporter("./Reports/"+ReportName+".html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
        extentTest = extentReports.createTest(className);
        Reporter.log(className, true);
        System.out.println(className);
    }

    public static void flushReports()
    {
        extentReports.flush();
    }

    public static void logResult(Status Status, String Result)
    {
        extentTest.log(Status, Result);
    }

    public static void logThrowable(Status Status, Throwable Throw)
    {
        extentTest.log(Status, Throw);
    }
}
