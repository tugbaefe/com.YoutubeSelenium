package actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.security.Key;
import java.util.Arrays;
import java.util.List;

public class GenelTekrar extends TestBase {
    static Select select;

        /*
        1- amazon gidin
        2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        3- dropdown menude 40 eleman olduğunu doğrulayın
        Test02
        1- dropdown menuden elektronik bölümü seçin
        2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        4- ikinci ürüne relative locater kullanarak tıklayin
        5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        Test03
        1- yeni bir sekme açarak amazon anasayfaya gidin
        2-dropdown’dan bebek bölümüne secin
        3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        4-sonuç yazsının puset içerdiğini test edin
        5-üçüncü ürüne relative locater kullanarak tıklayin
        6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        Test 4
        1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

         */
        @Test
        public void test01() {
            //1- amazon gidin
            driver.get("https://www.amazon.com");
            //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
            WebElement dropDownMenu= driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
            select=new Select(dropDownMenu);
            List<WebElement> tumOptions=select.getOptions();
            for (WebElement each:tumOptions) {
                System.out.println(each.getText());

            }

        }

    @Test
    public void test02() {
        //3- dropdown menude 28 eleman olduğunu doğrulayın
        List<WebElement> tumOptions=select.getOptions();
        int expectedDropdownMenuSayisi=28;
        int actualDropDownMenuSayisi= tumOptions.size();

        Assert.assertEquals(expectedDropdownMenuSayisi,actualDropDownMenuSayisi);
        //1- dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");
       select.getFirstSelectedOption().click();
        // 2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone"+ Keys.ENTER);
        WebElement aramaSonucSayisi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Arrays.stream(aramaSonucSayisi.getText().split(" ")).
                map(t->t.replaceAll("\\D","")).forEach(System.out::println);
        //  3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(aramaSonucSayisi.getText().contains("iphone"));
        // 4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        WebElement ikinciUrun=driver.findElement(RelativeLocator.with(By.tagName("img")).below(By.xpath("(//img[@class='s-image'])[1]")));
        ikinciUrun.click();
        // 5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        System.out.println(driver.getTitle());
        System.out.println("Urun stokta olmadigindan sepete eklenemedi");

    }
    @Test
    public void test03(){
            //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://amazon.com");
        // 2-dropdown’dan bebek bölümüne secin
        WebElement dropDownMenu= driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        select=new Select(dropDownMenu);
        select.selectByVisibleText("Baby");
        select.getFirstSelectedOption().click();
        // 3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("baby puset"+ Keys.ENTER);
        WebElement aramaSonucSayisi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(aramaSonucSayisi.getText());
        // 4-sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(aramaSonucSayisi.getText().contains("purse"));
        // 5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrun=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[2]"));
        WebElement dorduncuUrun=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[4]"));
        WebElement ucuncuUrun=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(ikinciUrun).toLeftOf(dorduncuUrun));
        ucuncuUrun.click();
        // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String title = driver.getTitle();
        System.out.println(title);
        WebElement ucret = driver.findElement(By.xpath("(//*[@aria-hidden='true'])[7]"));
        String ucretYazisi = ucret.getText();
        System.out.println(ucretYazisi);
        driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
        //7-Sepetteki urunlerle ekledigimiz urunlerin ayni oldugunu isim ve fiyat olarak dogrulayin
        driver.findElement(By.cssSelector("[href='/gp/cart/view.html?ref_=sw_gtc']")).click();//Sepete git
        WebElement fiyat = driver.findElement(By.cssSelector("[class='a-row a-spacing-mini sc-subtotal sc-subtotal-buybox sc-java-remote-feature']"));
        String sepetFiyat = fiyat.getText();
        System.out.println(sepetFiyat);
        Assert.assertTrue(sepetFiyat.contains(ucretYazisi));
        WebElement sepetBaslik = driver.findElement(By.cssSelector("[class='a-truncate-cut']"));
        String sepetBaslikYazisi = sepetBaslik.getText();
        Assert.assertTrue(title.contains(sepetBaslikYazisi));

    }
}