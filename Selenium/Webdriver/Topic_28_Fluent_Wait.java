package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

public class Topic_28_Fluent_Wait {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
    }

    @Test
    public void TC_01_Element_found(){

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

    public WebElement findElement (long timeout, long polling, By by) {
        FluentWait<WebDriver> driverFluentWait = new FluentWait<>(driver);

        driverFluentWait.withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        return driverFluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }
}