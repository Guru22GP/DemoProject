package Base;

import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CartPage;
import ObjectRepository.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class BaseClassAddToCart {

    protected WebDriver driver;
    public static WebDriver sdriver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    PropertyFileUtility putil = new PropertyFileUtility();
    WebDriverUtility wutil = new WebDriverUtility();

    String URL;
    String USERNAME;
    String PASSWORD;

    @BeforeSuite(groups = {"smoke", "regression"})
    public void beforeSuite()
    {
        System.out.println("DB Connection Open");
    }

    @BeforeTest(groups = {"smoke", "regression"})
    public void beforeTest()
    {
        System.out.println("Pre-condition execution");
    }

    @Parameters("BROWSER")
    @BeforeClass(groups = {"smoke", "regression"})
    public void beforeClass(@Optional("") String BROWSER) throws Throwable {

        URL = putil.toReadDataFromPropFile("Url");
        USERNAME = putil.toReadDataFromPropFile("Username");
        PASSWORD = putil.toReadDataFromPropFile("Password");

        String browserName = System.getProperty("Browser");
        if (browserName == null || browserName.trim().isEmpty()) {
            browserName = BROWSER;
        }
        if (browserName == null || browserName.trim().isEmpty()) {
            browserName = putil.toReadDataFromPropFile("Browser");
        }

        if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("FireFox") || browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            throw new RuntimeException("Invalid browser name: " + browserName);
        }

        tdriver.set(driver);
        sdriver = driver;

        driver.manage().window().maximize();
        wutil.waitForPageLoad(driver);
        driver.get(URL);
    }

    @BeforeMethod(groups = {"smoke", "regression"})
    public void login() {
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear(); window.sessionStorage.clear();");
        driver.navigate().refresh();

        LoginPage lp = new LoginPage(driver);
        lp.getUn().sendKeys(USERNAME);
        lp.getPwd().sendKeys(PASSWORD);
        lp.getLoginButton().click();
    }

    @AfterMethod(groups = {"smoke", "regression"})
    public void logout() {
        try {
            CartPage cp = new CartPage(driver);
            cp.getBurgerIcon().click();
            wutil.waitForVisibilityOfElement(driver, cp.getLogout());
            cp.getLogout().click();
        } catch (Exception e) {
            driver.manage().deleteAllCookies();
            driver.get(URL);
        }
    }

    @AfterClass(groups = {"smoke", "regression"})
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
        tdriver.remove();
    }

    @AfterTest(groups = {"smoke", "regression"})
    public void afterTest() {
        System.out.println("Post-condition execution");
    }

    @AfterSuite(groups = {"smoke", "regression"})
    public void afterSuite() {
        System.out.println("DB Connection Close");
    }

    public static WebDriver getDriver() {
        WebDriver webDriver = tdriver.get();
        return webDriver != null ? webDriver : sdriver;
    }
}
