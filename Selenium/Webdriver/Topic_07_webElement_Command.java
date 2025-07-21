package Webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_webElement_Command {
    WebDriver driver;
    WebElement element;

    @Test
    public void TC_01(){
        // dùng 1 lần
        driver.findElement(By.xpath(""));

        element = driver.findElement(By.xpath(""));

        // click vào các element (link, img,...)
        element.click();// **
        element.clear();// *

        // nhập liệu vào các element dạng textbox/ textArea/ dropdown (edit)
        element.sendKeys();// **

        element.sendKeys();

        // có thể find element bao nhiêu cũng đc
        element.findElement(By.id("")).findElement(By.name(""));// **

        // Áp dụng cho tất cả các dạng element
        // kiểm tra element có hiển thị ko?? (có size > 0?? / có thao tác/ thấy được ko??)
        element.isDisplayed();// **

        // áp dụng cho duy nhất 3 loại: checkbox/ dropdown (default)/ radio
        // dùng để kiểm tra 1 element đã được chọn hay chưa
        element.isSelected();// **

        //áp dụng cho tất cả các loại
        // kiểm tra 1 element có bị disable ko?
        element.isEnabled();

        // GUI: Font/ Size/ Color/ Position/ Location
        element.getCssValue("font-size");// *

        // áp dụng cho element chứa text (Link/ label/ tittle/ ...)
        element.getText();// **

        //
        element.getAttribute("placeholder");

        // chiều cao/ chiều rộng = bao nhiêu (trả ra dữ liệu demension)
        element.getSize();

        // vị trí của element so tới viewport
        element.getLocation();

        // hàm này là tông hợp của 2 hàm kia
        Rectangle rectangle = element.getRect();

        // size
        rectangle.getWidth();
        rectangle.getHeight();
        rectangle.getDimension();

        // location
        rectangle.getX();
        rectangle.getY();
        rectangle.getPoint();

        // lấy ra thẻ HTML của nó
        element.getTagName();

        // lấy ra têm thẻ là gì
        element.getAccessibleName();

        //
        element.getAriaRole();

        //
        element.getDomAttribute("");

        //
        element.getDomProperty(""); // *

        // popup
        element.getShadowRoot(); // **

        // FrameWork: HTML report
        element.getScreenshotAs(OutputType.FILE);// *
        element.getScreenshotAs(OutputType.BYTES);
        element.getScreenshotAs(OutputType.BASE64);// *
    }
}