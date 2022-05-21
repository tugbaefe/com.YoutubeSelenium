package actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_FileUpload extends TestBase {
    @Test
    public void test01() {
//Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        WebElement chooseFile= driver.findElement(By.id("file-upload"));
        String farklikisim="user.home";
        String ortakKisim="\\Downloads\\text.txt";
        String secilecekDosya=farklikisim+ortakKisim;
        //Yuklemek istediginiz dosyayi secelim.
       chooseFile.sendKeys(secilecekDosya);
        ////Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.



    }
}
