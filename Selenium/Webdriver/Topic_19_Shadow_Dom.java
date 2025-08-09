package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Shadow_Dom {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01(){

        driver.get("https://automationfc.github.io/shadow-dom/");

        // thuộc DOM bên ngoài
        driver.findElement(By.xpath("//a[text()='scroll.html']"));

        // Element cha chứa shadow Host thứ 1
        WebElement shadowHostParent = driver.findElement(By.cssSelector("div#shadow_host"));

        // lấy ra cái element shadow root
        SearchContext firstShadowRoot = shadowHostParent.getShadowRoot();

        firstShadowRoot.findElement(By.cssSelector("input[type='file']"));

        Assert.assertTrue(firstShadowRoot.findElement(By.cssSelector("input[type='file']")).isDisplayed());

        Assert.assertEquals(firstShadowRoot.findElement(By.cssSelector("span.info")).getText(),"some text");

        WebElement FirstshadowHostParent = firstShadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));

        // Element cha chứa shadow Host thứ 2
        SearchContext secondShadowRoot = FirstshadowHostParent.getShadowRoot();

        Assert.assertEquals(secondShadowRoot.findElement(By.cssSelector("div#nested_shadow_content>div")).getText(), "nested text");

    }

    @Test
    public void TC_02(){

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}