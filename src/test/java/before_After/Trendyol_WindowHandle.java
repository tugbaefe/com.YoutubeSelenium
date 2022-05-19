package before_After;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Trendyol_WindowHandle {
    /*
    - google'a git
          - trendyolu ara
          - trendyol linkini bulup siteye git
          - avize arat
          - toplam ürün sayısını al
          - yeni sekmede morhipoya git
          - avize arat
          - toplam ürün sayısını al
          - iki sitedeki topla avize sayısını karşılaştır
          - ürün sayısı fazla olan siteyi kapat
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
       driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        // - google'a git
        driver.get("https://www.google.com");
        //- trendyolu ara
        //- trendyol linkini bulup siteye git
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@name='q']"));
        aramaKutusu.sendKeys("trendyol" + Keys.ENTER);
        driver.findElement(By.xpath("(//span[@role='text'])[1]")).click();
        // - avize arat
        //  - toplam ürün sayısını al
        driver.findElement(By.xpath("//input[@class='search-box']")).sendKeys("avize" + Keys.ENTER);
        String trendyolHandle=driver.getWindowHandle();
        WebElement urunSayisiT = driver.findElement(By.xpath("//div[@class='dscrptn']"));
        String sonucTrendyol = Arrays.stream(urunSayisiT.getText().split(" ")).collect(Collectors.toList()).get(3).replaceAll("\\D", "");
        int trendyolUrunSayisi = Integer.parseInt(sonucTrendyol);
        System.out.println(trendyolUrunSayisi);

        //- yeni sekmede morhipoya git
        // - avize arat
        // - toplam ürün sayısını al

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.morhipo.com");
        driver.findElement(By.xpath("//input[@id='pw-search-input']")).sendKeys("avize"+Keys.ENTER);
        WebElement urunsayisiM= driver.findElement(By.id("total-product-count"));
        String sonucMorhipo=Arrays.stream(urunsayisiM.getText().split(" ")).collect(Collectors.toList()).get(0).replaceAll("\\D","");
        int morhipoUrunSayisi= Integer.parseInt(sonucMorhipo);
        System.out.println(morhipoUrunSayisi);

        // - iki sitedeki topla avize sayısını karşılaştır
        //          - ürün sayısı fazla olan siteyi kapat

        Assert.assertTrue(trendyolUrunSayisi>morhipoUrunSayisi);
        driver.switchTo().window(trendyolHandle);
        Thread.sleep(2000);
        driver.close();
    }

}
