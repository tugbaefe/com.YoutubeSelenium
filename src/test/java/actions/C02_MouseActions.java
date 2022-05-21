package actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_MouseActions extends TestBase {
    //Yeni bir class olusturalim: MouseActions2
    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test01(){
        driver.get("https://demoqa.com/droppable");
        WebElement dragMeElementi= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereElementi= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragMeElementi,dropHereElementi).perform();

        WebElement droppedElementi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        Assert.assertEquals("Dropped!",droppedElementi.getText());



    }
}
