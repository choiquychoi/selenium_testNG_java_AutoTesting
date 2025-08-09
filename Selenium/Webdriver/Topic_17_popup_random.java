package Webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class Topic_17_popup_random {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_JavaCode() throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");

        By newSleterPopUp = By.xpath("//div[@data-title='Newsletter-Books Anime Brief - NEW'" +
                " and not(contains(@style, 'display:none'))]");

        // hiên thị thì close đi rồi action tiếp
        if (driver.findElements(newSleterPopUp).size() > 0
                && driver.findElements(newSleterPopUp).get(0).isDisplayed()) {
            System.out.println("-----------Go to if ------------");
            driver.findElement(By.xpath("//div[@data-title='Newsletter-Books Anime Brief - NEW' and not(contains(@style, 'display:none'))]//a[contains(@onclick,'lepopup_close()')]")).click();
            Thread.sleep(5000);
        }

        // không hiển thị thì action luôn
        System.out.println("----------- Ignore if ------------");
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile");
        driver.findElement(By.cssSelector("form#search span.tie-search-icon")).click();

        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.cssSelector("header>h1.page-title")).isDisplayed());
    }


    @Test
    public void TC_02_VNK() throws InterruptedException {
        driver.get("https://vnk.edu.vn/");

        By maketingPopUpBy = By.cssSelector("div.popmake-content");

        // hiên thị thì close đi rồi action tiếp
        if (driver.findElements(maketingPopUpBy).size() > 0
                && driver.findElements(maketingPopUpBy).get(0).isDisplayed())
        {
            System.out.println("-----------Go to if ------------");
            driver.findElement(By.cssSelector("div.popmake-content~button")).click();
            Thread.sleep(5000);
        }

        // không hiển thị thì action luôn
        System.out.println("----------- Ignore if ------------");
        driver.findElement(By.xpath("//ul[@id='mega-menu-primary']//a[text()='Liên hệ']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.title-content>h1")).isDisplayed());
    }

    @Test
    public void TC_03_deHieu() throws InterruptedException {
        driver.get("https://dehieu.vn/");

        By popup = By.cssSelector("div.modal-content");

        // hiên thị thì close đi rồi action tiếp
        if (driver.findElements(popup).size() > 0
                && driver.findElements(popup).get(0).isDisplayed())
        {
            System.out.println("-----------Go to if ------------");
            driver.findElement(By.cssSelector("div.modal-content>div>button")).click();
            Thread.sleep(5000);
        }


        // không hiển thị thì action luôn
        System.out.println("----------- Ignore if ------------");
        driver.findElement(By.xpath("input.search-form")).sendKeys("Khóa học lập trình");

        Assert.assertEquals(driver.findElement(By.cssSelector("div.course-item-detail a")).getAttribute("title"),"Khóa học Lập Trình PLC Mitsubishi");

    }


    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }

}
