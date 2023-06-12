package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchPage {

    public SearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//h3[@class='title'])[1]")
    public WebElement ilkUrunIsim;

    @FindBy(xpath = "(//span[@class='sale-price'])[1]")
    public WebElement ilkUrunFiyat;

    @FindBy(xpath = "(//a[@class='btn btn-sm btn-primary add-to-basket'])[1]")
    public WebElement ilkUrunAddToBasketButton;

    //

    @FindBy(xpath = "(//h3[@class='title'])[2]")
    public WebElement ikinciUrunIsim;

    @FindBy(xpath = "(//span[@class='sale-price'])[2]")
    public WebElement ikinciUrunFiyat;

    @FindBy(xpath = "(//a[@class='btn btn-sm btn-primary add-to-basket'])[2]")
    public WebElement ikinciUrunAddToBasketButton;


    //home>>urun add to basket>>basket/checkout butonu
    @FindBy(xpath = "//a[@data-default-localized-pattern='Basket / Checkout']")
    public WebElement homeBasketCheckoutButton;

    //home>>urun add to basket>>continue shopping butonu
    @FindBy (xpath = "//a[@data-localizer-string-id='bd_js_continue_shopping']")
    public WebElement homeContinueShoppingElementi;

    @FindBy(xpath = "//input[@name='searchTerm']")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@data-dismiss='modal']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@data-default-localized-pattern='Basket / Checkout']")
    public WebElement basketCheckoutButton;




}
