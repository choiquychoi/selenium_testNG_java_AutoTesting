package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Authentication_Alert {
    WebDriver driver;
    String username = "admin";
    String password = "admin";

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Authentication(){
        // http// https:// + username + : + password + @ URL
        driver.get("https://"+ username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(), "Congratulations! You must have the proper credentials.");

    }

    @Test
    public void TC_02(){
        driver.get("http://the-internet.herokuapp.com/");

        String basicAuthLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");

        driver.get(getAuthenticationURL(basicAuthLink,username,password));

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example>p")).getText(), "Congratulations! You must have the proper credentials.");

    }

    public String getAuthenticationURL(String Link, String Username, String Password) {
        String [] linkAway = Link.split("//");
        String newLInk = linkAway[0] + "//" + Username + ":" + Password + "@" +linkAway[1] ;
        return newLInk;
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}