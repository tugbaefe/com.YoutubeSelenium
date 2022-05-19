package video1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class YeniClass {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.67\\XPathPlugin.crx"));
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        ChromeDriver driver=new ChromeDriver(capabilities);

        driver.get("https://www.amazon.com");

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("nutella"+ Keys.ENTER);
    }
}