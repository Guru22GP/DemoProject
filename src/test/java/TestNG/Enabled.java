package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled {

    @Test (enabled = false)
    public void add()
    {
        Reporter.log("add",true);
    }

    @Test (priority = 2)
    public void sub()
    {
        Reporter.log("subtract", true);
    }

    @Test (priority = 0)
    public void mul(){
        Reporter.log("multiply", true);
    }
}
