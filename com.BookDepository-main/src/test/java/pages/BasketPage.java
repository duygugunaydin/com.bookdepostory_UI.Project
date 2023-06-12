package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BasketPage {
    public BasketPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div/h2/a)[1]")
    public WebElement basketIlkUrunIsim;

    @FindBy(xpath = "(//p[@class='item-total'])[1]")
    public WebElement basketIlkUrunFiyat;

    @FindBy(xpath = "(//div/h2/a)[2]")
    public WebElement basketIkinciUrunIsim;

    @FindBy(xpath = "(//p[@class='item-total'])[2]")
    public WebElement basketIkinciUrunFiyat;

    @FindBy(xpath = "//dl[@class='total']")
    public WebElement basketTotalFiyat;

}
