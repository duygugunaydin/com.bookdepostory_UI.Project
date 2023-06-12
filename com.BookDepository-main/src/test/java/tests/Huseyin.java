package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Huseyin extends TestBaseRapor {

    @Test
    public void gecersizKuponTesti(){

        extentTest=extentReports.createTest("Kullanici yanlis kupon bilgisi ile ekleme yapamamali");

        HomePage homePage=new HomePage();

        Driver.getDriver().get(ConfigReader.getProperty("bookDepoUrl"));
        extentTest.info("Anasayfaya gidildi");

        homePage.depoSearchBox.sendKeys("Nathan"+ Keys.ENTER);
        extentTest.info("Arama kutusunda istenen element aratıldı");

        homePage.bookElementi.click();
        extentTest.info("istenen elemente tiklandi");

        homePage.addtoBasketElementi.click();
        extentTest.info("Sepete ekle butonuna tıklandı");

        homePage.sepetButonu.click();
        extentTest.info("Sepete ekleme işlemi onaylandı");

        homePage.kuponBox.sendKeys("aaaaaa"+Keys.ENTER);
        extentTest.info("Yanlis kupon kodu girildi");

        homePage.kuponApplyButonu.click();
         extentTest.info("Apply butonuna tıklandı");

        Assert.assertTrue(homePage.gecersizkuponYazisi.isDisplayed());
        extentTest.info("Yanlis kupon kodu ile girilemedigi dogrulandı");

        ReusableMethods.bekle(4);

        extentTest.pass("Yanlis kupon kodu ile ekleme yapilamadigi test edildi");
    }
}
