package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class OrderOfExecution {

    @Test
    public void apple()
    {
        Reporter.log("apple");
        System.out.println("apple");
    }
    @Test
    public void Banana()
    {
        Reporter.log("Banana");
        System.out.println("Banana");

    }
    @Test
    public void kiwi()
    {
        Reporter.log("kiwi");
        System.out.println("kiwi");

    }
    @Test
    public void Grapes()
    {
        Reporter.log("Grapes");
        System.out.println("Grapes");
    }

}
