package Webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_10_Checkbox_radio {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        // driver.manage().window().setSize(new Dimension(1366,768));
    }

    @Test
    public void TC_01(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        // scroll thêm 1 đoạn
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,300)");

        // Verify checkbox / radio đã được enabled hay disabled
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isEnabled());

        // Verify checkbox / radio đã được selected/inselected
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Leather trim']/preceding-sibling::span/input")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Towbar preparation']/preceding-sibling::span/input")).isSelected());


        // nếu chưa chọn thì mới click chon
        By Dualzone_air_conditioning = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        if (!driver.findElement(Dualzone_air_conditioning).isSelected())
        {
            driver.findElement(Dualzone_air_conditioning).click();
        }
        // click vào "Dual-zone air conditioning " checkbox
        driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input")).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,300)");

        By two_petrolBy = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        if (!driver.findElement(two_petrolBy).isSelected()) {
            driver.findElement(two_petrolBy).click();
        }

        Assert.assertTrue(driver.findElement(two_petrolBy).isSelected());
    }

    @Test
    public void TC_02(){
        driver.get("https://automationfc.github.io/multiple-fields/");

        // select tất cả checkbox
        List<WebElement> allCheckbox = driver.findElements(By.cssSelector("span.form-checkbox-item>input"));

        for (WebElement checkBox : allCheckbox){
            if(!checkBox.isSelected()){
                checkBox.click();
            }
        }

        // verify all checkbox selected
        for (WebElement checkBox : allCheckbox){
            Assert.assertTrue(checkBox.isSelected());
        }

        // unselect all checkbox
        for (WebElement checkBox : allCheckbox){
            if(checkBox.isSelected()){
                checkBox.click();
            }
        }

        // verify all checkbox deselected
        for (WebElement checkBox : allCheckbox){
            Assert.assertFalse(checkBox.isSelected());
        }

        // Select 1 in all + verify
        driver.findElement(By.cssSelector("input[value='Epilepsy Seizures']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Epilepsy Seizures']")).isSelected());

        // Select 1 in all + verify (cách 2)
        for (WebElement checkBox : allCheckbox){
            if(!checkBox.isSelected() && checkBox.getAttribute("value").equals("Heart Disease")){
                checkBox.click();
            }
        }

        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='Heart Diseasex`']")).isSelected());

    }

    @Test
    public void TC_03_Ubuntu(){
        driver.get("https://login.ubuntu.com/");

        // click to register radio
        // driver.findElement(By.cssSelector("input#id_new_user")).click();

        // By newUserRadio = By.cssSelector("input#id_new_user");

        // 1 - Dùng thẻ input để click -> Fail
        // Dùng thẻ input này để verify -> Pass
        // driver.findElement(newUserRadio).click();
        // Assert.assertFalse(driver.findElement(newUserRadio).isSelected());

        // By newUserRadio = By.cssSelector("label.new-user");
        // 2 - Dùng 1 thẻ khác input để click -> Pass
        // Dùng thẻ đó để verify -> Fail
        // isSelected() -> Dùng cho thẻ input/option
        // driver.findElement(newUserRadio).click();
        // Assert.assertTrue(driver.findElement(newUserRadio).isSelected());

        // 3 - Dùng 1 thẻ khác input để click -> Pass
        // Dùng thẻ input này để verify -> Pass
        By newUserRadioInput = By.cssSelector("input#id_new_user");
        By newUserRadioLabel = By.cssSelector("label.new-user");

        driver.findElement(newUserRadioLabel).click();
        Assert.assertTrue(driver.findElement(newUserRadioInput).isSelected());


    }

    @Test
    public void TC_04_(){}

    @AfterClass
    public void cleanBrowser(){
       // driver.quit();
    }
}