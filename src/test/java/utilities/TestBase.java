package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.time.Duration;

public abstract class TestBase {
    protected static WebDriver driver;
    protected static ChromeOptions options;



    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();

        options = new ChromeOptions();
        options.addExtensions(new File("C:\\Program Files\\Google\\Chrome\\Application\\101.0.4951.67\\XPathPlugin.crx"));
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        driver=new ChromeDriver(capabilities);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }
    @AfterClass
    public static void tearDown(){

        //driver.quit();
    }

}
