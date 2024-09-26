package Litener;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import qa.utils.ExtentReporter;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private ExtentReports extentReport;
    private ExtentTest extentTest;
    private WebDriver driver; // Declare the WebDriver instance

    // Setter method for WebDriver
    public void setDriver(WebDriver driver) {
        this.driver = driver; // Set the WebDriver instance
    }

    @Override
    public void onStart(ITestContext context) {
        extentReport = ExtentReporter.generateExtentReport(); // Initialize the report
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReport.createTest(result.getName());
        extentTest.log(Status.INFO, result.getName() + " started executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, result.getName() + " executed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Check if the driver is null
        if (driver == null) {
            System.err.println("WebDriver instance is null. Cannot capture screenshot.");
            return; // Exit if the driver is null
        }

        // Capture screenshot and log it to the report
        String destinationScreenshotPath = ScreenshotUtil.captureScreenshot(driver);
        
        if (destinationScreenshotPath != null) {
            extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
        }

        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.FAIL, result.getName() + " failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, result.getName() + " was skipped");
        extentTest.log(Status.INFO, result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush(); // Write all test results to the report

        // Open the report automatically after tests are finished
        String pathOfExtentReport = System.getProperty("user.dir") + "\\test-output\\extent-reports\\extentReport.html";
        File extentReportFile = new File(pathOfExtentReport);
        
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(extentReportFile.toURI());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
