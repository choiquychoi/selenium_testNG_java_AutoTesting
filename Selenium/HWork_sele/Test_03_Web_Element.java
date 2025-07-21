package HWork_sele;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.Key;

public class Test_03_Web_Element {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();

        driver.get("https://demo.nopcommerce.com");
    }

    @Test
    public void TC_01_Displayed(){
        // isDisplayed: kiểm tra bất kỳ 1 element nào hiển thị
        // hiển thị: có thể nhìn thấy - có kích thước cụ thể

        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='mail']"));

        if(emailTextBox.isDisplayed()){
            System.out.println("email textbox is displayed");
            emailTextBox.sendKeys("Automation testing");
        }
        else {
            System.out.println("email textbox is not displayed");
        }

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));

        if (ageUnder18Radio.isDisplayed()) {
            System.out.println("age under 18 is displayed");
            ageUnder18Radio.click();
        }
        else {
            System.out.println("age under 18 is not displayed");
        }

        WebElement eduTextArea = driver.findElement(By.cssSelector("textarea#edu"));
        if (ageUnder18Radio.isDisplayed()) {
            System.out.println("Education TextArea is displayed");
            ageUnder18Radio.sendKeys("nigga");
        }
        else {
            System.out.println("age under 18 is not displayed");
        }


        WebElement TextUser5 = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
        if (ageUnder18Radio.isDisplayed()) {
            System.out.println("Text is displayed");
            ageUnder18Radio.sendKeys("nigga");
        }
        else {
            System.out.println("age under 18 is not displayed");
        }
    }

    @Test
    public void TC_02_Enabled(){
        // isDisplayed: kiểm tra bất kỳ 1 element nào có thể tương tác được
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='mail']"));
        if(emailTextBox.isEnabled()){
            System.out.println("email textbox is enabled");
        }
        else {
            System.out.println("email textbox is disabled");
        }


        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if (ageUnder18Radio.isEnabled()) {
            System.out.println("age under 18 is enabled");
        }
        else {
            System.out.println("age under 18 is disabled");
        }

        WebElement disable_password = driver.findElement(By.cssSelector("input#disable_password"));
        if (disable_password.isEnabled()) {
            System.out.println("Password textBox is enabled");
        }
        else {
            System.out.println("Password textBox is disabled");
        }

        WebElement TextAreaBiography = driver.findElement(By.cssSelector("textarea#bio"));
        if (disable_password.isEnabled()) {
            System.out.println("Biography textBox is enabled");
        }
        else {
            System.out.println("Biography textBox is disabled");
        }
    }

    @Test
    public void TC_03_Seleted(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement ageUnder18Radio = driver.findElement(By.cssSelector("input#under_18"));
        if (ageUnder18Radio.isSelected()) {
            System.out.println("age under 18 is selected");
        }
        else {
            System.out.println("age under 18 is de-selected");
        }

        WebElement checkboxDevelopment = driver.findElement(By.cssSelector("input#development"));
        if (checkboxDevelopment.isSelected()) {
            System.out.println("interest checkbox is selected");
        }
        else {
            System.out.println("interest checkbox is de-selected");
        }

        ageUnder18Radio.click();
        checkboxDevelopment.click();

        if (ageUnder18Radio.isSelected()) {
            System.out.println("age under 18 is selected");
        }
        else {
            System.out.println("age under 18 is de-selected");
        }

        if (checkboxDevelopment.isSelected()) {
            System.out.println("interest checkbox is selected");
        }
        else {
            System.out.println("interest checkbox is de-selected");
        }
    }

    @Test
    public void TC_04_MailChimp_register_Validate(){
        driver.get("https://login.mailchimp.com/signup/");

        driver.findElement(By.cssSelector("input#email")).sendKeys("congquynguyen1349@gmail.com");

        driver.findElement(By.cssSelector("input#new_username")).sendKeys(Keys.TAB);

        // only nums
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345");
        driver.findElement(By.cssSelector("input#new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.\\38 -char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // only lowercase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("congquy");
        driver.findElement(By.cssSelector("input#new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.\\38 -char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());

        // only uppercase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("CONGQUY");
        driver.findElement(By.cssSelector("input#new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.\\38 -char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.not-completed")).isDisplayed());

        //  more 8 char
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("iasdfiashfisafi");
        driver.findElement(By.cssSelector("input#new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.\\38 -char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // only special character
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("=-.,;");
        driver.findElement(By.cssSelector("input#new_password")).sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.\\38 -char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // right pass
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Congquy123!");
        driver.findElement(By.cssSelector("input#new_password")).sendKeys(Keys.TAB);

        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.\\38 -char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}