package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_29_PageReady {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Element_found(){
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("admin");

        driver.findElement(By.cssSelector("button.login-button")).click();

        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy"))));

        driver.findElement(By.xpath("//a[text()=''logout]")).click();
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}
