package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoTestNG {
    @Test
    public void add()
    {
        Reporter.log("add", true);
    }

    @Test
    public void sub()
    {
        Reporter.log("subtract", true);
    }

    @Test
    public void mul()
    {
        Reporter.log("multiplication", true);
    }
}
