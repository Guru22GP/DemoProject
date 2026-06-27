package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerIcon;

    @FindBy (linkText = "Logout")
    private WebElement logout;

    @FindBy (id = "checkout")
    private WebElement checkout;

    @FindBy(id="continue-shopping")
    private WebElement continueBtn;

    @FindBy(className = "inventory_item_name")
    private WebElement inventItem;

    public WebElement getContinueBtn() {
        return continueBtn;
    }

    public WebElement getInventItem() {
        return inventItem;
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
