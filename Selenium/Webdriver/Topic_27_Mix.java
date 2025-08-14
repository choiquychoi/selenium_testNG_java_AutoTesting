package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_27_Mix {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01_Element_found(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        // wait  and explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

        // wait vs implicit
        driver.findElement(By.cssSelector("input#email"));
    }

    @Test
    public void TC_03_Element_Not_Found_Only_Explicit_By() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        By emailtextBoxBy = By.cssSelector("input#automationfc");

        // Wait vs Explicit
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(emailtextBoxBy));
    }

    @Test
    public void TC_03_Element_Not_Found_Only_Explicit_WebElement() {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.get("http://live.techpanda.org/index.php/customer/account/login/");

        // Implicit = 0
        // Explicit = 3
        System.out.println("Start = " + getDateTimeNow());
        WebElement emailTextbox = driver.findElement(By.cssSelector("input#automationfc"));
        try {
            explicitWait.until(ExpectedConditions.visibilityOf(
                    driver.findElement(By.cssSelector("input#automationfc"))
            ));
        } catch (Exception e) {
            System.out.println("End = " + getDateTimeNow());
            throw new RuntimeException(e);
        }
    }

    public String getDateTimeNow() {
        Date date = new Date();
        return date.toString();
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}