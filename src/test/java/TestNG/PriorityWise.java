package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityWise {

     @Test (priority = -1)
        public void add()
        {
            Reporter.log("add", true);
        }

        @Test (priority = 2)
        public void sub()
        {
            Reporter.log("subtract", true);
        }

        @Test (priority = 1)
        public void mul()
        {
            Reporter.log("multiplication", true);
        }
    }


