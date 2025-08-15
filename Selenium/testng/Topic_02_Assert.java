package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Topic_02_Assert {
    WebDriver driver;
    @Test
    public void assertion() {
        // AssertTrue    khi muốn kiểm tra 1 điều kiên mong đợi nó trả về là đúng mới đúng yêu cầu
        // các hàm trả về   true/ false
        // selenium : isDisplayed/ isSelected/ isMultiple
        // User defile
        Assert.assertTrue(driver.findElement(By.cssSelector("")).isDisplayed());

        // AssertFalse khi muốn kiểm tra 1 điều kiên mong đợi nó trả về là sai mới đúng yêu cầu
        Assert.assertFalse(driver.findElement(By.cssSelector("")).isDisplayed());

        // AssertEqual khi muốn kiểm tra 1 điều kiên mong đợi (expected) bằng vs điều kiện thực tế (actual) mới đúng yêu cầu
        // getText() / getURL / getAttribute / getTitle / ...

    }
}
