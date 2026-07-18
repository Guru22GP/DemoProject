package ListenerUtility;

import Base.BaseClassAddToCart;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenerImplementation implements ITestListener {

    private static ExtentReports extentReports;
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        extentReports = ExtentReportManager.getExtentReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getTestClass().getName());
        extentTest.set(test);
        Reporter.log("=== " + result.getMethod().getMethodName() + " STARTED ===", true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = extentTest.get();
        String testName = result.getMethod().getMethodName();

        if (test != null) {
            test.log(Status.FAIL, testName + " failed");
            if (result.getThrowable() != null) {
                test.fail(result.getThrowable());
            }
        }

        WebDriver driver = BaseClassAddToCart.getDriver();
        if (driver == null) {
            Reporter.log("Screenshot skipped because WebDriver was not available.", true);
            if (test != null) {
                test.warning("Screenshot skipped because WebDriver was not available.");
            }
            return;
        }

        try {
            String screenshotPath = captureScreenshot(driver, testName);
            Reporter.log("Screenshot saved: " + screenshotPath, true);

            if (test != null) {
                test.addScreenCaptureFromPath(screenshotPath);
            }
        } catch (IOException | WebDriverException e) {
            Reporter.log("Screenshot capture failed: " + e.getMessage(), true);
            if (test != null) {
                test.warning("Screenshot capture failed: " + e.getMessage());
            }
        }

        Reporter.log("=== " + testName + " FAILED ===", true);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = extentTest.get();
        if (test != null) {
            test.log(Status.PASS, result.getMethod().getMethodName() + " passed");
        }
        Reporter.log("=== " + result.getMethod().getMethodName() + " PASSED ===", true);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = extentTest.get();
        if (test != null) {
            test.log(Status.SKIP, result.getMethod().getMethodName() + " skipped");
            if (result.getThrowable() != null) {
                test.skip(result.getThrowable());
            }
        }
        Reporter.log("=== " + result.getMethod().getMethodName() + " SKIPPED ===", true);
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
            Reporter.log("Extent report generated: " + ExtentReportManager.getReportPath(), true);
        }
        extentTest.remove();
    }

    private String captureScreenshot(WebDriver driver, String testName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotDirectory = ExtentReportManager.getReportDirectory() + File.separator + "screenshots";
        File directory = new File(screenshotDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String safeTestName = testName.replaceAll("[^a-zA-Z0-9._-]", "_");
        String screenshotName = safeTestName + "_" + timeStamp + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(directory, screenshotName);
        FileHandler.copy(src, dest);

        return "screenshots" + File.separator + screenshotName;
    }
}
