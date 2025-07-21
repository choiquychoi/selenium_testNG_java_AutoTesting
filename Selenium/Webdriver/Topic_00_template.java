package Webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_template {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();

        driver.get("https://demo.nopcommerce.com");
    }

    @Test
    public void TC_01(){

    }

    @Test
    public void TC_02(){

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}