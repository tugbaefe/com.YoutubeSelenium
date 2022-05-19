package dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDownOptions {
    /*
    Amazon anasayfaya gidip dropdown menuden
    books'u secelim
    sectigimiz option'i yazdiralim

    dropdown'daki opsiyonlarin toplamsayisinin
    28 oldugunu test edin

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
          //driver.close();
     }
     @Test
     public void test01(){
          driver.get("https://www.amazon.com");
          WebElement dropDownMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
          Select select=new Select(dropDownMenu);
          select.selectByVisibleText("Books");
          System.out.println(select.getFirstSelectedOption().getText());

          // dropdown'daki opsiyonlarin toplamsayisinin
          //    20 oldugunu test edin

          List<WebElement> options=select.getOptions();
          int expectedOptionSayisi=28;
          int actualOptionSayisi=options.size();
          Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

     }

}
