package video1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_MavenTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        /*
        1-https://www.amazon.com/ sayfasina gidelim
        2- arama kutusunu locate edelim
        3--“Samsung headphones” ile arama yapalim
        4-Bulunan sonuc sayisini yazdiralim
        5-Ilk urunu tiklayalim
        6-Sayfadaki tum basliklari yazdiralim
         */

        //1-https://www.amazon.com/ sayfasina gidelim

        driver.get("https://www.amazon.com");

        //2- arama kutusunu locate edelim

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //3--“Samsung headphones” ile arama yapalim

        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4-Bulunan sonuc sayisini yazdiralim

        WebElement sonucsayisi= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        System.out.println("Sonuc sayisi : " +sonucsayisi.getText());

        // 5-Ilk urunu tiklayalim

         driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();


        //6-Sayfadaki tum basliklari yazdiralim

        System.out.println("Sayfadaki tum basliklar : "+ driver.getTitle());

        driver.close();


    }
}
