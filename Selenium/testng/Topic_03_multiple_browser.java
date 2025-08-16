package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_03_multiple_browser {
    WebDriver driver;
    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");
    String userName = "selenium_11_01@gmail.com";
    String password = "111111";

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browserName) {
//        if (browserName.equalsIgnoreCase("Chrome")) {
//            driver = new ChromeDriver();
//        } else if (browserName.equalsIgnoreCase("Edge")) {
//            driver = new EdgeDriver();
//        } else if (browserName.equalsIgnoreCase("Firefox")) {
//            driver = new FirefoxDriver();
//        } else {
//            throw new RuntimeException("Browser name is not valid!!!");
//        }

        // Switch case
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Edge" :
                driver = new EdgeDriver();
                break;
            case "FireFox":
                driver = new FirefoxDriver();
                break;
            default:
                new RuntimeException("Browser name is not valid ");
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void LoginOnMultipleBrowser() {
        // ...
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
