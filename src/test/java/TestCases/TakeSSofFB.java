package TestCases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeSSofFB {

    public static void main(String[] args) throws IOException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());


        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("./Screenshots/FB_"+timestamp+".jpg");
        FileHandler.copy(src,dest);
        System.out.println("Screenshot taken: FB_" + timestamp + ".jpg");
        driver.quit();

    }
}
