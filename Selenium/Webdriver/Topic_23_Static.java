package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_23_Static {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://automationfc.github.io/dynamic-loading/");
    }

    @Test
    public void TC_01_less_than() throws InterruptedException {
        driver.findElement(By.cssSelector("div.example button")).click();

        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")), "Hello World!");
    }

    @Test
    public void TC_02_equal() throws InterruptedException {
        driver.findElement(By.cssSelector("div.example button")).click();

        Thread.sleep(5000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")), "Hello World!");
    }

    @Test
    public void TC_03_greater_than() throws InterruptedException {
        driver.findElement(By.cssSelector("div.example button")).click();

        Thread.sleep(10000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")), "Hello World!");

    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}