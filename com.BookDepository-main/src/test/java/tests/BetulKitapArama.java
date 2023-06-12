package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor2;

public class BetulKitapArama extends TestBaseRapor2 {

    HomePage homePage =new HomePage();

        @DataProvider
        public static Object[][] kitaplar() {

            Object[][] kitapIsimleri = {{"java"},
                    {"selenium"},
                    {"cucumber"},
                    {"harry potter"},
                    {"animal farm"},
            };

            return kitapIsimleri;
        }

        @Test(dataProvider = "kitaplar")
        public void kitapAramaTesti(String kitap) {
            extentTest = extentReports.createTest("Kitap arama testleri");
            Driver.getDriver().get(ConfigReader.getProperty("bookDepoUrl"));
            extentTest.info("Anasayfaya gidildi");
            ReusableMethods.kitapAra(kitap,"//a[@class='suggestion suggest-word']");
            extentTest.info("1-Kitap ismi ile arama yapıldığında,  arama kutusunun altındaki panelde çıkan yazıların kitap adını içerip içermediği kontrol edildi");

            ReusableMethods.kitapAra(kitap,"//div[@class='suggestion suggest-book']");
            extentTest.info("2-Kitap ismi ile arama yapıldığında,  arama kutusunun altındaki panelde çıkan -kitap kapağı içeren- yazıların kitap adını içerip içermediği kontrol edildi");

            ReusableMethods.kitapAra(kitap,"//h3[@class='title']");
            extentTest.pass("3-Kitap ismi ile arama yapıldığında, sayfada kitap adını içeren sonuçların çıktığı doğrulandı");

        }
        @AfterTest
        public void tearDown(){
            Driver.closeDriver();
        }

    }



