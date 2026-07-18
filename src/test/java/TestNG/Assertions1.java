package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions1 {

    @Test
    public void login()
    {
        String expTitle = "Facebook";

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");

        String actTitle = driver.getTitle();

        Assert.assertEquals(actTitle, expTitle);
        System.out.println("Hi");

        driver.quit();

    }
}
