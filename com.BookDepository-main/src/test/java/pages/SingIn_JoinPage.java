package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SingIn_JoinPage {

   public SingIn_JoinPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


   @FindBy(xpath = "//input[@aria-label='Email address for newsletter subscription']")
    public WebElement aboneEmailKutusu;
   @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement aboneButton;

   @FindBy(xpath = "//div[@class='modal-content']")
    public WebElement alert;
   @FindBy(xpath = "//button[@class='close']")
    public WebElement alertCloseButton;
}
