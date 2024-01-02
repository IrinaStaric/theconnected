package theconnectedshop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//a[@href='/account' and contains(@class, 'Heading') and contains(@class, 'Link') and contains(@class, 'Link--primary') and contains(@class, 'Text--subdued') and contains(@class, 'u-h8')]")
    private WebElement accountLinkElement;

    @FindBy(xpath = "//a[@href='/account/register' and @class='Link Link--secondary']")
    private WebElement createOneLinkElement;

    @FindBy(xpath = "//button[@class='NewsletterPopup__Close']")
    private WebElement newsletterElement;
    @FindBy(id = "shopify-pc__banner__btn-accept")
    private WebElement okcookie;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickAccountLink() {
        WebElement accountLink = wait.until(ExpectedConditions.visibilityOf(accountLinkElement));
        accountLink.click();
    }

    public void clickCreateOneLink() {
        WebElement createOneLink = wait.until(ExpectedConditions.visibilityOf(createOneLinkElement));
        createOneLink.click();
    }

    public void newsletterclose() {
        // Wait for the button with class "NewsletterPopup__Close" to be present
        WebElement closeButton = wait.until(ExpectedConditions.visibilityOf(newsletterElement));
        closeButton.click();
    }

    public void closeCookie() {
        // Wait for the button with class "NewsletterPopup__Close" to be present
        WebElement closeCookie = wait.until(ExpectedConditions.visibilityOf(okcookie));
        closeCookie.click();
    }
}
