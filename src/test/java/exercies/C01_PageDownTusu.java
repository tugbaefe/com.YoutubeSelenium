package exercies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class C01_PageDownTusu {
    /*
     //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down page to bottom
    //5. Verify 'SUBSCRIPTION' is visible
    //6. Scroll up page to top
    //7. Verify that page is scrolled up and
    'Full-Fledged practice website for Automation Engineers' text is visible on screen
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
        driver.close();
    }
    @Test
    public void test01() throws AWTException, InterruptedException {
        ////2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        ////3. Verify that home page is visible successfully

        WebElement anasayfa= driver.findElement(By.className("header-middle"));
        Assert.assertTrue(anasayfa.isDisplayed());
        //4. Scroll down page to bottom
        Robot rbt=new Robot();
        rbt.keyPress(KeyEvent.VK_END);
        //5. Verify 'SUBSCRIPTION' is visible
        WebElement subscripition= driver.findElement(By.xpath("//*[text()='Subscription']"));
        Assert.assertTrue(subscripition.isDisplayed());
        //6. Scroll up page to top
        rbt.keyPress(KeyEvent.VK_HOME);
        Thread.sleep(2000);
        WebElement scrollupPage=driver.findElement(By.xpath("//*[@id=\"scrollUp\"]/i"));
        scrollupPage.click();
      //  Assert.assertTrue(scrollupPage.isEnabled());

//
        //7. Verify that page is scrolled up and
        Assert.assertTrue(scrollupPage.isDisplayed());

        Thread.sleep(2000);

       // 'Full-Fledged practice website for Automation Engineers' text is visible on
        WebElement text= driver.findElement(By.xpath("(//*[text()='Full-Fledged practice website for Automation Engineers'])[1]"));
        Assert.assertTrue(text.isDisplayed());

    }
    }

