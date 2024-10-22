package com.saucedemo.test.base;

import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;


public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    private String url = "https://www.saucedemo.com/";
    private String browser = "chrome";

    @BeforeClass
    public void setUp(){
        switch (browser){
            case("edge"):
                driver = new EdgeDriver();
                break;
            case("firefox"):
                driver = new FirefoxDriver();
                break;
            case("safari"):
                driver = new SafariDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
    }


    @AfterClass
    public void tearDown(){
       // driver.quit();
    }


}
