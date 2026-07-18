package TestCases;

import Base.BaseClassAddToCart;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CartPage;
import ObjectRepository.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddLowestItemToCart2 extends BaseClassAddToCart {

    @Test(groups = "regression")
    public void addLowestPriceItemTest() {

        // Create object instances
        ProductPage pp = new ProductPage(driver);
        CartPage cp = new CartPage(driver);
        WebDriverUtility wutil = new WebDriverUtility();

        // Sort by lowest price
        wutil.selectByVisibleText(pp.getFilter(), "Price (low to high)");

        // Capture lowest price product name
        String expectedProduct = pp.getFirstProductName().getText();

        // Add to cart
        pp.getFirstAddToCartButton().click();
        pp.getCartIcon().click();

        // Validation
        String actualProduct = cp.getInventItem().getText();

        Assert.assertEquals(
                actualProduct,
                expectedProduct,
                "Product mismatch in cart"
        );
    }
}
