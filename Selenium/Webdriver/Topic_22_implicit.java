package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_22_implicit {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://automationfc.github.io/dynamic-loading/");
    }

    @Test
    public void TC_01_dont_set(){
        driver.findElement(By.cssSelector("div.example button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")),"Hello World!");

    }

    @Test
    public void TC_02_less_than(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.cssSelector("div.example button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")),"Hello World!");
    }

    @Test
    public void TC_03_equal() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("div.example button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")),"Hello World!");
    }

    @Test
    public void TC_04_greater_than() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.cssSelector("div.example button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")),"Hello World!");

    }

        @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}
