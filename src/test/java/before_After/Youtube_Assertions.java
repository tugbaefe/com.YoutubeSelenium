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

public class Youtube_Assertions {
    /*
    1)Bir class oluşturun: Youtube Assertions
    2)https://www.youtube.com adresine gidin
    3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    ○ titleTest => Sayfa başlığının YouTube ” oldugunu test edin
    ○ imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
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
        //2)https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");

    } @Test
    public void test02(){
        //○ titleTest => Sayfa başlığının YouTube ” oldugunu test edin
        String actualBaslik=driver.getTitle();
        String expectedBaslik="YouTube";
        Assert.assertEquals("sayfa basligi testi",expectedBaslik,actualBaslik);


    }
    @Test
    public void test03(){
        //○ imageTest => YouTube resminin görüntülendiğini isDisplayed()) test edin
        WebElement imageTest= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(imageTest.isDisplayed());


    }
    @Test
    public void test04(){
       //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unExpectedBaslik="youtube";
        String actualBaslik=driver.getTitle();
        Assert.assertNotEquals(unExpectedBaslik,actualBaslik);

    }
}
