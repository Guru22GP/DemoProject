package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class InvoCount {

    @Test (invocationCount = 4)
            public void Login() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        Thread.sleep(2000);

        driver.get("https://www.amazon.com/");


        driver.quit();

    }


}
