package com.saucedemo.test.scripts;

import com.saucedemo.pages.ProductsPage;
import com.saucedemo.test.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginVerifyProductsListAddToCart extends BaseTest {

    private ProductsPage productsPage = new ProductsPage();

    @Test
    public void loginVerifyProductsListDisplayed(){
        //login to application
        loginPage.loginToApplication("standard_user","secret_sauce");
        //verify that landing page is Products
        Assert.assertEquals(productsPage.productsLabel().getText(),"Products");
    }

    @Test
    public void verifyItemDetailsDisplayed(){
        //verify list of available products with their names, descriptions, images, and prices.
        Assert.assertTrue(productsPage.verifyItemListDetailsComplete(),"An item displayed is missing either a name, description, image, or price");
   }

   @Test
    public void verifyCartIsEmpty(){
        //Verify Cart has no items in initial page
        Assert.assertEquals(productsPage.getNumberOfItemsInCart(),"0");
   }

   @Test
    public void addAnItemToCartVerifyCounter(){
        //Add item to cart
       productsPage.addItemToCart("Sauce Labs Fleece Jacket");
       //Verify Cart item count is updated
       Assert.assertEquals(productsPage.getNumberOfItemsInCart(),"1");
       //Add item to cart
       productsPage.addItemToCart("Sauce Labs Backpack");
      //Verify Cart item count is updated
       Assert.assertEquals(productsPage.getNumberOfItemsInCart(),"2");
  }




}
