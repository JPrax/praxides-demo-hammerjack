package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public WebElement userName(){
        return find(By.xpath("//input[@placeholder='Username']"));
    }

    public WebElement password(){
        return find(By.xpath("//input[@placeholder='Password']"));
    }

    public WebElement loginButton(){
        return find(By.xpath("//input[@type='submit'][@value='Login']"));
    }

    public ProductsPage loginToApplication(String user, String password){
        userName().sendKeys(user);
        password().sendKeys(password);
        loginButton().click();
        return new ProductsPage();
    }

}
