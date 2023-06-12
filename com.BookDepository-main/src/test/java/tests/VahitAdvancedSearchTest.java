package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SearchAdvancedPage;
import utilities.*;


public class VahitAdvancedSearchTest extends TestBaseRapor2 {
    HomePage homePage = new HomePage();
    SearchAdvancedPage searchAdvancedPage = new SearchAdvancedPage();

    @DataProvider
    public static Object[][] aranacakSearch() {
        Object[][] aranacakAuthor = {{"Noah Gordon"},
                {"Elif Şafak"},
                {"Yaşar Kemal"}};
        return aranacakAuthor;
    }

    @Test(dataProvider = "aranacakSearch")
    public void authorsSearch(String aranacakAuthor) {
        int bekleSny=0;
        extentTest = extentReports.createTest("kullanici yazar ismi ile aramanin dogru calistigini gormeli");
        Driver.getDriver().get(ConfigReader.getProperty("bookDepoUrl"));
        homePage.homeAdvancedSearchButton.click();
        ReusableMethods.bekle(bekleSny);
        searchAdvancedPage.searchAuthorBox.sendKeys(aranacakAuthor + Keys.ENTER);
        extentTest.info("yazar ismi girip aratildi");
        ReusableMethods.bekle(bekleSny);
        String actualAuthor = searchAdvancedPage.aramaSonrasiIlkKitabinYazarElementi.getText();
        extentTest.info("listede çıkan ilk kitabin yazarina ulasildi.");
        ReusableMethods.bekle(bekleSny);
        Assert.assertEquals(aranacakAuthor, actualAuthor);
        extentTest.info("aranan yazarla actual yazarın aynı oldugu test edildi");
        Driver.getDriver().navigate().back();
        extentTest.info("sonraki yazar aramasi icin arama kutusuna donuldu");
        //ReusableMethods.bekle(bekleSny);
        searchAdvancedPage.searchAuthorBox.clear();
        extentTest.info("sonraki arama için searchAuthorBox ta önceki yazan yazar ismi silindi");
    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }

}
