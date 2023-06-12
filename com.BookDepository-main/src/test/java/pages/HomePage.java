package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "(//input[@type='text'])[1]")
    public WebElement homePageAramaKutusu;

    @FindBy(xpath = "//select[@name='searchSortBy']")
    public WebElement mostPopulerDropDownMenu;
    
    @FindBy(xpath = "//p[@class='price']")
    public List<WebElement> fiyatlarList;
    
    @FindBy(xpath = "//a[@class='advanced-search']")
    public WebElement homeAdvancedSearchButton;

    @FindBy(xpath = "(//*[text()='Sign in/Join'])[1]")
    public WebElement signInJoinButonu;

    @FindBy(xpath = "//iframe[@class='signin-iframe']")
    public WebElement iframeElementi;

    @FindBy(xpath = "//*[@id='ap_email']")
    public WebElement emailBox;

    @FindBy(xpath = "//*[@id='ap_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id='signInSubmit']")
    public WebElement signInButonu;

    @FindBy(xpath = "//div[@class='message-success']")
    public WebElement welcomeBackYazisi;

    @FindBy(xpath = "(//li[@class='mob-nav-account'])[5]")
    public WebElement myAccount;

    @FindBy(xpath = "(//a[@rel='nofollow'])[12]")
    public WebElement personalDetails;

    @FindBy(xpath = "(//div[@class='a-row'])[2]")
    public WebElement personelDataNameElementi;

    @FindBy(xpath = "(//div[@class='a-row'])[5]")
    public WebElement personalDataEmailElementi;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement depoSearchBox;

    @FindBy(xpath="//img[@alt='Bored of Lunch: The Healthy Slow Cooker Book']")
    public WebElement bookElementi;

    @FindBy(xpath = "//a[@class='btn btn-primary add-to-basket']")
    public WebElement addtoBasketElementi;

    @FindBy(xpath = "//a[text()='Basket / Checkout']")
    public WebElement sepetButonu;

    @FindBy(xpath = "(//input[@id='couponCode'])[1]")
    public WebElement  kuponBox;

    @FindBy(xpath = "(//button[text()='Apply'])[1]")
    public WebElement  kuponApplyButonu;

    @FindBy(xpath = "//div[@class='message-error']")
    public WebElement  gecersizkuponYazisi;

    @FindBy(xpath = "(//h3[@class='title'])[1]")
    public WebElement ilkUrunIsim;

    @FindBy(xpath = "(//p[@class='price'])[1]")
    public WebElement ilkUrunFiyat;

    @FindBy(xpath = "(//a[@class=\"btn btn-sm btn-primary add-to-basket\"])[1]")
    public WebElement ilkUrunAddToBasketButton;

    @FindBy(xpath = "(//h3[@class='title'])[2]")
    public WebElement ikinciUrunIsim;

    @FindBy(xpath = "(//p[@class='price'])[2]")
    public WebElement ikinciUrunFiyat;

    @FindBy(xpath = "(//a[@class=\"btn btn-sm btn-primary add-to-basket\"])[2]")
    public WebElement ikinciUrunAddToBasketButton;


    //home>>urun add to basket>> yeni cıkan kucuk sayfadakı basket/checkout butonu
    @FindBy(xpath = "//a[@data-default-localized-pattern='Basket / Checkout']")
    public WebElement homeBasketCheckoutButton;

    //home>>urun add to basket>> yeni cıkan kucuk sayfadakıcontinue shopping butonu
    @FindBy (xpath = "//a[@data-localizer-string-id='bd_js_continue_shopping']")
    public WebElement homeContinueShoppingElementi;

    @FindBy(xpath = "//input[@name='searchTerm']")
    public WebElement searchBox;

}
