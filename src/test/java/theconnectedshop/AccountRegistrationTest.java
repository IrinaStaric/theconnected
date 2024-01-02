package theconnectedshop;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class AccountRegistrationTest {

    private WebDriver driver;
    private HomePageTest homePageTest;
    private RegistrationPage registrationPage;

    public AccountRegistrationTest(HomePageTest homePageTest) {
        this.homePageTest = homePageTest;
        this.registrationPage = new RegistrationPage(homePageTest.getDriver());
    }

    @Given("The user is on the registration page")
    public void navigateToRegistrationPage() {
       registrationPage.openRegPage();
    }

    @When("the user fills in the following valid registration details:")
    public void fillRegistrationDetails(DataTable dataTable) {
        List<Map<String, String>> registrationDataList = dataTable.asMaps(String.class, String.class);

        Map<String, String> registrationData = registrationDataList.get(0);

        registrationPage.fillRegistrationForm(
                registrationData.get("First Name"),
                registrationData.get("Last Name"),
                registrationData.get("Email"),
                registrationData.get("Password")
        );
    }

    @When("the user clicks on the submit button")
    public void clickSubmitButton() {
        registrationPage.clickSubmitButton();
    }

    @Then("the user should be successfully registered")
    public void verifySuccessfulRegistration (){
        // Add verification logic here, such as checking for a success message or navigating to the dashboard page.
    }

}
