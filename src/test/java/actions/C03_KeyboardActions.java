package actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyboardActions extends TestBase {
    //once arama kutusuna click yapip
    //sonra harf harf Nutella yazisini yazdiralim
    //sonra da ENTER tusuna basalim

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu).
                keyDown(Keys.SHIFT).
                sendKeys("n").
                keyUp(Keys.SHIFT).
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").
                sendKeys(Keys.ENTER).
                perform();

    }
}
