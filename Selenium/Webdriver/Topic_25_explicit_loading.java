package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_25_explicit_loading  {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_calendal(){
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        // wait and verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.
                textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"), "No Selected Dates to display.")));

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='9']"))).click();

        // wait ajax loading invisible
        Assert.assertTrue(explicitWait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.cssSelector("div[id$='RadCalendar1']>div.raDiv"))));

        // wait and verify text
        Assert.assertTrue(explicitWait.until(ExpectedConditions.
                textToBe(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1"), "Saturday, August 9, 2025")));
    }

    @Test
    public void TC_02_equal() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div.example button")).click();

        //Điều kiện wait
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish h4")));


        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")),"Hello World!");
    }

    @Test
    public void TC_03_greater_than() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div.example button")).click();

        //Điều kiện wait
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish h4")));

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")),"Hello World!");

    }

    @Test
    public void TC_04() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div.example button")).click();

        // visible (dành cho 1 element sau được xuất hiện)
        WebElement HelloText = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));
        Assert.assertEquals(HelloText.getText(),"Hello World!");

        // invisible (dành cho 1 element sắp biến mất đi)
        Boolean LoandingIconStatus = explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
        Assert.assertTrue(LoandingIconStatus);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(),"Hello World!");
        // text
        Boolean HelloTextStatus = explicitWait.until(ExpectedConditions.textToBe(By.cssSelector("div#finish>h4"),"Hello World!"));
        Assert.assertTrue(HelloTextStatus);
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}