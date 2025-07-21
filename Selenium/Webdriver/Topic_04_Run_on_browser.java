package Webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Run_on_browser {
    // 1- SetUp: OS/browser/ web/ Page/ Data
    WebDriver driver;

    @Test
    public void TC_01_Run_on_fireFox(){
        driver = new FirefoxDriver();

        driver.get("https://demo.nopcommerce.com/register");

        driver.quit();
    }

    @Test
    public void TC_02_Login(){

    }

}