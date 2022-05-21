package actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_Actions extends TestBase {
     /*
    1- Yeni bir class olusturalim: MouseActions1
    2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    3- Cizili alan uzerinde sag click yapalim
    4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        test edelim.
    5- Tamam diyerek alert’i kapatalim
    6- Elemental Selenium linkine tiklayalim
    7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
     */
    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // 3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
       WebElement cizgiliAlan =driver.findElement(By.id("hot-spot"));
       actions.contextClick(cizgiliAlan).perform();
        //    4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //        test edelim.
        String expectedAlert="You selected a context menu";
        String actualAlert=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlert,actualAlert);

        //    5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //    6- Elemental Selenium linkine tiklayalim
        String ilkWHDegeri=driver.getWindowHandle();
       Set<String> elementSeti=driver.getWindowHandles();
       String ikinciWHDegeri="";
        for (String each:elementSeti) {
            if (!each.equals(ilkWHDegeri)){
                ikinciWHDegeri=each;
            }

        }
        driver.switchTo().window(ikinciWHDegeri);

        //    7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        WebElement elemntSelenium= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        String expectedIkinci="Elemental Selenium";
        String actualikinci=elemntSelenium.getText();
        Assert.assertEquals(expectedIkinci,actualikinci);
    }


}
