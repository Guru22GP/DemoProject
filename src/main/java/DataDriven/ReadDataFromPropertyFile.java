package DataDriven;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class ReadDataFromPropertyFile {
    public static void main(String[] args) throws Throwable {

        FileInputStream fis = new FileInputStream("src/main/resources/CommonData.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String BROWSER = prop.getProperty("Browser");
        String URL = prop.getProperty("Url");
        String USERNAME = prop.getProperty("Username");
        String PASSWORD = prop.getProperty("Password");

        System.out.println(BROWSER);
        System.out.println(URL);
        System.out.println(USERNAME);
        System.out.println(PASSWORD);

        WebDriver driver = null;

        if(BROWSER.equals("Edge"))
        {
            driver = new EdgeDriver();
        }
        else if (BROWSER.equals("Chrome"))
        {
            driver = new ChromeDriver();
        }
        else if (BROWSER.equals("FireFox"))
        {
            driver = new FirefoxDriver();
        }else if (BROWSER.equals("Safari"))
        {
            driver = new SafariDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(URL);

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(USERNAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        //Thread.sleep(4000);
        driver.findElement(By.id("login-button")).click();

        FileInputStream fis1 = new FileInputStream("./src/main/resources/TestData21.xlsx");
        Workbook wb = WorkbookFactory.create(fis1);

        Sheet data = wb.getSheet("Products");
        Row row = data.getRow(1);
        String productName = row.getCell(2).getStringCellValue();
        System.out.println(productName);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='" + productName + "']")));

        WebElement element = driver.findElement(By.xpath("//div[text()='" + productName + "']"));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();


        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.className("inventory_item_name")).getText();


        driver.close();

    }
}
