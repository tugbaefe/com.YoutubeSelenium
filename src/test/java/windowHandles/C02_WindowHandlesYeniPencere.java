package windowHandles;

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
import java.util.Set;

public class C02_WindowHandlesYeniPencere {
    /*
    ●Tests package’inda yeni bir class olusturun: WindowHandle 2
    ●https://the internet.herokuapp.com/windows adresine gidin.
    ●Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    ●Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    ●Click Here butonuna basın.
    ●Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    ●Sayfadaki textin “New Window” olduğunu doğrulayın.
    ●Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
    doğrulayın.
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
    public void test01(){

        //●https://the internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //●Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text= driver.findElement(By.xpath("//h3"));
        String expectedText="Opening a new window";
        String actualText=text.getText();
        Assert.assertEquals(expectedText,actualText);
        //●Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String arananKelime="The Internet";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime));
        String ilkWindowHandleDegeri=driver.getWindowHandle();
        //●Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windowHandlesSeti= driver.getWindowHandles();
       String ikinciWnidowHandleDegeri="";
        for (String each:windowHandlesSeti) {
            if (!each.equals(ilkWindowHandleDegeri)){
                ikinciWnidowHandleDegeri=each;
            }
        }
        driver.switchTo().window(ikinciWnidowHandleDegeri);
        //●Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedYeniTitle="New Window";
        String actualYeniTitle=driver.getTitle();
        Assert.assertEquals(expectedYeniTitle,actualYeniTitle);
        //●Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement actualNewText= driver.findElement(By.xpath("(//*[text()='New Window'])[2]"));
        String yeniText="New Window";
        Assert.assertEquals(yeniText,actualNewText.getText());

        //●Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //doğrulayın.
        driver.switchTo().window(ilkWindowHandleDegeri);
         arananKelime="The Internet";
         actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime));


    }

}
