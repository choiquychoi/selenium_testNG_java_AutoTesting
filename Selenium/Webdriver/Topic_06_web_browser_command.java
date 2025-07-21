package Webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Topic_06_web_browser_command {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
    }

    @Test
    public void TC_01_Register(){

    }

    @Test
    public void TC_02_Login(){
        driver.get("https://demo.nopcommerce.com/"); // **

        driver.quit(); // **

        driver.close(); // *

        String homepage = driver.getTitle();

        // 2 - Kiểm tra trực tiếp
        // Kiểm tra tương đối
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");

        // Lấy ra URL của page hiện tại
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/cart");

        // Lấy ra Page Source Code
        String homePageSourceCode = driver.getPageSource();

        // Kiểm tra tương đối
        Assert.assertTrue(homePageSourceCode.contains("Conditions of Use"));

        // Đi tìm 1 element
        driver.findElement(By.xpath("")); // **

        // Đi tìm n element
        driver.findElements(By.xpath("")); // **

        Assert.assertEquals(homepage,"nop commerce store");
        Assert.assertEquals(driver.getTitle(),"nop commerce store");

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/cart");

        WebDriver.Options options = driver.manage();

        // Dùng để chờ cho viêc tìm element(findElement/findElements)
        options.timeouts().implicitlyWait(Duration.ofDays(15));
        options.timeouts().implicitlyWait(Duration.ofHours(15));

        options.timeouts().implicitlyWait(Duration.ofMinutes(1));
        options.timeouts().implicitlyWait(Duration.ofMinutes(2));
        options.timeouts().implicitlyWait(Duration.ofSeconds(20)); // *
        options.timeouts().implicitlyWait(Duration.ofSeconds(30));

        options.timeouts().implicitlyWait(Duration.ofMillis(15));
        options.timeouts().implicitlyWait(Duration.ofNanos(15));

        // dùng để chờ cho page load xong
        // có thể rút gọn "driver.manage().timeouts();"
        WebDriver.Timeouts timeouts = driver.manage().timeouts();

        timeouts.pageLoadTimeout(Duration.ofSeconds(15));

        // để dùng cho 1 đoạn scrips đc thực thi xong
        timeouts.scriptTimeout(Duration.ofSeconds(15));

        // thu nhỏ về taskBar để chạy
        driver.manage().window().minimize();

        // phóng to lên (vẫn còn task bar)
        driver.manage().window().maximize(); // *

        // tràn màn hình (không có taskBar)
        driver.manage().window().fullscreen();

        // Responsive
        driver.manage().window().setSize(new Dimension(1290,949));
        driver.manage().window().getSize();

        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();

        // lấy hết tất cả coockie : testCase1 regis / lấy hết tài khoản - lưu coockie lại
        Set<Cookie> cookies = driver.manage().getCookies(); // *

        // Alert/ IFrame/ windows (tab)
        WebDriver.TargetLocator targetLocator = driver.switchTo();

        // ALert
        targetLocator.alert().accept(); // *
        targetLocator.alert().dismiss(); // *

        // frame/IFrame
        targetLocator.frame(""); // *
        targetLocator.defaultContent(); // *

        // windows
        targetLocator.window(""); // *

        // lấy ra ID của tab/ window đang active
        driver.getWindowHandle(); // *

        // lấy ra tất cả ID của tất cả các tab/ window đang có
        driver.getWindowHandles(); // *
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}