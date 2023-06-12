package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SosyalMedyaPlatform {
    public SosyalMedyaPlatform(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@rel='nofollow noopener noreferrer'])[1]")
    public WebElement facebookLocate;
    @FindBy (xpath = "(//a[@rel='nofollow noopener noreferrer'])[2]")
    public WebElement twitterLocate;
    @FindBy (xpath = "(//a[@rel='nofollow noopener noreferrer'])[3]")
    public WebElement pinperestLocate;
    @FindBy (xpath = "(//a[@rel='nofollow noopener noreferrer'])[4]")
    public WebElement instagramLocate;
    @FindBy(xpath = "//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x xudqn12 x3x7a5m x6prxxf xvq8zen x1s688f x1qq9wsj']")
    public WebElement facebookDogrulama;
   // @FindBy(xpath = "((//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'])[11]")
   // public WebElement twitterDogrulama;
   // @FindBy(xpath = "(//div[@class='tBJ dyH iFc sAJ O2T zDA UK7 H2s'])[3]")
   // public WebElement pinperestDogrulama;
   // @FindBy(xpath = "(//img[@crossorigin='anonymous'])[1]")
   // public WebElement instagramDogrulama;



}

