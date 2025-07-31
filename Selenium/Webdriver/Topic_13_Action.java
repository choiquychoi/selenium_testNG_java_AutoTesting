package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Topic_13_Action {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        action = new Actions(driver);
    }

    @Test
    public void TC_01_Click_and_hold_block(){
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNum = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allNum.size(),30);

        action.clickAndHold(allNum.get(0))  // click vào 1 số rồi giữ nguyên
                .moveToElement(allNum.get(3)) // di chuyển đến số 4 trong bảng
                .release() // thả chuột trái ra
                .perform(); // tổng kết lại cả quá trình hành động

        List<WebElement> AllNumSelected = driver.findElements(By.cssSelector("ol#selectable > li.ui-selected"));
        Assert.assertEquals(AllNumSelected.size(), 4);
    }

    @Test
    public void TC_02_Click_and_hold_random(){
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNum = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allNum.size(),30);

        // giữ nút ctrl (chưa nhã ra)
        action.keyDown(Keys.CONTROL).perform();

        action.click(allNum.get(0)).
                click(allNum.get(3)).
                click(allNum.get(7)).
                click(allNum.get(10)).
                click(allNum.get(15)).
                click(allNum.get(17)).
                pause(Duration.ofSeconds(3)).
                perform();

        action.keyUp(Keys.CONTROL).perform();

        List<WebElement> AllNumSelected = driver.findElements(By.cssSelector("ol#selectable > li.ui-selected"));
        Assert.assertEquals(AllNumSelected.size(), 6);
    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}