package TestNG;

import org.testng.annotations.Test;

public class DataProvider {

    @Test (dataProvider = "details")
    public void login(String un, String pwd)
    {
        System.out.println(un + "-----"+ pwd);
    }

    @org.testng.annotations.DataProvider
    public Object[][] details(){
        Object obj[][] = new Object[2][2];
        obj[0][0] = "Dhoni";
        obj[0][1] = "Dhoni007";
        obj[1][0]= "Virat";
        obj[1][1] = "Virat18";

        return obj;
    }
}
