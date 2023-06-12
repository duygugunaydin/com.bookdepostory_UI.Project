package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SosyalMedyaPlatform;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Meral extends TestBaseRapor {

    @Test
    public void sosyalMedyaPlatformTesti  (){
        extentTest=extentReports.createTest("Kullanici sosyal medya platformlarına site üzerinden gidebilmeli");


        SosyalMedyaPlatform sosyalMedyaPlatform=new SosyalMedyaPlatform();
        Actions actions=new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("bookDepoUrl"));
        String bookDepoWHD=Driver.getDriver().getWindowHandle();
        actions.sendKeys(Keys.END).perform();
        sosyalMedyaPlatform.facebookLocate.click();
        extentTest.info("facebook sitesine yönlendirme yapildi");
        //String facebookBdWHD=Driver.getDriver().getWindowHandle();
        ReusableMethods.bekle(2);
        //Assert.assertTrue(sosyalMedyaPlatform.facebookDogrulama.isDisplayed());
        Driver.getDriver().switchTo().window(bookDepoWHD);

        sosyalMedyaPlatform.twitterLocate.click();
        ReusableMethods.bekle(2);

        extentTest.info("twitter sitesine yönlendirme yapildi");

        Driver.getDriver().switchTo().window(bookDepoWHD);
        sosyalMedyaPlatform.instagramLocate.click();
        ReusableMethods.bekle(2);

        extentTest.info("instagram sitesine yönlendirme yapildi");

        Driver.getDriver().switchTo().window(bookDepoWHD);
        sosyalMedyaPlatform.pinperestLocate.click();
        ReusableMethods.bekle(2);

        extentTest.info("pinperest sitesine yönlendirme yapildi");

        Driver.getDriver().switchTo().window(bookDepoWHD);
        Assert.assertTrue(sosyalMedyaPlatform.facebookLocate.isDisplayed());
        ReusableMethods.bekle(2);

        extentTest.pass("platformlarin calistigi goruldukten sonra anasayfaya donuldugu dogrulandi");









    }



}
