package actions;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;

public class C10 extends TestBase {
    /*
    1."http://webdriveruniversity.com/" adresine gidin
    2."Login Portal" a kadar asagi inin
    3."Login Portal" a tiklayin
    4.Diger window'a gecin
    5."username" ve "password" kutularina deger yazdirin
    6."login" butonuna basin
    7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    8.Ok diyerek Popup'i kapatin
    9.Ilk sayfaya geri donun
    10.Ilk sayfaya donuldugunu test edin
     */
    @Test
    public void test01() throws InterruptedException {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String ilkWindowUrl= driver.getCurrentUrl();
        // 2."Login Portal" a kadar asagi inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // 3."Login Portal" a tiklayin
        WebElement loginPortal= driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']"));
        loginPortal.click();
        //4.Diger window'a gecin
        //    5."username" ve "password" kutularina deger yazdirin
        //    6."login" butonuna basin
        ArrayList<String> handles= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        Faker faker=new Faker();
        WebElement userName= driver.findElement(By.xpath("//input[@id='text']"));
        actions.click(userName).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        //    8.Ok diyerek Popup'i kapatin
        String actualpopUpYazisi=driver.switchTo().alert().getText();
        String exceptionPopUpYazisi="validation failed";
        Assert.assertEquals(exceptionPopUpYazisi,actualpopUpYazisi);
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(handles.get(0));
        //    10.Ilk sayfaya donuldugunu test edin
        String ikinciUrl=driver.getCurrentUrl();
        Assert.assertEquals(ilkWindowUrl,ikinciUrl);





    }
}
