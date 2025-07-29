package Webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_08_Custom_DropDown {
    WebDriver driver;

    WebDriverWait expliciwait;

    @BeforeClass
    public void beforeCLass() {
        driver = new FirefoxDriver();

        expliciwait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void TC_01_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        // thực hiện hàm được tạo tại đây
        selectItemInCustomDropDown("span#speed-button>span.ui-selectmenu-icon", "ul#speed-menu>li>div", "Faster");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")),"Faster");

    }

    //dự án thực tế: 1 hàm để thao tác lên dropdown chỉ dùng 1 site/ app
    // không dùng cho nhiều app khác nhau
    // cơ chế của dropdown giống nhau

    @Test
    public void TC_02_React() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInCustomDropDown("div.dropdown","div.item>span", "Matt");
    }

    private void selectItemInCustomDropDown(String parentCss, String childCss, String textItem) throws InterruptedException {
        // Hành vi để thao tác lên
        // 1- chờ cho Dropdown có thể thao tác lên được
        // 2- click  vào element nào để nó xổ ra cái dropdown ra
        expliciwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();
        Thread.sleep(2000);


        // 3- chờ cho tất cả các item được load ra
        // 4- tìm cái item nào đúng với mong đợi
        List<WebElement> allItems = expliciwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        // (5 items)

        for (WebElement items: allItems) {
            if (items.getText().equals(textItem)) {
                // 5- click lên item đó
                items.click();
                break;
            }
        }

    }

    @AfterClass

    public void cleanBrowser(){
        // driver.quit();
    }
}