package actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C09 extends TestBase {
    /*
    1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
    2. “Our Products” butonuna basin
    3. “Cameras product”i tiklayin
    4. Popup mesajini yazdirin
    5. “close” butonuna basin
    6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
    Collapse
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
       WebElement iframe=driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        WebElement ourProducts=driver.findElement(By.xpath("//*[text()='Our Products']"));
        ourProducts.click();
        WebElement camerasProduct= driver.findElement(By.xpath("//*[text()='Cameras']"));
        camerasProduct.click();
        Thread.sleep(3000);
        WebElement popUpMesaji= driver.findElement(By.xpath("//div[@class='modal-content']"));
        System.out.println(popUpMesaji.getText());
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();
        String expectedUrl="http://webdriveruniversity.com/index.html";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);



    }
}
