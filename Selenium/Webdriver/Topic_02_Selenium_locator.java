package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_locator {
    // 1- SetUp: OS/browser/ web/ Page/ Data
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();

        driver.get("https://demo.nopcommerce.com/register");
        // đến nới màn mình Login
    }

    // 2- Action/ Execute: web Element/ nhập liệu /verify/...
    @Test
    public void TC_01_Id(){
        // tương tác lên email address textBox
        driver.findElement(By.id("small-searchterms")).sendKeys("niga");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}

        driver.findElement(By.id("FirstName")).sendKeys("admin1");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}

    }

    @Test
    public void TC_02_Class() throws InterruptedException {
        // tương tác lên email address textBox
        driver.findElement(By.className("register-next-step-button")).click();

        Thread.sleep(3000);
    }

    @Test
    public void TC_03_Name(){
        // tương tác lên email address textBox
        driver.findElement(By.name("DateOfBirthDay"));
        driver.findElement(By.name("DateOfBirthMonth"));
        driver.findElement(By.name("DateOfBirthYear"));
    }

    @Test
    public void TC_04_LinkText(){
        // chỉ làm việc với element có link và có text
        // thẻ <a> và các thuộc tính href
        // phải lấy hết toàn bôj text ko chừa cái nào hết

        driver.findElement(By.linkText("Register"));

        driver.findElement(By.linkText("Log in"));
    }

    @Test
    public void TC_05_Partial_link_Text(){
        // chỉ làm việc với element có link và có text
        // có thể lấy toàn bô text hoặc 1 phần (hay dùng)

        driver.findElement(By.partialLinkText("Digital"));
        driver.findElement(By.partialLinkText("downloads"));
    }

    @Test
    public void TC_06_TagName(){
        // tên thẻ (HTML)
        // tìm tất cả các element giống nhau
        driver.findElements(By.tagName("button"));

        driver.findElements(By.tagName("text"));

        driver.findElements(By.tagName("label"));

    }

    @Test
    public void TC_07_CSS(){
        // tương tác lên email address textBox
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("#Company"));
        driver.findElement(By.cssSelector("input[id='Company']"));

        driver.findElement(By.cssSelector("button.register-next-step-button"));
        driver.findElement(By.cssSelector("button[class='button-1 register-next-step-button']"));

        driver.findElement(By.cssSelector("input[name='Password']"));

        driver.findElement(By.cssSelector("a[href*='register']"));
        driver.findElement(By.cssSelector("a[href='/login?returnUrl=%2Fregister\']"));

        driver.findElement(By.cssSelector("a"));
        driver.findElement(By.cssSelector("input"));
        driver.findElement(By.cssSelector("button"));
    }

    @Test
    public void TC_08_XPath(){
        // id
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        driver.findElement(By.xpath("//input[@id='FirstName']"));
        driver.findElement(By.xpath("//input[@id='Company']"));

        // class
        driver.findElement(By.xpath("//button[@class='button-1 register-next-step-button']"));

        // name
        driver.findElement(By.xpath("//input[@name='Password']"));

        // linkText
        driver.findElement(By.xpath("//a[text()='Register']"));
        driver.findElement(By.xpath("//a[text()='Log in']"));
        driver.findElement(By.xpath("//a[text()='Shipping & returns']"));
        driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Shipping')]"));

        // tagName
        driver.findElement(By.xpath("//a"));
        driver.findElement(By.xpath("//button"));
        driver.findElement(By.xpath("//input"));

        //CSS

    }

    @Test
    public void TC_09_relative(){
        driver.get("https://demo.nopcommerce.com/login");

    }

    @Test
    public void TC_10_(){

    }

    // 3- clean: Delete data/ close browser
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}