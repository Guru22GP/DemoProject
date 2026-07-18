package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssert1 {

    @Test
    public void demo()
    {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        String expTitile="Facebook";

        driver.get("https://www.facebook.com/");
        String actTitle = driver.getTitle();

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(actTitle,expTitile);
        System.out.println("Step 1");
        System.out.println("Step 2");
        soft.assertAll();

        driver.quit();
    }

}
