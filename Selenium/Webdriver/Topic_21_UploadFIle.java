package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class Topic_21_UploadFIle {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir") + File.separator +"UploadFile" + File.separator ;
    String anime = "ANime.gif";
    String Dep = "Dep.jpg";
    String Darktheme = "DarkTheme.jpg";

    String animePath = projectPath + anime;
    String DepPath = projectPath + Dep;
    String DarkThemePath = projectPath + Darktheme;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Upload_Single_file() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By inputBy = By.xpath("//input[@type='file']");
// mỗi lần load 1 file
        driver.findElement(inputBy).sendKeys(animePath);
        Thread.sleep(2000);

        driver.findElement(inputBy).sendKeys(DarkThemePath);
        Thread.sleep(2000);

        driver.findElement(inputBy).sendKeys(DepPath);
        Thread.sleep(2000);

        // verify upload cho từng fiel
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ anime +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ Darktheme +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ Dep +"']")).isDisplayed());

        // click upload
        List<WebElement> StartButtons = driver.findElements(By.cssSelector(" table button.start"));

        for(WebElement StartButton: StartButtons) {
            StartButton.click();
            Thread.sleep(2000);
        }

        // verify đã upload xong

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ anime +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ Darktheme +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ Dep +"']")).isDisplayed());
    }

    @Test
    public void TC_02_Multiple_Single_file() throws InterruptedException {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");

        By inputBy = By.xpath("//input[@type='file']");

        // 1 lần load nhiều file
        driver.findElement(inputBy).sendKeys(animePath + "\n" + DarkThemePath + "\n" + DepPath);
        Thread.sleep(2000);

        // verify upload cho từng fiel
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ anime +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ Darktheme +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='"+ Dep +"']")).isDisplayed());

        // click upload
        List<WebElement> StartButtons = driver.findElements(By.cssSelector(" table button.start"));

        for(WebElement StartButton: StartButtons) {
            StartButton.click();
            Thread.sleep(2000);
        }

        // verify đã upload xong

        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ anime +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ Darktheme +"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ Dep +"']")).isDisplayed());

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}