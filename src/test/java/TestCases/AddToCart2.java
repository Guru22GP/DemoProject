package TestCases;

import GenericUtility.ExcelUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CartPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class AddToCart2 {
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
        LoginPage lp = new LoginPage(driver);
       lp.getUn().sendKeys(USERNAME);
        lp.getPwd().sendKeys(PASSWORD);
        //Thread.sleep(4000);
       lp.getLoginButton().click();

        String prodname = eutil.toReadDataFromExcel("Products", 1, 2);


        //add product
        ProductPage pp = new ProductPage(driver);
        CartPage cp = new CartPage(driver);
        pp.getProdname1().click();
        pp.getAddToCartButton().click();

       pp.getCartIcon().click();

        //validation
        String cartItem = cp.getInventItem().getText();

        if (cartItem.equals((prodname))) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }

        cp.getBurgerIcon().click();
        cp.getLogout().click();

        driver.close();

    }
}


