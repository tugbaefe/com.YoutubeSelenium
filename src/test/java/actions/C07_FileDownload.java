package actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileDownload extends TestBase {
    @Test
    public void test01() {
        //1. Tests packagenin altina bir class oluşturalim
        // 2. https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");
        //3. dummy.txt dosyasını indirelim
        WebElement someFile= driver.findElement(By.xpath("//a[text()='sample.png']"));
        someFile.click();
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\some-file.txt";
        String arananDosyaYolu=farkliKisim+ortakKisim;
        // dosya downloads'a indirilecektir, bize downloads'un dosya yolu lazim
        // geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));



    }
}
