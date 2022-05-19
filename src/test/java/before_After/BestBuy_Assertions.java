package before_After;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BestBuy_Assertions {
    /*
    1)
    Bir class oluşturun: BestBuy Assertions
    2) https://www.bestbuy.com/ A dresine gidin farkli test method’lari olusturarak asagidaki
    testleri yapin
    ○Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
    ○titleTest => Sayfa başlığının “ R est” içer me diğini(contains) test edin
    ○logoTest => BestBuy logosunun görüntülen digini test edin
    ○Francais LinkTest => Fransizca Linkin görüntüle n diğini test edin
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
    public static void  tearDown() {
        driver.close();

    }
    @Test
    public void test01(){
        //2) https://www.bestbuy.com/ A dresine gidin
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void test02(){
        //○Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.bestbuy.com/";

        Assert.assertEquals("Sayfa url Testi : ",expectedUrl,actualUrl);
    }
    @Test
    public void test03(){
        //○titleTest => Sayfa başlığının “ R est” içer me diğini(contains) test edin
        System.out.println(driver.getTitle());
        String sayfaBaslik=driver.getTitle();
        String arananKelime="Rest";

        Assert.assertFalse(sayfaBaslik.contains(arananKelime));
    }
    @Test
    public void test04(){
        // ○logoTest => BestBuy logosunun görüntülen digini test edin
        WebElement logo= driver.findElement(By.xpath("//div[@lang='en']"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test05(){
        // ○Francais LinkTest => Fransizca Linkin görüntüle n diğini test edin
        WebElement francisLogo= driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(francisLogo.isDisplayed());
    }
}
