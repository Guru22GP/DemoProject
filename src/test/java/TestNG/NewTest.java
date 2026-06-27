package TestNG;

import org.testng.Reporter;
import org.testng.annotations.*;

public class NewTest {

    @BeforeSuite
    public void beforeSuite() {
        Reporter.log("DB Connection Open", true);
    }

    @BeforeTest
    public void beforeTest() {
        Reporter.log("Pre-Conditions Setup", true);
    }

    @BeforeClass
    public void beforeClass() {
        Reporter.log("Launch Browser", true);
    }

    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("Login to Application", true);
    }

    @Test
    public void testExecution() {
        Reporter.log("Execute Test Case", true);
    }

    @AfterMethod
    public void afterMethod() {
        Reporter.log("Logout from Application", true);
    }

    @AfterClass
    public void afterClass() {
        Reporter.log("Close Browser", true);
    }

    @AfterTest
    public void afterTest() {
        Reporter.log("Post-Conditions Cleanup", true);
    }

    @AfterSuite
    public void afterSuite() {
        Reporter.log("DB Connection Close", true);
    }
}