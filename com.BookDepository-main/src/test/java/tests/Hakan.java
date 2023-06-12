package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SingIn_JoinPage;
import utilities.*;

import static org.testng.AssertJUnit.*;

public class Hakan extends TestBaseRapor2 {

    HomePage homePage =new HomePage();
    SingIn_JoinPage singInJoinPage= new SingIn_JoinPage();



    @Test(priority = 1)
    public void kullaniciAbonelikTest(){
        extentTest=extentReports.createTest("Kullanıcılar Haber Bültenine Kayıt Olabilmeli");
//      1-Kullanıcı, Book Depository sitesindeki e-posta aboneliği formunu doldurabilmeli
        //  -- kullanıcı "https://www.bookdepository.com/" adresine gider
        //  -- SıngIn / Join butonuna tıklar
        Driver.getDriver().get(ConfigReader.getProperty("bookDepoUrl"));
        String title=Driver.getDriver().getTitle();
        extentTest.info("Ana Sayfaya Gidildi"+title);
        homePage.signInJoinButonu.click();
        extentTest.info("Sing In / Join Linkine Tıklandı");


    }
    @DataProvider
    public static Object[][] negatifTest() {
        return new Object[][]{{""},{"abchotmail@com"},{"guglgug@yahooo"},{"guglgug@com"}};
    }

    @Test(dataProvider ="negatifTest",priority = 2)
    public void kullaniciAboneNegatifTest(String e_posta){
        extentTest=extentReports.createTest("Kullanıcılar yanlış E-Mail Adres Formatı İle Abone Olamamalı ");
//    1-Kullanıcı, Book Depository sitesindeki e-posta aboneliği formunu doldurabilmeli
        //  -- abone ol bölümünde ki e-mail kusunun erişilebilir olduğunu doğrular

        assertTrue(singInJoinPage.aboneEmailKutusu.isEnabled());
        extentTest.pass("Email Kutusunun Erişilebilir Olduğu Test Edildi");

        //  -- abone ol butonunun görülebilir olduğunu doğrular
        assertTrue(singInJoinPage.aboneButton.isDisplayed());
        extentTest.pass("Abone Ol Butonunun Görülebilir Olduğu Test Edildi");
        //  -- abone ol bölümündeki email kutusuna yanlış formatta e-posta adresini yazar

        singInJoinPage.aboneEmailKutusu.sendKeys(e_posta);
        extentTest.info("Yanlış Formatta "+"`"+e_posta+"`"+" Email Adresi Gönderildi");

        //  -- doğru formatta mail adresigirmesi için uyarı yazısının çıktığını test eder

        singInJoinPage.aboneButton.click();
        extentTest.info("Abone Ol Butonuna Basıldı");
        ReusableMethods.bekle(3);

        //Driver.getDriver().switchTo().alert();
        assertTrue(singInJoinPage.alert.isDisplayed());
        String erorMessage=singInJoinPage.alert.getText();
        extentTest.pass("Hata Mesajı "+"`"+erorMessage+"`"+" Alındı");

        singInJoinPage.alertCloseButton.click();
        extentTest.info("Alert Close Butonuna Tıklandı");



    }

    @Test(priority = 3)
    public void kullaniciAbonePozitifTesti(){

//    2- abone ol butonuna tıkladığında aboneliğin başarılı bir şekilde abone olabilmeli
        extentTest=extentReports.createTest("Kullanıcılar Doğru E-Mail Adres Formatı İle Abone Olmabilmeli ");
        //  -- abone ol bölümünde ki e-mail kusunun erişilebilir olduğunu doğrular
        assertTrue(singInJoinPage.aboneEmailKutusu.isEnabled());
        extentTest.pass("Email Kutusunun Erişilebilir Olduğu Test Edildi");
        //  -- abone ol butonunun görülebilir olduğunu doğrular
        assertTrue(singInJoinPage.aboneButton.isDisplayed());
        extentTest.pass("Abone Ol Butonunun Görülebilir Olduğu Test Edildi");

        //  -- abone ol kutusuna doğru email formatı  ile e-posta adresinini yazıp abone ol butonuna tıklar

        singInJoinPage.aboneEmailKutusu.sendKeys("guglgug@hotmail.com");
        extentTest.info("Doğru Formatta  Email Adresi Gönderildi");

        singInJoinPage.aboneButton.click();
        extentTest.info("Abone Ol Butonuna Basıldı");

        ReusableMethods.bekle(3);

        assertTrue(singInJoinPage.alert.isDisplayed());
        String successMessage=singInJoinPage.alert.getText();
        extentTest.pass("Abone Olma İşlemin Başarılı Mesajı "+"`"+successMessage+"`"+" Alındı");

        singInJoinPage.alertCloseButton.click();
        extentTest.info("Alert Close Butonuna Tıklandı");
        // -- başarılı bir şekilde abone oldunuz yazısının çıktığını test eder
        Driver.closeDriver();

    }

}
