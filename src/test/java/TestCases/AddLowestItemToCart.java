package TestCases;

import GenericUtility.ExcelUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CartPage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class AddLowestItemToCart {

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

        LoginPage lp = new LoginPage(driver);
        lp.getUn().sendKeys(USERNAME);
        lp.getPwd().sendKeys(PASSWORD);
        lp.getLoginButton().click();

        ProductPage pp = new ProductPage(driver);
        CartPage cp = new CartPage(driver);

        pp.getFilter().click();
//        Select select = new Select(pp.getFilter());
//        select.selectByVisibleText("Price (low to high)");

        wutil.selectByIndex(pp.getFilter(), 2);

        pp.getProdname1().getText();
        pp.getProdname1().click();
        pp.getAddToCartButton().click();

    }
}
