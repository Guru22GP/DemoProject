package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerIcon;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;

    @FindBy (id = "checkout")
    private WebElement checkout;

    @FindBy(id="continue-shopping")
    private WebElement continueBtn;

    @FindBy(className = "inventory_item_name")
    private WebElement inventItem;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getContinueBtn() {
        return continueBtn;
    }

    public WebElement getInventItem() {
        return inventItem;
    }

    public boolean isProductPresentInCart(String productName) {
        List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'inventory_item_name') and normalize-space()='" + productName + "']"));
        return !products.isEmpty();
    }

    public WebElement getBurgerIcon() {
        return burgerIcon;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getCheckout() {
        return checkout;
    }
}
