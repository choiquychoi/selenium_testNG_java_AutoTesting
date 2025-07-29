package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class Topic_09_Button {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();

    }

    @Test
    public void TC_01(){
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        By loginButton = By.cssSelector("button.fhs-btn-login");

        // mong đợi nó là disable
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());

        String LoginBGColor = driver.findElement(loginButton).getCssValue("background-color");
        System.out.println(LoginBGColor);
        Color loginColor = Color.fromString(LoginBGColor);
        Assert.assertEquals(loginColor.asHex().toUpperCase(), "#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("0987746291");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("draca123as");

        // mong đợi nó là enable
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());

        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color"))   .asHex().toUpperCase(), "#C92127");
    }

    @Test
    public void TC_02(){

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}