package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductsPage extends BasePage{

    private By shoppingCartItems = By.xpath("//*[@class='shopping_cart_link']/*[@class='shopping_cart_badge']");
    private By itemName = By.cssSelector("*.inventory_item_name");
    private By itemDescription = By.cssSelector("*.inventory_item_desc");
    private By itemImage = By.cssSelector("*.inventory_item_img");
    private By itemPrice = By.cssSelector("*.inventory_item_price");
    private By addToCartButton = By.xpath("//*[text()='Add to cart']");


    public WebElement productsLabel() {
        return find(By.xpath("//*[@class='title']"));
    }

    public List<WebElement> itemList(){
       return driver.findElements(By.xpath("//*[@class='inventory_list']/*[@class='inventory_item']"));
    }

    public String getInventoryName(int index){
        return itemList().get(index).findElement(By.cssSelector("*.inventory_item_name")).getText();
    }

    public Boolean verifyItemListDetailsComplete(){
        Boolean result = true;
        for(WebElement e: itemList()){
            result = e.findElement(itemName).isDisplayed();
            result = e.findElement(itemDescription).isDisplayed();
            result = e.findElement(itemImage).isDisplayed();
            result = e.findElement(itemPrice).isDisplayed();
            result = e.findElement(addToCartButton).isDisplayed();
        }
        return result;
    }

    public String getNumberOfItemsInCart(){
        String numberOfItems = "0";
        try {
            numberOfItems = find(shoppingCartItems).getText();
        } catch (Exception e) {
            //do nothing
        }
        return numberOfItems;
    }

    public void addItemToCart(String item){
        for(WebElement e: itemList()){
            if(e.findElement(itemName).getText().equals(item)){
                e.findElement(addToCartButton).click();
                break;
            }
        }
    }

}
