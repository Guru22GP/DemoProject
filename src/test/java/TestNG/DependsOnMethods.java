package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethods {

    @Test (invocationCount = 0)
    public void createAccount()
    {
        Reporter.log("Created Successfully", true);
    }

    @Test (dependsOnMethods = "createAccount")
    public void editAccount()
    {
        Reporter.log("Account edited", true);
    }

    @Test (dependsOnMethods = {"createAccount", "editAccount"})
    public void deleteAccount()
    {
        Reporter.log("Account deleted" , true);
    }
}
