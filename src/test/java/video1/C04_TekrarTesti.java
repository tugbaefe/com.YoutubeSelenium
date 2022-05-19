package video1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C04_TekrarTesti {
    /*
    2 https://www.google.com/ adresine gidin
    3 cookies uyarisini kabul ederek kapatin
    4 Sayfa basliginin “Google” ifadesi icerdigini test edin
    5 Arama cubuguna “Nutella” yazip aratin
    6 Bulunan sonuc sayisini yazdirin
    7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
    8 Sayfayi kapatin
     */

    WebDriver driver;
    @Before
    public void methodBaslik(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
   // @After
    public void methodKapat(){
        driver.close();
    }
    @Test
    public void methodIslem(){

        driver.get("https://www.google.com/");

        String sayfaBasligi=driver.getTitle();
        if (sayfaBasligi.contains("Google")){
            System.out.println("baslik testi PASSED ");
        }else System.out.println("baslik testi FAILED ");

        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
/*
       String [] sonucSayisi= driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split(" ");
       String sonucYazisi=sonucSayisi[1];
       System.out.println("Nutella icin bulunan sonuc sayisi : " + sonucYazisi);
       int istenenSayi=10000000;
       sonucYazisi=sonucYazisi.replaceAll("//D","");

    if (Integer.parseInt(sonucYazisi)>istenenSayi){
       System.out.println("Sayi testi PASSED");
   }else System.out.println("Sayi testi FAILED");



 */
        WebElement sonucSayisi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        String sonuc= Arrays.stream(sonucSayisi.getText().split(" ")).collect(Collectors.toList()).get(1).replaceAll("\\D","");
        int istenenSayi=10000000;
        if (Integer.parseInt(sonuc)>istenenSayi){
            System.out.println("Sayi testi PASSED");
        }else System.out.println("Sayi testi FAILED");
}
}
