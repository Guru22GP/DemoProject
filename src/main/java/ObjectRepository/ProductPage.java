package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public ProductPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']")
   private WebElement prodname1;

    @FindBy(xpath = "//div[text()='Sauce Labs Onesie']")
    private WebElement prodname2;

    @FindBy(xpath = "//button[text()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement filter;

    public WebElement getProdname1() {
        return prodname1;
    }

    public WebElement getProdname2() {
        return prodname2;
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getCartIcon() {
        return cartIcon;
    }

    public WebElement getFilter() {
        return filter;
    }
}
