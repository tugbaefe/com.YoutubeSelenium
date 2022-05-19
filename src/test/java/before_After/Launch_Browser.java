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

public class Launch_Browser {
     /*
      1. Launch browser
      2. Navigate to url 'http://automationexercise.com'
      3. Verify that home page is visible successfully
      4. Click on 'Signup / Login' button
      5. Verify 'Login to your account' is visible
      6. Enter correct email address and password
      7. Click 'login' button
      8. Verify that 'Logged in as username' is visible
      9. Click 'Delete Account' button
      10. Verify that 'ACCOUNT DELETED!' is visible
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
     public static void tearDown() {
          //   driver.close();
     }

     @Test
     public void test01() {
          //2) 2. Navigate to url 'http://automationexercise.com'
          driver.get("http://automationexercise.com");
     }
     @Test
     public void test02() {
          //3. Verify that home page is visible successfully
          WebElement homePage= driver.findElement(By.xpath("//html[@lang='en']"));
          Assert.assertTrue(homePage.isDisplayed());
     }
     @Test
     public void test03() {
          //  4. Click on 'Signup / Login' button
          driver.findElement(By.linkText("Signup / Login")).click();

     }
     @Test
     public void test04() {
          //5. Verify 'Login to your account' is visible
          WebElement login= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
          Assert.assertTrue(login.isDisplayed());

     }
     @Test
     public void test05() {
          //6. Enter correct email address and password
          WebElement emailAdress=driver.findElement(By.xpath("(//input[@name='email'])[1]"));
          WebElement password=driver.findElement(By.name("password"));
          emailAdress.sendKeys("evren@gmail.com");
          password.sendKeys("passwords");
          // 7. Click 'login' button
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();
        //8. Verify that 'Logged in as username' is visible
          WebElement loggedUsername=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a"));
          Assert.assertTrue(loggedUsername.isDisplayed());
          // 9. Click 'Delete Account' button
          driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();
          //10. Verify that 'ACCOUNT DELETED!' is visible
          WebElement accountDeleted=driver.findElement(By.className("content-main"));
          Assert.assertTrue(accountDeleted.isDisplayed());

     }
}