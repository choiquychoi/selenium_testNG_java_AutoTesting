package Webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_template {
    // 1- SetUp: OS/browser/ web/ Page/ Data
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();

        driver.get("https://demo.nopcommerce.com");
    }

    // 2- Action/ Execute: web Element/ nhập liệu /verify/...
    @Test
    public void TC_01_Register(){

    }

    @Test
    public void TC_02_Login(){

    }

    // 3- clean: Delete data/ close browser
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}