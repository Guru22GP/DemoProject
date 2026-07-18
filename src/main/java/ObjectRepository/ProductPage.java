package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

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

    @FindBy(css = ".inventory_item:first-child .inventory_item_name")
    private WebElement firstProductName;

    @FindBy(css = ".inventory_item:first-child button")
    private WebElement firstAddToCartButton;

    public ProductPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

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

    public WebElement getFirstProductName() {
        return firstProductName;
    }

    public WebElement getFirstAddToCartButton() {
        return firstAddToCartButton;
    }

    public WebElement getProductName(String productName) {
        return driver.findElement(By.xpath("//div[contains(@class,'inventory_item_name') and normalize-space()='" + productName + "']"));
    }

    public WebElement getAddToCartButtonForProduct(String productName) {
        return driver.findElement(By.xpath("//div[contains(@class,'inventory_item')][.//div[contains(@class,'inventory_item_name') and normalize-space()='" + productName + "']]//button"));
    }
}
