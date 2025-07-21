package HWork_sele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_01_Xpath_Lacator {
    // 1- SetUp: OS/browser/ web/ Page/ Data
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    // 2- Action/ Execute: web Element/ nhập liệu /verify/...
    @Test
    public void TC_register_01_empty_data(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");

    }

    @Test
    public void TC_register_02_invalid_email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Nigga");
        driver.findElement(By.id("txtEmail")).sendKeys("123@345@456");
        driver.findElement(By.id("txtCEmail")).sendKeys("123@345@456");
        driver.findElement(By.id("txtPassword")).sendKeys("choiquychoi123");
        driver.findElement(By.id("txtCPassword")).sendKeys("choiquychoi123");
        driver.findElement(By.id("txtPhone")).sendKeys("0987746291");
        // ...
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");
    }

    @Test
    public void TC_register_03_incorrect_confirm_email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Nigga");
        driver.findElement(By.id("txtEmail")).sendKeys("congquynguyen1349@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("congquynguyen2003@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("choiquychoi123");
        driver.findElement(By.id("txtCPassword")).sendKeys("choiquychoi123");
        driver.findElement(By.id("txtPhone")).sendKeys("0987746291");
        // ...
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
    }

    @Test
    public void TC_register_04_password_less_6_char(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Nigga");
        driver.findElement(By.id("txtEmail")).sendKeys("congquynguyen1349@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("congquynguyen1349@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("dick");
        driver.findElement(By.id("txtCPassword")).sendKeys("dick");
        driver.findElement(By.id("txtPhone")).sendKeys("0987746291");
        // ...
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void TC_register_05_incorrect_comfirm_pass(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        // Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Joe Nigga");
        driver.findElement(By.id("txtEmail")).sendKeys("congquynguyen1349@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("congquynguyen1349@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("mydiksobig123");
        driver.findElement(By.id("txtCPassword")).sendKeys("mydiksobgi123");
        driver.findElement(By.id("txtPhone")).sendKeys("0987746291");
        // ...
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void TC_register_06_invalid_phoneNum(){

    }

    // 3- clean: Delete data/ close browser
    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}