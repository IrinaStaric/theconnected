package theconnectedshop;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConnectedShopSteps {

    private WebDriver driver;

   /* @Given("The user is on the web site {string}")
    public void theUserIsOnTheWebSite(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }*/

    @When("The user clicks on the search field")
    public void theUserClicksOnTheSearchField() {
        WebElement searchField = driver.findElement(By.className("Heading"));
        searchField.click();
    }

    @Then("The user enters the invalid text")
    public void theUserEntersTheInvalidText() {
        WebElement searchField = driver.findElement(By.className("Heading"));
        searchField.sendKeys("Invalid Text");
        searchField.sendKeys(Keys.ENTER);
    }

    @Then("After the valid text {string}")
    public void afterTheValidText(String searchText) {
        WebElement searchField = driver.findElement(By.className("Heading"));
        searchField.clear();
        searchField.sendKeys(searchText);
        searchField.sendKeys(Keys.ENTER);
    }

    @Then("The user has many doors to choose from")
    public void theUserHasManyDoorsToChooseFrom() {
    }

    @Then("The user clicks on the first door")
    public void theUserClicksOnTheFirstDoor() {
        WebElement firstDoor = driver.findElement((By.xpath("//img[@alt='Smart Door Lock Slim Fingerprint Door Lock with Mobile App slim Smart Door Lock and Fingerprint Smart Lock']")));
        firstDoor.click();
    }
}
