package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_18_Window_tab {
    WebDriver driver;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_Github() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Lấy ra ID của tab/ window mà driver đang active tại page đó
        String githubWindowID = driver.getWindowHandle();
        System.out.println("Page ID = " + githubWindowID);

        // Click vào Google link -> nó sẽ bật lên 1 tab mới và tự nhảy qua
        // Nhưng về code Selenium là driver ko tự nhảy qua - nó vẫn ở tab cũ
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        Thread.sleep(3000);

        SwitchToTabById(githubWindowID);

        Thread.sleep(3000);

        String googleID = driver.getWindowHandle();

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Selenium WebDriver");
        Thread.sleep(3000);

        SwitchToTabById(googleID);
        Thread.sleep(3000);

        // Click vào Facebook link -> nó sẽ bật lên 1 tab mới và tự nhảy qua
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        Thread.sleep(2000);

        SwitchToTabByTitle("Facebook - log in or sign up");

        // lấy toàn bộ các ID của window/ tab
        Set<String> allWindowIds = driver.getWindowHandles();

        // Dũng vòng lặp duyệt qua từng ID
        for (String id : allWindowIds) {
            if (!id.equals(githubWindowID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }

        driver.switchTo().window(githubWindowID);
    }

    private void SwitchToTabByTitle(String ExpectedPageTitle ) throws InterruptedException {
        // Lấy hết toàn bộ các ID của window/ tab
        Set<String> allWindowIDs = driver.getWindowHandles();

        // Dùng vòng lặp duyệt qua từng ID
        for (String id : allWindowIDs) {
            // Mỗi lần duyệt sẽ cho nó switch vào trước
            driver.switchTo().window(id);
            Thread.sleep(3000);

            // Get ra title của window/ tab hiện tại
            String pageTitle = driver.getTitle();

            // Kiểm tra title
            if (pageTitle.equals("ExpectedPageTitle")) {
                // Nếu đúng tab Facebook thì có thể thao tác hoặc close luôn
                driver.close(); // đóng tab hiện tại (tab Facebook)
                break;
            }
        }
    }

    private void SwitchToTabById(String windowId) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(windowId)) {
                driver.switchTo().window(id);
            }
        }
    }


    @Test
    public void TC_02() throws InterruptedException {

        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        // Sony Xperia
        driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']" +
                "//a[@class='link-compare']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Sony Xperia has been added to comparison list.");

        // Samsung Galaxy
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']" +
                "//a[@class='link-compare']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "The product Samsung Galaxy has been added to comparison list.");

        driver.findElement(By.cssSelector("button[title='Compare']")).click();

        Thread.sleep(3000);

        SwitchToTabByTitle("Products Comparison List - Magento Commerce");

        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/catalog/product_compare/index/");

        driver.findElement(By.cssSelector("button[title='Close Window']")).click();
        Thread.sleep(3000);

        SwitchToTabByTitle("Mobile");

        driver.findElement(By.xpath("//a[text()='Clear All']")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.switchTo().alert().getText(),"Are you sure you would like to remove all products from your comparison?");
        driver.switchTo().alert().accept();

    }

    @AfterClass
    public void cleanBrowser(){
        driver.quit();
    }
}