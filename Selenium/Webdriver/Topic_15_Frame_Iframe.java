package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Frame_Iframe {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Iframe() throws InterruptedException {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("img[alt='Campus Safety Survey']")).click();
        Thread.sleep(7000);

        // Switch qua iframe
        //Index: page hiện tại có nhiều iframe/frame
        // frame/iframe đầu tiên đều là index = 0
        // khi thêm mới / update lại/ xóa bớt đi thì đổi index của các iframme
        // driver.switchTo().frame(0);

        // hoặc ID và name(page có iframe /iframe có id or name)
         driver.switchTo().frame("frame-one85593366");

        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");

        // từ B quay lại A
        driver.switchTo().defaultContent();

        // Dùng JS để xóa popup cookie
        ((JavascriptExecutor) driver).executeScript(
                "let popup = document.querySelector(\"div[class*='osano-cm-dialog']\");" +
                        "if (popup) { popup.remove(); }"
        );

        Thread.sleep(5000);

        // driver đã quay lại A rồi
        driver.findElement(By.cssSelector(".menu-item-login.fs-btn--transparent-kashmir")).click();
    }

    @Test
    public void TC_02_frame() throws InterruptedException {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        driver.switchTo().frame("login_page");

        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("automationFC");

        driver.findElement(By.cssSelector("a.btn")).click();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("anotherNiga");
        driver.findElement(By.cssSelector("a#loginBtn")).click();
        Thread.sleep(3000);


    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}