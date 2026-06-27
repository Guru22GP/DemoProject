package TestCases;

import GenericUtility.ExcelUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

public class AddToCart {
    public static void main(String[] args) throws Throwable {

        PropertyFileUtility putil = new PropertyFileUtility();
        ExcelUtility eutil = new ExcelUtility();
        WebDriverUtility wutil = new WebDriverUtility();

        String BROWSER = putil.toReadDataFromPropFile("Browser");
        String URL = putil.toReadDataFromPropFile("Url");
        String USERNAME = putil.toReadDataFromPropFile("Username");
        String PASSWORD = putil.toReadDataFromPropFile("Password");

        WebDriver driver = null;

        if (BROWSER.equals("Edge")) {
            driver = new EdgeDriver();
        } else if (BROWSER.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (BROWSER.equals("FireFox")) {
            driver = new FirefoxDriver();
        } else if (BROWSER.equals("Safari")) {
            driver = new SafariDriver();
        }

        driver.manage().window().maximize();
        wutil.waitForPageLoad(driver);
        driver.get(URL);

        //login
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(USERNAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        //Thread.sleep(4000);
        driver.findElement(By.id("login-button")).click();

        String prodname = eutil.toReadDataFromExcel("Products", 1, 2);


        //add product
        driver.findElement(By.xpath("//div[text()='" + prodname + "']")).click();
        driver.findElement(By.id("add-to-cart")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        //validation
        String cartItem = driver.findElement(By.className("inventory_item_name")).getText();

        if (cartItem.equals((prodname))) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        driver.close();

    }
}
