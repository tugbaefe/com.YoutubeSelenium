package video1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_MavenTest {
    public static void main(String[] args) {
        /*
        1.http://zero.webappsecurity.com sayfasina gidin
        2. Signin buttonuna tiklayin
        3.L ogin alanine “username“ yazdirin
        4.P assword alanine “password" yazdirin
        5. Sign in buttonuna tiklayin
        6. Pay Billssayfasina gidin
        7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        8.tarih kismina “2020 0 9 10 yazdirin
        9. Pay buttonuna tiklayin
        10. “The payment was successfully submitted.”
mesajinin ciktigini control edin
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //1.http://zero.webappsecurity.com sayfasina gidin

        driver.get("http://zero.webappsecurity.com");

        // 2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3.L ogin alanine “username" yazdirin

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //        4.P assword alanine “password" yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        //        5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();

        //        6. Pay Billssayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //        7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("500");
        //        8.tarih kismina “2020 0 9 10 yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        //        9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //        10. “The payment was successfully submitted.”
        //mesajinin ciktigini control edin

        WebElement mesajDogrulama=driver.findElement(By.xpath("//div[@id='alert_content']"));
        if (mesajDogrulama.isDisplayed()){
            System.out.println("test PASSED");
        }else System.out.println("test FAILED");

        driver.close();
    }
}
