package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SauceDemohardCodeFlow {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement sortby = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(sortby);

        select.selectByVisibleText("Name (Z to A)");

        WebElement item1 = driver.findElement(By.xpath("//div[@class = 'inventory_item_description']/div/button[@id='add-to-cart-sauce-labs-onesie']"));
        item1.click();

        WebElement item2=driver.findElement(By.xpath("//div[@class = 'inventory_item_description']/div/button[@id='add-to-cart-sauce-labs-bike-light']"));
        item2.click();

        WebElement addToCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        addToCart.click();

        WebElement removeItem1 = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bike-light']"));
        removeItem1.click();

        //WebElement checkout = driver.findElement(By.xpath("//button[@id = 'checkout']"));
        //checkout.click();

        WebElement continueShopping = driver.findElement(By.xpath("//button[@id = 'continue-shopping']"));
        continueShopping.click();

        WebElement hamberger = driver.findElement(By.xpath("//button[@id = 'react-burger-menu-btn']"));
        hamberger.click();

        WebElement logout = driver.findElement(By.xpath("//a[@id ='logout_sidebar_link']"));
        logout.click();

        Thread.sleep(3000);

        driver.close();

    }
}
