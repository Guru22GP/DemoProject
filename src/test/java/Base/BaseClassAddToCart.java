package Base;


import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.LoginPage;
import ObjectRepository.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class BaseClassAddToCart {

        public WebDriver driver;
        public static WebDriver sdriver;

        PropertyFileUtility putil = new PropertyFileUtility();
        WebDriverUtility wutil = new WebDriverUtility();

        String BROWSER;
        String URL;
        String USERNAME;
        String PASSWORD;

        @BeforeSuite
        public void beforeSuite() {
            System.out.println("DB Connection Open");
        }

        @BeforeTest
        public void beforeTest() {
            System.out.println("Pre-condition execution");
        }

        @BeforeClass
        public void beforeClass() throws Throwable {

            BROWSER = putil.toReadDataFromPropFile("Browser");
            URL = putil.toReadDataFromPropFile("Url");
            USERNAME = putil.toReadDataFromPropFile("Username");
            PASSWORD = putil.toReadDataFromPropFile("Password");

            if (BROWSER.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
            } else if (BROWSER.equalsIgnoreCase("Chrome")) {
                driver = new ChromeDriver();
            } else if (BROWSER.equalsIgnoreCase("FireFox")) {
                driver = new FirefoxDriver();
            } else if (BROWSER.equalsIgnoreCase("Safari")) {
                driver = new SafariDriver();
            }

            sdriver = driver;

            driver.manage().window().maximize();
            wutil.waitForPageLoad(driver);
            driver.get(URL);
        }

        @BeforeMethod
        public void login() {
            LoginPage lp = new LoginPage(driver);
            lp.getUn().sendKeys(USERNAME);
            lp.getPwd().sendKeys(PASSWORD);
            lp.getLoginButton().click();
        }

        @AfterMethod
        public void logout() {
            CartPage cp = new CartPage(driver);
            cp.getBurgerIcon().click();
            cp.getLogout().click();
        }

        @AfterClass
        public void afterClass() {
            driver.quit();
        }

        @AfterTest
        public void afterTest() {
            System.out.println("Post-condition execution");
        }

        @AfterSuite
        public void afterSuite() {
            System.out.println("DB Connection Close");
        }
    }
