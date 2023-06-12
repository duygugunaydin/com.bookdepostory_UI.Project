package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Erden extends TestBaseRapor {
    @Test
    public void urunSiralamaTesti(){
        extentTest=extentReports.createTest("Kullanici bir kitap aratip fiyata gore dusukten yuksek fiyata gore sıralayabilmeli");
        HomePage homePage=new HomePage();

        //Kullanici https://www.bookdepository.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("bookDepoUrl"));
        extentTest.info(ConfigReader.getProperty("bookDepoUrl")+"--> adresi uzerinden anasayfaya gidildi");
        //Arama Kutusuna aranacak kitap ismini yazar ve aratir
        homePage.homePageAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakKitap")+ Keys.ENTER);
        extentTest.info("anasayda arama kutusuna "+ConfigReader.getProperty("aranacakKitap")+" yazıldı ve enter tusuna basılarak arama yapıldı");
        //most popular menusunden price low to high secer.
        Select select=new Select(homePage.mostPopulerDropDownMenu);
        select.selectByVisibleText("Price, low to high");
        extentTest.info("mostpopuler acılır menu uzerinden price low to high secilerek sıralama yapıldı ");
        ArrayList<Integer> fiyatlarIntList=new ArrayList<>();
        for (WebElement each:homePage.fiyatlarList
        ) {
            String fiyatString=each.getText().replaceAll("\\D","");
            fiyatlarIntList.add(Integer.parseInt(fiyatString));
        }
        extentTest.info("fiyatlar karsılaştırılmak uzere bir listeye eklendi");
        List<Integer> kontrolList=new ArrayList<>(fiyatlarIntList);

        Collections.sort(kontrolList);
        extentTest.info("fiyatlar kodlama yardımı ile azdan cok olarak sıralanmış bir listeye eklendi");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(kontrolList.equals(fiyatlarIntList),"sıralama dogru yapılmıyor");
        extentTest.info("fiyatlar sıralama yapıldıktan sonra sıralanmıs liste ile eşleştirildi");
        extentTest.fail("fiyat siralaması price low to high secenegi beklenildigi gibi calısmadıgı goruldu");
        System.out.println(kontrolList+"\n"+fiyatlarIntList);
        softAssert.assertAll();
        Driver.quitDriver();
        //yorum satiri ekledim


    }

}
