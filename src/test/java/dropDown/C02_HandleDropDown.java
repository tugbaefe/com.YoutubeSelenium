package dropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropDown {
    /*
    ●Bir class oluşturun: DropDown
    ●https://the internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text (Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
    True , degilse
    False yazdırın
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
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown= driver.findElement(By.xpath("//select[@id='dropdown']"));

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Select select=new Select(dropDown);
        select.selectByIndex(1);
        System.out.println("index ile secim : "+ select.getFirstSelectedOption().getText());

        //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println("value ile secim : "+select.getFirstSelectedOption().getText());
        //    3.Visible Text (Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println("text ile secim : "+select.getFirstSelectedOption().getText());
        //4.Tüm dropdown optionslari yazdırın
        List<WebElement> tumOptions=select.getOptions();
        tumOptions.stream().forEach(t-> System.out.println(t.getText()));
        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda
        //    True , degilse
        //    False yazdırın

       int boyut=tumOptions.size();
       if (boyut==4){
           System.out.println("true");
       }else System.out.println("false");

    }

}
