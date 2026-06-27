package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ThreadPoolSize {

    @Test (invocationCount = 4, threadPoolSize = 2)
    public void LaunchBrowser() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        Thread.sleep(2000);

        driver.quit();
    }
}
