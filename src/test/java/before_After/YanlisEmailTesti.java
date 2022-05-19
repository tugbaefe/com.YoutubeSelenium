package before_After;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YanlisEmailTesti {
    /*
    1.Bir Class olusturalim YanlisEmailTesti
    2.http://automationpractice.com/index.php sayfasina gidelim
    3.Sign in butonuna basalim
    4.Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
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
    public static void teamDown() {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void test02() {
        //3.Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();

    }
    @Test
    public void test03() {
        //4.Email kutusuna @isareti olmayan bir mail yazip enter’a
        //    bastigimizda “Invalid email address” uyarisi ciktigini test edelim

        WebElement emailTest=driver.findElement(By.xpath("//input[@id='email_create']"));
        emailTest.sendKeys("efetugba1515.gmail.com"+ Keys.ENTER);
        WebElement emailInvalidUyari= driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
        Assert.assertTrue(emailInvalidUyari.isDisplayed());

    }
}