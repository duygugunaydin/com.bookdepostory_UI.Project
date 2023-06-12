package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class Erman extends TestBaseRapor {

    @Test
    public void test01(){

        extentTest=extentReports.createTest("kullanici login olup kullanici bilgisini dogrulamali");

        HomePage homePage=new HomePage();

        Driver.getDriver().get(ConfigReader.getProperty("bookDepoUrl"));
        extentTest.info("anasayfaya gidildi");

        homePage.signInJoinButonu.click();
        extentTest.info("sign in/join butonu tiklandi");

        Driver.getDriver().switchTo().frame(homePage.iframeElementi);
        extentTest.info("driver iframe'e switch edildi");

        homePage.emailBox.sendKeys(ConfigReader.getProperty("email"));
        extentTest.info("kullanici email bilgisi yazildi");

        homePage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        extentTest.info("kullanici sifre bilgisi yazildi");

        homePage.signInButonu.click();
        extentTest.info("sign in butonu tiklandi");

        ReusableMethods.bekle(2);
        Driver.getDriver().switchTo().defaultContent();
        extentTest.info("driver parent frame'e switch edildi");

        Assert.assertTrue(homePage.welcomeBackYazisi.isDisplayed());
        extentTest.info("welcome back yazisi test edildi");

        homePage.myAccount.click();
        extentTest.info("my account tiklandi");

        homePage.personalDetails.click();
        extentTest.info("personal details tiklandi");

        String expectedIsim=ConfigReader.getProperty("isim");
        String actualIsim=homePage.personelDataNameElementi.getText();
        Assert.assertEquals(expectedIsim,actualIsim);

        String expectedEmail=ConfigReader.getProperty("email");
        String actualEmail=homePage.personalDataEmailElementi.getText();
        Assert.assertEquals(expectedEmail,actualEmail);

        ReusableMethods.bekle(5);



        extentTest.pass("kullanici bilgilerinin dogrulugu test edildi");



    }


}
