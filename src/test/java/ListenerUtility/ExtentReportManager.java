package ListenerUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static String reportDirectory;
    private static String reportPath;

    private ExtentReportManager() {
    }

    public static synchronized ExtentReports getExtentReports() {
        if (extentReports == null) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            reportDirectory = System.getProperty("user.dir") + File.separator + "ExtentReports";
            reportPath = reportDirectory + File.separator + "SauceDemoReport_" + timestamp + ".html";

            File directory = new File(reportDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("SauceDemo Automation Report");
            sparkReporter.config().setReportName("SauceDemo Test Execution");
            sparkReporter.config().setTheme(Theme.DARK);

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
            extentReports.setSystemInfo("Project", "SauceDemoProject");
            extentReports.setSystemInfo("Tester", System.getProperty("user.name"));
            extentReports.setSystemInfo("OS", System.getProperty("os.name"));
            extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        }

        return extentReports;
    }

    public static String getReportDirectory() {
        getExtentReports();
        return reportDirectory;
    }

    public static String getReportPath() {
        getExtentReports();
        return reportPath;
    }
}
