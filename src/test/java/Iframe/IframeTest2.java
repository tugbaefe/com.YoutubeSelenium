package Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class IframeTest2 {
    /*
    ●Bir class olusturun: IframeTest 02
    1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    2) sayfadaki iframe sayısını bulunuz.
    3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    4) ilk iframe'den çıkıp ana sayfaya dönünüz
    5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live selenium project.html)
    tıklayınız
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
       // driver.close();
    }
    @Test
    public void test01(){
        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) sayfadaki iframe sayısını bulunuz.

        List<WebElement> iframe=driver.findElements(By.xpath("//iframe"));
        System.out.println(iframe.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement ilkIframe= driver.findElement(By.xpath("//iframe[@src='https:/www.youtube.com/embed/lYCEQqSM08I']"));
        driver.switchTo().frame(ilkIframe);
        driver.findElement(By.xpath("//button[@type='submit']")).click();








    }
}
