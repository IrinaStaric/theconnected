package theconnectedshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "customer[first_name]")
    private WebElement firstNameInputElenent;

    @FindBy(name = "customer[last_name]")
    private WebElement lastNameInputElement;

    @FindBy(name = "customer[email]")
    private WebElement emailInputElement;

    @FindBy(name= "customer[password]")
    private WebElement passwordInputElement;

    @FindBy(xpath = "//button[contains(@class, 'Form__Submit') and contains(@class, 'Button') and contains(@class, 'Button--primary') and contains(@class, 'Button--full') and text()='Create my account']")
    private WebElement submitButtonElement;

    @FindBy(xpath = "//li[@class='Alert__ErrorItem']")
    private WebElement warningField;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
 public void openRegPage(){
     wait.until(ExpectedConditions.urlToBe("https://theconnectedshop.com/account/register"));
     // Verify the current URL
     String currentUrl = driver.getCurrentUrl();
     if (currentUrl.equals("https://theconnectedshop.com/account/register")) {
         System.out.println("Registration successful! Current URL matches the expected URL.");
     } else {
         System.out.println("Registration failed or redirected to an unexpected URL.");
     }
 }
 public void fillRegistrationForm(String firstName, String lastName, String email, String password) {
        firstNameInputElenent.sendKeys(firstName);
        lastNameInputElement.sendKeys(lastName);
        emailInputElement.sendKeys(email);
        passwordInputElement.sendKeys(password);
    }
    public void clickSubmitButton() {
        submitButtonElement.click();
    }

public void warningMessage(String expectedErrorText) {
    WebElement errorItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='Alert__ErrorItem']")));
    String actualErrorText = errorItem.getText();
    if (actualErrorText.equals(expectedErrorText)) {
        System.out.println("Test Passed: Error text is as expected.");
    } else {
        System.out.println("Test Failed: Error text does not match the expected text.");
    }
}
}
