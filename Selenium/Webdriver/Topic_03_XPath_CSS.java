    package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_XPath_CSS {
    // 1- SetUp: OS/browser/ web/ Page/ Data
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();

        driver.get("https://live.techpanda.org");
    }

    // 2- Action/ Execute: web Element/ nhập liệu /verify/...
    @Test
    public void TC_01(){
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
    }

    @Test
    public void TC_02(){

    }

    // 3- clean: Delete data/ close browser
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}