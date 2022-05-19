package Iframe;

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

public class IframeTest1 {
    /*
    ●Bir class olusturun: IframeTest
    ●https://the internet.herokuapp.com/iframe adresine gidin.
    ●Bir metod olusturun: iframeTest
    ○“An IFrame containing….” textini n erisilebilir oldugunu test edin ve konsolda yazdirin.
    ○Text Box’a “Merhaba Dunya!” yazin.
    ○TextBox’in altinda bulunan “Elemental Selenium” linkini textini n gorunur oldugunu
    dogrulayin ve konsolda yazdirin.
     */

    static  WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void iframeTest(){
        // ●https://the internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //○“An IFrame containing….” textini n erisilebilir oldugunu test edin ve konsolda yazdirin.

        WebElement text=driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(text.isEnabled());
        System.out.println(text.getText());
        //○Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textSearch= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textSearch.clear();
        textSearch.sendKeys("Merhaba Dunya!");

        //○TextBox’in altinda bulunan “Elemental Selenium” linkini textini n gorunur oldugunu
        //    dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement linkText= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkText.isDisplayed());
        System.out.println(linkText.getText());


    }



}
