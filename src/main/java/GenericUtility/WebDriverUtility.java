package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverUtility {
    public void waitForPageLoad(WebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void waitForVisibilityOfElement(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void switchToFrame(WebDriver driver, int index)
    {
        driver.switchTo().frame(index);
    }

    public void switchToFrame(WebDriver driver , String nameOrID)
    {
        driver.switchTo().frame(nameOrID);
    }

    public void switchToFrame(WebDriver driver , WebElement element)
    {
        driver.switchTo().frame(element);
    }

    public void switchToAlertAndAccept(WebDriver driver)
    {
        driver.switchTo().alert().accept();
    }

    public void switchToAlertAndDismiss(WebDriver driver)
    {
        driver.switchTo().alert().dismiss();
    }

    public String switchToAlertAndText(WebDriver driver)
    {
        String text1 = driver.switchTo().alert().getText();
        return text1;
    }

    public void switchToAlertAndSendKeys(WebDriver driver , String text)
    {
        driver.switchTo().alert().sendKeys(text);
    }

    public void selectByIndex(WebElement element , int index)
    {
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }
    public void selectByValue(WebElement element , String value)
    {
        Select sel = new Select(element);
        sel.selectByValue(value);
    }
    public void selectByVisibleText(WebElement element , String visibleText)
    {
        Select sel = new Select(element);
        sel.selectByVisibleText(visibleText);
    }

    public void mouseHoverOnWebElement(WebDriver driver, WebElement element)
    {
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    public void doubleClick(WebDriver driver, WebElement element)
    {
        Actions act = new Actions(driver);
        act.doubleClick(element).perform();
    }
}
