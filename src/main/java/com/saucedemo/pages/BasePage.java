package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePage {
  public static WebDriver driver;
  public static JavascriptExecutor js;


  public void setDriver(WebDriver driver){
      BasePage.driver = driver;
      BasePage.js = (JavascriptExecutor) driver;
  }

  protected WebElement find(By locator){
      WebElement webElement = driver.findElement(locator);
      js.executeScript("arguments[0].scrollIntoView(true);",webElement);
      return webElement;
  }



}
