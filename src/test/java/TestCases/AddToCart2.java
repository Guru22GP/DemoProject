package TestCases;

import Base.BaseClassAddToCart;
import GenericUtility.ExcelUtility;
import ObjectRepository.CartPage;
import ObjectRepository.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCart2 extends BaseClassAddToCart {

    @Test(groups = "smoke")
    public void addToCart() throws IOException, Throwable {

        ExcelUtility eutil = new ExcelUtility();
        String prodname = eutil.toReadDataFromExcel("Products", 1, 2);


        //add product
        ProductPage pp = new ProductPage(driver);
        CartPage cp = new CartPage(driver);
        pp.getAddToCartButtonForProduct(prodname).click();
        pp.getCartIcon().click();

        //validation
        Assert.assertTrue(cp.isProductPresentInCart(prodname),prodname+" is not present in cart" );
        //Assert.assertTrue(cp.isProductPresentInCart(prodname), prodname + " is not present in cart");
//
//        if (cartItem.equals((prodname))) {
//            System.out.println("pass");
//        } else {
//            System.out.println("fail");
//        }
    }
}
