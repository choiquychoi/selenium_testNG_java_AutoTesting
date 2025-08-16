package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Topic4_Loop {
    WebDriver driver;

    String firstName, lastName, email, password, fullname;

    Random rand;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        rand = new Random();

        firstName = "Joe";
        lastName = "nicka";
        fullname = firstName + " " +  lastName;
        password = "joenicka234";

    }

    @Test(invocationCount = 5)
    public void TC_01_Register() throws InterruptedException {
        driver.get("http://live.techpanda.org/");

        email = "joenicka" + rand.nextInt(9999) + "@gmail.com";

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(email);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");

        String contactInformation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();

        System.out.println(contactInformation);

        //tương đối
        Assert.assertTrue(contactInformation.contains(fullname) && contactInformation.contains(email));

        //logOut
        driver.findElement(By.cssSelector("div.account-cart-wrapper>a")).click();

        driver.findElement(By.xpath("//a[@title='Log Out']")).click();

        Thread.sleep(6000);

        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/");

        System.out.println("Email address is : "+email);
        System.out.println("Password is : " + password);
    }
}
