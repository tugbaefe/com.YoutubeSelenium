package windowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WindowHandles {
    /*
    ●Y eni bir class olusturun: WindowHandle
    ●Amazon anasayfa adresine gidin.
    ●Sayfa’nin window handle degerini String bir degiskene atayin
    ●Sayfa title’nin “Amazon” icerdigini test edin
    ●Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    ●Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    ●Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    ●Sayfa title’nin “Walmart” icerdigini test edin
    ●Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        //    ●Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //    ●Sayfa’nin window handle degerini String bir degiskene
        String amazonSayfaHandleDegeri= driver.getWindowHandle();
        //    ●Sayfa title’nin “Amazon” icerdigini test edin
        String arananKelime="Amazon";
        String actualAmazonTitle=driver.getTitle();
        Assert.assertTrue(actualAmazonTitle.contains(arananKelime));
        //    ●Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        //    ●Sayfa title’nin “Techpro Education” icerdigini test edin
        String istenenKelime="Techpro Education";
        String actualTechTitle= driver.getTitle();
        Assert.assertTrue(actualTechTitle.contains(istenenKelime));
        //    ●Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");
        //    ●Sayfa title’nin “Walmart” icerdigini test edin
        String istenenTitle="Walmart";
        String actualWalmartTitle=driver.getTitle();
        System.out.println(actualWalmartTitle);
        Assert.assertTrue(actualWalmartTitle.contains(istenenTitle));
        //    ●Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonSayfaHandleDegeri);
        Thread.sleep(3000);
       String donusHandle=driver.getWindowHandle();
       Assert.assertEquals(donusHandle,amazonSayfaHandleDegeri);
       driver.close();





    }


    }

