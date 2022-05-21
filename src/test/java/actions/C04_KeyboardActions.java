package actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_KeyboardActions extends TestBase {
    /*
    1 Bir Class olusturalim KeyboardActions1
    2 https://www.amazon.com sayfasina gidelim
    3 Arama kutusuna actions method’larine kullanarak
    samsung A71 yazdirin ve Enter’a basarak arama
    yaptirin
    4 aramanin gerceklestigini test edin
     */
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions.contextClick(aramaKutusu).sendKeys("samsung A71"+ Keys.ENTER).perform();

        WebElement sonucTest= driver.findElement(By.xpath("//*[text()='\"samsung A71\"']"));
        Assert.assertTrue(sonucTest.getText().contains("samsung A71"));
    }
}
