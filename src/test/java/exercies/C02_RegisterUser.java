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

import java.time.Duration;

public class C02_RegisterUser {

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
        //driver.close();
    }

    //1. Launch browser
    @Test
    // 2. Navigate to url 'http://automationexercise.com'
    public void test01() {
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        WebElement homePage= driver.findElement(By.xpath("(//div[@class='row'])[1]"));
        Assert.assertTrue(homePage.isDisplayed());
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        // 5. Verify 'New User Signup!' is visible
        WebElement verify= driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(verify.isDisplayed());
        // 6. Enter name and email address
       driver.findElement(By.xpath("//input[@type='text']")).sendKeys("efetugba");
       driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("efetugba1515@gmail.com");
        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//*[text()='Signup']")).click();
        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement information= driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(information.isDisplayed());
        // 9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement title= driver.findElement(By.xpath("//*[text()='Title']"));
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        WebElement dateBirthday= driver.findElement(By.xpath("//*[text()='Date of Birth']"));
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("17");
        driver.findElement(By.xpath("//select[@id='months']")).sendKeys("January");
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1988");
        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
       WebElement adressInformation= driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
       driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("tugba");
       driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("efe");
       // 13. Click 'Create Account button'
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        // 14. Verify that 'ACCOUNT CREATED!' is visible
        // 15. Click 'Continue' button
        // 16. Verify that 'Logged in as username' is visible
        // 17. Click 'Delete Account' button
        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


    }
}