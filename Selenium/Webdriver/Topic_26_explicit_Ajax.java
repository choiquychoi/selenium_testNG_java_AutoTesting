package Webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_26_explicit_Ajax {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
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