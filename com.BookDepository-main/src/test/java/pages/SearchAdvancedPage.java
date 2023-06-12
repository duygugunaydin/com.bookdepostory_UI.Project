package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchAdvancedPage {

    public SearchAdvancedPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='searchAuthor']")
    public WebElement searchAuthorBox;

    @FindBy(xpath = "(//span[@itemprop='name'])[1]")
    public WebElement aramaSonrasiIlkKitabinYazarElementi;




}
