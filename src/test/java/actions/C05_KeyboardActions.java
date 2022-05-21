package actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {
    @Test
    public void test01(){
        /*
        Yeni bir class olusturalim: D15_MouseActions4
        1 https://www.facebook.com adresine gidelim
        2 Yeni hesap olustur butonuna basalim
        3 Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        4 Kaydol tusuna basalim
         */
        driver.get("https://www.facebook.com");
        WebElement hesapOlustur= driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]"));
        hesapOlustur.click();
        WebElement hesapIsmi= driver.findElement(By.name("firstname"));
        Actions actions=new Actions(driver);
        actions.click(hesapIsmi).
                sendKeys("Tugba").
                sendKeys(Keys.TAB).
                sendKeys("Efe").
                sendKeys(Keys.TAB).
                sendKeys("efetugba2gmail.com").sendKeys(Keys.TAB).sendKeys("password").
                sendKeys(Keys.TAB).sendKeys("10").
                sendKeys(Keys.TAB).sendKeys("Mayis").
                sendKeys(Keys.TAB).sendKeys("1980").
                sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
    }
}
