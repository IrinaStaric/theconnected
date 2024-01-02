package theconnectedshop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

@Listeners(ExtentReportListener.class)
public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;


    @Given("I open the home page {string}")
    public void openHomePage(String url) {
       //System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        homePage = new HomePage(driver);
    }
    public WebDriver getDriver() {
        return driver;
    }
    @When ("Close cookie popup")
    public void close_cookie_popup(){homePage.closeCookie();}

    @When ("Close subscribe popup")
    public void close_subscribe_popup(){
        homePage.newsletterclose();
    }

    @When("I'm clicking on the account link")
    public void clickAccountLink()
    {
        homePage.clickAccountLink();
    }

    @When("I'm clicking on Create one link")
    public void clickCreateOneLink()
    {
        homePage.clickCreateOneLink();
    }

    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
        System.out.println("Browser closed");
    }
}
