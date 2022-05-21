package actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_MouseActions extends TestBase {
    /*
        Yeni bir class olusturalim: MouseActions3
    1 https://www.amazon.com/ adresine gidelim
    2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
     mouse’u bu menunun ustune getirelim
    3 --“Create a list” butonuna basalim
    4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
     */

    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");
        Actions actions=new Actions(driver);
        WebElement accountListElementi= driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
        actions.moveToElement(accountListElementi).perform();
        WebElement createListElementi= driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        actions.click(createListElementi).perform();
        WebElement yourListElementi= driver.findElement(By.xpath("//div[@role='heading']"));
        String expectedYourList="Your Lists";
        String actualYourList=yourListElementi.getText();
        Assert.assertEquals(expectedYourList,actualYourList);

    }
}
