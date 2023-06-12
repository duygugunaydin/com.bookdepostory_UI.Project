package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasketPage;
import pages.HomePage;
import pages.SearchPage;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Duygu extends TestBaseRapor {
    HomePage homePage= new HomePage();
    BasketPage basketPage = new BasketPage();
    SoftAssert softAssert=new SoftAssert();
    Actions actions=new Actions(Driver.getDriver());
    SearchPage searchPage=new SearchPage();
    @Test
    public void basketTest(){

        //    TestCase :
        // 1- Kullanici url e gider
        // 2- Kitap aratir
        // 3- sepete 2 tane urun ekler
        // 4- Sepette doğru ürünün ve fiyatının görünürlugunu kontol eder

        extentTest = extentReports.createTest("Sepet Testi",
                "Kullanici sepete dogru urunu ekleyebilmeli");

        Driver.getDriver().get("https://www.bookdepository.com/");
        extentTest.info("Url'e gidildi.");

        //

        homePage.searchBox.sendKeys("Harry Potter"+Keys.ENTER);
        extentTest.info("Searchbox a 'Harry Potter' aratildi");

        //

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String expectedUrunIsmi1=searchPage.ilkUrunIsim.getText();
        extentTest.info("Arama sayfasindaki ilk urun ismi locate edildi");

        String expectedUrunFiyati1=searchPage.ilkUrunFiyat.getText();
        extentTest.info("Aramasayfasindaki ilk urun fiyati locate edildi");

        searchPage.ilkUrunAddToBasketButton.click();
        extentTest.info("Aramasayfasindaki ilk urun elementi 'add to basket' butonu ile sepete eklendi");

        //

        searchPage.continueShoppingButton.click();
        extentTest.info("'Continue Shopping' butonu ile sayfaya geri gidildi.");

        //

        String expectedUrunIsmi2=searchPage.ikinciUrunIsim.getText();
        extentTest.info("Arama sayfasindaki ikinci urun ismi locate edildi");

        String expectedUrunFiyati2=searchPage.ikinciUrunFiyat.getText();
        extentTest.info("Arama sayfasindaki ikinci urun fiyati locate edildi");

        searchPage.ikinciUrunAddToBasketButton.click();
        extentTest.info("Arama sayfasindaki ikinci urun elementi 'add to basket' butonu ile sepete eklendi");

        //

        searchPage.basketCheckoutButton.click();
        extentTest.info("'Basket/Checkout' butonu ile sepete gidildi.");

        //

        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("basket"),"(1)!!sepet sayfasında gidilemedi");
        extentTest.info("Sepet sayfasina gidildigi dogrulandi");

        //

        String actualUrunIsmi1=basketPage.basketIlkUrunIsim.getText();
        extentTest.info("Sepetteki ilk urun ismi locate edildi");

        String actualUrunFiyati1=basketPage.basketIlkUrunFiyat.getText();
        extentTest.info("Sepetteki ilk urun fiyati locate edildi");

        softAssert.assertEquals(actualUrunIsmi1,expectedUrunIsmi1,"(2)Sepete atilan ilk urun ismi ile sepetteki urun ismi farkli");
        extentTest.info("Sepetteki ilk urun ismi dogrulandı");

        softAssert.assertEquals(actualUrunFiyati1,expectedUrunFiyati1,"(3)Sepete atilan ilk urun fiyati ile sepetteki urun fiyati farkli");
        extentTest.info("Sepetteki ilk urun fiyati dogrulandı");

        //

        String actualUrunIsmi2=basketPage.basketIkinciUrunIsim.getText();
        extentTest.info("Sepetteki ikinci urun ismi locate edildi");

        String actualUrunFiyati2=basketPage.basketIkinciUrunFiyat.getText();
        extentTest.info("Sepetteki ikinci urun fiyati locate edildi");

        softAssert.assertEquals(actualUrunIsmi2,expectedUrunIsmi2,"(4)Sepete atilan ikinci urun ismi ile sepetteki urun ismi farkli");
        extentTest.info("Sepetteki ikinci urun ismi dogrulandı");

        softAssert.assertEquals(actualUrunFiyati2,expectedUrunFiyati2,"(5)Sepete atilan ikinci urun fiyati ile sepetteki urun fiyati farkli");
        extentTest.info("Sepetteki ikinci urun fiyati dogrulandı");

        //

        String ilkUrunFiyat=basketPage.basketIlkUrunFiyat.getText();
        String ikinciUrunFiyat=basketPage.basketIkinciUrunFiyat.getText();
        String totalFiyat=basketPage.basketTotalFiyat.getText();

        ilkUrunFiyat=ilkUrunFiyat.replaceAll("\\D","");
        ikinciUrunFiyat=ikinciUrunFiyat.replaceAll("\\D","");
        totalFiyat=totalFiyat.replaceAll("\\D","");

        int expectedTotalFiyat=Integer.parseInt(ilkUrunFiyat)+Integer.parseInt(ikinciUrunFiyat);
        int actualToalFiyat=Integer.parseInt(totalFiyat);
        softAssert.assertTrue(expectedTotalFiyat==actualToalFiyat,"(6)Total fiyat miktari urunlerin toplamından farkli");
        extentTest.info("Total fiyat miktari dogrulandi");

        softAssert.assertAll();
    }
}
