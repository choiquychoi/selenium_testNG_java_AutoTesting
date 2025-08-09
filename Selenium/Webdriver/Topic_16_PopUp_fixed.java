package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_PopUp_fixed {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01(){
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        By loginPopup = By.cssSelector("div.MuiPaper-elevation");

        // kiểm tra 1 element có hiênr thị
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("niga");
        driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("niga");


    }

    @Test
    public void TC_03_() throws InterruptedException {
        driver.get("https://tiki.vn/");

        // PopUp 01 - maketing
        // hiển thị cố định khi vừa mở site
        // khi đóng lại thì ko còn trong HTml nữa
        // khi reset page lại hiện ra

        By maketingPopUp = By.cssSelector("div#VIP_BUNDLE");
        Assert.assertTrue(driver.findElement(maketingPopUp).isDisplayed());

        driver.findElement(By.cssSelector("div#VIP_BUNDLE img[alt='close-icon']")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("div.hTmXuX")).click();
        Thread.sleep(3000);

        // verify popup hien thi
        By loginPopup = By.cssSelector("div.ReactModal__Content");
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        Assert.assertEquals(driver.findElement(loginPopup).getSize(),1);

        driver.findElement(By.cssSelector("p.login-with-email")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][1]")),"Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][2]")),"Mật khẩu không được để trống");

        driver.findElement(By.cssSelector("img.close-img")).click();
        Thread.sleep(3000);

        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());

        Assert.assertEquals(driver.findElement(loginPopup).getSize(),0);
    }


    @Test
    public void TC_02(){

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}